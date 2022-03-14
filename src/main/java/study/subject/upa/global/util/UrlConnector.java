package study.subject.upa.global.util;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

@Component
public class UrlConnector {

    /**
     * <p>URL 파싱</p>
     *
     * @param url (파싱할 URL)
     * @return String (파싱한 데이터)
     */
    public String dataParseUrl(String url) {
        String html = "";
        try {
            html = Jsoup.connect(url).get().html();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return html;
    }
}
