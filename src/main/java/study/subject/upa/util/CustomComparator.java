package study.subject.upa.util;

import java.util.Comparator;

/**
 * @Class : CustomComparator
 * @Author : KDW
 * @Date : 2022-03-11
 * @Description : 사용자 정의 Comparator 클래스
 */
public class CustomComparator implements Comparator<String> {

    /**
     * <p>오름차순, 대소문자순 정렬</p>
     *
     * @param o1 (비교 대상 문자열)
     * @param o2 (비교 대상 문자열)
     * @return int (정렬 기준)
     */
    @Override
    public int compare(String o1, String o2) {
        return o1.equalsIgnoreCase(o2) ? (o1.toUpperCase().equals(o1) ? -1 : 1)
            : o1.compareToIgnoreCase(o2);
    }
}
