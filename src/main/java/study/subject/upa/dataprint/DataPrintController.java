package study.subject.upa.dataprint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DataPrintController {

    private final DataPrintService dataPrintService;

    @GetMapping("/api/v1/basicParsing")
    public String basicParsing(@RequestParam("url") String paramUrl) {
        return dataPrintService.parseHtml(paramUrl);
    }
}
