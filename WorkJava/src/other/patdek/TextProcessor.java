package other.patdek;

// Интерфейс для обработки текста
interface TextProcessor {
    String process(String text);
}

// Класс, который не меняет текст
class SimpleTextProcessor implements TextProcessor {
    @Override
    public String process(String text) {
        return text;
    }
}

// Декоратор для преобразования в верхний регистр
class UpperCaseDecorator implements TextProcessor {
    private TextProcessor textProcessor;

    public UpperCaseDecorator(TextProcessor textProcessor) {
        this.textProcessor = textProcessor;
    }

    @Override
    public String process(String text) {
        return textProcessor.process(text).toUpperCase();
    }
}

// Декоратор для удаления пробелов
class TrimDecorator implements TextProcessor {
    private TextProcessor textProcessor;

    public TrimDecorator(TextProcessor textProcessor) {
        this.textProcessor = textProcessor;
    }

    @Override
    public String process(String text) {
        return textProcessor.process(text).trim();
    }
}

// Декоратор для замены пробелов
class ReplaceDecorator implements TextProcessor {
    private TextProcessor textProcessor;

    public ReplaceDecorator(TextProcessor textProcessor) {
        this.textProcessor = textProcessor;
    }

    @Override
    public String process(String text) {
        return textProcessor.process(text).replace(" ", "_");
    }
}

// Пример использования декораторов
class DecoratorDemo {
    public static void main(String[] args) {
        String text = "  Hello World  ";

        // Создаем основной процессор
        TextProcessor processor = new SimpleTextProcessor();
        System.out.println("Original: " + processor.process(text));

        // Применяем декоратор для преобразования в верхний регистр
        TextProcessor upperCaseProcessor = new UpperCaseDecorator(processor);
        System.out.println("UpperCase: " + upperCaseProcessor.process(text));

        // Применяем декоратор для удаления пробелов
        TextProcessor trimProcessor = new TrimDecorator(processor);
        System.out.println("Trim: " + trimProcessor.process(text));

        // Применяем декоратор для замены пробелов
        TextProcessor replaceProcessor = new ReplaceDecorator(processor);
        System.out.println("Replace: " + replaceProcessor.process(text));

        // Комбинируем декораторы
        TextProcessor combinedProcessor = new ReplaceDecorator(new UpperCaseDecorator(new TrimDecorator(processor)));
        System.out.println("Combined: " + combinedProcessor.process(text));
    }
}