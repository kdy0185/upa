package study.subject.upa.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Class : DataUtil
 * @Author : KDW
 * @Date : 2022-03-10
 * @Description : Data 관련 util 클래스
 */
public class DataUtil {

    /**
     * <p>URL 내 정보 조회</p>
     *
     * @param paramUrl (입력 URL)
     * @return BufferedReader (버퍼 단위로 파싱한 데이터)
     */
    public static BufferedReader getUrl(String paramUrl) {
        BufferedReader br = null;

        try {
            URL url = new URL(paramUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return br;
    }

    /**
     * <p>HTML 정보 조회</p>
     *
     * @param br (버퍼 단위 데이터)
     * @return String (파싱한 문자열)
     */
    public static String getHtml(BufferedReader br) {
        StringBuilder sb = new StringBuilder();
        String line;

        try {
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
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
    public static String trimWhiteSpace(String str) {
        return str.replaceAll("\\s", "");
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
