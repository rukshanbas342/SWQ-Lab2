package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should contain only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}
	
		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}
	
		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}
	
		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);
	
		// uncomment the following code
		
		if (this.number.isEmpty()) { // replace empty strings with a single zero
			this.number = "0";
		}
  		
	}
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}
	/**
    * Using OR operation between two binary variables.
    *
    * @param num1 The first binary number
    * @param num2 The second binary number
    * @return A binary variable to store the result
    */
    public static Binary or(Binary num1, Binary num2) {
        //Read the binary numbers from right to left, as the binary operations start from the least significant bit (LSB)
		int ind1 = num1.number.length() - 1;	//ind1 & ind2 represent the last character of the number strings of num1 and num2
        int ind2 = num2.number.length() - 1;	//num1.number & num2.number represent the binary numbers in string format
        String num3 = "";  // Store the final reesult after the OR operation is complete

		//Loop through each bit in the string until the end of the string
        while (ind1 >= 0 || ind2 >= 0) {
			//If the index is valid & the character in the current postion is 1, that bit is set to 1. Otherwise it is set to 0
			//This ensures that missing bits are considered to have a value of 0
            int bit1 = (ind1 >= 0 && num1.number.charAt(ind1) == '1') ? 1 : 0;
            int bit2 = (ind2 >= 0 && num2.number.charAt(ind2) == '1') ? 1 : 0;

			//Preform OR operation.
            int resultBit = (bit1 | bit2);

			//Converts the result to string by prepending the result bit to num3
			// If resultbit is 0, '0' is appened to the front of num3, otherwise '1' is added to num3
            num3 = ((resultBit == 0) ? "0" : "1") + num3;

			//Decrement indexes to move to the next bit
            ind1--;
            ind2--;
        }

		//Return the final result
        return new Binary(num3);
    }

	/**
    * Using AND operation between two binary variables.
    *
    * @param num1 The first binary number
    * @param num2 The second binary number
    * @return A binary variable to store the result
    */
    public static Binary and(Binary num1, Binary num2) {
        //Read the binary numbers from right to left, as the binary operations start from the least significant bit (LSB)
		int ind1 = num1.number.length() - 1;	//ind1 & ind2 represent the last character of the number strings of num1 and num2
        int ind2 = num2.number.length() - 1;	//num1.number & num2.number represent the binary numbers in string format
        String num3 = "";  // Store the final reesult after the OR operation is complete

		//Loop through each bit in the string until the end of the string
        while (ind1 >= 0 || ind2 >= 0) {
			//If the index is valid & the character in the current postion is 1, that bit is set to 1. Otherwise it is set to 0
			//This ensures that missing bits are considered to have a value of 0
            int bit1 = (ind1 >= 0 && num1.number.charAt(ind1) == '1') ? 1 : 0;
            int bit2 = (ind2 >= 0 && num2.number.charAt(ind2) == '1') ? 1 : 0;

			//Preform AND operation.
            int resultBit = (bit1 & bit2); 

            //Converts the result to string by prepending the result bit to num3
			// If resultbit is 0, '0' is appened to the front of num3, otherwise '1' is added to num3
            num3 = ((resultBit == 0) ? "0" : "1") + num3;

			//Decrement indexes to move to the next bit
            ind1--;
            ind2--;
        }

		//Return the final result
        return new Binary(num3);
    }

    /**
    * Multiplication Operation of two binary numbers
    *
    * @param num1 The first binary number
    * @param num2 The second binary number
    * @return A binary variable to store result
    */
    public static Binary multiply(Binary num1, Binary num2) {

		// len1 and len2 store the length of both binary number
        int len1 = num1.number.length();
        int len2 = num2.number.length();
		// The result array will store the product, as the maximum length of the result is len1+len2
        int[] result = new int[len1 + len2];

		// Nested loop iterates through each bit of the two binary numbers from right to left
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
				// mul converts the character to its integer equivalent and multiplies them together
                int mul = (num1.number.charAt(i) - '0') * (num2.number.charAt(j) - '0');
				// sum adds the mul value to the cuurent value in result to handle any carry-over from the previous calculation
                int sum = mul + result[i + j + 1];

				// sum % 2 calculates the carry, which is added to the next position
                result[i + j + 1] = sum % 2;
				// sum / 2 calculates the value of the current bit in the result
                result[i + j] += sum / 2;
            }
        }

		//Convert the binary string result into an integer array result
        StringBuilder num3 = new StringBuilder();
		// Loop through each bit and append each bit to num3, ignoring leading zerios
        for (int r : result) {
            if (!(num3.length() == 0 && r == 0)) { 
                num3.append(r);
            }
        }

		//If the product is 0, return 0. Otherwise return the product
        return new Binary(num3.length() == 0 ? "0" : num3.toString());
    }
}

