package com.company.Commands;
/**
 * Команда filter_greater_than_postal_address postalAddress, используемая для вывода элементов, значение поля postalAddress которых больше заданного
 */
import java.util.Scanner;

public class FilterGreaterThanPostalAddress implements Command {
    /** Класс, используемный для работы с коллекцией*/
    private CurrentCollection collection;
    /**
     * Конструктор, используемый для добавления команды в коллекцию команд Map
     * @param l - класс, используемый для управления командами
     * @param c - класс, используемый для работы с коллекцией
     */
    public FilterGreaterThanPostalAddress(CommandLauncher l, CurrentCollection c){
        l.addCommand("filter_greater_than_postal_address", this);
        this.collection=c;
    }
    /**
     * Фнкуция исполнения команды
     * @param option - аргумент программы
     * @param scanner - поток
     */
    @Override
    public void execute(String option, Scanner scanner) {
        System.out.println("Ищем элементы со значением postalAddress большими, чем " + option);
        collection.filterGreaterThanPostalAddress(option);
    }
}
