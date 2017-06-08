package ro.ucv.ace.builder;

/**
 * Created by Geo on 01.12.2016.
 */
public interface IPathBuilder {

    String buildAbsoluteTaskFolderPath(int professorId, int topicId, int taskId);

    String buildPathForInputFile(String basePath);

    String buildPathForOutputFile(String basePath);

    String buildAbsoluteTopicFolderPath(Integer professorId, Integer topicId);

    String buildAbsoluteProfessorFolderPath(Integer professorId);

    String buildAbsoluteStudentSolutionFolderPath(int professorId, int topicId, int taskId, int studentId);

    String buildRelativeTaskFolderPath(int professorId, int topicId, int taskId);

    String buildRelativeStudentSolutionFolderPath(int professorId, int topicId, int taskId, int studentId);

    String buildAbsoluteStudentSolutionFolderPath(String relativePath);
}
