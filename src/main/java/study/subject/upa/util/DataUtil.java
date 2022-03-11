package study.subject.upa.util;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Class : DataUtil
 * @Author : KDW
 * @Date : 2022-03-10
 * @Description : Data 관련 util 클래스
 */
public class DataUtil {

    /**
     * <p>공백 체크</p>
     *
     * @param object (체크할 문자형, 숫자형 객체)
     * @return boolean (체크 결과)
     */
    public static boolean isEmpty(Object object) {
        return object == null || String.valueOf(object).length() == 0;
    }

    /**
     * <p>공백 제거</p>
     *
     * @param str (변경할 문자)
     * @return String (변경 후 문자)
     */
    public static String trimSpace(String str) {
        str = str.replaceAll("\r\n", "");
        str = str.replaceAll("\r", "");
        str = str.replaceAll("\n", "");
        str = str.replaceAll("\t", "");
        str = str.replaceAll(" ", "");
        return str;
    }

    /**
     * <p>출력 문자 포맷</p>
     *
     * @param unitStr (몫)
     * @param restStr (나머지)
     * @return String (포맷 후 문자)
     */
    public static String dataFormat(String unitStr, String restStr) {
        return "+----------------------------------------+" + System.lineSeparator()
            + "+----------------------------------------+" + System.lineSeparator()
            + "몫 : " + unitStr + System.lineSeparator()
            + "나머지 : " + restStr + System.lineSeparator()
            + "+----------------------------------------+" + System.lineSeparator()
            + "+----------------------------------------+" + System.lineSeparator();
    }

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
