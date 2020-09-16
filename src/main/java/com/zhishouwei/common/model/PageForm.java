package com.zhishouwei.common.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class PageForm implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer currPage;
    private Integer pageSize;
    private String sortRule;
    private String keyword;
    private MatchRule matchRule;

    public static final PageForm NO_PAGING() {
        return new PageForm(1, 2147483647);
    }

    public PageForm() {
        this(1, 2147483647);
    }

    public PageForm(Integer currPage, Integer pageSize) {
        this.currPage = currPage;
        this.pageSize = pageSize;
    }

    public PageForm(Integer currPage, Integer pageSize, String sortRule) {
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.sortRule = sortRule;
    }
}
