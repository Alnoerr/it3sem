package lab3.task1;

public class HashTableExampleUsage {
    public static void main(String[] args) {
        HashTable<String, String> hashTable = new HashTable<>();

        System.out.println("До добавления:");
        System.out.printf("Размер: %d\n", hashTable.size());
        System.out.printf("Пустая: %s\n", hashTable.isEmpty());

        hashTable.put("sample_key", "value");
        hashTable.put("sample_key2", "value2");

        System.out.println("После добавления:");
        System.out.printf("Размер: %d\n", hashTable.size());
        System.out.printf("Пустая: %s\n", hashTable.isEmpty());

        for (int x = 0; x < 200; x++) {
            hashTable.put(String.format("key%d", x), String.format("value%d", x));
        }
        System.out.printf("Размер после добавления ещё 200 элементов: %d\n", hashTable.size());

        System.out.println(hashTable.get("key1").size());
        for (HashTableEntry<String, String> entry : hashTable.get("key1")) {
            System.out.println(entry.toString());
        }

        hashTable.remove("key1");

        System.out.println(hashTable.get("key1").size());
        System.out.printf("Размер после удаления 2 элементов: %d\n", hashTable.size());
    }
}
