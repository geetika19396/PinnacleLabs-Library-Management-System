import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Book[] books = new Book[10];

        int count = 0;
        int choice;

do {

    System.out.println("\n========================================");
    System.out.println("     LIBRARY MANAGEMENT SYSTEM");
    System.out.println("========================================");
    System.out.println("1. Add Book");
    System.out.println("2. View Books");
    System.out.println("3. Issue Book");
    System.out.println("4. Return Book");
    System.out.println("5. Exit");

    System.out.print("\nEnter your choice: ");
    choice = sc.nextInt();

    if (choice == 1) {
        if (count == books.length) {
    System.out.println("Library is Full! Cannot Add More Books.");
    }
     else {

    sc.nextLine();

    System.out.print("Enter Book ID: ");
    int id = sc.nextInt();
    sc.nextLine();

    System.out.print("Enter Book Title: ");
    String title = sc.nextLine();

    System.out.print("Enter Author Name: ");
    String author = sc.nextLine();

    books[count] = new Book(id, title, author);
    count++;

    System.out.println("\nBook Added Successfully!");

     }
}

if (choice == 2) {

    if (count == 0) {
        System.out.println("\nNo Books Available!");
    } else {

        System.out.println("\n========== BOOK LIST ==========");

        for (int i = 0; i < count; i++) {

            System.out.println("Book ID : " + books[i].bookId);
            System.out.println("Title   : " + books[i].title);
            System.out.println("Author  : " + books[i].author);

            if (books[i].isIssued) {
                System.out.println("Status  : Issued");
            } else {
                System.out.println("Status  : Available");
            }

            System.out.println("------------------------------");
        }
    }
}

if (choice == 3) {

    System.out.print("\nEnter Book ID to Issue: ");
    int id = sc.nextInt();

    boolean found = false;

    for (int i = 0; i < count; i++) {

        if (books[i].bookId == id) {

            found = true;

            if (books[i].isIssued) {
                System.out.println("Book is already issued.");
            } else {
                books[i].isIssued = true;
                System.out.println("Book Issued Successfully!");
            }

            break;
        }
    }

    if (!found) {
        System.out.println("Book Not Found!");
    }
}

if (choice == 4) {

    System.out.print("\nEnter Book ID to Return: ");
    int id = sc.nextInt();

    boolean found = false;

    for (int i = 0; i < count; i++) {

        if (books[i].bookId == id) {

            found = true;

            if (!books[i].isIssued) {
                System.out.println("Book is already available in the library.");
            } else {
                books[i].isIssued = false;
                System.out.println("Book Returned Successfully!");
            }

            break;
        }
    }

    if (!found) {
        System.out.println("Book Not Found!");
    }
}

if (choice < 1 || choice > 5) {
    System.out.println("Invalid Choice! Please try again.");
}

} while (choice != 5);
System.out.println("\n========================================");
System.out.println(" Thank You for Using Library Management System!");
System.out.println("========================================");

sc.close();


    }
}