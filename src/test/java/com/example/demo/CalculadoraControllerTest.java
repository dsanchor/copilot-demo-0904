package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CalculadoraController.class)
public class CalculadoraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFazerOp() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculadora/fazerOp")
                .param("num1", "2")
                .param("num2", "3")
                .param("op", "+"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("5.0"));
    }

    @Test
    public void testReverseString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculadora/reverseString")
                .param("input", "hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("olleh"));
    }

    // test reverse with spcial characters
    @Test
    public void testReverseStringWithSpecialCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculadora/reverseString")
                .param("input", "hello!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("!olleh"));
    }

    // test reverse with empty string
    @Test
    public void testReverseStringWithEmptyString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculadora/reverseString")
                .param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    public void testRemoveVowels() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculadora/removeVowels")
                .param("input", "hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hll"));
    }

    @Test
    public void testRemoveVowelsWithSpecialCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculadora/removeVowels")
                .param("input", "hello!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hll!"));
    }

    @Test
    public void testRemoveVowelsWithEmptyString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/calculadora/removeVowels")
                .param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}