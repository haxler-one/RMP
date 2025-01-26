
const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout,
});

// Функция для запроса ввода числа у пользователя
function askQuestion(query) {
    return new Promise(resolve => {
        readline.question(query, answer => {
            resolve(answer);
        });
    });
}

// Функция для запроса ввода массива чисел у пользователя
async function askArray(size) {
    const arr = [];
    for (let i = 0; i < size; i++) {
        const input = await askQuestion(`Введите элемент массива №${i + 1}: `);
        arr.push(parseInt(input));
    }
    return arr;
}

// Задача 1: Четное или нечетное число
async function task1() {
    const input = await askQuestion('Введите целое число: ');
    const number = parseInt(input);

    if (isNaN(number)) {
        console.log("Ошибка: Введите целое число.");
        return;
    }

    if (number % 2 === 0) {
        console.log(`${number} - четное число.`);
    } else {
        console.log(`${number} - нечетное число.`);
    }
}

// Задача 2: Минимальное из трех чисел
async function task2() {
    const num1 = parseInt(await askQuestion('Введите первое число: '));
    const num2 = parseInt(await askQuestion('Введите второе число: '));
    const num3 = parseInt(await askQuestion('Введите третье число: '));

     if (isNaN(num1) || isNaN(num2) || isNaN(num3)) {
        console.log("Ошибка: Введите целые числа.");
        return;
    }


    const min = Math.min(num1, num2, num3);
    console.log(`Минимальное число: ${min}`);
}

// Задача 3: Таблица умножения
async function task3() {
    console.log('Таблица умножения на 5:');
    for (let i = 1; i <= 10; i++) {
        console.log(`5 * ${i} = ${5 * i}`);
    }
}

// Задача 4: Сумма чисел от 1 до N
async function task4() {
    const input = await askQuestion('Введите целое число N: ');
    const n = parseInt(input);

    if (isNaN(n)) {
        console.log("Ошибка: Введите целое число.");
        return;
    }

    let sum = 0;
    for (let i = 1; i <= n; i++) {
        sum += i;
    }
    console.log(`Сумма чисел от 1 до ${n}: ${sum}`);
}

// Задача 5: Число Фибоначчи
async function task5() {
    const input = await askQuestion('Введите целое число N: ');
    const n = parseInt(input);

    if (isNaN(n)) {
        console.log("Ошибка: Введите целое число.");
        return;
    }

    let fib = [0, 1];
    for (let i = 2; i < n; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }
    console.log(`Первые ${n} чисел Фибоначчи: ${fib.slice(0, n).join(', ')}`);
}

// Задача 6: Проверка простого числа
async function task6() {
    const input = await askQuestion('Введите целое число: ');
    const number = parseInt(input);

    if (isNaN(number)) {
        console.log("Ошибка: Введите целое число.");
        return;
    }

    if (number <= 1) {
        console.log(`${number} - не является простым числом.`);
        return;
    }

    for (let i = 2; i <= Math.sqrt(number); i++) {
        if (number % i === 0) {
            console.log(`${number} - не является простым числом.`);
            return;
        }
    }
    console.log(`${number} - является простым числом.`);
}

// Задача 7: Обратный порядок чисел
async function task7() {
    const input = await askQuestion('Введите целое число N: ');
    const n = parseInt(input);

    if (isNaN(n)) {
        console.log("Ошибка: Введите целое число.");
        return;
    }

    let output = '';
    for (let i = n; i >= 1; i--) {
        output += i + ' ';
    }
    console.log(`Числа от ${n} до 1: ${output}`);
}

// Задача 8: Сумма четных чисел
async function task8() {
    const a = parseInt(await askQuestion('Введите число A: '));
    const b = parseInt(await askQuestion('Введите число B: '));

    if (isNaN(a) || isNaN(b)) {
        console.log("Ошибка: Введите целые числа.");
        return;
    }

    let sum = 0;
    for (let i = Math.min(a, b); i <= Math.max(a, b); i++) {
        if (i % 2 === 0) {
            sum += i;
        }
    }
    console.log(`Сумма четных чисел в диапазоне от ${Math.min(a, b)} до ${Math.max(a, b)}: ${sum}`);
}

// Задача 9: Реверс строки
async function task9() {
    const input = await askQuestion('Введите строку: ');
    const reversedString = input.split('').reverse().join('');
    console.log(`Строка в обратном порядке: ${reversedString}`);
}

// Задача 10: Количество цифр в числе
async function task10() {
    const input = await askQuestion('Введите целое число: ');
    const number = parseInt(input);

     if (isNaN(number)) {
        console.log("Ошибка: Введите целое число.");
        return;
    }

    const numStr = Math.abs(number).toString(); // Convert to string and handle negative numbers
    const digitCount = numStr.length;
    console.log(`Количество цифр в числе: ${digitCount}`);
}

// Задача 11: Факториал числа
async function task11() {
    const input = await askQuestion('Введите целое число N: ');
    const n = parseInt(input);

     if (isNaN(n)) {
        console.log("Ошибка: Введите целое число.");
        return;
    }

    let factorial = 1;
    for (let i = 2; i <= n; i++) {
        factorial *= i;
    }
    console.log(`Факториал числа ${n}: ${factorial}`);
}

// Задача 12: Сумма цифр числа
async function task12() {
    const input = await askQuestion('Введите целое число: ');
    const number = parseInt(input);

     if (isNaN(number)) {
        console.log("Ошибка: Введите целое число.");
        return;
    }

    const numStr = Math.abs(number).toString();
    let sum = 0;
    for (let i = 0; i < numStr.length; i++) {
        sum += parseInt(numStr[i]);
    }
    console.log(`Сумма цифр числа: ${sum}`);
}

