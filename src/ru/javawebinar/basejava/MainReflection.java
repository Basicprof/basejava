package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Class<? extends Resume> resumeClass = r.getClass();
        Field field = resumeClass.getDeclaredFields()[0];//Возмем поле объекта
        field.setAccessible(true);// Менять приватные поля финал
        System.out.println(field.getName());
        System.out.println(field.get(r));// Достаем поле по классу
        field.set(r, "new_uuid");

        Method method = resumeClass.getMethod("toString");
        Object result = method.invoke(r);
        System.out.println(result);
    }
}