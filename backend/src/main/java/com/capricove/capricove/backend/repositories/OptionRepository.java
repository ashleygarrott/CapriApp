package com.capricove.capricove.backend.repositories;

import com.capricove.capricove.backend.entities.OptionDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<OptionDAO, String> {

    List<OptionDAO> findByMenuId(int id);
}
