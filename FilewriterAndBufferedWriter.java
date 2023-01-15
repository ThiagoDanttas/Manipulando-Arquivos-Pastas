import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilewriterAndBufferedWriter {

    public static void main(String[] args) {

        String[] lines = {"Good Morning", "Good afternoon", "Good night"};
        String path = "C:\\OneDriveTemp\\out.csv";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){

            for(String line: lines){
                bw.write(line);
                bw.newLine();
            }

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}
