package study.subject.upa.domain.dataparse.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

/**
 * @Class : DataParseRequest
 * @Author : KDW
 * @Date : 2022-03-14
 * @Description : URL 파싱 API Request
 */
@Data
public class DataParseRequest {

    @ApiModelProperty(value = "파싱할 URL")
    @NotEmpty(message = "URL은 필수로 입력해야 합니다.")
    @URL(message = "URL 형식이 맞지 않습니다.")
    private String url;

    @ApiModelProperty(value = "노출 유형 (H : Html 태그 제외, T : Text 전체)")
    @Length(max = 1)
    @Pattern(regexp = "[HT]", message = "노출 유형은 \"H\", \"T\" 로만 입력 가능합니다.")
    private String dataType;

    @ApiModelProperty(value = "출력 묶음 단위")
    @Positive(message = "1 이상의 숫자를 입력해야 합니다.")
    private int unit;
}
