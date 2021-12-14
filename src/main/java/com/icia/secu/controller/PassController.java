package com.icia.secu.controller;

import com.icia.secu.dto.MapDTO;
import com.icia.secu.dto.PassMail;
import com.icia.secu.service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PassController {

    @Autowired
    private PassService psvc;

    private ModelAndView mav = new ModelAndView();

    @GetMapping("start")
    public String start(){
        return "start";
    }

    @GetMapping("start2")
    public String start2(){
        return "start2";
    }


    @RequestMapping(value="pwemail",method = RequestMethod.POST)
    public ModelAndView pss(@ModelAttribute PassMail passmail){
        mav = psvc.pss(passmail);
        return mav;
    }

    @RequestMapping(value="pwemail2",method = RequestMethod.POST)
    public ModelAndView pss2(@ModelAttribute PassMail passmail){
        mav = psvc.pss2(passmail);
        return mav;
    }

    @GetMapping("dmap1")
    public ModelAndView dmap1(@ModelAttribute MapDTO daumMap){
        mav.setViewName("dmap1");
        mav.addObject("daumMap", daumMap);
        return mav;
    }

    @GetMapping("dmap3")
    public String dmap3(){
        return "dmap3";
    }
}
