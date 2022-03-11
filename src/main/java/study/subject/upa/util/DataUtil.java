package study.subject.upa.util;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Class : DataUtil
 * @Author : KDW
 * @Date : 2022-03-10
 * @Description : Data 관련 util 클래스
 */
public class DataUtil {

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
     * <p>출력 문자 포맷</p>
     *
     * @param unitStr (몫)
     * @param restStr (나머지)
     * @return String (포맷 후 문자)
     */
    public static String dataFormat(String unitStr, String restStr) {
        return "+----------------------------------------+" + System.lineSeparator()
            + "+----------------------------------------+" + System.lineSeparator()
            + "몫 : " + unitStr + System.lineSeparator()
            + "나머지 : " + restStr + System.lineSeparator()
            + "+----------------------------------------+" + System.lineSeparator()
            + "+----------------------------------------+" + System.lineSeparator();
    }
}
