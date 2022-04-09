package com.medium.audhil.dao;

import com.medium.audhil.model.Alien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien, Integer> {

    List<Alien> findBytech(String tech);    //  findByTech(String tech) also works

    List<Alien> findByaIdGreaterThan(int aId);

    @Query("from Alien where tech=?1 order by aName")
    List<Alien> findByTechSorted(String tech);
}
