package ru.javawebinar.basejava.model;


import java.util.Date;

;


public class DateInterim {
    private  Date start;
    private Date finich;

    public DateInterim(Date start, Date finich) {
        this.start = start;
        this.finich = finich;
    }

    @Override
    public String toString() {
        return start.toString()+" - "+finich.toString();
    }
}
