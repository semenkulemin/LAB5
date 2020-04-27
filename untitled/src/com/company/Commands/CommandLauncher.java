package com.company.Commands;
/**
 * Класс, используемый для хранения и запуска команд
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandLauncher {
    /**
     * Коллекция типа Map для хранения команд
     */
    private Map<String,Command> Commands = new HashMap<>();
    private String lastCommands[] = new String[13];
    private int amountOfCommands = 0;
    /**
     * Функция, используемая для добавления команды в коллекцию Map
     * @param key - ключ
     * @param command - команда
     */
    public void addCommand(String key,Command command){
        Commands.put(key,command);
    }
    /**
     * Функция, используемая для исполнения команды
     * @param key - ключ команды
     * @param option - параметр команды
     * @param scanner - поток
     * @throws IOException
     */
    public void executeCommand(String key, String option, Scanner scanner) throws IOException {
        Commands.get(key).execute(option, scanner);
        if (amountOfCommands<13){
            lastCommands[amountOfCommands] = key;
            amountOfCommands++;
        } else{
            for(int i = 0; i < 12; i++){
                lastCommands[i] = lastCommands[i + 1];
            }
            lastCommands[12] = key;
        }
    }
    /**
     * Функция, используемая для вывода последних тринадцати командт
     */
    public void getListOfCommands(){
        if (amountOfCommands < 13){
            System.out.println("Вы использовали меньше 13 команд");
        }
        for (int i = 0; i < amountOfCommands; i++) {
            System.out.println(lastCommands[i]);
        }
    }
}
