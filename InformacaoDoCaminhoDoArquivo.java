import java.io.File;
import java.util.Scanner;

public class InformacaoDoCaminhoDoArquivo {

    public static void main(String[] args){

        try(Scanner sc = new Scanner(System.in)){

            System.out.println("Enter a folder path: ");
            String strPath = sc.nextLine();

            File path = new File(strPath);

            System.out.println(path.getPath());
            System.out.println(path.getParent());

        }

    }

}
