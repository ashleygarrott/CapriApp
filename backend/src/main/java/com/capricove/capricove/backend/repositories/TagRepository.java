package com.capricove.capricove.backend.repositories;

import com.capricove.capricove.backend.entities.MenuRow;
import com.capricove.capricove.backend.entities.TagRow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<TagRow, String> {

    List<TagRow> findById(int id);
}
