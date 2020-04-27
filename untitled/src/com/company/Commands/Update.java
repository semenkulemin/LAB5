package com.company.Commands;
/**
 * Команда update id {element}, используемая для обновления значения элемента коллекции, id которого равен заданному
 */
import com.company.Task.Organization;
import java.util.Scanner;

public class Update implements Command {
    /** Класс, используемный для работы с коллекцией*/
    private CurrentCollection collection;
    /**
     * Конструктор, используемый для добавления команды в коллекцию команд Map
     * @param l - класс, используемый для управления командами
     * @param c - класс, используемый для работы с коллекцией
     */
    public Update(CommandLauncher l, CurrentCollection c){
        l.addCommand("update", this);
        this.collection=c;
    }
    /**
     * Фнкуция исполнения команды
     * @param option - аргумент программы
     * @param scanner - поток
     */
    @Override
    public void execute(String option, Scanner scanner) {
        System.out.println("Ищем элемент с id " + option);
        int amount_before = collection.getSizeOfColl();
        System.out.println("Выполняется удаление элемента с id, равным " + option);
        collection.removeById(Long.parseLong(option));
        if (amount_before == collection.getSizeOfColl()){
            System.out.println("Элемента с id, равным" + option + ", не найдено");
        }
        else{
            Organization org = collection.getElement(Long.parseLong(option), scanner);
            collection.addElement(org);
        }
    }
}
