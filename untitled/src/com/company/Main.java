/**
 * @author Kulemin Semen
 * @version 1.0
 */
package com.company;

import com.company.Commands.TerminalLauncher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            String name = "C:\\Users\\mi\\Desktop\\untitled\\src\\com\\company\\Organizations.json";
            //String name = args[0];
            File file = new File(name);
            if (file.canRead()) {
                TerminalLauncher shit = new TerminalLauncher(file);
                shit.programLaunching();
            } else {
                System.out.println("Недостаточно прав");
            }
        } catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }
    }
}
