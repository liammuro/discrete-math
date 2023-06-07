import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws java.io.FileNotFoundException {
        System.out.println("Liam Muro 2023 Discrete Math Final Exam (Programming):\n");

        Scanner filenames = new Scanner(new File("triangle_files.txt"));

        while (filenames.hasNextLine()) {
            String tempFileName = filenames.nextLine();
            System.out.println("testing file: " + tempFileName);
            MaximumPathSum.main(new String[] {tempFileName});
        }

        filenames.close();
    }
}
