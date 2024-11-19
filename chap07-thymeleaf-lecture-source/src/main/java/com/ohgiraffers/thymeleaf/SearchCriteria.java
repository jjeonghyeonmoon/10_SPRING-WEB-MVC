package com.ohgiraffers.thymeleaf;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SearchCriteria {

    private int startPage;  //시작페이지 번호
    private int endPage;    // 마지막페이지 번호
    private int currentPage;    //현재페이지 번호

}
