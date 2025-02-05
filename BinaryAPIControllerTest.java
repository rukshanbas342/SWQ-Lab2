package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    // Test for the "/add" endpoint (binary addition)
    @Test
    public void add() throws Exception {
        // Simulate GET request to add with two operands
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
        // Expects HTTP Status 200 (OK)    
        .andExpect(status().isOk())
        // Expect result value to be 10001
        .andExpect(content().string("10001"));
    }
    // Test for the "/add_json" endpoint (binary addition in JSON format)
	@Test
    public void add2() throws Exception {
        // Simulate GET request to add with two operands
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            // Expects HTTP Status 200 (OK)    
            .andExpect(status().isOk())
            // Expect Operand1 to equal 111
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			// Expect Operand2 to equal 1010
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			// Expect Result to equal 10001
            .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			// Expect Operator to be add
            .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // Test for the "/multiply" endpoint (binary multiplication)
    @Test
    public void multiply() throws Exception {
        // Simulate GET request to multiply with two operands
        this.mvc.perform(get("/multiply").param("operand1","111").param("operand2","1010"))//.andDo(print())
            // Expects HTTP Status 200 (OK)
            .andExpect(status().isOk())
            // Expect Result to equal 1000110
            .andExpect(content().string("1000110"));
    }
    // Test for the "/multiply_json" endpoint (binary multiplication in JSON format)
	@Test
    public void multiply2() throws Exception {
        // Simulate GET request to multiply with two operands
        this.mvc.perform(get("/multiply_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            // Expects HTTP Status 200 (OK)    
            .andExpect(status().isOk())
            // Expects Operand1 to equal 111
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			// Expects Operand2 to equal 1010
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			// Expects Result to equal 1000110
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1000110))
            // Expect Operator to be multiply
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }
    // Test for the "/and" endpoint (binary AND operation)
    @Test
    public void and() throws Exception {
        // Simulate GET request to preform AND operation with two operands 
        this.mvc.perform(get("/and").param("operand1","111").param("operand2","1010"))//.andDo(print())
            // Expects HTTP Status 200 (OK)
            .andExpect(status().isOk())
            // Expects Result to equal 10
            .andExpect(content().string("10"));
    }
    // Test for the "/and" endpoint (binary AND operation in JSON format)
	@Test
    public void and2() throws Exception {
        // Simulate GET request to prefrom AND operation with two operands
        this.mvc.perform(get("/and_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            // Expects HTTP Status 200 (OK)    
            .andExpect(status().isOk())
            // Expects Operand1 to equal 111
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			// Expects Operand2 to equal 1010
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			// Expects Result to equal 10
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10))
            // Expect Operator to be AND
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));       
    }

    // Test for the "/or" endpoint (binary OR operation)
    @Test
    public void or() throws Exception {
        // Simulate GET request to preform OR operation with two operands
        this.mvc.perform(get("/or").param("operand1","111").param("operand2","1010"))//.andDo(print())
            // Expects HTTP Status 200 (OK)     
            .andExpect(status().isOk())
            // Expects Result to equal 1111
            .andExpect(content().string("1111"));
    }
    // Test for the "/or" endpoint (binary OR operation in JSON format)
	@Test
    public void or2() throws Exception {
        // Simulate GET request to preform OR operation with two operands
        this.mvc.perform(get("/or_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            // Expects HTTP Status 200 (OK)
            .andExpect(status().isOk())
            // Expects Operand1 to equal 111
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
            // Expects Operand2 to equal 1010
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
            // Expects Result to equal 1111
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1111))
            // Expects Operator to be OR
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
            
    }


}
