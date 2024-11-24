package com.ohgiraffers.crud.menu.model.dao;

import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuAndCategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/* comment.
*   mybatis 의 전용 어노테이션으로 Repository 의
*   더 구체적인 기능을 가진 어노테이션이다.
* */
@Mapper
public interface MenuMapper {


    List<MenuDTO> findAllMenus();

    List<CategoryDTO> findAllCategory();

    void registNewMenu(MenuDTO newMenu);

//    List<OneCategoryCodeDTO> findOneMenu();


    // SQL 실행 → 데이터베이스에서 결과 조회
    List<String> findOneMenu(int CategoryCode);


    List<MenuAndCategoryDTO> findAllMenuAndCategory();


    void deleteMenu(int menuCode);

    void updateMenu(MenuDTO menuDTO); // 업데이트 메서드

    MenuDTO findMenuByCode(int menuCode);

    List<MenuDTO> findMenuByKeyword(String keyword);

}





//1.사용자 요청 (브라우저):
//
//URL 요청 → /menu/menuCodeList?categoryCode=5.
//2,컨트롤러:
//
//요청 처리 → menuService.findOneMenu(categoryCode) 호출.
//3.서비스:
//
//비즈니스 로직 처리 → menuMapper.findOneMenu(categoryCode) 호출.
//4.DAO:
//
//SQL 실행 → 데이터베이스에서 결과 조회.
//5.데이터베이스:
//
//SQL 처리 → 조회된 결과 반환.
//6.DAO → 서비스:
//
//데이터베이스에서 조회된 결과를 서비스로 전달.
//7.서비스 → 컨트롤러:
//
//서비스에서 받은 데이터를 컨트롤러로 전달.
//8.컨트롤러 → 뷰:
//
//모델에 데이터를 담아 뷰(HTML 파일)에 전달.
//9.뷰 → 사용자 화면:
//
//HTML 렌더링 → 결과 화면 출력.
