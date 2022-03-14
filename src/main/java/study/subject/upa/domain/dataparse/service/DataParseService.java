package study.subject.upa.domain.dataparse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.subject.upa.domain.dataparse.dto.DataParseRequest;
import study.subject.upa.domain.dataparse.dto.DataParseResponse;
import study.subject.upa.global.util.DataParseUtil;
import study.subject.upa.global.util.UrlConnector;

/**
 * @Class : DataParseService
 * @Author : KDW
 * @Date : 2022-03-10
 * @Description : URL 파싱 API Service
 */
@Service
@RequiredArgsConstructor
public class DataParseService {

    private final UrlConnector urlConnector;
    private final DataParseUtil dataParseUtil;

    /**
     * <p>URL 파싱</p>
     *
     * @param request (요청 정보)
     * @return DataParseResponse (응답 데이터)
     */
    public DataParseResponse dataParsing(DataParseRequest request) {
        String resultData = urlConnector.dataParseUrl(request.getUrl());
        resultData = dataParseUtil.dataParseHtml(resultData, request.getDataType());
        resultData = dataParseUtil.dataParseAlphaNumeric(resultData);
        resultData = dataParseUtil.dataParseSort(resultData);
        resultData = dataParseUtil.dataParseSwap(resultData);
        return dataParseUtil.dataParseUnit(resultData, request.getUnit());
    }
}
