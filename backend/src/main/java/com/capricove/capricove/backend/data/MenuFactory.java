package com.capricove.capricove.backend.data;

//creates menu objects using id from database

import com.capricove.capricove.backend.entities.CategoryDAO;
import com.capricove.capricove.backend.entities.MenuDAO;
import com.capricove.capricove.backend.entities.OptionDAO;
import com.capricove.capricove.backend.entities.TagDAO;
import com.capricove.capricove.backend.repositories.CategoryRepository;
import com.capricove.capricove.backend.repositories.MenuRepository;
import com.capricove.capricove.backend.repositories.OptionRepository;
import com.capricove.capricove.backend.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
public class MenuFactory {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    OptionRepository optionRepository;

    @Autowired
    TagRepository tagRepository;

    public Menu createMenu(int id) throws SQLException {


        MenuDAO menuDAO = menuRepository.findById(id);
        Menu menu = new Menu(menuDAO.getId(), menuDAO.getName(), menuDAO.getSection(), menuDAO.getPrice(), menuDAO.getSrc(), menuDAO.getDescription());

        List<TagDAO> tagDAOS = tagRepository.findByMenuId(id);
        for (TagDAO row: tagDAOS){
            menu.addTag(row.getTag());
        }

        List<CategoryDAO> categoryDAOS = categoryRepository.findByMenuId(id);
        for (CategoryDAO row: categoryDAOS){
            menu.addCategory(row.getCategory());
        }

        List<OptionDAO> optionDAOS = optionRepository.findByMenuId(id);
        for (OptionDAO row: optionDAOS){
            menu.addOption(row.getOptionCategory(), row.getOptionName(), row.getOptionPrice());
        }

        return menu;
    }
}

