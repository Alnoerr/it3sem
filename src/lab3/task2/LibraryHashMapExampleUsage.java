package lab3.task2;

public class LibraryHashMapExampleUsage {
    public static void main(String[] args) {
        LibraryHashMap libraryHashMap = new LibraryHashMap();

        Book harryPotter = new Book(
                "Гарри Поттер и философский камень",
                "J.K. Rowling",
                120_000_000
        );

        Book lordOfTheRings = new Book(
                "Властелин колец",
                "J.R.R. Tolkien",
                150_000_000
        );

        Book taleOfTwoCities = new Book(
                "Повесть о двух городах",
                "Charles Dickens",
                200_000_000
        );

        System.out.println("Заполним элементами");
        libraryHashMap.put("978-0-7475-3274-3", harryPotter);
        libraryHashMap.put("978-0-618-64015-7", lordOfTheRings);
        libraryHashMap.put("978-0-141-19970-2", taleOfTwoCities);

        System.out.println("Получим книгу Властелин Колец:");
        System.out.println(libraryHashMap.get("978-0-618-64015-7"));


        System.out.println("Удалим книгу Властелин Колец и получим её снова:");
        libraryHashMap.remove("978-0-618-64015-7");
        System.out.println(libraryHashMap.get("978-0-618-64015-7"));
    }
}
