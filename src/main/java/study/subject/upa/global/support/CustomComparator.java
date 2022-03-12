package study.subject.upa.global.support;

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
     * @param s1 (비교 대상 문자열)
     * @param s2 (비교 대상 문자열)
     * @return int (정렬 기준)
     */
    @Override
    public int compare(String s1, String s2) {
        return s1.equalsIgnoreCase(s2) ? s1.compareTo(s2) : s1.compareToIgnoreCase(s2);
    }
}
