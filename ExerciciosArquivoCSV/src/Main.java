import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.println("Enter file path: ");
        String sourceFileStr = sc.nextLine();

        File sourceFile = new File(sourceFileStr);
        String sourceFoldesStr = sourceFile.getParent();

        Boolean success = new File(sourceFoldesStr + "\\out").mkdir();

        String targetFileStr = sourceFoldesStr + "\\out\\summary.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){

            String line = br.readLine();
            while(line != null){

                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1]), Integer.parseInt(fields[2])));
                line = br.readLine();
            }

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){

                for(Product item: list){
                    bw.write(item.getName() + ";" + String.format("%.2f", item.total()));
                    bw.newLine();
                }

            } catch (IOException e){
                System.out.println("Error writing file: " + e.getMessage());
            }

        } catch (IOException e){
            System.out.println("Error writing file: " + e.getMessage());
        }

        sc.close();

    }
}