package com.ohgiraffers.crud.menu.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDTO {
    private int code;
    private String name;
    private Integer refCategoryCode;
}
