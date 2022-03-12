package study.subject.upa.util.support;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class CustomStreamSupportTest {

    @Test
    public void interleaveTest() throws Exception {
        // given
        Stream<String> a = Stream.of("a", "c", "e");
        Stream<String> b = Stream.of("b", "d", "f");

        // when
        Stream<String> ab = CustomStreamSupport.interleave(a, b);

        // then
        String result = ab.collect(Collectors.joining());
        assertThat(result).isEqualTo("abcdef");
    }
}
