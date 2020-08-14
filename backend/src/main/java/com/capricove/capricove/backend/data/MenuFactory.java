package com.capricove.capricove.backend.data;

//creates menu objects using id from database

import com.capricove.capricove.backend.entities.CategoryRow;
import com.capricove.capricove.backend.entities.MenuRow;
import com.capricove.capricove.backend.entities.OptionRow;
import com.capricove.capricove.backend.entities.TagRow;
import com.capricove.capricove.backend.repositories.CategoryRepository;
import com.capricove.capricove.backend.repositories.MenuRepository;
import com.capricove.capricove.backend.repositories.OptionRepository;
import com.capricove.capricove.backend.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
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


        MenuRow menuRow = menuRepository.findById(id);
        Menu menu = new Menu(menuRow.getId(), menuRow.getName(), menuRow.getSection(), menuRow.getPrice(), menuRow.getSrc(), menuRow.getDescription());

        List<TagRow> tagRows = tagRepository.findById(id);
        for (TagRow row: tagRows){
            menu.addTag(row.getTag());
        }

        List<CategoryRow> categoryRows = categoryRepository.findById(id);
        for (CategoryRow row: categoryRows){
            menu.addCategory(row.getCategory());
        }

        List<OptionRow> optionRows = optionRepository.findById(id);
        for (OptionRow row: optionRows){
            menu.addOption(row.getOptionCategory(), row.getOptionName(), row.getOptionPrice());
        }

        return menu;
    }
}

