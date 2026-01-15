/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 3, 4
 * Analyzer class
 */

import java.util.Scanner;

/**
 * Prompting the user, on separate lines, for each of the 4 parameters required for the simulate method of the Simulator class.
 */
public class Analyzer {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Elevator simulator!");

        while (true) {
            System.out.print("Please enter the choice(integer 0 is regular, integer 1 is optimal): ");
            String choice = sc.next();
            int number = judgeChoice(choice);
            if (number == -1) {
                System.out.println("Invalid input, please enter again");
                continue;
            }

            System.out.print("Please enter the probability of arrival for Requests: ");
            double probability = sc.nextDouble();
            while (probability < 0.0 || probability > 1.0) {
                System.out.print("Invalid probability. Please enter a value between 0.0 and 1.0: ");
                probability = sc.nextDouble();
            }

            System.out.print("Please enter the number of floors: ");
            int numberOfFloors = sc.nextInt();
            while (numberOfFloors <= 1) {
                System.out.print("Invalid number of floors. Please enter a value greater than 1: ");
                numberOfFloors = sc.nextInt();
            }

            System.out.print("Please enter the number of elevators: ");
            int numberOfElevators = sc.nextInt();
            while (numberOfElevators <= 0) {
                System.out.print("Invalid number of elevators. Please enter a value greater than 0: ");
                numberOfElevators = sc.nextInt();
            }

            System.out.print("Please enter the length of the simulation (in time units): ");
            int length = sc.nextInt();
            while (length <= 0) {
                System.out.print("Invalid simulation length. Please enter a value greater than 0: ");
                length = sc.nextInt();
            }

            if (number == 0) {
                try {
                    Simulator.simulate(probability, numberOfFloors, numberOfElevators, length);
                } catch (InvalidStateException e) {
                    continue;
                }

            } else {
                try {
                    OptimalSimulator.simulate(probability, numberOfFloors, numberOfElevators, length);
                } catch (InvalidStateException e) {
                    continue;
                }

            }
            break;
        }
    }

    /**
     * Judge input choice whether valid.
     *
     * @param choice input
     * @return valid return 0 or 1, else return -1
     */
    private static int judgeChoice(String choice) {
        if (choice.equals("0")) {
            return 0;
        }
        if (choice.equals("1")) {
            return 1;
        }
        return -1;
    }

}
