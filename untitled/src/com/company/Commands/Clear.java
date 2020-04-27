package com.company.Commands;
/**
 * Команда clear, используемая для очистки коллекции
 */
import java.util.Scanner;

public class Clear implements Command {
    /** Класс, используемный для работы с коллекцией*/
    private CurrentCollection collection;
    /**
     * Конструктор, используемый для добавления команды в коллекцию команд Map
     * @param l - класс, используемый для управления командами
     * @param c - класс, используемый для работы с коллекцией
     */
    public Clear(CommandLauncher l, CurrentCollection c){
        l.addCommand("clear", this);
        this.collection=c;
    }
    /**
     * Фнкуция исполнения команды
     * @param option - аргумент программы
     * @param scanner - поток
     */
    @Override
    public void execute(String option, Scanner scanner) {
        if (collection.getSizeOfColl()==0){
            System.out.println("Коллекция пуста");
        }
        else{
            collection.clearList();
            System.out.println("Коллекция очищена");
        }
    }
}