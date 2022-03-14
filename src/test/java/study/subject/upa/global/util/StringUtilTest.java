package study.subject.upa.global.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilTest {

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
        boolean flag1 = StringUtil.isEmpty(obj1);
        boolean flag2 = StringUtil.isEmpty(obj2);
        boolean flag3 = StringUtil.isEmpty(obj3);
        boolean flag4 = StringUtil.isEmpty(obj4);
        boolean flag5 = StringUtil.isEmpty(obj5);

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
        str1 = StringUtil.trimWhiteSpace(str1);
        str2 = StringUtil.trimWhiteSpace(str2);
        str3 = StringUtil.trimWhiteSpace(str3);

        // then
        assertThat(str1).isEqualTo("abc");
        assertThat(str2).isEqualTo("abc");
        assertThat(str3).isEqualTo("abc");
    }
}
