package com.office.ctifier.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @author Dizzy
 */
public interface IConvertService {

    /**
     * 转成PDF
     *
     * @param fileInputStream  fileInputStream
     * @param originalFilename originalFilename
     * @return 返回结果
     * @throws Exception
     */
    ByteArrayOutputStream convertPdf(InputStream fileInputStream, String originalFilename) throws Exception;

}
