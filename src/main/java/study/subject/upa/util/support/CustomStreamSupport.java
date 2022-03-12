package study.subject.upa.util.support;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Class : CustomStreamSupport
 * @Author : KDW
 * @Date : 2022-03-12
 * @Description : 사용자 정의 Stream Support Class
 */
public class CustomStreamSupport {

    /**
     * <p>스트림 교차 기능</p>
     *
     * @param a (교차 대상 스트림)
     * @param b (교차 대상 스트림)
     * @return Stream (교차 적용한 스트림)
     */
    public static <T> Stream<T> interleave(Stream<? extends T> a, Stream<? extends T> b) {
        Spliterator<? extends T> spA = a.spliterator(), spB = b.spliterator();
        long s = spA.estimateSize() + spB.estimateSize();
        if (s < 0) {
            s = Long.MAX_VALUE;
        }
        int ch = spA.characteristics() & spB.characteristics()
            & (Spliterator.NONNULL | Spliterator.SIZED);
        ch |= Spliterator.ORDERED;

        return StreamSupport.stream(new Spliterators.AbstractSpliterator<T>(s, ch) {
            Spliterator<? extends T> sp1 = spA, sp2 = spB;

            @Override
            public boolean tryAdvance(Consumer<? super T> action) {
                Spliterator<? extends T> sp = sp1;
                if (sp.tryAdvance(action)) {
                    sp1 = sp2;
                    sp2 = sp;
                    return true;
                }
                return sp2.tryAdvance(action);
            }
        }, false);
    }
}
