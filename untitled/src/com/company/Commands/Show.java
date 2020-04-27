package com.company.Commands;
/**
 * Команда show, используемая для вывода в стандартный поток вывода всех элементов коллекции в строковом представлении
 */
import java.util.Scanner;

public class Show implements Command{
    /** Класс, используемный для работы с коллекцией*/
    private CurrentCollection collection;
    /**
     * Конструктор, используемый для добавления команды в коллекцию команд Map
     * @param l - класс, используемый для управления командами
     * @param c - класс, используемый для работы с коллекцией
     */
    public Show(CommandLauncher l, CurrentCollection c){
        l.addCommand("show", this);
        this.collection=c;
    }
    /**
     * Фнкуция исполнения команды
     * @param option - аргумент программы
     * @param scanner - поток
     */
    @Override
    public void execute(String option, Scanner scanner) {
        if (collection.getSizeOfColl() == 0){
            System.out.println("Коллекция пуста");
        }else{
            collection.getAllElements();
        }
    }
}
