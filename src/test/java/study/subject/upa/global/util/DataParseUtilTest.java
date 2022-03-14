package study.subject.upa.global.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.subject.upa.domain.dataparse.dto.DataParseResponse;
import study.subject.upa.domain.dataparse.dto.DataType;

/**
 * @Class : DataParseUtilTest
 * @Author : KDW
 * @Date : 2022-03-12
 * @Description : util 기능 관련 테스트 Class
 */
class DataParseUtilTest {

    private final DataParseUtil dataParseUtil = new DataParseUtil();

    @Test
    @DisplayName("HTML 태그 제거 기능 테스트")
    public void dataParseHtmlTest() throws Exception {
        // given
        String html1 = "no html";
        String html2 = "<br/>";
        String html3 = "<div>service</div>";
        String html4 = "<img src='http://google.com/' alt='sample.jpg' />";

        // when
        html1 = dataParseUtil.dataParseHtml(html1, DataType.REMOVE_HTML);
        html2 = dataParseUtil.dataParseHtml(html2, DataType.REMOVE_HTML);
        html3 = dataParseUtil.dataParseHtml(html3, DataType.REMOVE_HTML);
        html4 = dataParseUtil.dataParseHtml(html4, DataType.REMOVE_HTML);

        // then
        assertThat(html1).isEqualTo("nohtml");
        assertThat(html2).isEmpty();
        assertThat(html3).isEqualTo("service");
        assertThat(html4).isEmpty();
    }

    @Test
    @DisplayName("영문 + 숫자 출력 기능 테스트")
    public void dataParseAlphaNumericTest() throws Exception {
        // given
        String str1 = null;
        String str2 = "AbcD123";
        String str3 = "테스트";
        String str4 = "/user/system";
        String str5 = "a,b_c";

        // when
        str1 = dataParseUtil.dataParseAlphaNumeric(str1);
        str2 = dataParseUtil.dataParseAlphaNumeric(str2);
        str3 = dataParseUtil.dataParseAlphaNumeric(str3);
        str4 = dataParseUtil.dataParseAlphaNumeric(str4);
        str5 = dataParseUtil.dataParseAlphaNumeric(str5);

        // then
        assertThat(str1).isEmpty();
        assertThat(str2).isEqualTo("AbcD123");
        assertThat(str3).isEmpty();
        assertThat(str4).isEqualTo("usersystem");
        assertThat(str5).isEqualTo("abc");
    }

    @Test
    @DisplayName("데이터 정렬 기능 테스트")
    public void dataParseSortTest() throws Exception {
        // given
        String str1 = null;
        String str2 = "ib4gEQ9";
        String str3 = "8916590";
        String str4 = "9M3Sm1b2";
        String str5 = "u90aNA3k";

        // when
        str1 = dataParseUtil.dataParseSort(str1);
        str2 = dataParseUtil.dataParseSort(str2);
        str3 = dataParseUtil.dataParseSort(str3);
        str4 = dataParseUtil.dataParseSort(str4);
        str5 = dataParseUtil.dataParseSort(str5);

        // then
        assertThat(str1).isEmpty();
        assertThat(str2).isEqualTo("49bEgiQ");
        assertThat(str3).isEqualTo("0156899");
        assertThat(str4).isEqualTo("1239bMmS");
        assertThat(str5).isEqualTo("039AakNu");
    }

    @Test
    @DisplayName("데이터 교차 기능 테스트")
    public void dataParseSwapTest() throws Exception {
        // given
        String str1 = "134478889bcCmnST";
        String str2 = "23566aBbgils";
        String str3 = "12ab";
        String str4 = "12345";
        String str5 = "abcd";

        // when
        str1 = dataParseUtil.dataParseSwap(str1);
        str2 = dataParseUtil.dataParseSwap(str2);
        str3 = dataParseUtil.dataParseSwap(str3);
        str4 = dataParseUtil.dataParseSwap(str4);
        str5 = dataParseUtil.dataParseSwap(str5);

        // then
        assertThat(str1).isEqualTo("b1c3C4m4n7S8T889");
        assertThat(str2).isEqualTo("a2B3b5g6i6ls");
        assertThat(str3).isEqualTo("a1b2");
        assertThat(str4).isEqualTo("12345");
        assertThat(str5).isEqualTo("abcd");
    }

    @Test
    @DisplayName("단위별 데이터 묶음 기능 테스트")
    public void dataParseUnitTest() throws Exception {
        // given
        String str1 = "abcdefghij";
        int unit1 = 0;
        int unit2 = 1;
        int unit3 = 3;
        int unit4 = 12;

        // when
        DataParseResponse response2 = dataParseUtil.dataParseUnit(str1, unit2);
        DataParseResponse response3 = dataParseUtil.dataParseUnit(str1, unit3);
        DataParseResponse response4 = dataParseUtil.dataParseUnit(str1, unit4);

        // then
        assertThatThrownBy(
            () -> {
                dataParseUtil.dataParseUnit(str1, unit1);
            }
        ).isInstanceOf(ArithmeticException.class);
        assertAll(
            () -> assertThat(response2.getPiecesStr()).isEqualTo("abcdefghij"),
            () -> assertThat(response2.getRestStr()).isEmpty()
        );
        assertAll(
            () -> assertThat(response3.getPiecesStr()).isEqualTo("abcdefghi"),
            () -> assertThat(response3.getRestStr()).isEqualTo("j")
        );
        assertAll(
            () -> assertThat(response4.getPiecesStr()).isEqualTo("abcdefghij"),
            () -> assertThat(response4.getRestStr()).isEmpty()
        );
    }
}
