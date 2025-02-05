package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {
	
	// Handles the HTTP GET requests to the "/add" endpoint for binary addition
	@GetMapping("/add")
	public String addString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		// Creates a Binary Object for both Binary Numbers
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		// Adds two binary numbers and returns result as string
        return  Binary.add(number1,number2).getValue();
		// http://localhost:8080/add?operand1=111&operand2=1010
	}
	// Handles the HTTP GET requests to the "/add_json" endpoint, returns the result in JSON
	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		// Creates a Binary Object for both Binary Numbers
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		// Adds two binary numbers and returns result as string, and returns result as a JSON object
        return  new BinaryAPIResult(number1,"add",number2,Binary.add(number1,number2));
		//http://localhost:8080/add?operand1=111&operand2=1010
	}

	// Handles the HTTP GET requests to the "/and" endpoint for the binary AND Operation
	@GetMapping("/and")
	public String andString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		// Creates a Binary Object for both Binary Numbers
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		// Performs binary AND operation and returns result as string
        return  Binary.and(number1,number2).getValue();
		// http://localhost:8080/and?operand1=111&operand2=1010
	}
	// Handles the HTTP GET requests to the "/and" endpoint for binary AND operation
	@GetMapping("/and_json")
	public BinaryAPIResult andJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		// Creates a Binary Object for both Binary Numbers
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		// Performs binary AND operation and returns result as a JSON object
        return  new BinaryAPIResult(number1,"and",number2,Binary.and(number1,number2));
		// http://localhost:8080/and?operand1=111&operand2=1010
	}
	//Handles the HTTP GET requests to the "/or" endpoint for binary OR operation
	@GetMapping("/or")
	public String orString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		// Creates a Binary Object for both Binary Numbers
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		// Performs binary OR operation and returns result as string
        return  Binary.or(number1,number2).getValue();
		// http://localhost:8080/or?operand1=111&operand2=1010
	}
	
	//Handles the HTTP GET requests to the "/or" endpoint for binary OR operation
	@GetMapping("/or_json")
	public BinaryAPIResult orJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		// Creates a Binary Object for both Binary Numbers
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		// Performs binary OR operation and returns result as a JSON object
        return  new BinaryAPIResult(number1,"or",number2,Binary.or(number1,number2));
		// http://localhost:8080/or?operand1=111&operand2=1010
	}
	//Handles the HTTP GET requests to the "/multiply" endpoint for binary multiplication
	@GetMapping("/multiply")
	public String multiplyString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		// Creates a Binary Object for both Binary Numbers
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		// Performs binary multiply operation and returns result as string
        return  Binary.multiply(number1,number2).getValue();
		// http://localhost:8080/multiply?operand1=111&operand2=1010
	}
	//Handles the HTTP GET requests to the "/multiply" endpoint for binary multiplication
	@GetMapping("/multiply_json")
	public BinaryAPIResult multiplyJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		// Creates a Binary Object for both Binary Numbers
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		// Performs binary multiply operation and returns result as a JSON object
        return  new BinaryAPIResult(number1,"multiply",number2,Binary.multiply(number1,number2));
		// http://localhost:8080/multiply?operand1=111&operand2=1010
	}

}