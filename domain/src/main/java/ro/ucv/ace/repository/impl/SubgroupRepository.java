package ro.ucv.ace.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.ucv.ace.model.Subgroup;
import ro.ucv.ace.repository.IJpaRepository;
import ro.ucv.ace.repository.ISubgroupRepository;

import java.util.List;

/**
 * Created by Geo on 19.11.2016.
 */
@Repository("subgroupRepository")
public class SubgroupRepository implements ISubgroupRepository {

    @Autowired
    private IJpaRepository<Subgroup, Integer> innerSubgroupRepository;

    @Override
    public Subgroup save(Subgroup subgroup) {
        return innerSubgroupRepository.save(subgroup);
    }

    @Override
    public List<Subgroup> findAll() {
        return innerSubgroupRepository.findAll();
    }

    @Override
    public Subgroup delete(int id) {
        return innerSubgroupRepository.delete(id);
    }

    @Override
    public Subgroup findOne(int id) {
        return innerSubgroupRepository.findOne(id);
    }

    @Override
    public Subgroup findByName(String name) {
        return innerSubgroupRepository.findOneWhere(subgroup -> subgroup.getName().equals(name));
    }
}