// Задача 13: Палиндром
async function task13() {
    const input = await askQuestion('Введите строку: ');
    const cleanString = input.toLowerCase().replace(/[^a-z0-9]/g, ''); // Remove non-alphanumeric chars and lowercase
    const reversedString = cleanString.split('').reverse().join('');

    if (cleanString === reversedString) {
        console.log('Строка является палиндромом.');
    } else {
        console.log('Строка не является палиндромом.');
    }
}

// Задача 14: Найти максимальное число в массиве
async function task14() {
    const size = parseInt(await askQuestion('Введите размер массива: '));

     if (isNaN(size) || size <= 0) {
        console.log("Ошибка: Введите положительное целое число для размера массива.");
        return;
    }

    const arr = await askArray(size);

    if (arr.length === 0) {
        console.log("Массив пуст.");
        return;
    }

    const max = Math.max(...arr);
    console.log(`Максимальное число в массиве: ${max}`);
}

// Задача 15: Сумма всех элементов массива
async function task15() {
    const size = parseInt(await askQuestion('Введите размер массива: '));

    if (isNaN(size) || size <= 0) {
        console.log("Ошибка: Введите положительное целое число для размера массива.");
        return;
    }

    const arr = await askArray(size);

    let sum = 0;
    for (let i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    console.log(`Сумма всех элементов массива: ${sum}`);
}

// Задача 16: Количество положительных и отрицательных чисел
async function task16() {
    const size = parseInt(await askQuestion('Введите размер массива: '));

    if (isNaN(size) || size <= 0) {
        console.log("Ошибка: Введите положительное целое число для размера массива.");
        return;
    }

    const arr = await askArray(size);

    let positiveCount = 0;
    let negativeCount = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > 0) {
            positiveCount++;
        } else if (arr[i] < 0) {
            negativeCount++;
        }
    }
    console.log(`Количество положительных чисел: ${positiveCount}`);
    console.log(`Количество отрицательных чисел: ${negativeCount}`);
}

// Задача 17: Простые числа в диапазоне
async function task17() {
    const a = parseInt(await askQuestion('Введите число A: '));
    const b = parseInt(await askQuestion('Введите число B: '));

    if (isNaN(a) || isNaN(b)) {
        console.log("Ошибка: Введите целые числа.");
        return;
    }

    const min = Math.min(a, b);
    const max = Math.max(a, b);
    let primes = [];

    function isPrime(num) {
        if (num <= 1) return false;
        for (let i = 2; i <= Math.sqrt(num); i++) {
            if (num % i === 0) return false;
        }
        return true;
    }

    for (let i = min; i <= max; i++) {
        if (isPrime(i)) {
            primes.push(i);
        }
    }

    console.log(`Простые числа в диапазоне от ${min} до ${max}: ${primes.join(', ')}`);
}

// Задача 18: Подсчет гласных и согласных в строке
async function task18() {
    const input = await askQuestion('Введите строку: ');
    const vowels = 'aeiouAEIOU';
    let vowelCount = 0;
    let consonantCount = 0;

    for (let i = 0; i < input.length; i++) {
        const char = input[i];
        if (/[a-zA-Z]/.test(char)) { // Проверяем, является ли символ буквой
            if (vowels.includes(char)) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }
    }

    console.log(`Количество гласных: ${vowelCount}`);
    console.log(`Количество согласных: ${consonantCount}`);
}

// Задача 19: Перестановка слов в строке
async function task19() {
    const input = await askQuestion('Введите строку: ');
    const words = input.split(' ');
    const reversedWords = words.reverse();
    const reversedString = reversedWords.join(' ');
    console.log(`Строка с переставленными словами: ${reversedString}`);
}

// Задача 20: Число Армстронга
async function task20() {
    const input = await askQuestion('Введите целое число: ');
    const number = parseInt(input);

    if (isNaN(number)) {
        console.log("Ошибка: Введите целое число.");
        return;
    }

    const numStr = number.toString();
    const numDigits = numStr.length;
    let sum = 0;

    for (let i = 0; i < numDigits; i++) {
        sum += Math.pow(parseInt(numStr[i]), numDigits);
    }

    if (sum === number) {
        console.log(`${number} является числом Армстронга.`);
    } else {
        console.log(`${number} не является числом Армстронга.`);
    }
}


async function main() {
    let taskNumber = await askQuestion("Введите номер задачи (1-20) или 'q' для выхода: ");

    while (taskNumber !== 'q') {
        switch (taskNumber) {
            case '1':
                await task1();
                break;
            case '2':
                await task2();
                break;
            case '3':
                await task3();
                break;
            case '4':
                await task4();
                break;
            case '5':
                await task5();
                break;
            case '6':
                await task6();
                break;
            case '7':
                await task7();
                break;
            case '8':
                await task8();
                break;
            case '9':
                await task9();
                break;
            case '10':
                await task10();
                break;
            case '11':
                await task11();
                break;
            case '12':
                await task12();
                break;
            case '13':
                await task13();
                break;
            case '14':
                await task14();
                break;
            case '15':
                await task15();
                break;
            case '16':
                await task16();
                break;
            case '17':
                await task17();
                break;
            case '18':
                await task18();
                break;
            case '19':
                await task19();
                break;
            case '20':
                await task20();
                break;
            default:
                console.log("Неверный номер задачи. Введите число от 1 до 20 или 'q' для выхода.");
        }

        taskNumber = await askQuestion("Введите номер задачи (1-20) или 'q' для выхода: ");
    }

    readline.close();
}

main();
