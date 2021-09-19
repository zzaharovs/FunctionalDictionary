package ru.netology.distonary;

@FunctionalInterface
public interface DictionaryCreator <String, List> {

    List create (String t);

}
