package com.company.Commands;
/**
 * Команда filter_by_type type, используемая для вывода элементов, значение поля type которых равно заданному
 */
import java.util.Scanner;

public class FilterByType implements Command {
    /** Класс, используемный для работы с коллекцией*/
    private CurrentCollection collection;
    /**
     * Конструктор, используемый для добавления команды в коллекцию команд Map
     * @param l - класс, используемый для управления командами
     * @param c - класс, используемый для работы с коллекцией
     */
    public FilterByType(CommandLauncher l, CurrentCollection c){
        l.addCommand("filter_by_type", this);
        this.collection=c;
    }
    /**
     * Фнкуция исполнения команды
     * @param option - аргумент программы
     * @param scanner - поток
     */
    @Override
    public void execute(String option, Scanner scanner) {
        if ((option.toUpperCase().equals("PUBLIC")) || (option.toUpperCase().equals("GOVERNMENT")) || (option.toUpperCase().equals("TRUST")) || (option.toUpperCase().equals("PRIVATE_LIMITED_COMPANY")) || (option.toUpperCase().equals("OPEN_JOINT_STOCK_COMPANY"))) {
            System.out.println("Выводим элементы со значением type, равным " + option.toUpperCase());
            collection.filterByType(option.toUpperCase());
        }
        else {
            System.out.println("Поля type, равного " + option + ", не существует");
        }
    }
}
