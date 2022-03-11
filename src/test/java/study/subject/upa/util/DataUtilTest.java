package study.subject.upa.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

class DataUtilTest {

    @Test
    public void getUrlTest() throws Exception {
        // given
        String paramUrl = "http://google.com/";

        // when
        BufferedReader br = DataUtil.getUrl(paramUrl);

        // then
        assertThat(br).isNotNull();
    }

    @Test
    public void getHtmlTest() throws Exception {
        // given
        Reader reader = new StringReader("<img src='http://google.com/' alt='sample.jpg' />");
        BufferedReader br = new BufferedReader(reader);

        // when
        String str = DataUtil.getHtml(br);

        // then
        System.out.println(str);
    }

    @Test
    public void isEmptyTest() throws Exception {
        // given
        String obj1 = null;
        String obj2 = "";
        String obj3 = "  ";
        String obj4 = " abc ";
        int obj5 = 123;

        // when
        boolean flag1 = DataUtil.isEmpty(obj1);
        boolean flag2 = DataUtil.isEmpty(obj2);
        boolean flag3 = DataUtil.isEmpty(obj3);
        boolean flag4 = DataUtil.isEmpty(obj4);
        boolean flag5 = DataUtil.isEmpty(obj5);

        // then
        assertThat(flag1).isTrue();
        assertThat(flag2).isTrue();
        assertThat(flag3).isFalse();
        assertThat(flag4).isFalse();
        assertThat(flag5).isFalse();
    }

    @Test
    public void trimWhiteSpaceTest() throws Exception {
        // given
        String str1 = "a b c";
        String str2 = "a    b   c";
        String str3 = " abc ";

        // when
        str1 = DataUtil.trimWhiteSpace(str1);
        str2 = DataUtil.trimWhiteSpace(str2);
        str3 = DataUtil.trimWhiteSpace(str3);

        // then
        assertThat(str1).isEqualTo("abc");
        assertThat(str2).isEqualTo("abc");
        assertThat(str3).isEqualTo("abc");
    }
}
