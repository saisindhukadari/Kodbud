import java.util.ArrayList;
import java.util.Scanner;
class Book {
    @SuppressWarnings("FieldMayBeFinal")
    private int id;
    private String title;
    private String author;
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void display() {
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author);
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
public class LibraryManagementSystem {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();
        books.add(new Book(id, title, author));
        System.out.println(" Book added successfully!");
    }
    public static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println(" No books available.");
            return;
        }
        System.out.println(" List of Books:");
        for (Book b : books) {
            b.display();
        }
    }
    public static void searchBook() {
        System.out.print("Enter book title to search: ");
        String searchTitle = sc.nextLine();
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(searchTitle)) {
                System.out.println(" Book Found:");
                b.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println(" Book not found.");
        }
    }
    public static void removeBook() {
        System.out.print("Enter book ID to remove: ");
        int id = sc.nextInt();
        boolean removed = false;
        for (Book b : books) {
            if (b.getId() == id) {
                books.remove(b);
                System.out.println(" Book removed successfully!");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println(" Book not found.");
        }
    }
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("  Library Menu ");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1 -> addBook();
                case 2 -> displayBooks();
                case 3 -> searchBook();
                case 4 -> removeBook();
                case 5 -> System.out.println(" Exiting program...");
                default -> System.out.println(" Invalid choice!");
            }

        } while (choice != 5);
    }
}