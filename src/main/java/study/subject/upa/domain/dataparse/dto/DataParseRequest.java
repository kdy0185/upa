package study.subject.upa.domain.dataparse.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.URL;

/**
 * @Class : DataParseRequest
 * @Author : KDW
 * @Date : 2022-03-14
 * @Description : URL 파싱 API Request
 */
@Data
public class DataParseRequest {

    @Schema(description = "파싱할 URL", defaultValue = "http://google.com/")
    @NotEmpty(message = "URL은 필수로 입력해야 합니다.")
    @URL(message = "URL 형식이 맞지 않습니다.")
    private String url;

    @Schema(description = "노출 유형", defaultValue = "REMOVE_HTML")
    private DataType dataType;

    @Schema(description = "출력 묶음 단위", defaultValue = "20")
    @Positive(message = "1 이상의 숫자를 입력해야 합니다.")
    private int unit;
}
