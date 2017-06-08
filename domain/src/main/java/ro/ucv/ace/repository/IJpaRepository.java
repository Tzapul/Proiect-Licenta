package ro.ucv.ace.repository;

import ro.ucv.ace.repository.components.ICondition;
import ro.ucv.ace.repository.components.IPage;

import java.io.Serializable;
import java.util.List;

/**
 * This interface provides methods for basic operations on JPA entities.
 *
 * @param <T>  type of the entity
 * @param <ID> type of the entity primary key
 */
public interface IJpaRepository<T, ID extends Serializable> {

    /**
     * Returns all entities of the type.
     *
     * @return list of entities of type T
     */
    List<T> findAll();

    /**
     * Returns a IPage of entities meeting the paging restriction provided in the IPage object.
     *
     * @param page page
     * @return a page of entities
     */
    List<T> findAll(IPage page);

    /**
     * Returns all entities meeting the condition restriction provided in the ICondition object.
     *
     * @param condition condition
     * @return list of entities meeting the condition
     */
    List<T> findAllWhere(ICondition<T> condition);

    /**
     * Returns the entity whose id is the same as the method parameter.
     *
     * @param id id of the entity
     * @return entity
     */
    T findOne(ID id);

    /**
     * Returns the entity that meets the condition restriction provided in the ICondition object.
     *
     * @param condition condition
     * @return searched entity
     */
    T findOneWhere(ICondition<T> condition);


    /**
     * Saves the entity.
     *
     * @param t entity to be saved
     * @return saved entity
     */
    T save(T t);

    /**
     * Deletes the entity whose id is  the same as the method parameter.
     *
     * @param id id of the entity
     * @return deleted entity
     */
    T delete(ID id);


    /**
     * Returns the number of entities in the database.
     *
     * @return number of entities
     */
    Long count();
}
