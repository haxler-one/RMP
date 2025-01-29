package other.IOvsNIO;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class IOvsNIO {

    public static void main(String[] args) throws IOException {
        String inputFile = "large_input.txt";  // Создайте файл размером несколько МБ
        String outputFileIO = "output_io.txt";
        String outputFileNIO = "output_nio.txt";


        // Генерация большого файла для тестирования (только для демонстрации)
        generateLargeFile(inputFile, 1024 * 1024 * 5); // 5 MB файл

        // Сравнение IO
        long startTimeIO = System.nanoTime();
        copyFileIO(inputFile, outputFileIO);
        long endTimeIO = System.nanoTime();
        long durationIO = (endTimeIO - startTimeIO) / 1_000_000; // ms
        System.out.println("IO Time: " + durationIO + " ms");

        // Сравнение NIO
        long startTimeNIO = System.nanoTime();
        copyFileNIO(inputFile, outputFileNIO);
        long endTimeNIO = System.nanoTime();
        long durationNIO = (endTimeNIO - startTimeNIO) / 1_000_000; // ms
        System.out.println("NIO Time: " + durationNIO + " ms");


    }

    // Метод для генерации большого файла для тестирования
    public static void generateLargeFile(String filename, int size) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < size; i++) {
                writer.write("a");
            }
        }
    }

    // Копирование файла с использованием IO
    public static void copyFileIO(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
        }
    }

    // Копирование файла с использованием NIO
    public static void copyFileNIO(String inputFile, String outputFile) throws IOException {
        Path sourcePath = Paths.get(inputFile);
        Path destPath = Paths.get(outputFile);
        try (FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
             FileChannel destChannel = FileChannel.open(destPath, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

             long fileSize = sourceChannel.size();
            sourceChannel.transferTo(0, fileSize, destChannel);


        }
    }
}