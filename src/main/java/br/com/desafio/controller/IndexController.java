package br.com.desafio.controller;

import br.com.desafio.enums.RedirectEnum;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api(tags = "Index Controller")
public class IndexController {

    @GetMapping("/")
    public String home() {
        return RedirectEnum.REDIRECT_INDEX.getValor();
    }
}