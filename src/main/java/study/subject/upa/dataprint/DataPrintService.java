package study.subject.upa.dataprint;

import static study.subject.upa.util.DataUtil.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    public String dataParseUrl(String paramUrl) {
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
    public String dataParseHtml(Object object) {
        if (isEmpty(object)) {
            return "";
        }

        String str = String.valueOf(object)
            .replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
        return trimSpace(str);
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

        String[] arrStr = str.split("");
        Arrays.sort(arrStr, String.CASE_INSENSITIVE_ORDER);
        return String.join("", arrStr);
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

        return interleave(Stream.of(engArr), Stream.of(numArr)).collect(Collectors.joining());
    }

    /**
     * <p>단위 묶음별 출력</p>
     *
     * @param str  (출력할 문자열)
     * @param unit (출력 단위)
     * @return String (변경 후 문자)
     */
    public String dataParseUnit(String str, int unit) {
        if (isEmpty(str)) {
            return "";
        }

        if (unit <= 0) {
            return "유효한 단위가 아닙니다.";
        }

        if (str.length() <= unit) {
            unit = str.length();
        }

        int idx = str.length() - str.length() % unit;
        return dataFormat(str.substring(0, idx), str.substring(idx));
    }
}
