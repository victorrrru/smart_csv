package cn.smart;

/**
 * Created by think on 2017/5/31.
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String message, Exception e) {
        super(message,e);
    }

    public ServiceException(String msg) {
        super(msg);
    }
}
