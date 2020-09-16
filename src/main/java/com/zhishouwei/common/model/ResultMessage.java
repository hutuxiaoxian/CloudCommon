package com.zhishouwei.common.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Data
public class ResultMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    private int level = 0;
    private String title;
    private String body;

    public ResultMessage(int level) {
        this.level = level;
    }

    public ResultMessage(int level, String body) {
        this.level = level;
        this.body = body;
    }

    public ResultMessage(int level, String title, String body) {
        this.level = level;
        this.title = title;
        this.body = body;
    }

    public static List<ResultMessage> createReslutMessages(MessageEnum level, String... messages) {
        List<ResultMessage> list = new ArrayList();
        String[] var3 = messages;
        int var4 = messages.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String s = var3[var5];
            list.add(new ResultMessage(level.getValue(), s));
        }

        return list;
    }

    public static List<ResultMessage> createReslutMessages(MessageEnum level, String title, String... messages) {
        List<ResultMessage> list = new ArrayList();
        String[] var4 = messages;
        int var5 = messages.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String s = var4[var6];
            list.add(new ResultMessage(level.getValue(), title, s));
        }

        return list;
    }
}
