package com.company.Commands;
/**
 * Команда history, используемая для вывода последних 13 команд (без их аргументов)
 */
import java.util.Scanner;

public class History implements Command {
    /** Класс, используемый для управления командами*/
    private CommandLauncher launch;
    /**
     * Конструктор, используемый для добавления команды в коллекцию команд Map
     * @param l - класс, используемый для управления командами
     */
    public History(CommandLauncher l){
        l.addCommand("history", this);
        this.launch=l;
    }
    /**
     * Фнкуция исполнения команды
     * @param option - аргумент программы
     * @param scanner - поток
     */
    @Override
    public void execute(String option, Scanner scanner)  {
        System.out.println("Последние использованные команды:");
        launch.getListOfCommands();
    }
}
