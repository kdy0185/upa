package study.subject.upa.global.util;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;
import study.subject.upa.domain.dataparse.dto.DataParseResponse;
import study.subject.upa.domain.dataparse.dto.DataType;
import study.subject.upa.global.support.CustomComparator;
import study.subject.upa.global.support.CustomStreamSupport;

/**
 * @Class : DataParseUtil
 * @Author : KDW
 * @Date : 2022-03-10
 * @Description : Data 관련 util Class
 */
@Component
public class DataParseUtil {

    /**
     * <p>HTML 태그 제거</p>
     *
     * @param str      (변경할 문자열)
     * @param dataType (노출 유형)
     * @return String (변경 후 문자)
     */
    public String dataParseHtml(String str, DataType dataType) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }

        if (DataType.REMOVE_HTML.equals(dataType)) {
            str = str.replaceAll(Constants.HTML_PATTERN, Constants.EMPTY);
        }

        return StringUtil.trimWhiteSpace(str);
    }

    /**
     * <p>영문 + 숫자 출력</p>
     *
     * @param str (검사할 문자열)
     * @return String (변경 후 문자)
     */
    public String dataParseAlphaNumeric(String str) {
        if (StringUtil.isEmpty(str)) {
            return "";
        }

        return str.replaceAll(Constants.NOT_ALPHA_NUMERIC_PATTERN, Constants.EMPTY);
    }

    /**
     * <p>데이터 정렬</p>
     *
     * @param str (정렬할 문자열)
     * @return String (변경 후 문자)
     */
    public String dataParseSort(String str) {
        if (StringUtil.isEmpty(str)) {
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
        if (StringUtil.isEmpty(str)) {
            return "";
        }

        String[] engArr = str.replaceAll(Constants.NUM_PATTERN, Constants.EMPTY).split("");
        String[] numArr = str.replaceAll(Constants.ENG_PATTERN, Constants.EMPTY).split("");

        Stream<String> swapStream = CustomStreamSupport.interleave(Stream.of(engArr),
            Stream.of(numArr));
        return swapStream.collect(Collectors.joining());
    }

    /**
     * <p>단위별 데이터 묶음</p>
     *
     * @param str  (출력할 문자열)
     * @param unit (출력 단위)
     * @return DataParseResponse (응답 데이터)
     */
    public DataParseResponse dataParseUnit(String str, int unit) {
        if (str.length() <= unit) {
            unit = str.length();
        }

        if (unit == 0) {
            throw new ArithmeticException();
        }

        int idx = str.length() - str.length() % unit;
        return new DataParseResponse(str.substring(0, idx), str.substring(idx));
    }
}
