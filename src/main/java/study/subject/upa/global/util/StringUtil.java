package study.subject.upa.global.util;

/**
 * @Class : StringUtil
 * @Author : KDW
 * @Date : 2022-03-14
 * @Description : String 관련 util Class
 */
public class StringUtil {

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
    public static String trimWhiteSpace(String str) {
        return str.replaceAll(Constants.WHITESPACE_PATTERN, Constants.EMPTY);
    }
}
