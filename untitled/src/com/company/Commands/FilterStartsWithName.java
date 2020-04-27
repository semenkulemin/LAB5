package com.company.Commands;
/**
 * Команда filter_starts_with_name name, используемая для вывода элементов, значение поля name которых начинается с заданной подстроки
 */
import java.util.Scanner;

public class FilterStartsWithName implements Command {
    /** Класс, используемный для работы с коллекцией*/
    private CurrentCollection collection;
    /**
     * Конструктор, используемый для добавления команды в коллекцию команд Map
     * @param l - класс, используемый для управления командами
     * @param c - класс, используемый для работы с коллекцией
     */
    public FilterStartsWithName(CommandLauncher l, CurrentCollection c){
        l.addCommand("filter_starts_with_name", this);
        this.collection=c;
    }
    /**
     * Фнкуция исполнения команды
     * @param option - аргумент программы
     * @param scanner - поток
     */
    @Override
    public void execute(String option, Scanner scanner) {
        System.out.println("Элементы, поля name которых начинаются с " + option + ":");
        collection.filterStartsWithName(option);
    }
}
