package other.potoki;
import java.io.*;

public class FileProcessor {

    public static void main(String[] args) {
        String inputFile = "WorkJava\\src\\other\\potoki\\input.txt";
        String outputFile = "WorkJava\\src\\other\\potoki\\output.txt";

        try {
            processFile(inputFile, outputFile);
            System.out.println("Файл успешно обработан.");
        } catch (IOException e) {
            System.err.println("Ошибка при обработке файла: " + e.getMessage());
        }
    }

    public static void processFile(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String upperCaseLine = line.toUpperCase();
                writer.write(upperCaseLine);
                writer.newLine(); // Добавляем перевод строки
            }

        }
    }
}