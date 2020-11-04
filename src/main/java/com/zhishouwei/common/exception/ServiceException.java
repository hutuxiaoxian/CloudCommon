package com.zhishouwei.common.exception;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer errId;

    public static final Integer ERROR_NO_ID = 101;

    public Integer getErrId() {
        return this.errId == null ? ERROR_NO_ID : errId;
    }

    public ServiceException() {
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(String message, Integer errCode) {
        super(message);
        errId = errCode;
    }
    public ServiceException(Integer errCode, String message) {
        super(message);
        errId = errCode;
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
