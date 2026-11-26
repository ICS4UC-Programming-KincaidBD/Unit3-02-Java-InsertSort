// these imports help read and write files
// imports
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
// this class contains the sorting code
// this method sorts the numbers from smallest to largest
public class InsertSort {
    // start with the second number
    public int[] InsertionSort(int[] arr) {
        int n = arr.length;
        // save the number we are placing
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            // move larger numbers one spot to the right
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            // put the saved number in the open spot
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    // set the input and output file locations
    public static void main(String[] args) {
        File inputFile = new File("/home/vscode/ICS4UC/Unit3/Unit3-02/Unit3-02-Java-InsertSort/input.txt");
        File outputFile = new File("/home/vscode/ICS4UC/Unit3/Unit3-02/Unit3-02-Java-InsertSort/output.txt");
        // read each line and handle file errors

        try {
            Scanner scanner = new Scanner(inputFile);
            // turn the line of text into numbers
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                int[] numbers = new int[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    numbers[i] = Integer.parseInt(tokens[i]);
                }

                // sort the numbers
                InsertSort sorter = new InsertSort();
                numbers = sorter.InsertionSort(numbers);

                // add the sorted numbers to the output file
                FileWriter writer = new FileWriter(outputFile, true);
                for (int i = 0; i < numbers.length; i++) {
                    writer.write(numbers[i] + "");
                    if (i < numbers.length - 1) {
                        writer.write(" ");
                    }
                }
                writer.write("\n");
                writer.close();
            }
            scanner.close();
        } catch (IOException e) {
            // show the error if a file cannot be used
            e.printStackTrace();
        }
    }

}