package com.company.Commands;
/**
 * Команда execute_script file_name, используемая для исполнения скрипта из указанного файла
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExecuteScript implements Command  {
    /** Класс, используемый для управления командами*/
    private CommandLauncher launch;
    /** Коллекция, используемая для хранения всех файлов, к которым обращается команда */
    ArrayList<String> list = new ArrayList<>();
    /**
     * Конструктор, используемый для добавления команды в коллекцию команд Map
     * @param l - класс, используемый для управления командами
     * @param c - класс, используемый для работы с коллекцией
     */
    public ExecuteScript(CommandLauncher l, CurrentCollection c){
        l.addCommand("execute_script", this);
        this.launch=l;
    }
    /**
     * Фнкуция исполнения команды
     * @param option - аргумент программы
     * @param scanner - поток
     */
    @Override
    public void execute(String option, Scanner scanner) {
        /*option = "C:\\Users\\mi\\Desktop\\untitled\\src\\com\\company\\test.txt";*/
        try {
            File file = new File(option);
            if (file.canRead()) {
                FileReader filereader = new FileReader(file);
                Scanner scanfile = new Scanner(filereader);
                list.add(option);
                boolean flag;
                String line;
                while (scanfile.hasNextLine()) {
                    line = scanfile.nextLine();
                    try {
                        if (!line.equals("")) {
                            if (line.equals("exit")) {break;}
                            else {
                                if (line.contains(" ")) {
                                    String[] words = line.split(" ", 2);
                                    if (words[0].equals("execute_script")) {
                                        flag = true;
                                        for (String files : list) {
                                            if (files.equals(words[1])) {
                                                flag = false;
                                                break;
                                            }

                                        }
                                        if (flag) {
                                            list.add(words[1]);
                                            launch.executeCommand(words[0], words[1], scanfile);
                                        } else {
                                            System.out.println("ПОПАЛСЯ. Исполнение команды приведет к зацикливанию. Дальше только пустота");
                                            break;
                                        }
                                    } else {
                                        launch.executeCommand(words[0], words[1], scanfile);
                                    }
                                } else {
                                    launch.executeCommand(line, null, scanfile);
                                }
                            }
                        } else {
                            System.out.println("Строка пуста");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Беда. Данная команда не существует. Список всех команд доступен, если написать \"help\"");
                    } catch (NoSuchElementException e) {
                        System.out.println("Некорректно введен элемент коллекции. Команда не будет исполнена");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Некорректно введен аргумент программы. Команда не будет исполнена");
                    }
                }
                filereader.close();
            }
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        } catch (IOException e) {

        }
    }
}
