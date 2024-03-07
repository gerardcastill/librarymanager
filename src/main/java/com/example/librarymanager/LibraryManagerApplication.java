package com.example.librarymanager;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;

public class LibraryManagerApplication
{
    //Method used to change the dueDate variable within a Book object
    public static void dueDateCheckout(ArrayList<Book> library, int ISBN, String dueDate)
    {
        boolean found = library.stream().anyMatch(Book->Book.getISBN() == ISBN);

        if (found)
        {
            for (int i = 0; i< library.size(); i++)
                if (library.get(i).getISBN()== ISBN)
                    library.get(i).setdueDate(dueDate);
        }
    }

    //Method used to change the name variable within a Book object
    public static void nameCheckout(ArrayList<Book> library, int ISBN, String name)
    {
        boolean found = library.stream().anyMatch(Book->Book.getISBN() == ISBN);

        if (found)
        {
            for (int i = 0; i< library.size(); i++)
                if (library.get(i).getISBN()== ISBN)
                    library.get(i).setName(name);
        }
    }

    //Method used to change the status variable within a Book object for checking in/out
    public static void bookCheck(ArrayList<Book> library, int ISBN, int status)
    {
        boolean found = library.stream().anyMatch(Book->Book.getISBN() == ISBN);

        if (found)
        {
            for (int i = 0; i< library.size(); i++)
                if (library.get(i).getISBN()== ISBN)
                    library.get(i).setStatus(status);
        }
        else
            System.out.println("The ISBN does not match any book in the library\n");
    }

    //Method that calls on the description() method in the Book objects
    public static void printArray(ArrayList<Book> library)
    {
        for (int i=0; i < library.size();i++)
            library.get(i).description();
    }

    //Method that removes a Book object from the ArrayList
    public static void removeFromArray(ArrayList<Book> library, int ISBN)
    {
        boolean found = library.stream().anyMatch(Book->Book.getISBN() == ISBN);

        if (found)
        {
            library.removeIf(Book -> Book.getISBN() == ISBN);
            System.out.println("The book has been removed\n");
        }
        else
            System.out.println("The ISBN does not match any book in the library\n");
    }

    //Method that prints the list of books that are checked in or checked out
    public static void printAvailability(ArrayList<Book> library, int status)
    {
        boolean found = library.stream().anyMatch(Book->Book.getStatus() == status);

        if (found)
        {
            for (int i = 0; i< library.size(); i++)
                if (library.get(i).getStatus()== status)
                    library.get(i).description();
        }
        else
            System.out.print("There are no books with that status\n");
    }

    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        String name;
        String title;
        String type;
        String publisher;
        String date;
        int pages;
        int ISBN;
        int pubyear;
        int status;
        float price;
        boolean endProgram = true;

        //Creation of ArrayList and input for scanner
        ArrayList <Book> library = new ArrayList <>(100);
        Scanner input = new Scanner(System.in);

        //Creation of file to save the ArrayList between program uses
        File file = new File("library.txt");
        FileWriter fw = new FileWriter (file, true);
        Writer output = new BufferedWriter(fw);
        BufferedReader reader = new BufferedReader(new FileReader(file));


        //This do-while loop will continue until case:8 is specified by the user
        do
        {
            //This is the menu that is displayed to the user until a selection is chosen.
            System.out.println("Welcome to the Library Manager! Make a selection to continue.");
            System.out.println("1. Add a new book");
            System.out.println("2. Remove a book (input ISBN)");
            System.out.println("3. Check out a book (input ISBN and the due date)");
            System.out.println("4. Check in a book (input ISBN)");
            System.out.println("5. Display all book details (along with their specialization)");
            System.out.println("6. Display all available book details");
            System.out.println("7. Display all checked-out books");
            System.out.println("8. Exit program");

            int UserInput = input.nextInt();

            switch (UserInput)
            {
                //Case for adding a new Book object
                case 1:
                    System.out.println("\nWhat is the ISBN of the book?");
                    ISBN = input.nextInt();

                    input.nextLine();
                    System.out.println("What is the title of the book?");
                    title = input.nextLine();

                    System.out.println("What type of book is it?");
                    type = input.nextLine();

                    System.out.println("Who is the publisher of the book?");
                    publisher = input.nextLine();

                    System.out.println("How many pages are in the book?");
                    pages = input.nextInt();

                    System.out.println("What is the price of the book?");
                    price = input.nextFloat();

                    System.out.println("What is the publication year of the book?");
                    pubyear = input.nextInt();
                    status=0;
                    name="-";
                    date="-";
                    library.add(new Book (ISBN, title, type, publisher, pages, price, pubyear, status, name, date));
                    System.out.println("The book has been added to the library\n");
                    break;

                //Case for removing a Book object
                case 2:
                    System.out.println("\nWhat is the ISBN of the book?");
                    ISBN = input.nextInt();

                    removeFromArray(library, ISBN);
                    break;

                //Case for changing the status, name, and dueDate variables of a Book object
                case 3:
                    System.out.println("\nWhat is the ISBN of the book you wish to check out?");
                    ISBN = input.nextInt();
                    status = 1;
                    bookCheck(library, ISBN, status);

                    input.nextLine();
                    System.out.println("Who is checking out the book?");
                    name = input.nextLine();
                    nameCheckout(library, ISBN, name);

                    System.out.println("What year will the book be returned? (ex. YYYY)");
                    int year = input.nextInt();
                    System.out.println("What month will the book be returned? (ex. MM)");
                    int month = input.nextInt();
                    System.out.println("What day will the book be returned? (ex. dd)");
                    int day = input.nextInt();
                    String dueDate = month + "/" + day + "/" + year;
                    dueDateCheckout(library, ISBN, dueDate);

                    System.out.println("The book has been checked out. Enjoy\n");
                    break;

                //Case for changing the status of a Book object
                case 4:
                    System.out.println("\nWhat is the ISBN of the book you wish to check in?");
                    ISBN = input.nextInt();
                    status = 0;

                    bookCheck(library, ISBN, status);
                    System.out.println("The book has been checked in\n");
                    break;

                //Case for printing the details of all Book objects in the ArrayList
                case 5:
                    printArray(library);
                    break;

                //Case for displaying all books that are NOT checked out
                case 6:
                    status = 0;
                    printAvailability(library, status);
                    break;

                //Case for displaying all books that are checked out
                case 7:
                    status = 1;
                    printAvailability(library, status);
                    break;

                //Case for ending the program and saving the ArrayList to the library.txt file
                case 8:
                    System.out.println("\nThank you for using the Library Manager. Good bye!");
                    for (int i=0; i<library.size();i++)
                        output.write(library.get(i) + "\n");
                    reader.close();
                    output.close();
                    endProgram = false;
                    break;

                default:
                    System.out.print("\nNot a valid input.");
            }
        } while (endProgram);
    }
}
