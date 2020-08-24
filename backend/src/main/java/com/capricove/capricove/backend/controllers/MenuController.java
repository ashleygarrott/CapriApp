package com.capricove.capricove.backend.controllers;


import com.capricove.capricove.backend.data.Menu;
import com.capricove.capricove.backend.data.MenuDTO;
import com.capricove.capricove.backend.data.StringDTO;
import com.capricove.capricove.backend.services.MenuService;
import com.capricove.capricove.backend.data.ProductCardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/get_categories")
    public List<String> getCategories() throws SQLException {
        return menuService.getCategories();
    }

    @GetMapping("/get_all_menu_cards")
    public List<ProductCardDTO> getAllMenuCards() throws SQLException {
        return menuService.getAllMenuCards();

    }

    @GetMapping("/get_all_menus")
    public List<Menu> getAllMenus() throws SQLException {
        return menuService.getAllMenus();
    }

    @PostMapping("/get_menu_item")
    public Menu getMenu(@RequestBody MenuDTO menuDTO) throws SQLException {
        return menuService.getMenuById(menuDTO.getId());
    }

    @PostMapping("/get_menu_by_category")  //categoryName
    public List<Menu> getMenuByCategory(@RequestBody StringDTO stringDTO) throws SQLException {
        return menuService.getMenusByCategory(stringDTO.getString());
    }

}
