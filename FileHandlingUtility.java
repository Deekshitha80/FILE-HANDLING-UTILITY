import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            File file = new File("sample.txt");

            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }

            FileWriter writer = new FileWriter(file);

            System.out.println("Enter text:");
            String text = sc.nextLine();

            writer.write(text);
            writer.close();

            System.out.println("Data written successfully.");

            System.out.println("\nReading file:");

            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }

            reader.close();

            FileWriter appendWriter = new FileWriter(file, true);

            System.out.println("\nEnter text to append:");
            String appendText = sc.nextLine();

            appendWriter.write("\n" + appendText);
            appendWriter.close();

            System.out.println("Data appended successfully.");

            System.out.println("\nUpdated File Content:");

            Scanner updatedReader = new Scanner(file);

            while (updatedReader.hasNextLine()) {
                System.out.println(updatedReader.nextLine());
            }

            updatedReader.close();

        } catch (IOException e) {
            System.out.println("Error occurred.");
        }

        sc.close();
    }
}
