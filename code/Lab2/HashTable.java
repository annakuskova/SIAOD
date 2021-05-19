import java.util.Date;
import java.util.ArrayList;
//import java.io;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class HashTable {

    private static Integer[] table;
    private static ArrayList<Integer> randoms;
    private static int tableSize;
    private static ArrayList<Integer> stackTable;
    private static ArrayList<Integer> links;

    public static void main(String[] args) {
            try {
                if (args.length >= 2) {
                    tableSize = Integer.parseInt(args[1]);
                } else {
                    tableSize = 257;
                }

                if (args[0].equals("rehashSimple") || args[0].equals("rehashRandom")) {
                    table = new Integer[tableSize];
                }

                if (args[0].equals("rehashRandom")) {
                    randoms = new ArrayList<>();
                    for (int i = 0; i < tableSize; i++) {
                        while (true) {
                            int num = (int)(Math.random()*tableSize);
                            if (!randoms.contains(num)) {
                                randoms.add(num);
                                break;
                            }
                        }
                    }
                }

                if (args[0].equals("chainMethod")) {
                    table = new Integer[tableSize];
                    stackTable = new ArrayList<>();
                    links = new ArrayList<>();
                }

                Scanner input = new Scanner(System.in);
                System.out.println("Enter 'exit' to close the program\n'input' to add number into table\n'find' to search number in table\n'print' to print a table");
                while (true) {
                    String line = input.nextLine();
                    if (line.equals("exit")) {
                        break;
                    }

                    if (line.equals("input")) {
                        System.out.print("Enter number ");
                        if (input.hasNextInt()) {
                            int number = input.nextInt();
                            if (args[0].equals("rehashSimple")) {
                                rehashSimple(number, number);
                            }
                            if (args[0].equals("rehashRandom")) {
                                rehashRandom(number, 0);
                            }
                            if (args[0].equals("chainMethod")) {
                                chainMethod(number);
                            }
                        } else {
                            System.out.println("Entered string isn't a number");
                        }
                    }

                    if (line.equals("find")) {
                        System.out.print("Enter number ");
                        if (input.hasNextInt()) {
                            int number = input.nextInt();
                            if (args[0].equals("rehashSimple")) {
                                rehashSimpleFind(number, number);
                            }
                            if (args[0].equals("rehashRandom")) {
                                rehashRandomFind(number, 0);
                            }
                            if (args[0].equals("chainMethod")) {
                                chainMethodFind(number);
                            }
                        } else {
                            System.out.println("Entered string isn't a number");
                        }
                    }

                    if (line.equals("print")) {
                        if (args[0].equals("rehashSimple") || args[0].equals("rehashRandom")) {
                            System.out.println(Arrays.toString(table));
                        }
                        if (args[0].equals("chainMethod")) {
                            System.out.println(stackTable.toString());
                            System.out.println(links.toString());
                        }
                    }
                }
                input.close();

            }
            catch (Exception ex) {
                System.out.println("Arguments error, input form: java HashTable type_of_task <size_of_table>");
                ex.printStackTrace();
            }
        }


        public static void rehashSimple (int number, int current) {
            if (table[current % tableSize] == null) {
                table[current % tableSize] = number;
            } else {
                if (current != number + tableSize) {
                    rehashSimple(number, current + 1);
                } else {
                    System.out.println("Table is filled");
                }
            }
        }

        public static Integer rehashSimpleFind(int number, int current) {
            if (table[current % tableSize] != null) {
                if (table[current % tableSize] == number) {
                    System.out.println("Index of number = " + Integer.toString(current % tableSize));
                    return current % tableSize;
                } else {
                    if (current != number + tableSize) {
                        rehashSimpleFind(number, current + 1);
                    } else {
                        System.out.println("Table doesn't contain number");
                    }
                }
            } else {
                System.out.println("Table doesn't contain number");
            }
            return null;
        }


        public static void rehashRandom (int number, int rehashIndex) {
            if (table[number % tableSize] == null) {
                table[number % tableSize] = number;
            } else {
                if (table[randoms.get(rehashIndex)] == null) {
                    table[randoms.get(rehashIndex)] = number;
                } else {
                    if (rehashIndex + 1 < randoms.size()-1) {
                        rehashRandom(number, rehashIndex + 1);
                    } else {
                        System.out.println("Table is filled");
                    }
                }
            }
        }

        public static Integer rehashRandomFind(int number, int rehashIndex)
        {
            if(table[number % tableSize] != null)
            {
                if(table[number % tableSize] == number)
                {
                    System.out.println("Index of number = " + Integer.toString(number % tableSize));
                    return number % tableSize;
                }
                else
                {
                    if(table[randoms.get(rehashIndex)] != null)
                    {
                        if(table[randoms.get(rehashIndex)] == number)
                        {
                            System.out.println("Index of number = " + Integer.toString(randoms.get(rehashIndex)));
                            return randoms.get(rehashIndex);
                        }
                        else
                        {
                            if(rehashIndex + 1 < randoms.size()-1)
                            {
                                rehashRandomFind(number, rehashIndex + 1);
                            }
                            else
                            {
                                System.out.println("Table doesn't contain number");
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Table doesn't contain number");
                    }
                }
            }
            else
            {
                System.out.println("Table doesn't contain number");
            }
            return null;
        }


        public static void chainMethod(int number)
        {
            if(table[number % tableSize] == null)
            {
                stackTable.add(number);
                links.add(null);
                table[number % tableSize] = stackTable.size() - 1;
            }
            else
            {
                int i = table[number % tableSize];
                while(stackTable.get(i) != number || links.get(i) != null)
                {
                    if(stackTable.get(i) == number)
                    {
                        System.out.println("Table contains number already");
                    }
                    else
                    {
                        if(links.get(i) != null)
                        {
                            i = links.get(i);
                        }
                        else
                        {
                            stackTable.add(number);
                            links.add(null);
                            links.set(i, links.size()-1);
                        }

                    }
                }


            }
        }

        public static Integer chainMethodFind(int number)
        {
            if(table[number % tableSize] != null)
            {
                int i = table[number % tableSize];
                while(true)
                {
                    if(stackTable.get(i) == number)
                    {
                        System.out.println("Index of number = " + Integer.toString(i));
                        return i;
                    }
                    else
                    {
                        if(links.get(i) != null)
                        {
                            i = links.get(i);
                        }
                        else
                        {
                            System.out.println("Table doesn't contain number");
                            return null;
                        }

                    }
                }
            }
            else
            {
                System.out.println("Table doesn't contain number");
            }
            return null;
        }

    }

