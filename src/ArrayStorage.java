
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                resume = storage[i];
                break;
            }
        }
        if (resume == null) {
            resume = new Resume();
            resume.uuid = "not in the database";
        }
        return resume;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                storage[i] = null;
                for (int j = i; j < size - 1; j++) {
                    storage[j] = storage[j + 1];
                    storage[j + 1] = null;
                }
                break;
            }
        }
        size--;
    }

    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return size;
    }
}
