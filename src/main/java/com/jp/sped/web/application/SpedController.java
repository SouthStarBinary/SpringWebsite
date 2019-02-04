package com.jp.sped.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpedController {

    @GetMapping("/index")
    public String getHome () {
        return "index";
    }

    @GetMapping("/About_Me")
    public String getAboutMe () {
        return "About_Me";
    }

//    @GetMapping("/database_ex")
//    public String getDatabaseEx() { return "database_ex";}

    @GetMapping("/personal_projects")
    public String getPersonalProjects() {return "personal_projects";}
}
