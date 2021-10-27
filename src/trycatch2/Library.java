package trycatch2;

public class Library {
    private String name;
    private String city;
    private Book[] books;
    private int index;

    public Library() {
        books = new Book[20];
        index = 0;
    }

    public void addBook(Book book) {
        try {
            books[index++] = book;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The library is full");
        }
    }

    public void printBooks() {
        for (int i = 0; i < books.length; i++) {
            System.out.print((i + 1) + ": ");
            try{
                System.out.println(books[i].getData());
            }catch (NullPointerException e){
                System.out.println("The book is empty");
            }
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

