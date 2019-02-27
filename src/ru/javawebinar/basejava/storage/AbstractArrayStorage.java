package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

   public void clear( ) {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }


    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

    protected abstract int getIndex(String uuid);
}