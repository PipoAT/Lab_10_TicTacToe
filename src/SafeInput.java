import java.util.Scanner;

public class SafeInput {

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
}
