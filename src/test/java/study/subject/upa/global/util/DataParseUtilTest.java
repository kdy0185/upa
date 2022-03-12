package study.subject.upa.global.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.subject.upa.global.util.DataParseUtil;

/**
 * @Class : DataParseUtilTest
 * @Author : KDW
 * @Date : 2022-03-12
 * @Description : util 기능 관련 테스트 Class
 */
class DataParseUtilTest {

    @Test
    @DisplayName("URL 내 정보 조회 기능 테스트")
    public void getUrlTest() throws Exception {
        // given
        String paramUrl = "http://google.com/";

        // when
        BufferedReader br = DataParseUtil.getUrl(paramUrl);

        // then
        assertThat(br).isNotNull();
    }

    @Test
    @DisplayName("HTML 정보 조회 기능 테스트")
    public void getHtmlTest() throws Exception {
        // given
        Reader reader = new StringReader("<img src='http://google.com/' alt='sample.jpg' />");
        BufferedReader br = new BufferedReader(reader);

        // when
        String str = DataParseUtil.getHtml(br);

        // then
        System.out.println(str);
    }

    @Test
    @DisplayName("공백 체크 기능 테스트")
    public void isEmptyTest() throws Exception {
        // given
        String obj1 = null;
        String obj2 = "";
        String obj3 = "  ";
        String obj4 = " abc ";
        int obj5 = 123;

        // when
        boolean flag1 = DataParseUtil.isEmpty(obj1);
        boolean flag2 = DataParseUtil.isEmpty(obj2);
        boolean flag3 = DataParseUtil.isEmpty(obj3);
        boolean flag4 = DataParseUtil.isEmpty(obj4);
        boolean flag5 = DataParseUtil.isEmpty(obj5);

        // then
        assertThat(flag1).isTrue();
        assertThat(flag2).isTrue();
        assertThat(flag3).isFalse();
        assertThat(flag4).isFalse();
        assertThat(flag5).isFalse();
    }

    @Test
    @DisplayName("공백 제거 기능 테스트")
    public void trimWhiteSpaceTest() throws Exception {
        // given
        String str1 = "a b c";
        String str2 = "a    b   c";
        String str3 = " abc ";

        // when
        str1 = DataParseUtil.trimWhiteSpace(str1);
        str2 = DataParseUtil.trimWhiteSpace(str2);
        str3 = DataParseUtil.trimWhiteSpace(str3);

        // then
        assertThat(str1).isEqualTo("abc");
        assertThat(str2).isEqualTo("abc");
        assertThat(str3).isEqualTo("abc");
    }
}
