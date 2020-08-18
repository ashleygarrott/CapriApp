package com.capricove.capricove.backend.repositories;

import com.capricove.capricove.backend.entities.TagDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<TagDAO, String> {

    List<TagDAO> findByMenuId(int id);
}
