/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 5
 * Club class
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Club class.
 */
public class Club {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("I) Insert a new record");
        System.out.println("C) Cancel membership");
        System.out.println("L) List active members");
        System.out.println("N) Number of active members");
        System.out.println("S) Status of a member");
        System.out.println("A) List active members in a given area");
        System.out.println("D) Depth of the tree");
        System.out.println("Q) Quit the program");
        System.out.println("R) Read mailing records from a file");
        ZipCodeTree tree = new ZipCodeTree();
        loop:
        while (true) {
            System.out.print("Enter Your Choice:");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next().toUpperCase();
            switch (choose) {
                case "I" -> insert(tree);
                case "C" -> cancel(tree);
                case "L" -> printList(tree);
                case "N" -> printNumActive(tree);
                case "S" -> status(tree);
                case "A" -> listActive(tree);
                case "D" -> System.out.println("The depth of the Tree is " + tree.maxDepth(tree.getRoot()) + ".");
                case "Q" -> {
                    System.out.println("Exiting Program...");
                    break loop;
                }
                case "R" -> getFromFile(tree);
                default -> System.out.println("** Invalid Option **");
            }
        }
    }

    /**
     * Read mailing records from a file
     *
     * @param tree has created
     */
    private static void getFromFile(ZipCodeTree tree) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = input.nextLine();
        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String name = fileScanner.nextLine();
                String street = fileScanner.nextLine();
                String cityState = fileScanner.nextLine();
                int zipCode = Integer.parseInt(input.nextLine());
                Member m = new Member(name, street, cityState, zipCode);
                tree.insert(m);
            }
            System.out.println("Mailing records have been read from the file successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    /**
     * Number of active members
     *
     * @param tree has created
     */
    private static void printNumActive(ZipCodeTree tree) {
        System.out.println("Number of active members at each zip code:");
        System.out.println();
        System.out.println("  Zip Code    Number of Members");
        System.out.println("  --------    -----------------");
        tree.traverseInOrder(tree.getRoot(), 2);
    }

    /**
     * List active members in a given area
     *
     * @param tree has created
     */
    private static void listActive(ZipCodeTree tree) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Zip Code: ");
        int zipCode = Integer.parseInt(input.nextLine());

        ZipCodeNode targetNode = tree.find(zipCode);
        if (targetNode == null) {
            System.out.println("Zip Code Not Found!");
            return;
        }
        System.out.println("List of all active members with zip code greater than or equal to " + zipCode + ":");
        System.out.println("        Name                  Street              City and State    Zip ");
        System.out.println("--------------------- ------------------------- ------------------ -----");
        MemberList list = targetNode.getMemberList();
        for (int i = 0; i < list.getSize(); i++) {
            Member m = list.getMember(i);
            System.out.printf("%-21s%-26s%19s%06d\n", m.getName(), m.getStreet(), m.getCityState(), m.getZipCode());
        }


    }

    /**
     * Status of a member
     *
     * @param tree has created
     */
    private static void status(ZipCodeTree tree) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Name: ");
        String name = input.nextLine();
        System.out.print("Enter a Zip Code: ");
        int zipCode = Integer.parseInt(input.nextLine());

        Member target = new Member();
        target.setName(name);
        target.setZipCode(zipCode);


        ZipCodeNode targetNode = tree.find(zipCode);
        if (targetNode == null) {
            System.out.println("ZipCode Not Found!");
            return;
        }
        boolean found = false;
        MemberList list = targetNode.getMemberList();

        for (int i = 0; i < list.getSize(); i++) {
            Member m = list.getMember(i);
            if (m.getName().equals(target.getName())) {
                System.out.println("Mailing address and status for user:");
                System.out.println();
                if(m.isActive()){
                    System.out.println(m.getStreet() + "            " + m.getCityState() + " " + m.getZipCode() + " (active)");
                }else{
                    System.out.println(m.getStreet() + "            " + m.getCityState() + " " + m.getZipCode() + " (inactive)");
                }

                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Member Not Found!");
        }

    }

    /**
     * List active members
     *
     * @param tree has created
     */
    private static void printList(ZipCodeTree tree) {
        System.out.println("List of all active members:");
        System.out.println("        Name                  Street              City and State    Zip ");
        System.out.println("--------------------- ------------------------- ------------------ -----");
        tree.traverseInOrder(tree.getRoot(), 1);
    }

    /**
     * Cancel membership
     *
     * @param tree has created
     */
    private static void cancel(ZipCodeTree tree) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Name: ");
        String name = input.nextLine();
        System.out.print("Enter a Zip Code: ");
        int zipCode = Integer.parseInt(input.nextLine());

        Member cancelMember = new Member();
        cancelMember.setName(name);
        cancelMember.setZipCode(zipCode);

        ZipCodeNode tempNode = tree.find(zipCode);
        if (tempNode == null) {
            System.out.println("Member Not Found!");
            return;
        }

        boolean result = tempNode.getMemberList().removeMember(cancelMember);
        if (result) {
            System.out.println("Cancelling Membership for " + name + "...");
        } else {
            System.out.println("Member Not Found!");
        }
    }

    /**
     * Insert a new record
     *
     * @param tree has created
     */
    private static void insert(ZipCodeTree tree) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Name: ");
        String name = input.nextLine();
        System.out.print("Enter a Street: ");
        String street = input.nextLine();
        System.out.print("Enter the City and State: ");
        String cityState = input.nextLine();
        System.out.print("Enter a Zip Code: ");
        int zipCode = Integer.parseInt(input.nextLine());
        //record member
        Member m = new Member(name, street, cityState, zipCode);
        //record zipNode into tree
        tree.insert(m);
        System.out.println("Inserting " + name + " into List...");

    }


}

