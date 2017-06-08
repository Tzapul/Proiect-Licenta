package ro.ucv.ace.builder.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ro.ucv.ace.builder.IPathBuilder;

import java.io.File;

/**
 * Created by Geo on 01.12.2016.
 */
@Component
public class PathBuilder implements IPathBuilder {

    @Value("${folder.root}")
    private String folderRoot;

    @Value("${folder.inp}")
    private String folderInput;

    @Value("${folder.outp}")
    private String folderOutput;

    @Override
    public String buildAbsoluteTaskFolderPath(int professorId, int topicId, int taskId) {
        return folderRoot + buildRelativeTaskFolderPath(professorId, topicId, taskId);
    }

    @Override
    public String buildPathForInputFile(String basePath) {
        return basePath + File.separator + folderInput;
    }

    @Override
    public String buildPathForOutputFile(String basePath) {
        return basePath + File.separator + folderOutput;
    }

    @Override
    public String buildAbsoluteTopicFolderPath(Integer professorId, Integer topicId) {
        return String.format("%s%s%s%s%s", folderRoot, File.separator, professorId,
                File.separator, topicId);
    }

    @Override
    public String buildAbsoluteProfessorFolderPath(Integer professorId) {
        return String.format("%s%s%s", folderRoot, File.separator, professorId);
    }

    @Override
    public String buildAbsoluteStudentSolutionFolderPath(int professorId, int topicId, int taskId, int studentId) {
        return folderRoot + buildRelativeStudentSolutionFolderPath(professorId, topicId, taskId, studentId);
    }

    @Override
    public String buildRelativeTaskFolderPath(int professorId, int topicId, int taskId) {
        return String.format("%s%s%s%s%s%s", File.separator, professorId,
                File.separator, topicId, File.separator, taskId);
    }

    @Override
    public String buildRelativeStudentSolutionFolderPath(int professorId, int topicId, int taskId, int studentId) {
        return String.format("%s%s%s%s%s%s%s%s", File.separator, professorId, File.separator, topicId, File.separator,
                taskId, File.separator, studentId);
    }

    @Override
    public String buildAbsoluteStudentSolutionFolderPath(String relativePath) {
        return folderRoot + relativePath;
    }
}
