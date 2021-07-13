package com.office.ctifier.controller;

import com.office.ctifier.service.IConvertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

/**
 * 测试 控制器
 *
 * @author Dizzy
 */
@Slf4j
@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor
@Api(value = "测试接口", tags = "测试接口")
public class TestController {

    private final IConvertService convertService;

    /**
     * 转成PDF
     *
     * @param file
     */
    @PostMapping(value = "convert-pdf")
    @ApiOperation(value = "转成PDF", notes = "转成PDF")
    public void convertPdf(@RequestParam("file") MultipartFile file,
                           HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Content-disposition", "attachment; filename=" + "convert-pdf.pdf");
        ByteArrayOutputStream byteArrayOutputStream = convertService.convertPdf(file.getInputStream(), file.getOriginalFilename());
        httpServletResponse.getOutputStream().write(byteArrayOutputStream.toByteArray());
        httpServletResponse.getOutputStream().flush();
        httpServletResponse.getOutputStream().close();
    }


}
