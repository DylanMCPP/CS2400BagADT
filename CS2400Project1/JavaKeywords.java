//  Name:   Dylan, Michalak 
//  Homework: # 1
//  Due:      9/26/2022
//  Course:  cs-2400-01-f22 
// 
//  Description: 
//    A bag data structure implemented using a resizeable array! 
// 
import java.io.*;

public class JavaKeywords {
    public static void main(String[] args) throws IOException{
            BufferedReader fileInput = new BufferedReader(new FileReader("javakeywords.txt"));
            String line;

            BagInterface<String> testBag = new ArrayBag<>();
            while((line = fileInput.readLine()) != null) {
                testBag.add(line);
            }

            System.out.print("Java Keywords by D. Michalak\n");
            System.out.println(testBag.getCurrentSize() + " Java kewords loaded\n");
            

            for (String inp: args) {
                if (testBag.contains(inp)) {
                    System.out.println(inp + " is a keyword");
                } else {
                    System.out.println(inp + " is not a keyword");
                }
            }

            System.out.println("\nTesting .toArray(), .remove()");

            Object[] list = testBag.toArray();
            for (Object ind: list) {
                System.out.print(ind.toString() + ", ");
            }

            System.out.print("\n\nremoved: ");

            for (int i = 0; i < 5; i++) {
                System.out.print(testBag.remove() + ", ");
            }

            System.out.print("\n\nnew bag: ");

            Object[] list2 = testBag.toArray();
            for (Object ind: list2) {
                System.out.print(ind.toString() + ", ");
            }

            System.out.print("\n\nRemoving assert");

            testBag.remove("assert");
            System.out.print("\n\nnewer bag: ");
            Object[] list3 = testBag.toArray();
            for (Object ind: list3) {
                System.out.print(ind.toString() + ", ");
            }

            System.out.print("\n\nDone testing the bag!");
            fileInput.close();
    }
    
}
