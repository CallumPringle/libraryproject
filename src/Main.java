
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static String textName = "";
    public static boolean run = true;

    public static void main(String[] args) throws IOException {
        fileNamesRead();
        while (run == true) {
            mainMenu();
        }
    }


    public static String getBookDetails() { //sets details into the bookDeets class and returns csv values maybe
        final char delim = ',';
        ArrayList<String> why = new ArrayList<>();
        String bookTitle = getInput("what is the title: ");
        String bookISBN = getInput("enter the ISBN: ");
        String bookAuthor = getInput("enter the Author: ");
        String bookGenre = getInput("enter the genre: ");
        Borowwere borrower = new Borowwere("", why, "");
        bookDeets c = new bookDeets(bookTitle, bookISBN, bookAuthor, bookGenre);c.setTitle(bookTitle);
        borrower.setName(getInput("waht is your name"));
        borrower.addBooks(bookTitle);
        c.setISBN(bookISBN);c.setAuthor(bookAuthor);c.setGenre(bookGenre);
        return (bookTitle + delim + bookISBN + delim + bookAuthor + delim + bookGenre + delim + borrower.getName() + "\n");
    }

    public static String getInput(String prompt) { //input function
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void fileNamesStore(String among) {
        try {
            FileWriter myWriter = new FileWriter("filenames.txt", false);
            myWriter.write(among);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void fileNamesRead() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("filenames.txt"));
            textName = br.readLine();
            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void viewBooks() {
        try {
            Scanner sc = new Scanner(new FileReader(textName));
            while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void createNewFile(String sussy) { //why does this exist
        try {
            File myObj = new File(sussy + ".txt");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter(sussy + ".txt", false);
                myWriter.write("Title, ISBN, Author, Genre, Borrower Name:\n");
                myWriter.close();
                System.out.println("File created " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void createFile(String sussy) { //figure out what this does
        try {
            File myObj = new File(sussy);
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter(sussy, false);
                myWriter.write("Title, ISBN, Author, Genre, Borrower Name:\n");
                myWriter.close();
                System.out.println("File created " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeFile(String deez) { //takes the formatted book details and writes them into the file currently held in textName
        try {
            FileWriter myWriter = new FileWriter(textName, true);
            myWriter.write(deez);
            myWriter.close();
            System.out.println("Successfully wrote to the file " + textName);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public static void mainMenu() { //  main menu
        String userChoice = getInput("do you want to add a book, close the program or delete a book?\nType 'add' to add a book ,'end' to end the program and 'delete' to delete a book, 'view' to view all books : ");
        switch(userChoice.toLowerCase(Locale.ROOT)){
            case "end":
                run = false;
                break;
            case "view":
                viewBooks();
                break;
            case "add":
                boolean y = true;
                while(y == true){//java is lying this is the only way it works dont change it
                String x = getInput("do you want to use the same text file or a different one, \ntype 'new' to use a different one and 'same' to use the same one");
                switch (x) {
                    case "same":
                        createFile(textName);
                        y = false;
                        break;
                    case "new":
                        String word = getInput("what is the name of the text file you want to enter?");
                        textName = (word + ".txt");
                        fileNamesStore(textName);
                        createNewFile(word);
                        y = false;
                        break;
                    default:
                        System.out.println("invalid");
                        break;
                }
                }
                String nuts = getBookDetails();
                writeFile(nuts);
                break;
        }
    }
    /*public static void logOn(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("details.txt"));
            String userName = getInput("enter username");
            String passWord = getInput("enter password");
            String line = br.readLine();
            System.out.println(line);
            line = br.readLine();
            br.close();
        }  catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }*/
}
