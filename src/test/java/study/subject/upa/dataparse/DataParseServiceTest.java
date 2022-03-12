package study.subject.upa.dataparse;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataParseServiceTest {

    @Autowired
    DataParseService dataParseService;

    @Test
    public void dataParseHtmlTest() throws Exception {
        // given
        String html1 = "no html";
        String html2 = "<br/>";
        String html3 = "<div>service</div>";
        String html4 = "<img src='http://google.com/' alt='sample.jpg' />";

        // when
        html1 = dataParseService.dataParseHtml(html1);
        html2 = dataParseService.dataParseHtml(html2);
        html3 = dataParseService.dataParseHtml(html3);
        html4 = dataParseService.dataParseHtml(html4);

        // then
        assertThat(html1).isEqualTo("nohtml");
        assertThat(html2).isEmpty();
        assertThat(html3).isEqualTo("service");
        assertThat(html4).isEmpty();
    }

    @Test
    public void dataParseAlphaNumericTest() throws Exception {
        // given
        String str1 = null;
        String str2 = "AbcD123";
        String str3 = "테스트";
        String str4 = "/user/system";
        String str5 = "a,b_c";

        // when
        str1 = dataParseService.dataParseAlphaNumeric(str1);
        str2 = dataParseService.dataParseAlphaNumeric(str2);
        str3 = dataParseService.dataParseAlphaNumeric(str3);
        str4 = dataParseService.dataParseAlphaNumeric(str4);
        str5 = dataParseService.dataParseAlphaNumeric(str5);

        // then
        assertThat(str1).isEmpty();
        assertThat(str2).isEqualTo("AbcD123");
        assertThat(str3).isEmpty();
        assertThat(str4).isEqualTo("usersystem");
        assertThat(str5).isEqualTo("abc");
    }

    @Test
    public void dataParseSortTest() throws Exception {
        // given
        String str1 = null;
        String str2 = "ib4gEQ9";
        String str3 = "8916590";
        String str4 = "9M3Sm1b2";
        String str5 = "u90aNA3k";

        // when
        str1 = dataParseService.dataParseSort(str1);
        str2 = dataParseService.dataParseSort(str2);
        str3 = dataParseService.dataParseSort(str3);
        str4 = dataParseService.dataParseSort(str4);
        str5 = dataParseService.dataParseSort(str5);

        // then
        assertThat(str1).isEmpty();
        assertThat(str2).isEqualTo("49bEgiQ");
        assertThat(str3).isEqualTo("0156899");
        assertThat(str4).isEqualTo("1239bMmS");
        assertThat(str5).isEqualTo("039aAkNu");
    }

    @Test
    public void dataParseSwapTest() throws Exception {
        // given
        String str1 = "134478889bcCmnST";
        String str2 = "23566aBbgils";
        String str3 = "12ab";
        String str4 = "12345";
        String str5 = "abcd";

        // when
        str1 = dataParseService.dataParseSwap(str1);
        str2 = dataParseService.dataParseSwap(str2);
        str3 = dataParseService.dataParseSwap(str3);
        str4 = dataParseService.dataParseSwap(str4);
        str5 = dataParseService.dataParseSwap(str5);

        // then
        assertThat(str1).isEqualTo("b1c3C4m4n7S8T889");
        assertThat(str2).isEqualTo("a2B3b5g6i6ls");
        assertThat(str3).isEqualTo("a1b2");
        assertThat(str4).isEqualTo("12345");
        assertThat(str5).isEqualTo("abcd");
    }

    @Test
    public void dataParseUnitTest() throws Exception {
        // given
        String str1 = "abcdefghij";
        int unit1 = 0;
        int unit2 = 1;
        int unit3 = 3;
        int unit4 = 12;

        // when
        String result1 = dataParseService.dataParseUnit(str1, unit1);
        String result2 = dataParseService.dataParseUnit(str1, unit2);
        String result3 = dataParseService.dataParseUnit(str1, unit3);
        String result4 = dataParseService.dataParseUnit(str1, unit4);

        // then
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
