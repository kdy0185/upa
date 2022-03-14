package study.subject.upa.global.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UrlConnectorTest {

    private final UrlConnector urlConnector = new UrlConnector();

    @Test
    @DisplayName("URL 파싱 실패 테스트")
    public void dataParseUrlFailTest() throws Exception {
        // given
        String failUrl = "abcdefg";

        // then
        assertThatThrownBy(
            () -> urlConnector.dataParseUrl(failUrl)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"https://www.naver.com/, <title>NAVER</title>",
        "http://google.com/, <title>Google</title>"})
    @DisplayName("URL 파싱 성공 테스트")
    public void dataParseUrlSuccessTest(String successUrl, String title) throws Exception {
        // when
        String html = urlConnector.dataParseUrl(successUrl);

        // then
        assertThat(html).contains(title);
    }
}
