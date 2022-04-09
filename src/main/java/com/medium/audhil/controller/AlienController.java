package com.medium.audhil.controller;

import com.medium.audhil.dao.AlienRepo;
import com.medium.audhil.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aId) {  //  @RequestParam gets input from user
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Alien alien = alienRepo.findById(aId).orElse(new Alien());  //  returns Java 8 Optional<Alien> for preventing null values, we handled with orElse();
        mv.addObject(alien);
        return mv;
    }

    @RequestMapping("/updateAlien")
    public ModelAndView updateAlien(@RequestParam int aId, Alien alien) {
        Alien oldAlien = alienRepo.findById(aId).orElse(new Alien());
        oldAlien.setaName(alien.getaName());
        oldAlien.setTech(alien.getTech());
        alienRepo.save(oldAlien);
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Alien updatedAlien = alienRepo.findById(aId).orElse(new Alien());
        mv.addObject(updatedAlien);
        return mv;
    }
}
