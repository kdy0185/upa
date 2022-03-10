package study.subject.upa.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataUtilTest {

    @Test
    public void deleteHtmlTest() throws Exception {
        // given
        String html1 = "no html";
        String html2 = "<br/>";
        String html3 = "<div>service</div>";
        String html4 = "<img src='http://google.com/' alt='sample.jpg' />";

        // when
        html1 = DataUtil.deleteHtml(html1);
        html2 = DataUtil.deleteHtml(html2);
        html3 = DataUtil.deleteHtml(html3);
        html4 = DataUtil.deleteHtml(html4);

        // then
        assertThat(html1).isEqualTo("no html");
        assertThat(html2).isEmpty();
        assertThat(html3).isEqualTo("service");
        assertThat(html4).isEmpty();
    }

    @Test
    public void isBlankTest() throws Exception {
        // given
        String obj1 = null;
        String obj2 = "";
        String obj3 = "  ";
        String obj4 = " abc ";
        int obj5 = 123;

        // when
        boolean flag1 = DataUtil.isBlank(obj1);
        boolean flag2 = DataUtil.isBlank(obj2);
        boolean flag3 = DataUtil.isBlank(obj3);
        boolean flag4 = DataUtil.isBlank(obj4);
        boolean flag5 = DataUtil.isBlank(obj5);

        // then
        assertThat(flag1).isTrue();
        assertThat(flag2).isTrue();
        assertThat(flag3).isTrue();
        assertThat(flag4).isFalse();
        assertThat(flag5).isFalse();
    }
}
