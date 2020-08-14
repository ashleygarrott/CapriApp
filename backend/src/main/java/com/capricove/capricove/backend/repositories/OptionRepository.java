package com.capricove.capricove.backend.repositories;

import com.capricove.capricove.backend.entities.MenuRow;
import com.capricove.capricove.backend.entities.OptionRow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<OptionRow, String> {

    List<OptionRow> findById(int id);
}
