package com.capricove.capricove.backend.data;

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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class AppDataService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private TagRepository tagRepository;

    public void addMenu(Menu menu) throws SQLException {
        //insert single attributes linearly
        //insert into menu table
        menuRepository.save(new MenuRow(menu.getId(), menu.getName(), menu.getSection(), menu.getPrice(), menu.getSrc(), menu.getDescription()));

        //insert into tags table
        for (String tag: menu.getTags()){
            tagRepository.save(new TagRow(menu.getId(), tag));
        }

        //insert into categories table
        for (String category: menu.getCategories()){
            categoryRepository.save(new CategoryRow(menu.getId(), category));
        }

        //insert into options table
        for(String optionCategory: menu.getOptions().keySet()){
            for(String option: menu.getOptions().get(optionCategory).keySet()){
                int price = menu.getOptions().get(optionCategory).get(option);
                optionRepository.save(new OptionRow(menu.getId(), optionCategory, option, price));
            }
        }
    }

    public void addMenuOption(){

    }
}


