package com.company.Commands;
/**
 * Команда info, используемая для вывода в стандартный поток вывода информацию о коллекции
 */
import java.util.Scanner;

public class Info implements Command {
    /** Класс, используемный для работы с коллекцией*/
    private CurrentCollection collection;
    /**
     * Конструктор, используемый для добавления команды в коллекцию команд Map
     * @param l - класс, используемый для управления командами
     * @param c - класс, используемый для работы с коллекцией
     */
    public Info(CommandLauncher l, CurrentCollection c){
        l.addCommand("info", this);
        this.collection=c;
    }
    /**
     * Фнкуция исполнения команды
     * @param option - аргумент программы
     * @param scanner - поток
     */
    @Override
    public void execute(String option, Scanner scanner) {
        System.out.println("Тип коллекции: " + collection.getTypeOfColl());
        System.out.println("Дата создания коллекции: " + collection.getDataOfColl());
        System.out.println("Количество элементов коллекции: " + collection.getSizeOfColl());
    }
}
