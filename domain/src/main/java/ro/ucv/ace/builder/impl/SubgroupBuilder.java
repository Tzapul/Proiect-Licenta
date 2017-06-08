package ro.ucv.ace.builder.impl;

import org.springframework.stereotype.Component;
import ro.ucv.ace.builder.ISubgroupBuilder;
import ro.ucv.ace.dto.subgroup.ESSubgroupDto;
import ro.ucv.ace.model.Subgroup;

/**
 * Created by Geo on 19.11.2016.
 */
@Component
public class SubgroupBuilder implements ISubgroupBuilder {

    @Override
    public Subgroup build(ESSubgroupDto subgroupDto) {
        return new Subgroup(subgroupDto.getName());
    }
}
