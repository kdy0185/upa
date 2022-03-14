package study.subject.upa.domain.dataparse.service;

import static study.subject.upa.global.util.DataParseUtil.dataFormat;
import static study.subject.upa.global.util.DataParseUtil.getHtml;
import static study.subject.upa.global.util.DataParseUtil.getUrl;
import static study.subject.upa.global.util.DataParseUtil.isEmpty;
import static study.subject.upa.global.util.DataParseUtil.trimWhiteSpace;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import study.subject.upa.domain.dataparse.dto.DataParseRequest;
import study.subject.upa.domain.dataparse.dto.DataParseResponse;
import study.subject.upa.domain.dataparse.dto.DataType;
import study.subject.upa.global.support.CustomComparator;
import study.subject.upa.global.support.CustomStreamSupport;

/**
 * @Class : DataParseService
 * @Author : KDW
 * @Date : 2022-03-10
 * @Description : URL 파싱 API Service
 */
@Service
public class DataParseService {

    /**
     * <p>URL 파싱</p>
     *
     * @param request (요청 정보)
     * @return DataParseResponse (응답 데이터)
     */
    public DataParseResponse dataParsing(DataParseRequest request) {
        String resultData = dataParseUrl(request.getUrl());
        resultData = dataParseHtml(resultData, request.getDataType());
        resultData = dataParseAlphaNumeric(resultData);
        resultData = dataParseSort(resultData);
        resultData = dataParseSwap(resultData);
        return dataParseUnit(resultData, request.getUnit());
    }

    /**
     * <p>URL 파싱</p>
     *
     * @param paramUrl (파싱할 URL)
     * @return String (파싱한 데이터)
     */
    public String dataParseUrl(String paramUrl) {
        return getHtml(getUrl(paramUrl));
    }

    /**
     * <p>HTML 태그 제거</p>
     *
     * @param str (변경할 문자열)
     * @param dataType (노출 유형)
     * @return String (변경 후 문자)
     */
    public String dataParseHtml(String str, DataType dataType) {
        if (isEmpty(str)) {
            return "";
        }

        String htmlRegex = "<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>";

        if (DataType.REMOVE_HTML.equals(dataType)) {
            str = str.replaceAll(htmlRegex, "");
        }

        return trimWhiteSpace(str);
    }

    /**
     * <p>영문 + 숫자 출력</p>
     *
     * @param str (검사할 문자열)
     * @return String (변경 후 문자)
     */
    public String dataParseAlphaNumeric(String str) {
        if (isEmpty(str)) {
            return "";
        }

        return str.replaceAll("[\\W_]", "");
    }

    /**
     * <p>데이터 정렬</p>
     *
     * @param str (정렬할 문자열)
     * @return String (변경 후 문자)
     */
    public String dataParseSort(String str) {
        if (isEmpty(str)) {
            return "";
        }

        return Stream.of(str.split("")).sorted(new CustomComparator())
            .collect(Collectors.joining());
    }

    /**
     * <p>데이터 교차</p>
     *
     * @param str (교차할 문자열)
     * @return String (변경 후 문자)
     */
    public String dataParseSwap(String str) {
        if (isEmpty(str)) {
            return "";
        }

        String[] engArr = str.replaceAll("[0-9]", "").split("");
        String[] numArr = str.replaceAll("[a-zA-Z]", "").split("");

        Stream<String> swapStream = CustomStreamSupport.interleave(Stream.of(engArr),
            Stream.of(numArr));
        return swapStream.collect(Collectors.joining());
    }

    /**
     * <p>단위 묶음별 데이터 출력</p>
     *
     * @param str  (출력할 문자열)
     * @param unit (출력 단위)
     * @return DataParseResponse (응답 데이터)
     */
    public DataParseResponse dataParseUnit(String str, int unit) {
        if (str.length() <= unit) {
            unit = str.length();
        }

        int idx = str.length() - str.length() % unit;
        return dataFormat(str.substring(0, idx), str.substring(idx));
    }
}
