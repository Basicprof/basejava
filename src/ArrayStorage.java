import java.util.ArrayList;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
//        for (int i = 0; i <storage.length ; i++) {
//            if(storage[i] == null) {storage[i] = r;break;}
//        }
//
        storage[size()] = r;
    }

    Resume get(String uuid) {
        Resume resume = null;

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) break;
            if (storage[i].toString() == uuid) {
                resume = storage[i];
                break;
            }
        }
        if (resume == null) resume = new Resume();
        resume.uuid = "not in the database";
        return resume;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].toString() == uuid) {
                storage[i] = null;
                for (int j = i; j < storage.length - 2; j++) {
                    storage[j] = storage[j + 1];
                    if (storage[j] == null) {
                        break;
                    }
                }
                storage[storage.length - 1] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        List list = new ArrayList();
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) list.add(storage[i]);
        }
        Resume[] resumes = new Resume[list.size()];
        list.toArray(resumes);
        return resumes;
    }

    int size() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) count++;
        }
        return count;
    }
}
