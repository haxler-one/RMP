import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Random;

public class DateTime{

    public static void main(String[] args) {
        // 1. Основы LocalDate и LocalTime
        printCurrentDateAndTime();

        // 2. Сравнение дат
        LocalDate date1 = LocalDate.of(2023, 10, 26);
        LocalDate date2 = LocalDate.of(2023, 11, 15);
        System.out.println(compareDates(date1, date2));

        // 3. Сколько дней до Нового года?
        System.out.println("Дней до Нового года: " + daysUntilNewYear());

        // 4. Проверка високосного года
        System.out.println("2024 - високосный год: " + isLeapYear(2024));
        System.out.println("2023 - високосный год: " + isLeapYear(2023));

        // 5. Подсчет выходных за месяц
        System.out.println("Выходных в феврале 2025: " + countWeekendDays(02, 2025));

        // 6. Расчет времени выполнения метода
        measureExecutionTime(() -> {
            for (int i = 0; i < 1_000_000; i++) {
            }
        });

        // 7. Форматирование и парсинг даты
        formatAndParseDate("28-01-2025");

         // 8. Конвертация между часовыми поясами
        convertTimeZone(LocalDateTime.now(ZoneOffset.UTC), ZoneId.of("Europe/Moscow"));

        // 9. Вычисление возраста по дате рождения
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        System.out.println("Возраст: " + calculateAge(birthDate));

        // 10. Создание календаря на месяц
        printCalendarForMonth(02, 2025);
        
        // 11. Генерация случайной даты в диапазоне
        LocalDate startDate = LocalDate.of(2025, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 12, 31);
        System.out.println("Случайная дата в диапазоне: " + generateRandomDate(startDate, endDate));
        
        // 12. Расчет времени до заданной даты
        LocalDateTime eventTime = LocalDateTime.of(2024, 12, 31, 23, 59, 59);
        calculateTimeToEvent(eventTime);
        
        // 13. Вычисление количества рабочих часов
        LocalDateTime startWork = LocalDateTime.of(2025, 11, 20, 9, 0, 0);
        LocalDateTime endWork = LocalDateTime.of(2025, 11, 20, 18, 0, 0);
        System.out.println("Рабочих часов: " + calculateWorkingHours(startWork, endWork));
        
        // 14. Конвертация даты в строку с учетом локали
        LocalDate localDate = LocalDate.now();
        convertDateToStringWithLocale(localDate, Locale.forLanguageTag("ru"));
        convertDateToStringWithLocale(localDate, Locale.US);

         // 15. Определение дня недели по дате
        LocalDate someDate = LocalDate.of(2025, 01, 29);
        System.out.println("День недели: " + getDayOfWeekRussian(someDate));
    }


    // 1. Основы LocalDate и LocalTime
    public static void printCurrentDateAndTime() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    
        System.out.println("Текущая дата: " + currentDate.format(dateFormatter));
        System.out.println("Текущее время: " + currentTime.format(timeFormatter));

    }

    // 2. Сравнение дат
    public static String compareDates(LocalDate date1, LocalDate date2) {
        if (date1.isBefore(date2)) {
            return "Дата " + date1 + " раньше, чем " + date2;
        } else if (date1.isAfter(date2)) {
            return "Дата " + date1 + " позже, чем " + date2;
        } else {
            return "Даты " + date1 + " и " + date2 + " равны";
        }
    }


    // 3. Сколько дней до Нового года?
    public static long daysUntilNewYear() {
        LocalDate today = LocalDate.now();
        LocalDate newYear = LocalDate.of(today.getYear() + 1, 1, 1);
        return ChronoUnit.DAYS.between(today, newYear);
    }

   // 4. Проверка високосного года
    public static boolean isLeapYear(int year) {
        return Year.of(year).isLeap();
    }
     
    // 5. Подсчет выходных за месяц
    public static int countWeekendDays(int month, int year) {
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());
        int weekendDays = 0;

        for (LocalDate date = firstDayOfMonth; !date.isAfter(lastDayOfMonth); date = date.plusDays(1)) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekendDays++;
            }
        }
        return weekendDays;
    }

    // 6. Расчет времени выполнения метода
   public static void measureExecutionTime(Runnable method) {
        long startTime = System.nanoTime();
        method.run();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Milliseconds
        System.out.println("Время выполнения метода: " + duration + " мс");
    }
    
    // 7. Форматирование и парсинг даты
    public static void formatAndParseDate(String dateString) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateString, inputFormatter);
        LocalDate newDate = date.plusDays(10);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println("Дата после добавления 10 дней: " + newDate.format(outputFormatter));
    }

     // 8. Конвертация между часовыми поясами
    public static void convertTimeZone(LocalDateTime dateTime, ZoneId targetZone) {
        ZonedDateTime zonedTime = ZonedDateTime.of(dateTime, ZoneId.of("UTC"));
        ZonedDateTime convertedTime = zonedTime.withZoneSameInstant(targetZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        System.out.println("Время в UTC: " + zonedTime.format(formatter));
        System.out.println("Время в " + targetZone + ": " + convertedTime.format(formatter));
    }

    // 9. Вычисление возраста по дате рождения
   public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    
     // 10. Создание календаря на месяц
     public static void printCalendarForMonth(int month, int year) {
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());
        System.out.println("Календарь на " + firstDayOfMonth.getMonth() + " " + year + ":");
        
        for (LocalDate date = firstDayOfMonth; !date.isAfter(lastDayOfMonth); date = date.plusDays(1)) {
            String dayType = (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) ? "Выходной" : "Рабочий";
            System.out.println(date + " - " + dayType);
        }
    }

    // 11. Генерация случайной даты в диапазоне
    public static LocalDate generateRandomDate(LocalDate startDate, LocalDate endDate) {
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        Random random = new Random();
        // Генерация случайного числа в пределах [0, endEpochDay - startEpochDay)
        long randomDay = (long) (random.nextDouble() * (endEpochDay - startEpochDay));
        return LocalDate.ofEpochDay(startEpochDay + randomDay);
    }
    
    // 12. Расчет времени до заданной даты
    public static void calculateTimeToEvent(LocalDateTime eventTime) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, eventTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes();
        long seconds = duration.getSeconds();
         minutes = minutes % 60;
         seconds = seconds % 60;
        System.out.println("До события осталось: " + hours + " часов, " + minutes + " минут, " + seconds + " секунд");
    }

     // 13. Вычисление количества рабочих часов
    public static long calculateWorkingHours(LocalDateTime start, LocalDateTime end) {
        return ChronoUnit.HOURS.between(start, end);
    }
   
    // 14. Конвертация даты в строку с учетом локали
   public static void convertDateToStringWithLocale(LocalDate date, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", locale);
        System.out.println("Дата в формате " + locale.getDisplayLanguage() + ": " + date.format(formatter));
    }
   
   // 15. Определение дня недели по дате
    public static String getDayOfWeekRussian(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY: return "Понедельник";
            case TUESDAY: return "Вторник";
            case WEDNESDAY: return "Среда";
            case THURSDAY: return "Четверг";
            case FRIDAY: return "Пятница";
            case SATURDAY: return "Суббота";
            case SUNDAY: return "Воскресенье";
            default: return "Неизвестный день";
        }
    }
}
