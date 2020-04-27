package com.company.Commands;
/**
 * Команда add_if_min {element}, используемая для добавления нового элемента в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 */
import com.company.Task.Organization;
import java.util.Scanner;

public class AddIfMin implements Command {
    /** Класс, используемный для работы с коллекцией*/
    private CurrentCollection collection;
    /**
     * Конструктор, используемый для добавления команды в коллекцию команд Map
     * @param l - класс, используемый для управления командами
     * @param c - класс, используемый для работы с коллекцией
     */
    public AddIfMin(CommandLauncher l, CurrentCollection c){
        l.addCommand("add_if_min", this);
        this.collection=c;
    }
    /**
     * Фнкуция исполнения команды
     * @param option - аргумент программы
     * @param scanner - поток
     */
    @Override
    public void execute(String option, Scanner scanner) {
        Organization org = collection.getElement((long)(Math.random()*1000000),scanner);
        if (collection.getSizeOfColl() == 0){
            System.out.println("Коллекция пуста");
            collection.addElement(org);
        }
        else{
            if (collection.findMin() > org.getAnnualTurnover()){
                System.out.println("Элемент меньше минимального");
                collection.addElement(org);
            }
            else{
                System.out.println("Элемент больше минимального");
            }
        }
    }
}
