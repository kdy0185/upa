package study.subject.upa.util;

import lombok.Getter;

@Getter
public enum ErrorStatus {
    MESSAGE_NOT_READABLE("EM400", "입력 형식이 올바르지 않습니다."),
    METHOD_NOT_VALID("EV400", "요청 값이 올바르지 않습니다."),
    ROOT_EXCEPTION("ER500", "알 수 없는 오류가 발생하였습니다.");

    private final String code;
    private final String message;

    ErrorStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
