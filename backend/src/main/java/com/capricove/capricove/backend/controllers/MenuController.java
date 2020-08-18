package com.capricove.capricove.backend.controllers;


import com.capricove.capricove.backend.data.Menu;
import com.capricove.capricove.backend.data.MenuDTO;
import com.capricove.capricove.backend.data.MenuService;
import com.capricove.capricove.backend.data.ProductCardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

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
    public List<ProductCardDTO> getAllMenus() throws SQLException {
        return menuService.getAllMenuCards();

    }

    @PostMapping("/get_menu_item")
    public Menu getMenu(@RequestBody MenuDTO menuDTO) throws SQLException {
        return menuService.getMenuById(menuDTO.getId());
    }

}
