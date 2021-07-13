package com.office.ctifier.office;

import com.artofsolving.jodconverter.DefaultDocumentFormatRegistry;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.DocumentFormatRegistry;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;
import com.office.ctifier.utils.LogUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.ConnectException;

public class OpenOfficeUtils {

    public static final String LOCAL_HOST = "localhost";
    public static final int LOCAL_PORT = 8100;

    // Format
    public static DocumentFormatRegistry formatFactory = new DefaultDocumentFormatRegistry();

    /**
     * @param inputStream
     * @param inputFileExtension  示例：pdf
     * @param outputStream
     * @param outputFileExtension 示例：pdf
     * @param connectIp           远程调用ip
     * @param connectPort         远程调用端口
     */
    public static void convert(InputStream inputStream, FileType inputFileExtension, OutputStream outputStream,
                               FileType outputFileExtension, String connectIp, int connectPort) throws ConnectException {

        if (inputStream == null || inputFileExtension == null || outputStream == null || outputFileExtension == null || StringUtils.isEmpty(connectIp)) {
            throw new IllegalArgumentException("参数异常！！");
        }

        OpenOfficeConnection connection = new SocketOpenOfficeConnection(connectIp, connectPort);
        connection.connect();
        DocumentConverter converter = getConverter(connectIp, connection);

        converter.convert(inputStream, formatFactory.getFormatByFileExtension(inputFileExtension.name()), outputStream,
                formatFactory.getFormatByFileExtension(outputFileExtension.name()));
        connection.disconnect();
    }

    public static OpenOfficeUtils.FileType fileType(String fileName) {
        String fileExtension = getFileExtension(fileName);
        FileType[] values = FileType.values();
        for (FileType value : values) {
            if (StringUtils.containsIgnoreCase(fileExtension, value.name())) {
                return value;
            }
        }
        return null;
    }


    private static String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    public enum FileType {
        PDF,
        PPT,
        DOC,
        XLS
    }

    public static DocumentConverter getConverter(String connectIp, OpenOfficeConnection connection) {
        DocumentConverter converter = "localhost".equals(connectIp) || "127.0.0.1".equals(connectIp)
                || "0:0:0:0:0:0:0:1".equals(connectIp) ? new OpenOfficeDocumentConverter(connection)
                : new StreamOpenOfficeDocumentConverter(connection);
        return converter;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("E:/openoffice/创意花鸟风自然和谐风学术汇报总结PPT模板.pptx");
        FileInputStream fileInputStream = new FileInputStream(file);
        File file1 = new File("E:/openoffice/创意花鸟风自然和谐风学术汇报总结PPT模板-测试.pdf");
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        //这里端口是上面你启动服务设置的端口
        LogUtils logUtils = LogUtils.startRecord();
        OpenOfficeUtils.convert(fileInputStream, FileType.PPT, fileOutputStream, FileType.PDF, "119.91.111.207", 8100);
        logUtils.stopRecord("完成时间");
    }


}
