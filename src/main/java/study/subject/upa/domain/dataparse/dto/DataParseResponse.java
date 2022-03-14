package study.subject.upa.domain.dataparse.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Class : DataParseResponse
 * @Author : KDW
 * @Date : 2022-03-14
 * @Description : URL 파싱 API Response
 */
@Getter
@RequiredArgsConstructor
public class DataParseResponse {

    private final String piecesStr; // 몫
    private final String restStr; // 나머지
}
