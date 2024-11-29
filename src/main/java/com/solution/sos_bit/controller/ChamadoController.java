package com.solution.sos_bit.controller;

import com.solution.sos_bit.dto.ChamadoDTO;
import com.solution.sos_bit.dto.Greeting;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChamadoController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")

    public Greeting greeting(ChamadoDTO message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getTitle()) + "!");
    }
}
