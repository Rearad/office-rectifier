package com.office.ctifier.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * 日志工具
 *
 * @author Dizzy
 */
@Slf4j
public class LogUtils {

    private Long startTime;

    private Long endTime;

    private LogUtils() {
    }

    public LogUtils(Long startTime) {
        this.startTime = startTime;
    }

    private LogUtils(Long startTime, Long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * 开始记录
     *
     * @return 返回工具
     */
    public static LogUtils startRecord() {
        return new LogUtils(System.currentTimeMillis());
    }

    public void stopRecord() {
        // 调用请求之后统计时间
        float f = (float) (System.currentTimeMillis() - startTime) / 1000;
        log.info("处理时长: {} 秒", f);
        System.out.printf("处理时长: %s 秒%n", f);
    }

    public void stopRecord(String message) {
        // 调用请求之后统计时间
        float f = (float) (System.currentTimeMillis() - this.startTime) / 1000;
        log.info("{}，处理时长: {} 秒", message, f);
        System.out.printf("%s，处理时长: %s 秒%n", message, f);
    }


}
