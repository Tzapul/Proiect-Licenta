package ro.ucv.ace.utility;

import net.lingala.zip4j.exception.ZipException;

/**
 * Created by Geo on 05.12.2016.
 */
public interface IUnzipper {

    void unzip(String zipFilePath, String destDirectory) throws ZipException;
}
