//currently malding, writing in the bookdetails to the file and using bad variable names
//added main menu and delete option as well as formatting text file a bit
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static boolean run = true;
    public static final String delim = ",";
    public static void main(String[] args) throws IOException {
        while(run == true){
            mainMenu();
        }
    }
    public static String getBookDetails(){
        String bookTitle = getInput("what is the title: ");
        String bookISBN = getInput("enter the ISBN: ");
        String bookAuthor = getInput("enter the Author: ");
        String bookGenre = getInput("enter the genre: ");
        return (bookTitle + delim + bookISBN + delim + bookAuthor + delim + bookGenre + "\n");
    }
    public static String getInput(String prompt){
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static void createFile() {
        try {
            File myObj = new File("bookstoragefileඞ.txt");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter("bookstoragefileඞ.txt", false);
                myWriter.write("Title, ISBN, Author, Genre:\n");
                myWriter.close();
                System.out.println("File created " + myObj.getName());
            }
        }  catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void writeFile(String deez){
        try {
            FileWriter myWriter = new FileWriter("bookstoragefileඞ.txt", true);
            myWriter.write(deez);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void deleteFile() throws IOException {
        File myObj = new File("bookstoragefileඞ.txt");
        myObj.delete();
    }
    public static void mainMenu() throws IOException {
        String userChoice = getInput("do you want to add a book, close the program or delete the text file?\nType 'add' to add a book ,'end' to end the program and 'delete' to delete the file : ");
        switch(userChoice.toLowerCase(Locale.ROOT)){
            case "end":
                run = false;
                break;
            case "add":
                createFile();
                String nuts = getBookDetails();
                writeFile(nuts);
                break;
            case "delete":
                deleteFile();
                break;
        }
    }
}
