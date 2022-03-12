package study.subject.upa.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * @Class : ErrorResponse
 * @Author : KDW
 * @Date : 2022-03-12
 * @Description : 예외 응답 정보가 담긴 Class
 */
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

    private String code; // 예외 코드
    private String message; // 예외 메시지
    private Map<String, String> errors; // 오류 정보 (필드 + 메시지 형태)

    public ErrorResponse(ErrorStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public ErrorResponse(ErrorStatus status, Map<String, String> errors) {
        this.code = status.getCode();
        this.message = status.getMessage();
        this.errors = errors;
    }
}
