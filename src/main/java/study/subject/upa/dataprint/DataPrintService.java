package study.subject.upa.dataprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;

@Service
public class DataPrintService {

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
