package ua.hillelit.lms.maps;


import ua.hillelit.lms.maps.model.FileData;
import ua.hillelit.lms.maps.model.FileNavigator;

public class Main{

  public static void main(String[] args) {

    FileNavigator fileNavigator = new FileNavigator();
    
    fileNavigator.add(new FileData("test.txt","my/project"));
    fileNavigator.add(new FileData("test1.txt","my/project"));
    fileNavigator.add(new FileData("test2.txt","my/project"));
    fileNavigator.add(new FileData("test3.txt","my/project"));
    fileNavigator.add(new FileData("test4.txt","my/project"));
    fileNavigator.add(new FileData("test5.txt","my/project"));
    fileNavigator.add(new FileData("test4.txt","my/project2"));
    fileNavigator.add(new FileData("test5.txt","my/project2"));
    fileNavigator.add(new FileData("test6.txt","my/project2"));
    fileNavigator.add(new FileData("test7.txt","my/project2"));

    fileNavigator.
  }

}