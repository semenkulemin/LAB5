package com.company.Commands;
/**
 * Класс, обрабатывающий ввод команд
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TerminalLauncher {
    private File file;
    public TerminalLauncher(File file){
        this.file = file;
    }
    /**
     * Функции, запускающая ввод команд с консоли
     */
    public void programLaunching() throws IOException {
        System.out.println("Вечер в хату! Введите \"help\", чтобы увидеть список всех команд");
        Scanner terminalScanner = new Scanner(System.in);
        CommandLauncher run = new CommandLauncher();
        CurrentCollection collection = new CurrentCollection(file);
        collection.fromFileToCollection(file);

        Command help = new Help(run);
        Command info = new Info(run, collection);
        Command show = new Show(run, collection);
        Command clear = new Clear(run, collection);
        Command history = new History(run);
        Command add = new Add(run, collection);
        Command update = new Update(run, collection);
        Command filter_by_type = new FilterByType(run, collection);
        Command remove_by_id = new RemoveById(run, collection);
        Command filter_starts_with_name = new FilterStartsWithName(run, collection);
        Command add_if_max = new AddIfMax(run, collection);
        Command add_if_min = new AddIfMin(run, collection);
        Command filter_greater_than_postal_address = new FilterGreaterThanPostalAddress(run, collection);
        Command save = new Save(run, collection);
        Command execute_script = new ExecuteScript(run, collection);

        System.out.println("Введите команду");
        String line = terminalScanner.nextLine();
        while(!line.equals("exit")){
            if(!line.trim().equals("")) {
                try{
                    if (line.contains(" ")) {
                       String[] words = line.split(" ", 2);
                        run.executeCommand(words[0], words[1], terminalScanner);
                    } else{
                        run.executeCommand(line, null, terminalScanner);
                    }
                } catch (NullPointerException e) {
                    System.out.println("Данная команда не существует. Список всех команд доступен, если написать \"help\"");
                } catch (NumberFormatException e) {
                    System.out.println("Некорректно введен аргумент программы. Повторите ещё раз");
                }
            }
            line = terminalScanner.nextLine();
        }
    }
}