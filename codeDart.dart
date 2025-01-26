import 'dart:math';

void main() {
  // Пример использования функций и обработки исключений
  try {
    print('Максимум из 5 и 10: ${findMax(5, 10)}');
    print('Деление 10 на 2: ${divide(10, 2)}');
    print('Строка "123" в число: ${stringToInt('123')}');
    print('Строка "abc" в число: ${stringToInt('abc')}'); // Ожидаем исключение
  } catch (e) {
    print('Ошибка: $e');
  }

  try {
    checkAge(151); // Ожидаем исключение
  } catch (e) {
    print('Ошибка проверки возраста: $e');
  }

  try {
    print('Корень из 25: ${findRoot(25)}');
    print('Корень из -1: ${findRoot(-1)}'); // Ожидаем исключение
  } catch (e) {
    print('Ошибка извлечения корня: $e');
  }
}

// 1. Функция для нахождения максимума
int findMax(int a, int b) {
  if (a == b) {
    throw Exception('Числа равны');
  }
  return a > b ? a : b;
}

// 2. Калькулятор деления
double divide(int a, int b) {
  if (b == 0) {
    throw ArithmeticException('Деление на ноль недопустимо');
  }
  return a / b;
}

// 3. Конвертер строк в числа
int stringToInt(String str) {
  try {
    return int.parse(str);
  } catch (e) {
    throw FormatException('Невозможно конвертировать строку в число');
  }
}

// 4. Проверка возраста
void checkAge(int age) {
  if (age < 0 || age > 150) {
    throw ArgumentError('Недопустимый возраст');
  }
}

// 5. Нахождение корня
double findRoot(num number) {
  if (number < 0) {
    throw ArgumentError('Нельзя извлечь корень из отрицательного числа');
  }
  return sqrt(number);
}

// 6. Факториал
int factorial(int n) {
  if (n < 0) {
    throw ArgumentError('Факториал отрицательного числа не определен');
  }
  if (n == 0) {
    return 1;
  }
  int result = 1;
  for (int i = 1; i <= n; i++) {
    result *= i;
  }
  return result;
}

// 7. Проверка массива на нули
void checkArrayForZeros(List<int> arr) {
  for (int i = 0; i < arr.length; i++) {
    if (arr[i] == 0) {
      throw Exception('Массив содержит нули');
    }
  }
}

// 8. Калькулятор возведения в степень
double power(num base, int exponent) {
  if (exponent < 0) {
    throw ArgumentError('Отрицательная степень не поддерживается');
  }
  return pow(base, exponent).toDouble();
}

// 9. Обрезка строки
String truncateString(String str, int length) {
  if (length > str.length) {
    throw ArgumentError('Длина обрезки больше длины строки');
  }
  return str.substring(0, length);
}

// 10. Поиск элемента в массиве
int findElement(List<int> arr, int element) {
  for (int i = 0; i < arr.length; i++) {
    if (arr[i] == element) {
      return i; // Возвращаем индекс, если нашли
    }
  }
  throw Exception('Элемент не найден в массиве');
}

// 11. Конвертация в двоичную систему
String toBinary(int number) {
  if (number < 0) {
    throw ArgumentError('Нельзя конвертировать отрицательное число в двоичную систему');
  }
  return number.toRadixString(2);
}

// 12. Проверка делимости
bool isDivisible(int a, int b) {
  if (b == 0) {
    throw ArithmeticException('Деление на ноль недопустимо');
  }
  return a % b == 0;
}

// 13. Чтение элемента списка
dynamic getElementAtIndex(List list, int index) {
  if (index < 0 || index >= list.length) {
    throw RangeError('Индекс за пределами списка'); // Corrected exception type
  }
  return list[index];
}

// 14. Парольная проверка
void checkPasswordStrength(String password) {
  if (password.length < 8) {
    throw Exception('Пароль слишком короткий. Должен содержать не менее 8 символов.');
  }
}

// 15. Проверка даты
bool isValidDate(String dateStr) {
  RegExp datePattern = RegExp(r'^\d{2}\.\d{2}\.\d{4}$');
  if (!datePattern.hasMatch(dateStr)) {
    throw FormatException('Неверный формат даты. Ожидается "dd.MM.yyyy"');
  }

  // Можно добавить более строгую проверку на корректность даты (например, на количество дней в месяце).
  return true;
}

// 16. Конкатенация строк
String concatenateStrings(String? str1, String? str2) {
  if (str1 == null || str2 == null) {
    throw NullThrownError();
  }
  return str1 + str2;
}

// 17. Остаток от деления
int getRemainder(int a, int b) {
  if (b == 0) {
    throw ArithmeticException('Деление на ноль недопустимо');
  }
  return a % b;
}

// 18. Квадратный корень (дубликат 5, но с другим именем)
double squareRoot(num number) {
  if (number < 0) {
    throw ArgumentError('Нельзя извлечь корень из отрицательного числа');
  }
  return sqrt(number);
}

// 19. Конвертер температуры
double celsiusToFahrenheit(double celsius) {
  if (celsius < -273.15) {
    throw ArgumentError('Температура ниже абсолютного нуля');
  }
  return (celsius * 9 / 5) + 32;
}

// 20. Проверка строки на пустоту
void checkStringNotEmpty(String? str) {
  if (str == null || str.isEmpty) {
    throw ArgumentError('Строка пуста или равна null');
  }
}