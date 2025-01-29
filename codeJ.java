import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class codeJ {

    public static void main(String[] args) {
        // Task 1: Четное или нечетное число
        try (Scanner scanner = new Scanner(System.in)) {
            // Task 1: Четное или нечетное число
            System.out.println("\n--- Task 1: Четное или нечетное число ---");
            System.out.print("Введите целое число: ");
            int number1 = scanner.nextInt();
            if (number1 % 2 == 0) {
                System.out.println("Число четное");
            } else {
                System.out.println("Число нечетное");
            }
            
            // Task 2: Минимальное из трех чисел
            System.out.println("\n--- Task 2: Минимальное из трех чисел ---");
            System.out.print("Введите первое целое число: ");
            int num2_1 = scanner.nextInt();
            System.out.print("Введите второе целое число: ");
            int num2_2 = scanner.nextInt();
            System.out.print("Введите третье целое число: ");
            int num2_3 = scanner.nextInt();
            int min = Math.min(Math.min(num2_1, num2_2), num2_3);
            System.out.println("Минимальное число: " + min);
            
            // Task 3: Таблица умножения на 5
            System.out.println("\n--- Task 3: Таблица умножения на 5 ---");
            System.out.println("Таблица умножения на 5:");
            for (int i = 1; i <= 10; i++) {
                System.out.println("5 x " + i + " = " + (5 * i));
            }
            
            // Task 4: Сумма чисел от 1 до N
            System.out.println("\n--- Task 4: Сумма чисел от 1 до N ---");
            System.out.print("Введите целое число N: ");
            int n4 = scanner.nextInt();
            int sum4 = 0;
            for (int i = 1; i <= n4; i++) {
                sum4 += i;
            }
            System.out.println("Сумма чисел от 1 до " + n4 + ": " + sum4);
            
            // Task 5: Число Фибоначчи
            System.out.println("\n--- Task 5: Число Фибоначчи ---");
            System.out.print("Введите целое число N: ");
            int n5 = scanner.nextInt();
            int first = 0;
            int second = 1;
            System.out.print("Первые " + n5 + " чисел Фибоначчи: " + first + " " + second);
            for (int i = 3; i <= n5; i++) {
                int next = first + second;
                System.out.print(" " + next);
                first = second;
                second = next;
            }
            System.out.println();
            
            // Task 6: Проверка простого числа
            System.out.println("\n--- Task 6: Проверка простого числа ---");
            System.out.print("Введите целое число: ");
            int number6 = scanner.nextInt();
            if (isPrime(number6)) {
                System.out.println("Число простое");
            } else {
                System.out.println("Число не простое");
            }
            
            // Task 7: Обратный порядок чисел
            System.out.println("\n--- Task 7: Обратный порядок чисел ---");
            System.out.print("Введите целое число N: ");
            int n7 = scanner.nextInt();
            System.out.print("Числа от " + n7 + " до 1 в обратном порядке: ");
            for (int i = n7; i >= 1; i--) {
                System.out.print(i + " ");
            }
            System.out.println();
            
            // Task 8: Сумма четных чисел
            System.out.println("\n--- Task 8: Сумма четных чисел ---");
            System.out.print("Введите целое число A: ");
            int a8 = scanner.nextInt();
            System.out.print("Введите целое число B: ");
            int b8 = scanner.nextInt();
            int sum8 = 0;
            for (int i = a8; i <= b8; i++) {
                if (i % 2 == 0) {
                    sum8 += i;
                }
            }
            System.out.println("Сумма четных чисел в диапазоне от " + a8 + " до " + b8 + ": " + sum8);
            
            // Task 9: Реверс строки
            System.out.println("\n--- Task 9: Реверс строки ---");
            scanner.nextLine();  // Consume the newline
            System.out.print("Введите строку: ");
            String input9 = scanner.nextLine();
            String reversed9 = new StringBuilder(input9).reverse().toString();
            System.out.println("Строка в обратном порядке: " + reversed9);
            
            // Task 10: Количество цифр в числе
            System.out.println("\n--- Task 10: Количество цифр в числе ---");
            System.out.print("Введите целое число: ");
            int number10 = scanner.nextInt();
            String numStr10 = Integer.toString(number10);
            int digitCount10 = numStr10.length();
            System.out.println("Количество цифр в числе: " + digitCount10);
            
            // Task 11: Факториал числа
            System.out.println("\n--- Task 11: Факториал числа ---");
            System.out.print("Введите целое число N: ");
            int n11 = scanner.nextInt();
            long factorial11 = calculateFactorial(n11);
            System.out.println("Факториал числа " + n11 + ": " + factorial11);
            
            // Task 12: Сумма цифр числа
            System.out.println("\n--- Task 12: Сумма цифр числа ---");
            System.out.print("Введите целое число: ");
            int number12 = scanner.nextInt();
            int sum12 = 0;
            int temp12 = number12;
            while (temp12 != 0) {
                sum12 += temp12 % 10;
                temp12 /= 10;
            }
            System.out.println("Сумма цифр числа: " + sum12);
            
            // Task 13: Палиндром
            System.out.println("\n--- Task 13: Палиндром ---");
            scanner.nextLine(); // Consume the newline
            System.out.print("Введите строку: ");
            String input13 = scanner.nextLine();
            if (isPalindrome(input13)) {
                System.out.println("Строка является палиндромом");
            } else {
                System.out.println("Строка не является палиндромом");
            }
            
            // Task 14: Найти максимальное число в массиве
            System.out.println("\n--- Task 14: Найти максимальное число в массиве ---");
            System.out.print("Введите размер массива: ");
            int size14 = scanner.nextInt();
            int[] array14 = new int[size14];
            System.out.println("Введите элементы массива:");
            for (int i = 0; i < size14; i++) {
                array14[i] = scanner.nextInt();
            }
            int max14 = findMax(array14);
            System.out.println("Максимальное число в массиве: " + max14);
            
            // Task 15: Сумма всех элементов массива
            System.out.println("\n--- Task 15: Сумма всех элементов массива ---");
            System.out.print("Введите размер массива: ");
            int size15 = scanner.nextInt();
            int[] array15 = new int[size15];
            System.out.println("Введите элементы массива:");
            for (int i = 0; i < size15; i++) {
                array15[i] = scanner.nextInt();
            }
            int sum15 = calculateSum(array15);
            System.out.println("Сумма всех элементов массива: " + sum15);
            
            // Task 16: Количество положительных и отрицательных чисел
            System.out.println("\n--- Task 16: Количество положительных и отрицательных чисел ---");
            System.out.print("Введите размер массива: ");
            int size16 = scanner.nextInt();
            int[] array16 = new int[size16];
            System.out.println("Введите элементы массива:");
            for (int i = 0; i < size16; i++) {
                array16[i] = scanner.nextInt();
            }
            int[] counts16 = countPositiveNegative(array16);
            System.out.println("Количество положительных чисел: " + counts16[0]);
            System.out.println("Количество отрицательных чисел: " + counts16[1]);
            
            
            // Task 17: Простые числа в диапазоне
            System.out.println("\n--- Task 17: Простые числа в диапазоне ---");
            System.out.print("Введите целое число A: ");
            int a17 = scanner.nextInt();
            System.out.print("Введите целое число B: ");
            int b17 = scanner.nextInt();
            List<Integer> primes17 = findPrimesInRange(a17, b17);
            System.out.println("Простые числа в диапазоне от " + a17 + " до " + b17 + ": " + primes17);
            
            
            // Task 18: Подсчет гласных и согласных в строке
            System.out.println("\n--- Task 18: Подсчет гласных и согласных в строке ---");
            scanner.nextLine(); // Consume the newline
            System.out.print("Введите строку: ");
            String input18 = scanner.nextLine().toLowerCase();
            int[] counts18 = countVowelsConsonants(input18);
            System.out.println("Количество гласных: " + counts18[0]);
            System.out.println("Количество согласных: " + counts18[1]);
            
            // Task 19: Перестановка слов в строке
            System.out.println("\n--- Task 19: Перестановка слов в строке ---");
            System.out.print("Введите строку, состоящую из нескольких слов: ");
            String input19 = scanner.nextLine();
            String reversed19 = reverseWords(input19);
            System.out.println("Строка со словами в обратном порядке: " + reversed19);
            
            
            // Task 20: Число Армстронга
            System.out.println("\n--- Task 20: Число Армстронга ---");
            System.out.print("Введите целое число: ");
            int number20 = scanner.nextInt();
            if (isArmstrong(number20)) {
                System.out.println("Число является числом Армстронга");
            } else {
                System.out.println("Число не является числом Армстронга");
            }
        }
    }

    // Helper methods (from individual task classes)
   public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleanStr).reverse().toString();
        return cleanStr.equals(reversed);
    }

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым или null");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int calculateSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым или null");
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

   public static int[] countPositiveNegative(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }
        int positiveCount = 0;
        int negativeCount = 0;
        for (int num : arr) {
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            }
        }
        return new int[]{positiveCount, negativeCount};
    }

    public static List<Integer> findPrimesInRange(int start, int end) {
         if (start > end) {
            throw new IllegalArgumentException("Начало диапазона не может быть больше конца");
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(2, start); i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static int[] countVowelsConsonants(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Строка не может быть null");
        }
        int vowelsCount = 0;
        int consonantsCount = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowelsCount++;
                } else {
                    consonantsCount++;
                }
            }
        }
        return new int[]{vowelsCount, consonantsCount};
    }

    public static String reverseWords(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] words = str.split("\\s+");
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
   public static boolean isArmstrong(int num) {
         if (num < 0) {
            return false;
        }
         String strNum = Integer.toString(num);
         int n = strNum.length();
         int sum = 0;
          int temp = num;
         while(temp > 0){
             int digit = temp % 10;
             sum += Math.pow(digit, n);
             temp /= 10;
         }
         return sum == num;
    }
}