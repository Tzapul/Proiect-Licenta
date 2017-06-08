package ro.ucv.ace.service;

import ro.ucv.ace.dto.other.ResponseMessageDto;
import ro.ucv.ace.dto.solution.ESSolutionDto;
import ro.ucv.ace.utility.impl.Content;
import ro.ucv.ace.utility.impl.Node;

/**
 * Created by tzapt on 12/4/2016.
 */
public interface ISolutionService {

    ResponseMessageDto save(int studentId, int taskId, ESSolutionDto solutionDto);

    Node getSolutionFolderStructure(int solutionId);

    Content getFileContent(String filePath);
}
