package ru.netology.distonary;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        /*

        1. Детерминированность функций:
            В качестве аргументов для методов create и print
            можно принимать любые строки и любые списки
        2. Монады:
            В методе create применяется последовательность мелких операций
            Для получения результата в функции print вызывается последовательность операций record и create

         */

        DictionaryRecorder <String> dictionaryRecorder = () -> {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        };

        DictionaryCreator<String, List <String>> dictionaryCreator = x -> {
            return Arrays.stream(x.split(" "))
                   .sorted(Comparator.naturalOrder())
                   .collect(Collectors.toList());
        };

        DictionaryPrinter<List <String>> dictionaryPrinter = x -> x.forEach(System.out::println);

        printRequest();
        dictionaryPrinter.print(
                dictionaryCreator.create(
                        dictionaryRecorder.record()));



    }

    public static void printRequest () {

        System.out.println("Введите услышанные слова аборигенов разделяя их пробелами");

    }

}
