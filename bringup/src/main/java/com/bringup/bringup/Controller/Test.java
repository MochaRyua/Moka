package com.bringup.bringup.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping
    public String test() {

        return "HTTPS 성공 tlqkf 그지 같은 SSL";
    }
}
