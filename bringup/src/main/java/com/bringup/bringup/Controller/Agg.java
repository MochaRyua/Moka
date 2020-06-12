package com.bringup.bringup.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Agg {

    @GetMapping("jisu")
    public String jisu() {

        return "안.녕.안.녕.나.는.지.수.야↗\n헬.륨.가.스.먹.었.더.니.요.로.케.됐.지~";
    }

    @GetMapping("dus")
    public String dus() {

        return "https://www.youtube.com/watch?v=ETqNc1IFzWE";
    }

    @GetMapping("timo")
    public String timo() {

        return "후흐흐흐헤헤흐흐흫";
    }
}
