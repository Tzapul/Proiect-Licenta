package ro.ucv.ace.service;

import ro.ucv.ace.dto.subgroup.ESSubgroupDto;
import ro.ucv.ace.dto.subgroup.SubgroupDto;

import java.util.List;

/**
 * Created by Geo on 19.11.2016.
 */
public interface ISubgroupService {

    SubgroupDto save(ESSubgroupDto subgroupDto);

    List<SubgroupDto> getAll();

    SubgroupDto delete(int id);

    SubgroupDto edit(int id, ESSubgroupDto subgroupDto);
}
