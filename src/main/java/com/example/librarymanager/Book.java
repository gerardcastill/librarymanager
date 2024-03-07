package com.example.librarymanager;
public class Book extends LibraryManagerApplication
{
    int ISBN;
    int status;
    String title;
    String type;
    String publisher;
    int pages;
    float price;
    int pubyear;
    String name;
    String dueDate;

    //Constructor of Book object that sets the data for all variables/details of a book
    Book(int ISBN, String title, String type, String publisher, int pages, float price, int pubyear, int status, String name, String dueDate)
    {
        this.ISBN = ISBN;
        this.status = status;
        this.title = title;
        this.type = type;
        this.publisher = publisher;
        this.pages = pages;
        this.price = price;
        this.pubyear = pubyear;
        this.name = name;
        this.dueDate = dueDate;
    }

    //Method used to change the status of a Book object
    void setStatus(int status)
    {
        this.status = status;
    }

    //Method used to change the name of a Book object
    void setName(String name)
    {
        this.name = name;
    }

    //Method used to change the dueDate of a Book object
    void setdueDate(String dueDate)
    {
        this.dueDate = dueDate;
    }

    //Method used to retrieve the ISBN of a Book object
    int getISBN()
    {
        return ISBN;
    }

    //Method used to retrieve the status of a Book object
    int getStatus()
    {
        return status;
    }

    //Method prints out the details of the Book object
    void description ()
    {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Type: " + type);
        System.out.println("Publisher: " + publisher);
        System.out.println("Pages: " + pages);
        System.out.println("Price: " + price);
        System.out.println("Publication Year: " + pubyear);
        System.out.println("Checked out status: " + status);
        System.out.println("Name of person who checked out: " + name);
        System.out.println("Due date:" + dueDate + "\n");
    }
}
