package ro.ucv.ace.repository;

import ro.ucv.ace.model.Subgroup;

import java.util.List;

/**
 * Created by Geo on 19.11.2016.
 */
public interface ISubgroupRepository {

    Subgroup save(Subgroup subgroup);

    List<Subgroup> findAll();

    Subgroup delete(int id);

    Subgroup findOne(int id);

    Subgroup findByName(String name);
}
