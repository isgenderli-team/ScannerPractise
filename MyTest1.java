
package mytest1;

import java.util.*;
import java.io.*;
import java.nio.charset.Charset;

public class MyTest1 {

    public static void main(String[] args) throws Exception {
   askNameOfFile();


    }
    
    
    static void askNameOfFile() throws Exception{
        Scanner scanner = new Scanner(System.in);
        String filePath =null;
        File file = null;
        while(true){
        System.out.println("Please, enter a file name with the path!");
        filePath =   scanner.next();
        file = new File(filePath);
        if(file.exists()){        
        if(!file.isAbsolute()) {
        System.out.println("This directory does not contain a absolute pathname");
        scanner.nextLine();
        }
        if(!file.isFile()) {
        System.out.println("This directory does not contain a filepath");
        scanner.nextLine();
        }
        else{
        System.out.println("Everything is okay..Pls wait for a while..");
        displayFileContent(file);
        break;
        }
        }else{
        System.out.println("A directory could not be found");
        scanner.nextLine();
        }
        }   
        scanner.close();
    }
    
    static void displayFileContent(File file) throws Exception{
    File file2 = file;
    Scanner scanner = new Scanner(file2,Charset.forName("utf-8"));
    ArrayList<String> list = new ArrayList<>();
    while(scanner.hasNextLine()){
    Thread.sleep(400);
    list.add(scanner.nextLine());
    }
   Iterator<String> it = list.listIterator();
   while(it.hasNext()){
    System.out.println(it.next());
   }
   displayFileLine(list);
    }
    
    
    static void displayFileLine(ArrayList<String> lister){
    ArrayList<String> list =new  ArrayList<>(lister);
    String stopScan;
    int count = 5;
    int x;
    Scanner askForIndex = new Scanner(System.in);
    System.out.println();
    System.out.println("Please, enter a line number, if you would like special line to read");
    while(true){
        System.out.println("Line number or enter \"stop\" to exit or it is going to stop after "+count+" attempt"); 
        if(count==0) {
            System.out.println("Вы уже 5 раз поискали.Хватит вам!");
            break;
        }
        count--;
        if(askForIndex.hasNextInt()){
             x = askForIndex.nextInt();
             System.out.println("Строка "+x);
             System.out.println(list.get(x));
             askForIndex.nextLine();
        }else{
          if(askForIndex.hasNextLine()){
          stopScan = askForIndex.nextLine();
          if(stopScan.equals("stop")){
              System.out.println("You enter stop..");
              break;
          }else{
          if(askForIndex.hasNextLine()) askForIndex.nextLine();
          }
          }else break;
        }
        }
    
    
}
    
    
}
