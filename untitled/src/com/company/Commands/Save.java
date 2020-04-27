package com.company.Commands;
/**
 * Команда save, используемая для сохранения коллекции в файл
 */
import java.io.IOException;
import java.util.Scanner;

public class Save implements Command {
    /** Класс, используемный для работы с коллекцией*/
    private CurrentCollection collection;
    /**
     * Конструктор, используемый для добавления команды в коллекцию команд Map
     * @param l - класс, используемый для управления командами
     * @param c - класс, используемый для работы с коллекцией
     */
    public Save(CommandLauncher l, CurrentCollection c){
        l.addCommand("save", this);
        this.collection=c;
    }
    /**
     * Фнкуция исполнения команды
     * @param option - аргумент программы
     * @param scanner - поток
     */
    @Override
    public void execute(String option, Scanner scanner) throws IOException {
        System.out.println("Сохраняем коллекцию в файл");
        collection.saveCollectionToFile();
        System.out.println("Коллекция успешно сохранена");
    }
}
