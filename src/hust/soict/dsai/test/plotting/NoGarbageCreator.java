package hust.soict.dsai.test.plotting;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbageCreator {
    public static void main(String[] args) throws Exception {
        String filename = "test.exe";
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        
        long startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b); // Tối ưu, không tạo đối tượng thừa
        }
        String outputString = outputStringBuilder.toString();
        long endTime = System.currentTimeMillis();
        
        System.out.println("Processing time with StringBuilder: " + (endTime - startTime) + " ms");
    }
}