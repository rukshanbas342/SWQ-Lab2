package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

   // Test the default GET request without the parameters
    @Test
    public void getDefault() throws Exception {
        // Simulate a GET request to the root URL ("/")
        this.mvc.perform(get("/"))//.andDo(print())
            // Expects HTTP Status 200 (OK)
            .andExpect(status().isOk())
            // Expects the view to be calculator
            .andExpect(view().name("calculator"))
            // Expects the first operand to be empty and not focused
			.andExpect(model().attribute("operand1", ""))
            // Expects no input
			.andExpect(model().attribute("operand1Focused", false));
    }
	// Test the GET request with a parameter for operand1
	@Test
    public void getParameter() throws Exception {
        // Simulate a GET request to the root URL ("/") with a parameter for operand1
        this.mvc.perform(get("/").param("operand1","111"))
            // Expects HTTP Status 200 (OK)
            .andExpect(status().isOk())
            // Expects the view to be calculator
            .andExpect(view().name("calculator"))
            // Expects the first operand to equal 111
			.andExpect(model().attribute("operand1", "111"))
            // Expects no input
			.andExpect(model().attribute("operand1Focused", true));
    }
    // Test the POST request for addition operation
	@Test
	    public void postParameter() throws Exception {
        // Simulate a POST request to the root URL ("/") with parameters for operand1, operator and operand2
        this.mvc.perform(post("/").param("operand1","111").param("operator","+").param("operand2","111"))//.andDo(print())
            // Expects HTTP Status 200 (OK)
            .andExpect(status().isOk())
            // Expects the view to be result
            .andExpect(view().name("result"))
            // Expects the result to equal 1110
			.andExpect(model().attribute("result", "1110"))
            // Expects the first operand to equal 111
			.andExpect(model().attribute("operand1", "111"));
    }
    // Test the POST request for multiplication operator
    @Test
    public void testMultiply() throws Exception {
        // Simulates a POST request
        this.mvc.perform(post("/")
                //Operand1 = 101
                .param("operand1", "101")
                //Operator = *
                .param("operator", "*")
                //Operand2 = 11
                .param("operand2", "11"))
                //Expects HTTP status 200 (OK)
                .andExpect(status().isOk())
                // Expects result to be 1111
                .andExpect(model().attribute("result", "1111")); 
    }

    // Test the POST request for AND operation
    @Test
    public void testAndOperation() throws Exception {
        // Simulates a POST request
        this.mvc.perform(post("/")
                //Operand1 = 1101            
                .param("operand1", "1101")
                //Operator = &
                .param("operator", "&")
                //Operand2 = 1011
                .param("operand2", "1011"))
                // Expects HTTP status 200 (OK)
                .andExpect(status().isOk())
                // Expects result to be 1001
                .andExpect(model().attribute("result", "1001")); 
    }
    // Test the POST request for OR operation
    @Test
    public void testOrOperation() throws Exception {
        // Simulates a POST request
        this.mvc.perform(post("/")
                //Operand1 = 1100
                .param("operand1", "1100")
                //Operator = OR
                .param("operator", "|")
                //Operand2 = 1010
                .param("operand2", "1010"))
                //Expects HTTP 200 (OK)
                .andExpect(status().isOk())
                // Expects result to be 1110
                .andExpect(model().attribute("result", "1110")); 
    }

}
