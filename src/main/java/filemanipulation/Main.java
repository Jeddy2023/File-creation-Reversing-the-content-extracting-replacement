package main.java.filemanipulation;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize classes
            FileOperations fileOperations = new FileOperations();
            FileComparator fileComparator = new FileComparator(fileOperations);
            ByteConverter byteConverter = new ByteConverter();
            Scanner scanner = new Scanner(System.in);

            // File names
            String fileName1 = "src/main/resources/file1.txt";
            String fileName2 = "src/main/resources/file2.txt";
            String fileName3 = "src/main/resources/file3.txt";
            String fileName4 = "src/main/resources/file4.txt";

            // Ask user to input data for the first file
            System.out.println("Enter the content to display in  the first file:");
            String inputData = scanner.nextLine();
            fileOperations.writeFile(fileName1, inputData);

            boolean exit = false;
            while (!exit) {
                // Display menu options to the user
                System.out.println("\nChoose an option:");
                System.out.println("1. Display content of the first file");
                System.out.println("2. Reverse content of the first file into the second file");
                System.out.println("3. Replace a word in the first file");
                System.out.println("4. Compare content of the first and second files");
                System.out.println("5. Convert the first file data into byte codes and save in another file");
                System.out.println("6. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                switch (choice) {
                    case 1:
                        // Display content of the first file
                        String content = fileOperations.readFile(fileName1);
                        System.out.println("Content of the first file:");
                        System.out.println(content);
                        break;

                    case 2:
                        // Reverse content of the first file into the second file
                        fileOperations.reverseFileContent(fileName1, fileName2);
                        System.out.println("Content of the first file has been reversed into the second file.");
                        break;

                    case 3:
                        // Replace a word in the first file
                        System.out.println("Enter the position to replace word: ");
                        int position = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character
                        System.out.println("Enter the new word:");
                        String newWord = scanner.nextLine();
                        fileOperations.replaceWordInFile(fileName1, position, newWord);
                        System.out.println("Word replaced successfully in the first file.");
                        break;

                    case 4:
                        // Compare the content of both files and check if they are the same
                        boolean isSame = fileComparator.compareFiles(fileName1, fileName2);
                        System.out.println("Are both files the same? " + isSame);
                        break;

                    case 5:
                        // Convert the first file data into byte codes and save in another file
                        byteConverter.convertFileToBytes(fileName1, fileName4);
                        System.out.println("First file content has been converted to byte codes and saved in another file.");
                        break;

                    case 6:
                        // Exit the program
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}