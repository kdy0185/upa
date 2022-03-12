package study.subject.upa.domain.dataparse.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.subject.upa.domain.dataparse.service.DataParseService;
import study.subject.upa.domain.dataparse.entity.DataParseVO;

/**
 * @Class : DataParseController
 * @Author : KDW
 * @Date : 2022-03-10
 * @Description : URL 파싱 API Controller
 */
@RestController
@RequiredArgsConstructor
public class DataParseController {

    private final DataParseService dataParseService;

    /**
     * <p>URL 파싱</p>
     *
     * @param dataParseVO (파라미터 정보)
     * @return String (파싱한 데이터)
     */
    @GetMapping("/api/dataParsing")
    public String dataParsing(@RequestBody @Valid DataParseVO dataParseVO) {
        String resultData = dataParseService.dataParseUrl(dataParseVO.getUrl());

        // 노출 유형 - H : Html 태그 제외, T : Text 전체
        if ("H".equals(dataParseVO.getDataType())) {
            resultData = dataParseService.dataParseHtml(resultData);
        }

        resultData = dataParseService.dataParseAlphaNumeric(resultData);
        resultData = dataParseService.dataParseSort(resultData);
        resultData = dataParseService.dataParseSwap(resultData);
        return dataParseService.dataParseUnit(resultData, dataParseVO.getUnit());
    }
}
