package ro.ucv.ace.repository.impl;

import org.jinq.jpa.JPAJinqStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.orm.jpa.JpaSystemException;
import ro.ucv.ace.config.JinqSource;
import ro.ucv.ace.exception.DuplicateEntryException;
import ro.ucv.ace.exception.EntityNotFoundException;
import ro.ucv.ace.exception.ForeignKeyException;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.components.ICondition;
import ro.ucv.ace.repository.components.IExceptionParser;
import ro.ucv.ace.repository.components.IPage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by Geo on 28.10.2016.
 */
public class JpaRepository<T, ID extends Serializable> implements IJpaRepository<T, ID> {

    private final Class<T> persistentClass;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JinqSource jinqSource;

    @Autowired
    private IExceptionParser exceptionParser;


    public JpaRepository(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    protected JinqSource getJinqSource() {
        return this.jinqSource;
    }

    protected JPAJinqStream<T> streamAll() {
        return jinqSource.streamAll(entityManager, (Class<T>) persistentClass);
    }

    @Override
    public List<T> findAll() {
        return streamAll().toList();
    }

    @Override
    public List<T> findAll(IPage page) {
        return streamAll()
                .skip(page.getSkip())
                .limit(page.getLimit())
                .toList();
    }

    @Override
    public List<T> findAllWhere(ICondition<T> condition) {
        return streamAll()
                .where(condition)
                .toList();
    }

    @Override
    public T findOne(ID id) {
        T t = getEntityManager().find(persistentClass, id);

        if (t != null) {
            return t;
        }

        throw new EntityNotFoundException("Unable to find " + persistentClass.getSimpleName() + " with id " + id);
    }

    @Override
    public T findOneWhere(ICondition<T> condition) {
        Optional<T> opt = streamAll()
                .where(condition)
                .findAny();

        if (opt.isPresent()) {
            return opt.get();
        }

        throw new EntityNotFoundException("Unable to find " + persistentClass.getSimpleName() + " with the searched criteria");
    }

    @Override
    public T save(T t) {
        try {
            T saved = getEntityManager().merge(t);
            getEntityManager().flush();

            return saved;
        } catch (JpaObjectRetrievalFailureException jbrfe) {
            throw new ForeignKeyException(exceptionParser.parseEntityNotFoundException(jbrfe));
        } catch (JpaSystemException jse) {
            throw new DuplicateEntryException(exceptionParser.parsePersistenceException(jse, persistentClass));
        }
    }

    @Override
    public T delete(ID id) {
        T t = findOne(id);
        getEntityManager().remove(t);

        return t;
    }


    @Override
    public Long count() {
        return streamAll().count();
    }

}
