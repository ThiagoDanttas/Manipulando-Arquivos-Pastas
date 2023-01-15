import java.io.File;
import java.util.Scanner;

public class ManipularPasta {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        // Leitura de pastas
        File[] folders = path.listFiles(File::isDirectory);

        System.out.println("---- FOLDERS ----");
        assert folders != null;
        for(File folder: folders){
            System.out.println(folder);
        }

        // Leitura de arquivos
        File[] files = path.listFiles(File::isFile);

        System.out.println("---- FILES ----");
        assert files != null;
        for(File file: files){
            System.out.println(file);
        }

        // Cria uma pasta
        boolean success = new File(strPath + "\\subdir").mkdir();
        System.out.println("Directory created successfully: " + success);



        sc.close();

    }

}
