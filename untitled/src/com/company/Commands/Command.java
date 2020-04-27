package com.company.Commands;
/**
 * Интерфейс, наследуемый классами всех команд
 */
import java.io.IOException;
import java.util.Scanner;

public interface Command {
    public void execute(String option, Scanner scanner) throws IOException;
}
