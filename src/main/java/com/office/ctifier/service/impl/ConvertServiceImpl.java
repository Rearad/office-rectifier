package com.office.ctifier.service.impl;


import com.artofsolving.jodconverter.DefaultDocumentFormatRegistry;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.DocumentFormatRegistry;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.office.ctifier.office.OpenOfficeUtils;
import com.office.ctifier.properties.OpenOfficeConnectionProperties;
import com.office.ctifier.service.IConvertService;
import com.office.ctifier.utils.LogUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author Dizzy
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ConvertServiceImpl implements IConvertService {

    private final OpenOfficeConnectionProperties openOfficeConnectionProperties;

    public static DocumentFormatRegistry formatFactory = new DefaultDocumentFormatRegistry();

//    private final OpenOfficeConnection openOfficeConnection;

//    private final DocumentConverter documentConverter;

//    private final DocumentConverter documentConverter;

    public static void main(String[] args) throws Exception {
        File file = new File("E:/openoffice/创意花鸟风自然和谐风学术汇报总结PPT模板.pptx");
        FileInputStream fileInputStream = new FileInputStream(file);
        File file1 = new File("E:/openoffice/创意花鸟风自然和谐风学术汇报总结PPT模板.pdf");
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
//这里端口是上面你启动服务设置的端口
    }

    @Override
    public ByteArrayOutputStream convertPdf(InputStream fileInputStream, String originalFilename) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        LogUtils logUtils = LogUtils.startRecord();
        OpenOfficeUtils.convert(fileInputStream,
                OpenOfficeUtils.fileType(originalFilename),
                byteArrayOutputStream,
                OpenOfficeUtils.FileType.PDF,
                openOfficeConnectionProperties.getIp(),
                openOfficeConnectionProperties.getPort());
        logUtils.stopRecord("停止记录");
        return byteArrayOutputStream;
    }

}
