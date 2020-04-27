package com.company.Commands;
/**
 * Команда remove_by_id id, используемая для удаления элемента из коллекции по его id
 */
import java.util.Scanner;

public class RemoveById implements Command {
    /** Класс, используемный для работы с коллекцией*/
    private CurrentCollection collection;
    /**
     * Конструктор, используемый для добавления команды в коллекцию команд Map
     * @param l - класс, используемый для управления командами
     * @param c - класс, используемый для работы с коллекцией
     */
    public RemoveById(CommandLauncher l, CurrentCollection c){
        l.addCommand("remove_by_id", this);
        this.collection=c;
    }
    /**
     * Фнкуция исполнения команды
     * @param option - аргумент программы
     * @param scanner - поток
     */
    @Override
    public void execute(String option, Scanner scanner) {
        System.out.println("Выполняется удаление элемента с id, равным " + option);
        collection.removeById(Long.parseLong(option));
    }
}
