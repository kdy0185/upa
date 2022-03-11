package study.subject.upa.util;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;
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
        assertThat(html1).isEqualTo("nohtml");
        assertThat(html2).isEmpty();
        assertThat(html3).isEqualTo("service");
        assertThat(html4).isEmpty();
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
    public void printAlphaNumericTest() throws Exception {
        // given
        String str1 = null;
        String str2 = "AbcD123";
        String str3 = "테스트";
        String str4 = "/user/system";
        String str5 = "a,b_c";

        // when
        str1 = DataUtil.printAlphaNumeric(str1);
        str2 = DataUtil.printAlphaNumeric(str2);
        str3 = DataUtil.printAlphaNumeric(str3);
        str4 = DataUtil.printAlphaNumeric(str4);
        str5 = DataUtil.printAlphaNumeric(str5);

        // then
        assertThat(str1).isEmpty();
        assertThat(str2).isEqualTo("AbcD123");
        assertThat(str3).isEmpty();
        assertThat(str4).isEqualTo("usersystem");
        assertThat(str5).isEqualTo("abc");
    }

    @Test
    public void compareTest() throws Exception {
        // given

        // when

        // then

    }

    @Test
    public void sortTest() throws Exception {
        // given
        String str1 = null;
        String str2 = "ib4gEQ9";
        String str3 = "8916590";
        String str4 = "9M3Sm1b2";
        String str5 = "u90aNA3k";

        // when
        str1 = DataUtil.dataSort(str1);
        str2 = DataUtil.dataSort(str2);
        str3 = DataUtil.dataSort(str3);
        str4 = DataUtil.dataSort(str4);
        str5 = DataUtil.dataSort(str5);

        // then
        assertThat(str1).isEmpty();
        assertThat(str2).isEqualTo("49bEgiQ");
        assertThat(str3).isEqualTo("0156899");
        assertThat(str4).isEqualTo("1239bMmS");
        assertThat(str5).isEqualTo("039aAkNu");
    }

    @Test
    public void crossTest() throws Exception {
        // given
        String str1 = "134478889bcCmnST";
        String str2 = "23566aBbgils";
        String str3 = "12ab";
        String str4 = "12345";
        String str5 = "abcd";

        // when
        str1 = DataUtil.dataSwap(str1);
        str2 = DataUtil.dataSwap(str2);
        str3 = DataUtil.dataSwap(str3);
        str4 = DataUtil.dataSwap(str4);
        str5 = DataUtil.dataSwap(str5);

        // then
        assertThat(str1).isEqualTo("b1c3C4m4n7S8T889");
        assertThat(str2).isEqualTo("a2B3b5g6i6ls");
        assertThat(str3).isEqualTo("a1b2");
        assertThat(str4).isEqualTo("12345");
        assertThat(str5).isEqualTo("abcd");
    }

    @Test
    public void interleaveTest() throws Exception {
        // given
        Stream<String> a = Stream.of("a", "c", "e");
        Stream<String> b = Stream.of("b", "d", "f");

        // when
        Stream<String> ab = DataUtil.interleave(a, b);

        // then
        String result = ab.collect(Collectors.joining());
        assertThat(result).isEqualTo("abcdef");
    }
}
