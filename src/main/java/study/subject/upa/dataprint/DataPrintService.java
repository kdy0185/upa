package study.subject.upa.dataprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;

/**
 * @Class : DataPrintService
 * @Author : KDW
 * @Date : 2022-03-10
 * @Description : URL 파싱 API Service
 */
@Service
public class DataPrintService {

    /**
     * <p>URL 파싱</p>
     *
     * @param paramUrl (파싱할 URL)
     * @return String (파싱한 데이터)
     */
    public String parseHtml(String paramUrl) {
        StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL(paramUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    /**
     * <p>HTML 태그 제거</p>
     *
     * @param object (변경할 문자형 객체)
     * @return String (변경 후 문자)
     */
    public String deleteHtml(Object object) {
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
     * <pre>
     * isBlank(null)    = true
     * isBlank("")      = true
     * isBlank("  ")    = true
     * isBlank(" bob ") = false
     * isBlank(123)     = false
     * </pre>
     *
     * @param object (체크할 문자형, 숫자형 객체)
     * @return boolean (체크 결과)
     */
    public boolean isBlank(Object object) {
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
