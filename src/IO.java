import java.io.*;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class IO {
    public static void main(String[] args) {
        String text = "Java world";
        String str ="";

        File dir = new File("C:\\QA\\Test_folder");
            boolean createDir = dir.mkdir();

    if (createDir) {
        System.out.println("Directory was created");
    }
        File file1 = new File("C:\\QA\\Test_folder\\file_1.txt");
        File file2 = new File("C:\\QA\\Test_folder\\file_2.txt");

        boolean createdFile1 = false;
        boolean createdFile2 = false;
    try {
        createdFile1 = file1.createNewFile();
        createdFile2 = file2.createNewFile();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    if (createdFile1 & createdFile2) {
        System.out.println("Files 1 and 2 were created");
    }

        try(FileWriter writer = new FileWriter("C:\\QA\\Test_folder\\file_1.txt", false)) {
        writer.append(text);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }


        try {
            FileReader read = new FileReader("C:\\QA\\Test_folder\\file_1.txt");
            int text2;
            while ((text2 = read.read()) !=-1) {
            str +=(char) text2;
            } read.close();
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(FileWriter writer2 = new FileWriter("C:\\QA\\Test_folder\\file_2.txt", false)) {
            writer2.append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    file1.delete();
    file2.delete();

    boolean deleteDir = dir.delete();
        if (deleteDir) {
            System.out.println("Directory was deleted");
        }
        System.out.println();
        try(ObjectInputStream oos = new ObjectInputStream((new FileInputStream("cat.dat")))) {

                Cat c = (Cat) oos.readObject();
                System.out.println(c);

         } catch (IOException | ClassNotFoundException e) {
             throw new RuntimeException(e);
         }

//        try(ObjectOutputStream oos = new ObjectOutputStream((new FileOutputStream("cat.dat")))) {
//
//              Cat cat1 = new Cat("Bob", 5, 8.2);
//
//                 oos.writeObject(cat1);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
