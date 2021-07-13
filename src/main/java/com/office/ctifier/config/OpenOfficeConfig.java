//package com.office.ctifier.config;
//
//import com.artofsolving.jodconverter.DocumentConverter;
//import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
//import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
//import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
//import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;
//import com.office.ctifier.properties.OpenOfficeConnectionProperties;
//import com.office.ctifier.utils.LogUtils;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.ConnectException;
//
///**
// * @author Dizzy
// */
//@RequiredArgsConstructor
//@Configuration
//public class OpenOfficeConfig {
//
//    private final OpenOfficeConnectionProperties openOfficeConnectionProperties;
//
//    @Bean
//    public OpenOfficeConnection openOfficeConnection() {
//        LogUtils logUtils = LogUtils.startRecord();
//        OpenOfficeConnection connection = new SocketOpenOfficeConnection(openOfficeConnectionProperties.getIp(), openOfficeConnectionProperties.getPort());
//        try {
//            connection.connect();
//            logUtils.stopRecord("连接成功");
//        } catch (ConnectException e) {
//            e.printStackTrace();
//            logUtils.stopRecord("连接失败");
//            System.exit(-1);
//        }
//        return connection;
//    }
//
////    @Bean
////    public DocumentConverter documentConverter(OpenOfficeConnection openOfficeConnection) {
////        DocumentConverter converter = "localhost".equals(openOfficeConnectionProperties.getIp()) || "127.0.0.1".equals(openOfficeConnectionProperties.getIp())
////                || "0:0:0:0:0:0:0:1".equals(openOfficeConnectionProperties.getIp()) ? new OpenOfficeDocumentConverter(openOfficeConnection)
////                : new StreamOpenOfficeDocumentConverter(openOfficeConnection);
////        return converter;
////    }
//
//
//}
