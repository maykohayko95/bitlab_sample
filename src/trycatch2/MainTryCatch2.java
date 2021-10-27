package trycatch2;

public class MainTryCatch2 {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book(1, "Homo Sapiens", "Noah Harari"));
        library.addBook(null);
        for (int i = 2; i < 25; i++) {
            library.addBook(new Book(i, "TestBook" + i, "TestAuthor" + i));
        }
        library.printBooks();
    }
}

