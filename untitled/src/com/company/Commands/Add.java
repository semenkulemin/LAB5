package com.company.Commands;
/**
 * Команда add {element}, используемая для добавления нового элемента в коллекцию
 */
import com.company.Task.Organization;
import java.util.Scanner;

public class Add implements Command {
    /** Класс, используемный для работы с коллекцией*/
    private CurrentCollection collection;
    /**
     * Конструктор, используемый для добавления команды в коллекцию команд Map
     * @param l - класс, используемый для управления командами
     * @param c - класс, используемый для работы с коллекцией
     */
    public Add(CommandLauncher l, CurrentCollection c){
        l.addCommand("add", this);
        this.collection=c;
    }
    /**
     * Фнкуция исполнения команды
     * @param option - аргумент программы
     * @param scanner - поток
     */
    @Override
    public void execute(String option, Scanner scanner) {
        Organization org = collection.getElement((long)(Math.random()*100000), scanner);
        collection.addElement(org);
    }
}
