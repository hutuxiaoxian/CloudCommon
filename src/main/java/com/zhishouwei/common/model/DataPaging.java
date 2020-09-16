package com.zhishouwei.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class DataPaging<E> implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<E> EMPTY_CONTENT = new ArrayList();
    private final PageForm EMPTY_PAGEABLE = new PageForm();
    private List<E> contents;
    private Long total;
    private Long totalPage;
    private PageForm pageForm;
    private Map<String, Object> exposition;

    public DataPaging() {
        this.contents = this.EMPTY_CONTENT;
        this.pageForm = this.EMPTY_PAGEABLE;
    }

    public DataPaging(List<E> contents, DataPaging dataPaging) {
        this.contents = this.EMPTY_CONTENT;
        this.pageForm = this.EMPTY_PAGEABLE;
        this.contents = contents;
        this.total = dataPaging.getTotal();
        this.pageForm = dataPaging.getPageForm();
    }

    public DataPaging(List<E> contents, Long total) {
        this.contents = this.EMPTY_CONTENT;
        this.pageForm = this.EMPTY_PAGEABLE;
        this.contents = contents;
        this.total = total;
    }

    public DataPaging(List<E> contents, Long total, Long totalPage, PageForm pageForm) {
        this.contents = this.EMPTY_CONTENT;
        this.pageForm = this.EMPTY_PAGEABLE;
        this.contents = contents;
        this.total = total;
        this.totalPage = totalPage;
        this.pageForm = pageForm;
    }

    public DataPaging(List<E> contents, Long total, PageForm pageForm) {
        this.contents = this.EMPTY_CONTENT;
        this.pageForm = this.EMPTY_PAGEABLE;
        this.contents = contents;
        this.total = total;
        this.pageForm = pageForm;
    }
}
