package study.subject.upa.util;

import lombok.Getter;

/**
 * @Class : ErrorStatus
 * @Author : KDW
 * @Date : 2022-03-12
 * @Description : 예외 정보가 담긴 enum Class
 */
@Getter
public enum ErrorStatus {
    MESSAGE_NOT_READABLE("EM400", "입력 형식이 올바르지 않습니다."),
    METHOD_NOT_VALID("EV400", "요청 값이 올바르지 않습니다."),
    ROOT_EXCEPTION("ER500", "알 수 없는 오류가 발생하였습니다.");

    private final String code; // 예외 코드
    private final String message; // 예외 메시지

    ErrorStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
