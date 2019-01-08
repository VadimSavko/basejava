/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = 0;

    void clear() {
        for (int i = 0; i < storageSize; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        if (r != null) {
            for (int i = 0; i < storageSize; i++) {
                if (storage[i].uuid.equals(r.uuid)) {
                    return;
                }
            }

            if (storageSize < storage.length) {
                storage[storageSize] = r;
                storageSize++;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int index = -1;

        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            for (int i = index; i < (storageSize - 1); i++) {
                storage[i] = storage[i + 1];
            }
            storage[storageSize - 1] = null;
            storageSize--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[storageSize];

        for (int i = 0; i < storageSize; i++)
            result[i] = storage[i];

        return result;
    }

    int size() {
        return storageSize;
    }
}
