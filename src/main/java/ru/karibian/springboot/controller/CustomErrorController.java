package ru.karibian.springboot.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class CustomErrorController implements ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

    @RequestMapping("/error")
    public String handleError() {
        logger.error("Handling error");
        return "error"; // Возвращает имя шаблона ошибки (error.html)
    }

    public String getErrorPath() {
        return "/error"; // Указывает путь, который обрабатывает ошибки
    }
}