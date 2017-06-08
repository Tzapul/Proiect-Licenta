package ro.ucv.ace.builder;

import ro.ucv.ace.dto.subgroup.ESSubgroupDto;
import ro.ucv.ace.model.Subgroup;

/**
 * Created by Geo on 19.11.2016.
 */
public interface ISubgroupBuilder {
    Subgroup build(ESSubgroupDto subgroupDto);
}
