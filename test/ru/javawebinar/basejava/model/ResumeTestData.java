package ru.javawebinar.basejava.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class ResumeTestData {
    Resume RESUME;

    @AfterClass
    public void setUpClass() throws Exception {
        this.RESUME = new Resume("Григорий Кислин");
        this.RESUME.addContact("Тел.", "+7(921) 855-0482");
        this.RESUME.addContact("Skype: ", "<a href=\"skype:grigory.kislin\">grigory.kislin</a>");
        this.RESUME.addContact("Почта:", "<a href=\"mailto:gkislin@yandex.ru\">gkislin@yandex.ru</a>");
        this.RESUME.addContact("<a href=\"https://www.linkedin.com/in/gkislin\">Профиль LinkedIn</a>");
        this.RESUME.addContact( "< a href =\"https://www.linkedin.com/in/gkislin\">Профиль LinkedIn</a>");
        this.RESUME.addContact("<a href=\"https://github.com/gkislin\">Профиль GitHub</a>");
        this.RESUME.addContact("<a href=\"https://stackoverflow.com/users/548473\">Профиль Stackoverflow</a>");


        this.RESUME.addContent(new Date(15151515), new Date(156156156),
                SectionType.ACHIEVEMENT, new SectionText("что то о себе", "ссылка"));
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void getUuid() {
        Resume resume = new Resume("Григорий Кислин");

    }

    @Test
    public void equals() {
    }


    @Test
    public void compareTo() {
    }
}