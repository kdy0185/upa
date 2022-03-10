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
}
