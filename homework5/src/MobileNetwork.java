/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 7, 8, 9
 * MobileNetwork class
 */

import java.awt.Point;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.ArrayList;
import java.io.*;


/**
 * The type Mobile network.
 */
public class MobileNetwork implements Serializable {
    private static final String INSERT = "I";
    private static final String DELETE = "D";
    private static final String UPDATE = "U";
    private static final String SEARCH = "S";
    private static final String PRINT = "P";
    private static final String QUIT = "Q";

    /**
     * The type Hash table.
     */
    static class HashTable {
        private Hashtable<String, Profile> network;
        private static final String FILE_NAME = "network.obj";

        /**
         * Instantiates a new Profile.
         *
         * @param size size of hashtable
         * @param load load factor
         */
        private HashTable(int size, float load) {
            network = new Hashtable<>(size, load);
            File file = new File(FILE_NAME);
            if (file.exists()) {
                try (FileInputStream fis = new FileInputStream(file);
                     ObjectInputStream ois = new ObjectInputStream(fis)) {
                    network = (Hashtable<String, Profile>) ois.readObject();
                    System.out.println("Content of hash table:");
                    for (String key : network.keySet()) {
                        System.out.println("Key: " + key + ", Value: " + network.get(key).toString());
                    }
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error reading data from file");
                }
            } else {

                System.out.println("File does not exist. Starting with an empty network.");
            }

        }

        /**
         * Add people to hashtable.
         *
         * @param people input data
         */
        private void addPeople(Profile people) {
            if (people == null) {
                System.out.println("Invalid input.");
                return;
            }
            String name = people.getFullName();
            if (network.containsKey(name)) {
                System.out.println("Duplicate people. Input again.");
                return;
            }
            network.put(name, people);
            String outName = nameFormat(name);
            System.out.println("Added " + outName + " into the table.");

            updateInfo();
        }

        /**
         * Remove from hashtable.
         *
         * @param name people name
         */
        private void removePeople(String name) {
            if (!network.containsKey(name)) {
                String outName = nameFormat(name);
                System.out.println(outName + " not found in table!");
                return;
            }
            network.remove(name);
            String outName = nameFormat(name);
            System.out.println(outName + " has been removed from the table.");

            updateInfo();
        }

        /**
         * Update table data.
         *
         * @param name update people name
         */
        private void updatePeople(String name) {
            if (!network.containsKey(name)) {
                String outName = nameFormat(name);
                System.out.println(outName + " is not in the network.");
                return;
            }
            Scanner scanner = new Scanner(System.in);
            Profile newData = network.get(name);
            String outName = nameFormat(name);
            System.out.println("Updating information for " + outName + ":");
            System.out.print("Enter a new coordinate pair [x y]: ");
            int xCoordinate = scanner.nextInt();
            int yCoordinate = scanner.nextInt();
            Point newLocation = new Point(xCoordinate, yCoordinate);
            System.out.print("Enter the new preferred network range: ");
            int newRange = scanner.nextInt();
            newData.setLocation(newLocation);
            newData.setNetworkRange(newRange);

            updateInfo();
        }

        /**
         * Search two people whether be in each other network
         *
         * @param name1 people1's name
         * @param name2 people2's name
         */
        private void searchPeople(String name1, String name2) {
            if (!network.containsKey(name1)) {
                String outName1 = nameFormat(name1);
                System.out.println(outName1 + " is not in the network.");
                return;
            }
            if (!network.containsKey(name2)) {
                String outName2 = nameFormat(name2);
                System.out.println(outName2 + " is not in the network.");
                return;
            }

            Profile people1 = network.get(name1);
            Profile people2 = network.get(name2);

            String outName1 = nameFormat(name1);
            String outName2 = nameFormat(name2);
            if (people1.isInRange(people2)) {
                System.out.println(outName1 + "and " + outName2 + " are in each other's social network.");
            } else {
                System.out.println(outName1 + "and " + outName2 + " are not in each other's social network.");
            }

        }

        /**
         * Print all friend with name.
         *
         * @param name finding people name
         */
        private void printPeople(String name) {
            if (!network.containsKey(name)) {
                String outName = nameFormat(name);
                System.out.println(outName + " is not in the network.");
                return;
            }
            Profile people = network.get(name);
            ArrayList<String> list = people.getNetwork();
            String outName = nameFormat(name);
            System.out.println("Social network for " + outName + ":");
            for (String friend : list) {
                System.out.println("[ " + friend + " ]");
            }

        }

        /**
         * Update information in ArrayList.
         */
        private void updateInfo() {
            for (Profile people1 : network.values()) {
                ArrayList<String> list = new ArrayList<>();
                for (Profile people2 : network.values()) {
                    if (people1 != people2 && people1.isInRange(people2)) {
                        list.add(nameFormat(people2.getFullName()));
                    }
                }
                people1.setNetwork(list);
            }
        }

