package ru.javawebinar.basejava.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.Writer;

public class XmlParser {
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;

    public XmlParser(Class... classesToBeBound) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(classesToBeBound);
            //Создаем контекст по этим классам которые будем сирелизовать

            marshaller = ctx.createMarshaller();// Созадем маршаллер
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // Созадем проперти форматируем красиво не в одну строчку
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

            unmarshaller = ctx.createUnmarshaller();// онмаршалер просто
        } catch (JAXBException e) {
            throw new IllegalStateException(e);
        }
    }

    public <T> T unmarshall(Reader reader) {
        try {
            return (T) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            throw new IllegalStateException(e);
        }
    }

    public void marshall(Object instance, Writer writer) {
        try {
            marshaller.marshal(instance, writer);
        } catch (JAXBException e) {
            throw new IllegalStateException(e);
        }
    }
}

