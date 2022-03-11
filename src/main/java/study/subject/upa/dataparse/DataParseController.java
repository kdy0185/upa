package study.subject.upa.dataparse;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * @param paramUrl (파싱할 URL)
     * @param dataType (노출 유형)
     * @param unit (출력 묶음 단위)
     * @return String (파싱한 데이터)
     */
    @GetMapping("/api/v7/dataParsing")
    public String dataParsing(@RequestParam("url") String paramUrl,
        @RequestParam("dataType") String dataType,
        @RequestParam("unit") int unit) {
        String resultData = dataParseService.dataParseUrl(paramUrl);

        // 노출 유형 - H : Html 태그 제외, T : Text 전체
        if ("H".equals(dataType)) {
            resultData = dataParseService.dataParseHtml(resultData);
        }

        resultData = dataParseService.dataParseAlphaNumeric(resultData);
        resultData = dataParseService.dataParseSort(resultData);
        resultData = dataParseService.dataParseSwap(resultData);
        return dataParseService.dataParseUnit(resultData, unit);
    }
}
