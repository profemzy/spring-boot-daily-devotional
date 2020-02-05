package com.infotitans.dailydevotional.data.repository;

import com.infotitans.dailydevotional.data.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByName(String name);
}
