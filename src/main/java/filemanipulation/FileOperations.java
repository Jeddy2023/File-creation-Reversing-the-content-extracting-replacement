package main.java.filemanipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {
    // Method to write data to a file
    public void writeFile(String fileName, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
        }
    }

    // Method to read data from a file
    public String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    // Method to reverse the content of a file and write to another file
    public void reverseFileContent(String inputFile, String outputFile) throws IOException {
        String content = readFile(inputFile);
        String reversedContent = new StringBuilder(content).reverse().toString();
        writeFile(outputFile, reversedContent);
    }

    // Method to replace a word in the file at a given position
    public void replaceWordInFile(String fileName, int position, String newWord) throws IOException {
        String content = readFile(fileName);
        String[] words = content.split(" ");
        if (position < 1 || position > words.length) {
            throw new IllegalArgumentException("Invalid position");
        }
        words[position - 1] = newWord;
        String newContent = String.join(" ", words);
        writeFile(fileName, newContent);
    }
}
