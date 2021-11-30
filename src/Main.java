//currently malding, writing in the bookdetails to the file and using bad variable names
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final String delim = ",";
    public static void main(String[] args) {
        String nuts = getBookDetails();
        writeFile(nuts);
    }
    public static String getBookDetails(){
        String bookTitle = getInput("what is the title");
        String bookISBN = getInput("enter the ISBN");
        String bookAuthor = getInput("enter the Author");
        String bookGenre = getInput("enter the genre");
        return (bookTitle + delim + bookISBN + delim + bookAuthor + delim + bookGenre);
    }
    public static String getInput(String prompt){
        System.out.println(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static void createFile() throws IOException {
        try {
            File myObj = new File("bookstoragefileඞ.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created " + myObj.getName());
            } else {
                System.out.println("file already exists nerd ඞඞඞඞ");
            }
        }  catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void writeFile(String deez){
        try {
            FileWriter myWriter = new FileWriter("bookstoragefileඞ.txt");
            myWriter.write(deez);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
