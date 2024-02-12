
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortBubble {
    public static void ArraytoFile(int[] arr, String file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            for (int num : arr) {
                writer.println(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] RandomArray(int arrLength) {
        int[] RandomArr = new int[arrLength];
        Random random = new Random();

        for (int i = 0; i < arrLength; i++) {
            RandomArr[i] = random.nextInt(101);
        }
        return RandomArr;

    }

   public static int[] FileToArray(String file)
   {
    try(Scanner scanner = new Scanner(new File(file)))
    {
        int size = 0;
        while(scanner.hasNextInt())
        {
            scanner.nextInt();
            size++;
        }

        int[] result = new int[size];
       

        try(Scanner fileScan = new Scanner(new File(file)))
        {
          for(int i = 0; i < size; i++)
         {
            result[i] = fileScan.nextInt();
         }
        }
        return result;
    } 
    catch(FileNotFoundException e)
    {
        e.printStackTrace();
        return null;
    }
   }

    public static void BubbleSortting(int[] arr) {
        int n = arr.length;
        boolean swap;

        for (int i = 0; i < n - 1; i++) {
            swap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;

                }
            }

            if (!swap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        System.out.println("*************************************************************************************");
        System.out.println("*************************************************************************************");

        System.out.println("                        **           ************** ");
        System.out.println("                       ****          ************** ");
        System.out.println("                     *******         ******         ");
        System.out.println("                    ***   ***        **************  ");
        System.out.println("                   ***********       **************  ");
        System.out.println("                  *************              ******  ");
        System.out.println("                 ******   ******     **************  ");
        System.out.println("                 *****     *****     **************   ");
        System.out.println("                                                        ");
        System.out.println("*************************************************************************************");
        System.out.println("*************************************************************************************");
        System.out.println("                                                        ");
        System.out.println("Welcome to Sort ArraysR'Us! ,Where you can generate your very own random array");
        System.out.println("or provide us with an array and we will sort it for you!");
        System.out.println("Choose an option 1 or 2:");
        System.out.println("                                                        ");
        System.out.println("1. Generate an array of random integers and store it in a file ");
        System.out.println("2. Read an array from an existing file , sort it, and store it in another file");
        System.out.println("*************************************************************************************");
        System.out.println("*************************************************************************************");

        int option = scanner.nextInt();

        if (option == 1) {
            System.out.println("Enter the amount of elelements in the array::");
            int arrLength = scanner.nextInt();

            int[] RandomArr = RandomArray(arrLength);

            System.out.println("Enter the filename to store the random array::");
            String file = scanner.next();

            ArraytoFile(RandomArr, file);

            System.out.println("Array generated and stored!");

        } else if (option == 2) {
            System.out.println("Enter the filename to read the array from::");
            String inputFile = scanner.next();

            int[] arrSort = FileToArray(inputFile);

            if (arrSort != null) {
                BubbleSortting(arrSort);

                System.out.println("Enter the filename to store the sorted array::");
                String outputFile = scanner.next();

                ArraytoFile(arrSort, outputFile);

                System.out.println("Array sorted and stored!");
            } else {
                System.out.println("***Error reading from file***");
            }

        } else {
            System.out.println("Not an option, Choose option 1 or option 2.");
        }
        scanner.close();
    }
}
