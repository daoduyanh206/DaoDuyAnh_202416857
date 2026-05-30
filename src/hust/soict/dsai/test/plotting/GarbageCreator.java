package hust.soict.dsai.test.plotting;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws Exception {
        String filename = "test.exe"; // Đảm bảo file này có tồn tại trong thư mục gốc
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        
        long startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b; // Mỗi lần + là một lần tạo đối tượng mới (Rác)
        }
        long endTime = System.currentTimeMillis();
        
        System.out.println("Processing time with +: " + (endTime - startTime) + " ms");
    }
}