package SocketThread;

import java.io.*;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<Book> books;
    Book book;

    public PackageData() {
    }

    public PackageData(String operationType, ArrayList<Book> books, Book book) {
        this.operationType = operationType;
        this.books = read();
        this.book = book;
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Book> getBooks() {
        this.books = read();
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        write(books);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void addBook(Book book){
        books.add(book);
        write(books);
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", books=" + books +
                ", book=" + book +
                '}';
    }

    public static void write(ArrayList<Book> books) {
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("library.data"));
            outStream.writeObject(books);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Book> read() {
        ArrayList books = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("library.data"));
            books = (ArrayList) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {

        }
        return books;
    }
}

