package com.example.ems.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle all exceptions
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {

        model.addAttribute("errorTitle", "Something went wrong");
        model.addAttribute("errorMessage", ex.getMessage());

        return "error"; // error.html
    }
}
