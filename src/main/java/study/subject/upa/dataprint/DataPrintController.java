package study.subject.upa.dataprint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DataPrintController {

    private final DataPrintService dataPrintService;

    @GetMapping("/api/v2/typeParsing")
    public String typeParsing(@RequestParam("url") String paramUrl,
        @RequestParam("dataType") String dataType) {
        String resultData = dataPrintService.parseHtml(paramUrl);

        // 노출 유형 - H : Html 태그 제외, T : Text 전체
        if ("H".equals(dataType)) {
            resultData = dataPrintService.deleteHtml(resultData);
        }

        return resultData;
    }
}
