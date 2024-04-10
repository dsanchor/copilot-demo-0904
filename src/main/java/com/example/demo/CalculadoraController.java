package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping("/fazerOp")
    public double fazerOp(@RequestParam(name = "num1") double a, @RequestParam(name = "num2") double b,
            @RequestParam(name = "op") String op) {
        System.out.println("Input: num1=" + a + ", num2=" + b + ", op=" + op);
        double result;
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Operation '%s' not recognized. Should be  '+', '-', '*' ou '/'.", op));
        }
        System.out.println("Output: " + result);
        return result;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException e) {
        return e.getMessage();
    }

    @GetMapping("/reverseString")
    public String reverseString(@RequestParam(name = "input") String input) {
        System.out.println("Input: " + input);
        String result = new StringBuilder(input).reverse().toString();
        System.out.println("Output: " + result);
        return result;
    }

    // remove vowels
    @GetMapping("/removeVowels")
    public String removeVowels(@RequestParam(name = "input") String input) {
        System.out.println("Input: " + input);
        String result = input.replaceAll("[aeiouAEIOU]", "");
        System.out.println("Output: " + result);
        return result;
    }
}
