package other.NIO;

import java.io.FileNotFoundException; // Добавляем импорт
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOCopy {
    public static void main(String[] args) {
        String sourceFile = "WorkJava\\src\\other\\NIO\\large_input.txt"; // Создайте большой файл для копирования (> 1ГБ)
        String destFile = "WorkJava\\src\\other\\NIO\\copied_file.txt";


        try {
             // Генерация большого файла для тестирования (только для демонстрации)
            generateLargeFile(sourceFile, 64 * 64 * 64 + 64 * 100); // 64МБ + 100 KB файл
            copyFile(sourceFile, destFile);
            System.out.println("Файл успешно скопирован!");
        } catch (IOException e) {
            System.err.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }

    // Метод для генерации большого файла для тестирования
    public static void generateLargeFile(String filename, long size) throws IOException {
       Path filePath = Paths.get(filename);
        try (FileChannel channel = FileChannel.open(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

          long position = 0;
          long blockSize = 1024*1024; // Block size = 1 MB

            while(position < size) {
              long writeSize = Math.min(blockSize, size - position);
              channel.write(java.nio.ByteBuffer.allocate( (int) writeSize ), position);
              position += writeSize;

           }

        }
    }


    public static void copyFile(String sourceFile, String destFile) throws IOException {
        Path sourcePath = Paths.get(sourceFile);
        Path destPath = Paths.get(destFile);

        if (!Files.exists(sourcePath)) {
             throw new FileNotFoundException("Исходный файл не найден: " + sourceFile);
        }

        try (FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
             FileChannel destChannel = FileChannel.open(destPath, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            long fileSize = sourceChannel.size();
            long transferred = 0;

            while(transferred < fileSize){
              transferred += sourceChannel.transferTo(transferred, fileSize - transferred, destChannel);
            }

        }

    }
}