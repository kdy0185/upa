package study.subject.upa.global.exception;

/**
 * @Class : UrlConnectException
 * @Author : KDW
 * @Date : 2022-03-14
 * @Description : URL 관련 예외 처리 Class
 */
public class UrlConnectException extends IllegalArgumentException {

    public UrlConnectException(String message) {
        super(message);
    }
}
