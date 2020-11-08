package uk.ac.ox.ctsu.arts.oauth2demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
public class HelloController {
    @Autowired
    @RequestMapping("/version")
    public String helloWorld() {
        return "Hello World! (no auth required)";
    }

    @Autowired
    @RequestMapping("/secure")
    public String helloWorldSecure() {
        return "Hello World! (authenticated in Azure AD)";
    }

    @Autowired
    @PreAuthorize("hasRole('bams-devops')")
    @RequestMapping("/secureByGroup")
    public String helloWorldByGroup() {
        return "Hello World! (pre-authorized via AD group)";
    }
}
