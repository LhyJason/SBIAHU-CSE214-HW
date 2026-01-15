/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 2
 * Editor class
 */

import java.util.Scanner;

/**
 * This class will contain a main method that receives a sequence of options
 * from the keyboard and performs necessary action after each option is entered.
 * Following is the list of valid options and required values, along with what
 * to do if the user enters that option.
 */
public class Editor {
    /**
     * Test class of program
     *
     * @param args A <number of lines>
     *             Appends one or more lines at the end of text. Prompt the user for
     *             the lines, one at the time, and append it to the end of text
     *             after each line is entered. Also, set the current line to the
     *             last line appended.
     *             H
     *             Helps the user by displaying all valid options.
     *             I <number of lines>
     *             Inserts one or more lines before the current line. You must
     *             prompt the user for the lines, one at the time, and after the
     *             user enters a string, insert it before the current line. The
     *             current line is not changed.
     *             L <startingLine> <endingLine>
     *             Prints one or more lines of the text, from startingLine to
     *             endingLine, and each line is preceded by its line number. If
     *             startingLine is greater than endingLine, or if it doesn't exist,
     *             print an appropriate message and ignore the entry. If endingLine
     *             exceeds number of lines in the text, simply stop at the last line
     *             of the text. The current line should be set to the last line
     *             printed. This option can also be used to move the current line to
     *             a specific position. For example "L 3 3" prints the third line
     *             and sets the current line to that line.
     *             N
     *             Moves forward to the next line and prints that line. If current
     *             line is at the bottom of text, prints a message and ignores the
     *             entry.
     *             P
     *             Moves backward to the previous line and prints that line. If
     *             current line is at the top of text, prints a message and ignores
     *             the entry.
     *             R
     *             Removes the current line, if there's at least one line in the
     *             text, otherwise prints a message and ignores the entry.
     *             Q
     *             If the text is modified or a new line is inserted, quit the
     *             program after user's confirmation; otherwise quit without a
     *             confirmation.
     */
    public static void main(String[] args) {
        System.out.println("CSE214 Editor, Version 1.0, 29/03/23");
        int count = 0;
        LineList list = new LineList();

        loop:
        while (true) {
            //System.out.print("Enter Your Choice:");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next().toUpperCase();
            switch (choose) {
                case "A" -> {
                    int numberOfLines = sc.nextInt();
                    for (int i = 1; i <= numberOfLines; i++) {
                        System.out.print(i + "*");
                        Scanner input = new Scanner(System.in);
                        String add = input.nextLine();
                        list.append(add);
                    }

                    count++;
                }
                case "H" -> {
                    System.out.println("A   Append one or more lines at the end of file.");
                    System.out.println("I   Insert one or more lines before the current line.");
                    System.out.println("H   Help.");
                    System.out.println("L   List one or more lines.");
                    System.out.println("P   Move to the previous line.");
                    System.out.println("N   Move to the next line.");
                    System.out.println("Q   Quit.");
                    System.out.println("R   Remove the current line.");
                }
                case "I" -> {
                    int numberOfLines = sc.nextInt();
                    for (int i = 1; i <= numberOfLines; i++) {
                        System.out.print(list.cursorLineNo() + "*");
                        Scanner input = new Scanner(System.in);
                        String add = input.nextLine();
                        boolean result = list.insertBeforeCursor(add);
                        if (result) {
                            // System.out.println("insert success");
                            count++;
                        /*} else {
                            System.out.println("insert fail");*/
                        }
                    }
                }
                case "L" -> {
                    int startingLine = sc.nextInt();
                    int endingLine = sc.nextInt();
                    try {
                        list.printList(startingLine, endingLine);
                    } catch (InvalidCursorException e) {
                        System.out.println("** Invalid Line Range **");
                    }
                }
                case "N" -> {
                    String nextLine = list.nextLine();
                    if (nextLine == null) {
                        System.out.println("** End of file reached **");
                        break;
                    }
                    System.out.println(list.cursorLineNo() + "*" + nextLine);

                    count++;
                }
                case "P" -> {
                    String prevLine = list.previousLine();
                    if (prevLine == null) {
                        System.out.println("** Top of file reached **");
                        break;
                    }
                    System.out.println(list.cursorLineNo() + "*" + prevLine);

                    count++;
                }
                case "R" -> {
                    boolean result = list.removeCursor();
                    if (result) {
                        // System.out.println(false);
                        count++;
                    }
                    // System.out.println(true);
                }
                case "Q" -> {
                    if (count == 0) {
                        break loop;
                    }
                    System.out.println("Are you sure?");
                    String s = sc.next();
                    if (s.equals("y")) {
                        System.out.println("Good Bye.");
                        break loop;
                    }
                }
                default -> System.out.println("** Invalid Option **");
            }
        }
    }
}
