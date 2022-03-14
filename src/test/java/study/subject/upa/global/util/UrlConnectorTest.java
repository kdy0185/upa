package study.subject.upa.global.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UrlConnectorTest {

    @Test
    @DisplayName("URL 파싱 기능 테스트")
    public void dataParseUrlTest() throws Exception {
        // given
        String url = "http://google.com/";

        // when
        UrlConnector urlConnector = new UrlConnector();
        String html = urlConnector.dataParseUrl(url);

        // then
        assertThat(html).isNotNull();
    }
}
