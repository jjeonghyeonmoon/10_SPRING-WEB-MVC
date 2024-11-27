package com.ohgiraffers.springstudy.menu.model.service;

import com.ohgiraffers.springstudy.menu.model.dao.MenuMapper;
import com.ohgiraffers.springstudy.menu.model.dto.MenuDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper) {

        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenu() {
        return menuMapper.findAllMenu();
    }
}
