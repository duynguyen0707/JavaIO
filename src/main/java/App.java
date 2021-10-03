import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String workdirPath = System.getProperty("user.dir");
        File dir = new File(workdirPath);
        listFileInDir(dir);
        System.out.println("====================================================");

        listDir(dir, "1");   //- >
    }
    public static void listDir(File dir, String path) {

        String filePath = "";

        if (path == "1") {
            filePath = "";
        } else  {
            filePath = path + "_";
        }

        if (dir.isDirectory()) {


            System.out.println(filePath + dir.getName());

            File[] list = dir.listFiles();
            for (File f : list) {

                listDir(f, filePath);
            }
        } else System.out.println(filePath +dir.getName());

    }
    public static void listFileInDir (File dir){

        File[] list = dir.listFiles();
        for (int i = 0; i < list.length; i++) {
//            System.out.println(list[i]);
            boolean res = list[i].isFile();
//            System.out.println(res);
            if (res) {
//                System.out.println("nhảy vô if is file");
                System.out.println(list[i].getPath());
            } else {
                listFileInDir(list[i]);
            }
        }
    }

}
