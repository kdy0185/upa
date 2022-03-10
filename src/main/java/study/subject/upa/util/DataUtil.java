package study.subject.upa.util;

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
        if (isBlank(object)) {
            return "";
        }
        String str = String.valueOf(object);
        str = str.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
//        str = str.replaceAll("\r\n", "");
//        str = str.replaceAll("\r", "");
//        str = str.replaceAll("\n", "");
//        str = str.replaceAll("\t", "");
        return str;
    }

    /**
     * <p>null 및 공백 체크</p>
     *
     * @param object (체크할 문자형, 숫자형 객체)
     * @return boolean (체크 결과)
     */
    public static boolean isBlank(Object object) {
        if (object == null) {
            return true;
        }
        String str = String.valueOf(object);
        if (str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if ((!Character.isWhitespace(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
