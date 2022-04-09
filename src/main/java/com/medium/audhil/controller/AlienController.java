package com.medium.audhil.controller;

import com.medium.audhil.dao.AlienJPARepo;
import com.medium.audhil.dao.AlienRepo;
import com.medium.audhil.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping("/deleteAlien")
    public ModelAndView deleteAlien(@RequestParam int aId) {
        Alien alien = alienRepo.findById(aId).orElse(new Alien());
        alienRepo.deleteById(aId);
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        mv.addObject(alien);
        return mv;
    }

    @RequestMapping("/getByTech")
    public ModelAndView getByTech(@RequestParam String tech) {
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        //  customised approach - you should follow, findBy/getBy+field name+GreaterThan/LessThan etc
        if (!alienRepo.findBytech(tech).isEmpty()) {
            Alien alien = alienRepo.findBytech(tech).get(0);
            mv.addObject(alien);
        }
        //  one more customised approach - you should follow, findBy/getBy+field name+GreaterThan/LessThan etc
        System.out.println(alienRepo.findByaIdGreaterThan(102));

        //  complex customised approach
        System.out.println(alienRepo.findByTechSorted("Kotlin"));
        return mv;
    }

    //  REST apis implementations
    @RequestMapping("/aliens")
    @ResponseBody   //  hey, I'm returning data, not a view name
    public String getAliens() {
        return alienRepo.findAll().toString();
    }

    @RequestMapping("/alien/102")
    @ResponseBody
    public String getAlien() {
        return alienRepo.findById(102).toString();
    }

    //  using wild card
    @RequestMapping("/alien/{id}")
    @ResponseBody
    public String getAlienById(@PathVariable int id) {
        return alienRepo.findById(id).toString();
    }

    //  json format
    @Autowired
    AlienJPARepo jpaRepo;

    @RequestMapping("/aliens_json")
    @ResponseBody   //  hey, I'm returning data, not a view name
    public List<Alien> getAliensJson() {
        return jpaRepo.findAll();
    }

    //  using wild card
    @RequestMapping("/alien_json/{id}")
    @ResponseBody
    public Optional<Alien> getAlienByIdJson(@PathVariable int id) {
        return jpaRepo.findById(id);
    }
}
