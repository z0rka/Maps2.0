package ua.hillelit.lms.maps;

import java.util.List;
import ua.hillelit.lms.maps.model.exersice.FileData;
import ua.hillelit.lms.maps.model.exersice.FileNavigator;

public class Main {

  public static void main(String[] args) {

    FileNavigator fileNavigator = new FileNavigator();

    fileNavigator.add("my/project", new FileData("test0.txt", 20, "my/project"));
    fileNavigator.add("my/project", new FileData("test1.txt", 10, "my/project"));
    fileNavigator.add("my/project", new FileData("test2.txt", 30, "my/project"));
    fileNavigator.add("my/project", new FileData("test3.txt", 50, "my/project"));
    fileNavigator.add("my/project", new FileData("test4.txt", 60, "my/project"));

    //Тест на помилку передачі по неправильному шляху
    fileNavigator.add("my/project2", new FileData("test0.txt", 90, "my/project"));

    fileNavigator.add("my/project2", new FileData("test1.txt", 10, "my/project2"));
    fileNavigator.add("my/project2", new FileData("test2.txt", 50, "my/project2"));
    fileNavigator.add("my/project2", new FileData("test3.txt", 60, "my/project2"));
    fileNavigator.add("my/project2", new FileData("test4.txt", 70, "my/project2"));

    List<FileData> fileData = fileNavigator.filterBySize(10);
    List<FileData> fileData1 = fileNavigator.sortBySize();
    List<FileData> fileData2 = fileNavigator.find("my/project");

    System.out.println("Filter by Size method");
    printList(fileData);
    System.out.println("-".repeat(20));

    System.out.println("Sort by Size method");
    printList(fileData1);
    System.out.println("-".repeat(20));

    System.out.println("Find method");
    printList(fileData2);
    System.out.println("-".repeat(20));

    fileNavigator.remove(null);

  }

  private static void printList(List<FileData> fileData) {
    for (FileData fileDatum : fileData) {
      System.out.println(
          fileDatum.getPath() + " " + fileDatum.getFileName() + " " + fileDatum.getFileSize());
    }
  }

}


