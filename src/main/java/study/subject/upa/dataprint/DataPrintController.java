package study.subject.upa.dataprint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.subject.upa.util.DataUtil;

/**
 * @Class : DataPrintController
 * @Author : KDW
 * @Date : 2022-03-10
 * @Description : URL 파싱 API Controller
 */
@RestController
@RequiredArgsConstructor
public class DataPrintController {

    private final DataPrintService dataPrintService;

    /**
     * <p>URL 파싱</p>
     *
     * @param paramUrl (파싱할 URL)
     * @param dataType (노출 유형)
     * @return String (파싱한 데이터)
     */
    @GetMapping("/api/v2/typeParsing")
    public String typeParsing(@RequestParam("url") String paramUrl,
        @RequestParam("dataType") String dataType) {
        String resultData = dataPrintService.parseHtml(paramUrl);

        // 노출 유형 - H : Html 태그 제외, T : Text 전체
        if ("H".equals(dataType)) {
            resultData = DataUtil.deleteHtml(resultData);
        }

        return resultData;
    }
}
