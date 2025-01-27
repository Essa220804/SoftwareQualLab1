package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary {
    private String number = "0"; // string containing the binary value '0' or '1'

    /**
     * A constructor that generates a binary object.
     *
     * @param number a String of the binary values. It should contain only zeros or ones with any length and order.
     *               Otherwise, the value of "0" will be stored. Trailing zeros will be excluded, and an empty string
     *               will be considered as zero.
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

        if (this.number.isEmpty()) { // Replace empty strings with a single zero
            this.number = "0";
        }
    }

    /**
     * Return the binary value of the variable
     *
     * @return the binary value in a string format.
     */
    public String getValue() {
        return this.number;
    }

    /**
     * Adding two binary variables.
     *
     * @param num1 The first addend object
     * @param num2 The second addend object
     * @return A binary variable with a value of <i>num1+num2</i>.
     */
    public static Binary add(Binary num1, Binary num2) {
        int ind1 = num1.number.length() - 1; // Index of the first digit of num1
        int ind2 = num2.number.length() - 1; // Index of the first digit of num2
        int carry = 0;
        String num3 = ""; // The binary value of the sum

        while (ind1 >= 0 || ind2 >= 0 || carry != 0) { // Loop until all digits are processed
            int sum = carry;
            if (ind1 >= 0) {
                sum += (num1.number.charAt(ind1) == '1') ? 1 : 0;
                ind1--;
            }
            if (ind2 >= 0) {
                sum += (num2.number.charAt(ind2) == '1') ? 1 : 0;
                ind2--;
            }
            carry = sum / 2; // The new carry
            sum = sum % 2;   // The resultant digit
            num3 = ((sum == 0) ? "0" : "1") + num3; // Append the digit to the result
        }

        return new Binary(num3);
    }

    /**
 * Performs a bitwise OR operation on two binary numbers.
 *
 * @param other The other binary number to perform the OR operation with.
 * @return A new Binary object containing the result of the OR operation.
 */
    public Binary or(Binary other) {
        String thisValue = this.getValue();
        String otherValue = other.getValue();

        String thisPadded = padToEqualLength(thisValue, otherValue);
        String otherPadded = padToEqualLength(otherValue, thisValue);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < thisPadded.length(); i++) {
            char bit1 = thisPadded.charAt(i);
            char bit2 = otherPadded.charAt(i);
            result.append((bit1 == '1' || bit2 == '1') ? '1' : '0');
        }

        return new Binary(result.toString());
    }

   /**
 * Performs a bitwise AND operation on two binary numbers.
 *
 * @param other The other binary number to perform the AND operation with.
 * @return A new Binary object containing the result of the AND operation.
 */
    public Binary and(Binary other) {
        String thisValue = this.getValue();
        String otherValue = other.getValue();

        String thisPadded = padToEqualLength(thisValue, otherValue);
        String otherPadded = padToEqualLength(otherValue, thisValue);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < thisPadded.length(); i++) {
            char bit1 = thisPadded.charAt(i);
            char bit2 = otherPadded.charAt(i);
            result.append((bit1 == '1' && bit2 == '1') ? '1' : '0');
        }

        return new Binary(result.toString());
    }

   /**
 * Multiplies two binary numbers.
 *
 * @param other The other binary number to multiply with.
 * @return A new Binary object containing the product of the two binary numbers.
 */
    public Binary multiply(Binary other) {
        Binary result = new Binary("0");
        String multiplier = other.getValue();

        for (int i = multiplier.length() - 1; i >= 0; i--) {
            if (multiplier.charAt(i) == '1') {
                String shifted = this.getValue() + "0".repeat(multiplier.length() - 1 - i);
                result = Binary.add(result, new Binary(shifted));
            }
        }

        return result;
    }

    /**
 * Makes two binary numbers the same length.
 *
 * @param other The other binary number to compare length with.
 * @return A new String with the correct length.
 */
    private String padToEqualLength(String value, String otherValue) {
        int lengthDifference = otherValue.length() - value.length();
        return "0".repeat(Math.max(lengthDifference, 0)) + value;
    }

	@Override
	public String toString() {
    return this.number;
	}
}
