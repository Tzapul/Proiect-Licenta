package ro.ucv.ace.repository.components;

import org.jinq.orm.stream.JinqStream;

/**
 * This is a functional interface used in database queries to filter the results.
 *
 * @param <U> type of the entity involved in the query
 * @author Georgian Vladutu
 */
@FunctionalInterface
public interface ICondition<U> extends JinqStream.Where<U, Exception> {
}
