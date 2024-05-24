package main.java.filemanipulation;

import java.io.IOException;

public class FileComparator {
    private final FileOperations fileOperations;

    public FileComparator(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    // Method to compare two files and check if their content is the same
    public boolean compareFiles(String fileName1, String fileName2) throws IOException {
        String content1 = fileOperations.readFile(fileName1);
        String content2 = fileOperations.readFile(fileName2);
        return content1.equals(content2);
    }
}
