package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.assertEquals;

public abstract   class AbstractArrayStorageTest {
    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0,storage.size());

    }

    @Test
    public void update() throws Exception {
         Resume resume = new Resume("uuid4");
          storage.update(resume);
        assertEquals( resume,storage.get("uuid4"));

    }

    @Test
    public void getAll() throws Exception {
     Resume []resumes = storage.getAll();
     assertEquals(storage.size(),resumes.length);
    }

    @Test
    public void save() throws Exception {
        Resume resume = new Resume("uuid4");
        storage.save(resume);

        assertEquals( resume,storage.get("uuid4"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {

        storage.delete("uuid3");
        Resume resume = new Resume("uuid3");
        try {
            storage.get("uuid3");
        }catch (NotExistStorageException e){
             throw new NotExistStorageException(e.getUuid());
        }
    }

    @Test
    public void get() throws Exception {
           storage.get("uuid3");
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}