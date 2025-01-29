import java.util.ArrayList;
import java.util.List;

public class SingletonEnum {

    public static void main(String[] args) {
        // Задача 1: База данных
        DatabaseConnector db1 = DatabaseConnector.getInstance();
        DatabaseConnector db2 = DatabaseConnector.getInstance();

        System.out.println("Database instances are the same: " + (db1 == db2));

        // Задача 2: Логирование
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First log message");
        logger2.log("Second log message");
        logger1.displayLogs();

        System.out.println("Logger instances are the same: " + (logger1 == logger2));

        // Задача 3: Статусы заказа
        Order order1 = new Order(1);
        System.out.println("Order 1 status: " + order1.getStatus());
        order1.changeStatus(OrderStatus.IN_PROGRESS);
        System.out.println("Order 1 status: " + order1.getStatus());
        order1.changeStatus(OrderStatus.DELIVERED);
        System.out.println("Order 1 status: " + order1.getStatus());
        order1.changeStatus(OrderStatus.CANCELLED); // Попытка отмены доставленного
       
        
        Order order2 = new Order(2);
        order2.changeStatus(OrderStatus.CANCELLED);
        System.out.println("Order 2 status: " + order2.getStatus());
        
        // Задача 4: Сезоны года
        System.out.println("Season of WINTER: " + getSeasonName(Season.WINTER));
        System.out.println("Season of SPRING: " + getSeasonName(Season.SPRING));
        System.out.println("Season of SUMMER: " + getSeasonName(Season.SUMMER));
        System.out.println("Season of AUTUMN: " + getSeasonName(Season.AUTUMN));
    }


    // Задача 1: Singleton для подключения к базе данных
    static class DatabaseConnector {
        private static DatabaseConnector instance;

        private DatabaseConnector() {
            System.out.println("Creating database connection.");
        }

        public static DatabaseConnector getInstance() {
            if (instance == null) {
                instance = new DatabaseConnector();
            }
            return instance;
        }
    }

    // Задача 2: Singleton для логирования
    static class Logger {
        private static Logger instance;
        private List<String> logs;

        private Logger() {
            logs = new ArrayList<>();
        }

        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            logs.add(message);
        }

        public void displayLogs() {
            for (String log : logs) {
                System.out.println(log);
            }
        }
    }

    // Задача 3: Enum для статусов заказа
    enum OrderStatus {
        NEW, IN_PROGRESS, DELIVERED, CANCELLED
    }

    static class Order {
        private OrderStatus status;

        public Order(int orderId) {
            this.status = OrderStatus.NEW;
        }

        public void changeStatus(OrderStatus newStatus) {
            if (status == OrderStatus.DELIVERED && newStatus == OrderStatus.CANCELLED) {
                System.out.println("Cannot cancel a delivered order!");
                return;
            }
            this.status = newStatus;
        }

        public OrderStatus getStatus() {
            return status;
        }
    }

    // Задача 4: Enum для времен года
    enum Season {
        WINTER, SPRING, SUMMER, AUTUMN
    }

    public static String getSeasonName(Season season) {
        switch (season) {
            case WINTER:
                return "Зима";
            case SPRING:
                return "Весна";
            case SUMMER:
                return "Лето";
            case AUTUMN:
                return "Осень";
            default:
                return "Неизвестное время года";
        }
    }
}
