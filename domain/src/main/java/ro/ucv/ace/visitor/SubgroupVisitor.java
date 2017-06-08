package ro.ucv.ace.visitor;

import org.springframework.stereotype.Component;
import ro.ucv.ace.dto.subgroup.SubgroupDto;
import ro.ucv.ace.model.Subgroup;

/**
 * Created by Geo on 19.11.2016.
 */
@Component
public class SubgroupVisitor {

    private SubgroupDto subgroupDto;

    public void visit(Subgroup subgroup) {
        subgroupDto = new SubgroupDto(subgroup.getId(), subgroup.getName());
    }

    public SubgroupDto getSubgroupDto() {
        return subgroupDto;
    }
}
