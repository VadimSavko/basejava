/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++)
            if (storage[i] == null)
                break;
            else
                storage[i] = null;
    }

    void save(Resume r) {
        if (r != null)
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] != null)
                    if (storage[i].uuid.equals(r.uuid))
                        break;

                if (storage[i] == null) {
                    storage[i] = r;
                    break;
                }
            }

    }

    Resume get(String uuid) {
        int index = -1;

        for (int i = 0; i < storage.length; i++)
            if (storage[i] == null) {
                break;
            } else if (storage[i].uuid.equals(uuid)) {
                index = i;
                break;
            }

        if (index != -1)
            return storage[index];
        else
            return null;
    }

    void delete(String uuid) {
        boolean found = false;

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null)
                break;

            if (!found)
                found = storage[i].uuid.equals(uuid);

            if (found) {
                if (i == (storage.length - 1))
                    storage[i] = null;
                else
                    storage[i] = storage[i + 1];
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size = size();
        Resume[] result = new Resume[size];

        for (int i = 0; i < size; i++)
            result[i] = storage[i];

        return result;
    }

    int size() {
        int count = 0;

        for (Resume r : storage)
            if (r == null)
                break;
            else
                count++;

        return count;
    }
}
