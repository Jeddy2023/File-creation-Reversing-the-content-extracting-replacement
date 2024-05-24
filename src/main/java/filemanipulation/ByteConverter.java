package main.java.filemanipulation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ByteConverter {
    // Method to convert file content to byte codes and save to another file
    public void convertFileToBytes(String inputFile, String outputFile) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(inputFile));
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.write(Arrays.toString(bytes).getBytes());
        }
    }
}
