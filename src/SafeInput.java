import java.util.Scanner;

public class SafeInput {

    // Part A getNonZeroLenString
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop until it isn't
        do {
            System.out.print("\n"+prompt+": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    // Part B getInt
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt for the user
     * @return a String response that is not zero length
     */
    public static int getInt(Scanner pipe, String prompt) {
        int num = 0; // initialize variable that will return the int value
        boolean validInput; // initialize variable that sets input flag as T/F

        do {
            validInput = true;
            System.out.print("\n"+prompt+": "); // show prompt

            if (pipe.hasNextInt()) { // checks if the input is an int
                num = pipe.nextInt(); // if yes, read the int
            } else {
                String trash = pipe.next(); // Read and discard non-integer input
                System.out.println("You have input value of: " + trash);
                System.out.println("Invalid input. Please enter an integer.");
                validInput = false;
            }

            pipe.nextLine();
        } while (!validInput);

        return num;
    }

    // Part C getDouble
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt for the user
     * @return a String response that is not zero length
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double num = 0; // initialize variable that will return the int value
        boolean validInput; // initialize variable that sets input flag as T/F

        do {
            validInput = true;
            System.out.print("\n"+prompt+": "); // show prompt

            if (pipe.hasNextDouble()) { // checks if the input is an int
                num = pipe.nextDouble(); // if yes, read the int
            } else {
                String trash = pipe.next(); // Read and discard non-integer input
                System.out.println("You have input value of: " + trash);
                System.out.println("Invalid input. Please enter an double.");
                validInput = false;
            }

            pipe.nextLine(); // Clear the newline character from the input buffer
        } while (!validInput);

        return num;
    }

    // Part D getRangedInt
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt for the user
     * @param low for lower limit of integer
     * @param high for upper limit of integer
     * @return a String response that is not zero length
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int rangedInt = 0; // initialize variable that returns ranged int
        boolean validInput = false; // initialize variable that sets input flag as T/F

        do {
            System.out.print(prompt);
            if (pipe.hasNextInt()) { // checks if input is an integer
                rangedInt = pipe.nextInt();
                pipe.nextLine(); // Clear the newline character from the input buffer

                if (rangedInt >= low && rangedInt <= high) { // checks if it is within the stated bounds of high/low
                    validInput = true;
                } else { // output value is int but out of the specified range
                    System.out.println("You input the value: " + rangedInt);
                    System.out.println("Input out of range. Please try again.");
                }
            } else {
                String trash = pipe.nextLine(); // Read and discard the non-integer input
                System.out.println("You have input value of: " + trash);
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        } while (!validInput);

        return rangedInt;
    }

    // Part E getRangedDouble
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt for the user
     * @param low for lower limit of double
     * @param high for upper limit of double
     * @return a String response that is not zero length
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double rangedDouble = 0; // initialize variable that returns ranged double
        boolean validInput = false; // initialize variable that sets input flag as T/F

        do {
            System.out.print(prompt);
            if (pipe.hasNextDouble()) { // checks if input is a double
                rangedDouble = pipe.nextDouble();
                pipe.nextLine(); // Clear the newline character from the input buffer

                if (rangedDouble >= low && rangedDouble <= high) { // checks if it is within the stated bounds of high/low
                    validInput = true;
                } else { // output value is double but out of the specified range
                    System.out.println("You input the value: " + rangedDouble);
                    System.out.println("Input out of range. Please try again.");
                }
            } else {
                String trash = pipe.nextLine(); // Read and discard the non-double input
                System.out.println("You have input value of: " + trash);
                System.out.println("Invalid input. Please enter a valid double.");
            }
        } while (!validInput);

        return rangedDouble;
    }

    // Part F getYNConfirm
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt for the user
     * @return a String response that is not zero length
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean validInput = false; // initialize variable as flag of valid input T/F
        boolean userConfirmation = false; // initialize variable as flag of yes or no (true or false)

        do {
            System.out.print(prompt); // prompt user to input
            String userInput = pipe.nextLine().trim().toLowerCase(); // changes uppercase to lowercase to allow for both cases

            if (userInput.equals("y")) { // checks if user input was Y or y
                validInput = true; // sets valid response to true
                userConfirmation = true; // sets user response to true or yes
            } else if (userInput.equals("n")) { // checks if user input was N or n
                validInput = true; // sets valid response to true, but leaves user response as false or no
            } else {
                // if user does not input Y, y, N, or n, print out error
                System.out.println("You input a response of: " + userInput);
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        } while (!validInput);

        return userConfirmation;
    }


    // Part G getRegExString
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt for the user
     * @param regex for the pattern of string the string must follow
     * @return a String response that is not zero length
     */
    public static String getRegExString(Scanner pipe, String prompt, String regex) {
        String userInput = ""; // initialize variable for the string input/return string
        boolean validInput = false; // initialize variable for the input flag (T/F)

        do {
            System.out.print(prompt); // prompt user to input string
            if (pipe.hasNextLine()) { // checks to ensure user inputs a valid string
                userInput = pipe.nextLine();

                if (userInput.matches(regex)) { // checks to ensure that it matches the pattern or regex
                    validInput = true;
                } else {
                    // outputs error message if it does not match regex pattern
                    System.out.println("Input does not match the specified pattern. Please try again by entering in following pattern: " + regex);
                }
            } else { // if user inputs an invalid input, prompt error
                String invalidInput = pipe.nextLine(); // Read and discard the invalid input
                System.out.println("Your input was " + invalidInput);
                System.out.println("Invalid input. Please enter a valid string.");
            }
        } while (!validInput);

        return userInput;
    }

    // Part H/Program 06 prettyHeader
    /**
     *
     * @param msg a string that will be centered within the header
     */
    public static void prettyHeader(String msg) {
        int totalWidth = 60;
        int msgWidth = msg.length();
        int padding = (totalWidth - msgWidth - 6) / 2; // Calculate the padding on each side

        // Print the top line
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Print the second line with centered message
        System.out.print("***");
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        // If the message length is odd, add one extra space on the right side
        if (msgWidth % 2 != 0) {
            System.out.print(" ");
        }
        System.out.println("***");

        // Print the bottom line
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
