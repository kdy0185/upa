package study.subject.upa.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Class : DataUtil
 * @Author : KDW
 * @Date : 2022-03-10
 * @Description : Data 관련 util 클래스
 */
public class DataUtil {

    /**
     * <p>HTML 태그 제거</p>
     *
     * @param object (변경할 문자형 객체)
     * @return String (변경 후 문자)
     */
    public static String deleteHtml(Object object) {
        if (isEmpty(object)) {
            return "";
        }

        String str = String.valueOf(object)
            .replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
        return trimSpace(str);
    }

    /**
     * <p>공백 체크</p>
     *
     * @param object (체크할 문자형, 숫자형 객체)
     * @return boolean (체크 결과)
     */
    public static boolean isEmpty(Object object) {
        return object == null || String.valueOf(object).length() == 0;
    }

    /**
     * <p>공백 제거</p>
     *
     * @param str (변경할 문자)
     * @return String (변경 후 문자)
     */
    public static String trimSpace(String str) {
        str = str.replaceAll("\r\n", "");
        str = str.replaceAll("\r", "");
        str = str.replaceAll("\n", "");
        str = str.replaceAll("\t", "");
        str = str.replaceAll(" ", "");
        return str;
    }

    /**
     * <p>영문 + 숫자 출력</p>
     *
     * @param str (검사할 문자열)
     * @return String (변경 후 문자)
     */
    public static String printAlphaNumeric(String str) {
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
    public static String dataSort(String str) {
        if (isEmpty(str)) {
            return "";
        }

        String[] arrStr = str.split("");
        Arrays.sort(arrStr, String.CASE_INSENSITIVE_ORDER);
        return String.join("", arrStr);
    }
}
