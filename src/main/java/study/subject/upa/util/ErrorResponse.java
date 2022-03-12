package study.subject.upa.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

    private String code;
    private String message;
    private Map<String, String> errors;

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
