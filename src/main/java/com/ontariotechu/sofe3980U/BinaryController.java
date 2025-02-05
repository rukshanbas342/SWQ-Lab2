package com.ontariotechu.sofe3980U;

// Import the necessary Spring Libraries
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BinaryController {
	// Handles HTTP GET requests to the root URL ("/")
	@GetMapping("/")
	public String getCalculator(@RequestParam(name="operand1", required=false, defaultValue="") String operand1, Model model) {
		//Adds first operand to model, in order to be accesed in the view
		model.addAttribute("operand1", operand1);
		//Adds boolean attribute to indicate whether operand1 has any content
		model.addAttribute("operand1Focused", operand1.length()>0);
		//Returns view name calculator to be rendered
        return "calculator";
	}
	// Handles HTTP POST request to the root URL
	@PostMapping("/")
	public String result(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
	@RequestParam(name="operator", required=false, defaultValue="") String operator ,
	@RequestParam(name="operand2", required=false, defaultValue="") String operand2, Model model) {
		//Adds operands and operator to model, in order to be accesed in the view
		model.addAttribute("operand1", operand1);
		model.addAttribute("operator", operator);
		model.addAttribute("operand2", operand2);

		//Create Binary objects for each operand
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);

		// Perform the operation based on the operator provided
		switch(operator)
		{
			// Addition Operation
			case "+":
				model.addAttribute("result", Binary.add(number1,number2).getValue());
				// Returns to result view to display the output
				return "result";
			
			// OR operation
			case "|":
				model.addAttribute("result", Binary.or(number1,number2).getValue());
				return "result";

			// Multiplication Operation
			case "*":
			    model.addAttribute("result", Binary.multiply(number1,number2).getValue());
				return "result";

			// AND operation
			case "&":
			    model.addAttribute("result", Binary.and(number1,number2).getValue());
				return "result";	
			
			// Handles any undefined operations			
			default:
			    // Returns an error view if operator is invalid
				return "Error";
		}
	}

}
