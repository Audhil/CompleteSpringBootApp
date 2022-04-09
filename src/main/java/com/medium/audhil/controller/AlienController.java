package com.medium.audhil.controller;

import com.medium.audhil.dao.AlienRepo;
import com.medium.audhil.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlienController {

    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }

    @Autowired
    AlienRepo alienRepo;

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien) {
        alienRepo.save(alien);
        return "home.jsp";
    }
}
