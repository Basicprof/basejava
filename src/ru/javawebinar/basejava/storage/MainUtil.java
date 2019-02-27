package ru.javawebinar.basejava.storage;

public class MainUtil {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf(-1) == Integer.valueOf(-1));// Достается из кеша если -128 до 127
        System.out.println(Integer.valueOf(-1) == new Integer(-1));// Создается  объеет
        int  result = getInt();
        System.out.println(result);
    }

    private static Integer getInt() {
        return null;
    }
}