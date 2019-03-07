package ru.javawebinar.basejava.model;

public class Contact {
    String title ;
    String number;

    public Contact(String title, String number) {
        this.title = title;
        this.number = number;
    }

    public Contact(String number) {
        this.number = number;
        this.title = "";
    }

    @Override
    public String toString() {
        return title+" "+number;
    }
}
