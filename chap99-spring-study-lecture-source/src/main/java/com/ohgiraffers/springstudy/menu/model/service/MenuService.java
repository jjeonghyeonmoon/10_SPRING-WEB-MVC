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

    public void registMenu(MenuDTO menuDTO) {

        menuMapper.registMenu(menuDTO);

    }

    // 1.업데이트
    public List<MenuDTO> findAllMenus() {

        return menuMapper.findAllMenus();
    }

    public MenuDTO findMenuByCode(int menuCode) {

        return menuMapper.findMenuByCode(menuCode);
    }

    public void updateMenu(MenuDTO menuDTO) {

        menuMapper.updateMenu(menuDTO);
    }




    public List<MenuDTO> findAllMenuDelete() {
        return menuMapper.findAllMenuDelete();
    }

    public void deleteMenu(int code) {
        menuMapper.deleteMenu(code); // 영향받은 행의 수를 확인할 필요가 없다면 반환값을 무시
    }

}
