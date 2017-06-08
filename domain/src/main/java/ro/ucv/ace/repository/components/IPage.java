package ro.ucv.ace.repository.components;

/**
 * This interface in used to limit the results on a query.
 *
 * @author Georgian Vladutu
 */
public interface IPage {

    /**
     * Returns the maximum number of entities that can be returned by the query.
     *
     * @return Integer
     */
    Integer getLimit();

    /**
     * Returns the number of elements that the query must skip.
     *
     * @return Integer
     */
    Integer getSkip();
}
