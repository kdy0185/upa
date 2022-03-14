package study.subject.upa.domain.dataparse.dto;

import lombok.Getter;

/**
 * @Class : DataType
 * @Author : KDW
 * @Date : 2022-03-14
 * @Description : 노출 유형 정보가 담긴 enum Class
 */
@Getter
public enum DataType {
    REMOVE_HTML, // HTML 태그 제외
    ALL_TEXT // Text 전체
}