        /**
         * Save data into file.
         */
        private void saveToFile() {
            try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(network);
                System.out.println("Data saved to file: " + FILE_NAME);
            } catch (IOException e) {
                System.out.println("Error saving data to file: " + FILE_NAME);
                e.printStackTrace();
            }
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        HashTable network = new HashTable(8, 0.8f);
        loop:
        while (true) {
            System.out.println("I) Insert a new user profile into the table.");
            System.out.println("D) Delete a user profile from the table.");
            System.out.println("U) Update the information for a given profile in the table.");
            System.out.println("S) Search to see if two users are within each other's mobile social network.");
            System.out.println("P) Print out a user's social network.");
            System.out.println("Q) Quit Program");
            System.out.print("Enter Your Choice: ");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next().toUpperCase();
            switch (choose) {
                case INSERT -> {
                    try {
                        insert(network);
                    } catch (IllegalNameException illegalNameException) {
                        System.out.println("Error:  User name not valid, entry ignored.");
                    } catch (IllegalCoordinatesException illegalCoordinatesException) {
                        System.out.println("Error:  User coordinates not valid, entry ignored.");
                    } catch (IllegalRangeException illegalRangeException) {
                        System.out.println("Error:  User network range not valid, entry ignored.");
                    }
                }

                case DELETE -> {
                    try {
                        delete(network);
                    } catch (IllegalNameException illegalNameException) {
                        System.out.println("Error:  User name not valid, entry ignored.");
                    } catch (IllegalCoordinatesException illegalCoordinatesException) {
                        System.out.println("Error:  User coordinates not valid, entry ignored.");
                    } catch (IllegalRangeException illegalRangeException) {
                        System.out.println("Error:  User network range not valid, entry ignored.");
                    }
                }

                case UPDATE -> {
                    try {
                        update(network);
                    } catch (IllegalNameException illegalNameException) {
                        System.out.println("Error:  User name not valid, entry ignored.");
                    } catch (IllegalCoordinatesException illegalCoordinatesException) {
                        System.out.println("Error:  User coordinates not valid, entry ignored.");
                    } catch (IllegalRangeException illegalRangeException) {
                        System.out.println("Error:  User network range not valid, entry ignored.");
                    }
                }
                case SEARCH -> {
                    try {
                        search(network);
                    } catch (IllegalNameException illegalNameException) {
                        System.out.println("Error:  User name not valid, entry ignored.");
                    } catch (IllegalCoordinatesException illegalCoordinatesException) {
                        System.out.println("Error:  User coordinates not valid, entry ignored.");
                    } catch (IllegalRangeException illegalRangeException) {
                        System.out.println("Error:  User network range not valid, entry ignored.");
                    }
                }
                case PRINT -> {
                    try {
                        print(network);
                    } catch (IllegalNameException illegalNameException) {
                        System.out.println("Error:  User name not valid, entry ignored.");
                    } catch (IllegalCoordinatesException illegalCoordinatesException) {
                        System.out.println("Error:  User coordinates not valid, entry ignored.");
                    } catch (IllegalRangeException illegalRangeException) {
                        System.out.println("Error:  User network range not valid, entry ignored.");
                    }
                }
                case QUIT -> {
                    network.saveToFile();
                    System.out.println("Exiting Program...");
                    break loop;
                }
                default -> System.out.println("** Invalid Option **");
            }
        }
    }

    /**
     * Insert a new user profile into the table.
     *
     * @param network hashtable
     */
    private static void insert(HashTable network) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the First Name: ");
        String firstName = input.next().toLowerCase();
        System.out.print("Enter the Last Name: ");
        String lastName = input.next().toLowerCase();
        String name = firstName + " " + lastName;

        System.out.print("Enter a coordinate pair [x y]: ");
        int xCoordinate = input.nextInt();
        int yCoordinate = input.nextInt();
        Point location = new Point(xCoordinate, yCoordinate);

        System.out.print("Enter the preferred network range: ");
        int range = input.nextInt();

        Profile people = new Profile(name, location, range);
        network.addPeople(people);
    }

    /**
     * Delete a user profile from the table.
     *
     * @param network hashtable
     */
    private static void delete(HashTable network) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the First Name: ");
        String firstName = input.next().toLowerCase();
        System.out.print("Enter the Last Name: ");
        String lastName = input.next().toLowerCase();
        String name = firstName + " " + lastName;

        network.removePeople(name);
    }

    /**
     * Update the information for a given profile in the table.
     *
     * @param network hashtable
     */
    private static void update(HashTable network) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the First Name: ");
        String firstName = input.next().toLowerCase();
        System.out.print("Enter the Last Name: ");
        String lastName = input.next().toLowerCase();
        String name = firstName + " " + lastName;

        network.updatePeople(name);
    }

    /**
     * Search to see if two users are within each other's mobile social network.
     *
     * @param network hashtable
     */
    private static void search(HashTable network) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter person one's First Name: ");
        String firstNameOne = input.next().toLowerCase();
        System.out.print("Enter person one's Last Name: ");
        String lastNameOne = input.next().toLowerCase();
        String nameOne = firstNameOne + " " + lastNameOne;

        System.out.print("Enter person two's First Name: ");
        String firstNameSecond = input.next().toLowerCase();
        System.out.print("Enter person two's Last Name: ");
        String lastNameSecond = input.next().toLowerCase();
        String nameSecond = firstNameSecond + " " + lastNameSecond;

        network.searchPeople(nameOne, nameSecond);
    }

    /**
     * Print out a user's social network.
     *
     * @param network hashtable
     */
    private static void print(HashTable network) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the First Name: ");
        String firstName = input.next().toLowerCase();
        System.out.print("Enter the Last Name: ");
        String lastName = input.next().toLowerCase();
        String name = firstName + " " + lastName;

        network.printPeople(name);
    }

    /**
     * Format name to proper form
     *
     * @param name origin name
     * @return format name
     */
    private static String nameFormat(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        String[] parts = name.split(" ");
        String part1 = parts[0];
        String part2 = parts[1];
        String name1 = part1.substring(0, 1).toUpperCase() + part1.substring(1);
        String name2 = part2.substring(0, 1).toUpperCase() + part2.substring(1);
        name = name1 + " " + name2;
        return name;

    }
}