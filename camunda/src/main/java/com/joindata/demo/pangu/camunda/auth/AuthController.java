package com.joindata.demo.pangu.camunda.auth;

import org.camunda.bpm.engine.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    private IdentityService identityService;

    @GetMapping("/")
    public String list()
    {
        return identityService.getCurrentAuthentication().getUserId();
    }
}
