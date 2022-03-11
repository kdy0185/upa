package study.subject.upa.util;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class DataUtilTest {

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
