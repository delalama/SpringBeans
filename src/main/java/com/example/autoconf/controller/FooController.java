package com.example.autoconf.controller;

import com.example.autoconf.service.AplicationContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class FooController {
    @Autowired
    private AplicationContextService aplicationContextService;

    @GetMapping(value = "/beans" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String,String>> path(@RequestParam String packageName) {
        return new ResponseEntity<>(aplicationContextService.getBeans(packageName), HttpStatus.OK);
    }


    @GetMapping("/appContextAnalysis")
    public String appContextAnalysis(@RequestParam(required = false) String packageName, Model model) {
        Map<String, String> beans = aplicationContextService.getBeans(packageName);
        model.addAttribute("beans", beans);
        if(beans!=null){
            model.addAttribute("beansLength", beans.size());
        }
        return "appContextAnalysis";
    }


    @GetMapping("/appContextAnalysis/destroyBean")
    public void destroyBean(@RequestParam String beanId) {
        aplicationContextService.destroyBeans(beanId);
        System.out.println("Bean " + beanId + " borrada.");
    }

    @GetMapping("/appContextAnalysis/createBean")
    public void createBean(@RequestParam String beanId) {
        aplicationContextService.createBean(beanId);
        System.out.println("Bean " + beanId + " borrada.");
    }
}
