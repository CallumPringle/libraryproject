//currently malding, writing in the bookdetails to the file and using bad variable names
//added main menu and delete option as well as formatting text file a bit
//added the ability to make new files unfortunately and made an abomination of a logon
import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static String textName = "";
    public static boolean run = true;
    public static void main(String[] args) throws IOException {
        logOn();
        fileNamesRead();
        while(run == true){
            mainMenu();
        }
    }
    public static String getBookDetails(){
        final String delim = ",";
        String bookTitle = getInput("what is the title: ");
        String bookISBN = getInput("enter the ISBN: ");
        String bookAuthor = getInput("enter the Author: ");
        String bookGenre = getInput("enter the genre: ");
        bookDeets ccccccccc = new bookDeets(bookTitle, bookISBN, bookAuthor, bookGenre);
        return (bookTitle + delim + bookISBN + delim + bookAuthor + delim + bookGenre + "\n");
    }
    public static String getInput(String prompt){
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static void fileNamesStore(String among){
        try {
                FileWriter myWriter = new FileWriter("filenames.txt", false);
                myWriter.write(among);
                myWriter.close();

        }  catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void fileNamesRead(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("filenames.txt"));
            textName = br.readLine();
            br.close();
        }  catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void createNewFile(String sussy) {
        try {
            File myObj = new File(sussy + ".txt");
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter(sussy + ".txt", false);
                myWriter.write("Title, ISBN, Author, Genre:\n");
                myWriter.close();
                System.out.println("File created " + myObj.getName());
            }
        }  catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void createFile(String sussy) {
        try {
            File myObj = new File(sussy);
            if (myObj.createNewFile()) {
                FileWriter myWriter = new FileWriter(sussy, false);
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
            FileWriter myWriter = new FileWriter(textName, true);
            myWriter.write(deez);
            myWriter.close();
            System.out.println("Successfully wrote to the file" + textName);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void deleteFile() {
        File myObj = new File(textName);
        myObj.delete();
        System.out.println(textName + " has been deleted, bussy");
    }
    public static void mainMenu() throws IOException {
        String userChoice = getInput("do you want to add a book, close the program or delete the text file?\nType 'add' to add a book ,'end' to end the program and 'delete' to delete the file : ");
        switch(userChoice.toLowerCase(Locale.ROOT)){
            case "end":
                run = false;
                break;
            case "add":
                boolean y = true;
                while(y == true){
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
            case "delete":
                deleteFile();
                break;
        }
    }
    public static void logOn(){
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
    }
}
