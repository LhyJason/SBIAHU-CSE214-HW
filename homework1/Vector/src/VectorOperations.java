
/** 
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 0
 * VectorOperations class
*/

import java.util.Scanner;

/**
 * The VectorOperations class is a Java application that tests the methods of
 * the VectorADT class and allows the user to input long vectors as a list of
 * elements separated by spaces and perform operations on them.
 */
public class VectorOperations {
    /**
     * Test class of VectorADT
     * 
     * @param args
     *             public static void main(String[] args)
     *             When the program begins, the main program should display a menu
     *             that allows following operations:
     *             A (Add two vectors)
     *             D (Dot product)
     *             E (test if two vectors are equal)
     *             M (Multiply two vectors)
     *             S (Subtract two vectors)
     *             Q (Quit Program)
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("A) Add ");
        System.out.println("D) Dot Product ");
        System.out.println("E) Equality ");
        System.out.println("M) Multiply");
        System.out.println("S) Subtract");
        System.out.println("Q) Quit program");

        loop: while (true) {
            System.out.print("Enter Your Choice:");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next().toUpperCase();
            switch (choose) {
                case "A" -> {
                    System.out.println("Enter First Vector:");
                    String[] s1 = getString();
                    System.out.println("Enter Second Vector:");
                    String[] s2 = getString();
                    try {
                        VectorADT vector1 = createNewVector(s1);
                        VectorADT vector2 = createNewVector(s2);

                        String s = VectorADT.add(vector1, vector2).toString();
                        System.out.println(vector1.toString() + " + ");
                        System.out.println(vector2.toString() + " = ");
                        System.out.println(s);
                    } catch (InvalidSizeException e) {
                        int max = 60;
                        if ((s1.length < 0 || s1.length > max) || (s2.length < 0 || s2.length > max)) {
                            System.out.println("there exists vector out of the bound");
                        } else {
                            for (int i = 0; i < s1.length; i++) {
                                if (i == s1.length - 1) {
                                    System.out.print(s1[i] + " + ");
                                    break;
                                }
                                System.out.print(s1[i] + " ");
                            }
                            System.out.println();
                            for (int i = 0; i < s2.length; i++) {
                                if (i == s2.length - 1) {
                                    System.out.print(s2[i] + " = ");
                                    break;
                                }
                                System.out.print(s2[i] + " ");
                            }
                            System.out.println();
                            System.out.print("Size Error");
                            System.out.println();
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("there exists null vector");
                    }

                }
                case "D" -> {
                    System.out.println("Enter First Vector:");
                    String[] s1 = getString();
                    System.out.println("Enter Second Vector:");
                    String[] s2 = getString();
                    try {
                        VectorADT vector1 = createNewVector(s1);
                        VectorADT vector2 = createNewVector(s2);

                        int result = VectorADT.dotProduct(vector1, vector2);
                        System.out.println(vector1.toString() + " (dot)");
                        System.out.println(vector2.toString() + " =");
                        System.out.println(result);
                    } catch (InvalidSizeException e) {
                        int max = 60;
                        if ((s1.length < 0 || s1.length > max) || (s2.length < 0 || s2.length > max)) {
                            System.out.println("there exists vector out of the bound");
                        } else {
                            for (int i = 0; i < s1.length; i++) {
                                if (i == s1.length - 1) {
                                    System.out.print(s1[i] + " (dot) ");
                                    break;
                                }
                                System.out.print(s1[i] + " ");
                            }
                            System.out.println();
                            for (int i = 0; i < s2.length; i++) {
                                if (i == s2.length - 1) {
                                    System.out.print(s2[i] + " = ");
                                    break;
                                }
                                System.out.print(s2[i] + " ");
                            }
                            System.out.println();
                            System.out.print("Size Error");
                            System.out.println();
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("there exists null vector");
                    }
                }
                case "E" -> {
                    System.out.println("Enter First Vector:");
                    String[] s1 = getString();
                    System.out.println("Enter Second Vector:");
                    String[] s2 = getString();
                    try {
                        VectorADT vector1 = createNewVector(s1);
                        VectorADT vector2 = createNewVector(s2);

                        boolean result = false;
                        if (vector1.getSize() != vector2.getSize()) {
                            result = false;
                        } else {
                            result = vector1.equals(vector2);
                        }
                        System.out.println(vector1.toString() + " =");
                        System.out.println(vector2.toString() + " ?");
                        System.out.println(result);
                    } catch (IllegalArgumentException e) {
                        System.out.println(false);
                        
                    }

                }
                case "M" -> {
                    try {
                        System.out.println("Enter Number:");
                        int scaler = sc.nextInt();
                        System.out.println("Enter Vector:");
                        String[] s1 = getString();
                        VectorADT vector = createNewVector(s1);
                        String s = VectorADT.multiplyByScalar(vector, scaler).toString();

                        System.out.println(scaler + " *");
                        System.out.println(createNewVector(s1).toString() + " =");
                        System.out.println(s);
                    } catch (IllegalArgumentException e) {
                        System.out.println("there exists null vector");
                    }

                }
                case "S" -> {
                    System.out.println("Enter First Vector:");
                    String[] s1 = getString();
                    System.out.println("Enter Second Vector:");
                    String[] s2 = getString();
                    try {
                        VectorADT vector1 = createNewVector(s1);
                        VectorADT vector2 = createNewVector(s2);

                        String s = VectorADT.subtract(vector1, vector2).toString();
                        System.out.println(vector1.toString() + " - ");
                        System.out.println(vector2.toString() + " = ");
                        System.out.println(s);
                    } catch (InvalidSizeException e) {
                        int max = 60;
                        if ((s1.length < 0 || s1.length > max) || (s2.length < 0 || s2.length > max)) {
                            System.out.println("there exists vector out of the bound");
                        } else {
                            for (int i = 0; i < s1.length; i++) {
                                if (i == s1.length - 1) {
                                    System.out.print(s1[i] + " - ");
                                    break;
                                }
                                System.out.print(s1[i] + " ");
                            }
                            System.out.println();
                            for (int i = 0; i < s2.length; i++) {
                                if (i == s2.length - 1) {
                                    System.out.print(s2[i] + " = ");
                                    break;
                                }
                                System.out.print(s2[i] + " ");
                            }
                            System.out.println();
                            System.out.print("Size Error");
                            System.out.println();
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("there exists null vector");
                    }

                }
                case "Q" -> {
                    System.out.println("Program terminating normally");

                    break loop;
                }
                default -> System.out.println("invalid, please input again");

            }

        }
    }

    /**
     * record the data from input and invert into String[] type
     * 
     * @param input
     *              one Scanner to get data from input
     * @param temp
     *              get data and restore with String type
     * @param s
     *              s is the result of covertion
     * @return
     *         return the result with String[] type
     */
    public static String[] getString() {
        Scanner input = new Scanner(System.in);
        String temp = input.nextLine();
        String[] s = temp.trim().split(" ");
        return s;
    }

    /**
     * create new vector with VectorADT type
     * 
     * @param size
     *              the size of one VectorADT
     * @param v
     *              the VectorADT has been created
     * @param value
     *              the value of such position
     * @param s
     *              get from method getString()
     * @return
     *         the VectorADT create
     */
    public static VectorADT createNewVector(String[] s) {
        int size = s.length;
        VectorADT v = new VectorADT(size);
        for (int i = 0; i < v.getSize(); i++) {
            int value = Integer.valueOf(s[i]);
            v.setElement(value, i);
        }
        return v;
    }
}
