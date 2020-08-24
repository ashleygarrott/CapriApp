package com.capricove.capricove.backend.controllers;

import com.capricove.capricove.backend.data.Menu;
import com.capricove.capricove.backend.services.AppDataService;
import com.capricove.capricove.backend.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    AppDataService appDataService;

    @GetMapping("/add_menus")
    public void addMenus() throws SQLException {
        Menu menu = new Menu(1, "Habizza", "italian", 0, "https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg", "this is a description");
        menu.addCategory("pizza");
        menu.addOption("size", "large", 480);
        menu.addOption("size", "small", 320);
        appDataService.addMenu(menu);
        menu = new Menu(2, "Arcadio", "italian", 0, "https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg", "this is a description");
        menu.addCategory("pizza");
        menu.addOption("size", "large", 340);
        menu.addOption("size", "small", 220);
        appDataService.addMenu(menu);
        menu = new Menu(3, "Four cheese", "italian", 0, "https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg", "this is a description");
        menu.addCategory("pizza");
        menu.addOption("size", "large", 420);
        menu.addOption("size", "small", 250);
        appDataService.addMenu(menu);
        menu = new Menu(4, "Bolognese", "italian", 0, "https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg", "this is a description");
        menu.addCategory("pizza");
        menu.addOption("size", "large", 380);
        menu.addOption("size", "small", 240);
        appDataService.addMenu(menu);
        menu = new Menu(5, "Black truffle", "italian", 0, "https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg", "this is a description");
        menu.addCategory("pizza");
        menu.addOption("size", "large", 380);
        menu.addOption("size", "small", 240);
        appDataService.addMenu(menu);
        menu = new Menu(6, "Bacon and onion", "italian", 0, "https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg", "this is a description");
        menu.addCategory("pizza");
        menu.addOption("size", "large", 340);
        menu.addOption("size", "small", 220);
        appDataService.addMenu(menu);
        menu = new Menu(7, "Bacon and onion", "italian", 0, "https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg", "this is a description");
        menu.addCategory("pizza");
        menu.addOption("size", "large", 340);
        menu.addOption("size", "small", 220);
        appDataService.addMenu(menu);
        menu = new Menu(8, "Hawaiian", "italian", 0, "https://www.newyorkpizza.co.th/wp-content/uploads/2018/07/Featured_Main.jpg", "this is a description");
        menu.addCategory("pizza");
        menu.addOption("size", "large", 340);
        menu.addOption("size", "small", 220);
        appDataService.addMenu(menu);
        menu = new Menu(9, "Margarita", "italian", 0, "", "this is a description");
        menu.addCategory("pizza");
        menu.addOption("size", "large", 340);
        menu.addOption("size", "small", 220);
        appDataService.addMenu(menu);
        menu = new Menu(10, "Four season", "italian", 0, "", "this is a description");
        menu.addCategory("pizza");
        menu.addOption("size", "large", 340);
        menu.addOption("size", "small", 220);
        appDataService.addMenu(menu);




    }
}
