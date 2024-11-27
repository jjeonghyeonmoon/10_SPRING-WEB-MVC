package com.ohgiraffers.springstudy.menu.model.dao;

import com.ohgiraffers.springstudy.menu.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDTO> findAllMenu();
}
