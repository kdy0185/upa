package study.subject.upa.domain.dataparse.controller;

import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.subject.upa.domain.dataparse.dto.DataParseRequest;
import study.subject.upa.domain.dataparse.dto.DataParseResponse;
import study.subject.upa.domain.dataparse.service.DataParseService;

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
     * @param request (요청 정보)
     * @return ResponseEntity (응답 데이터)
     */
    @ApiOperation(value = "URL 파싱")
    @PostMapping("/api/dataParsing")
    public ResponseEntity<DataParseResponse> dataParsing(
        @RequestBody @Valid DataParseRequest request) {
        DataParseResponse response = dataParseService.dataParsing(request);
        return ResponseEntity.ok().body(response);
    }
}
