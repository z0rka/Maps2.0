package ua.hillelit.lms.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import ua.hillelit.lms.maps.model.FileData;
import ua.hillelit.lms.maps.model.FileNavigator;

public class Main {//Все таки на мапе

  public static void main(String[] args) {//Метод файнд , додаю 2 об'єкти, маю 1
    FileNavigator fileNavigator = new FileNavigator();

    fileNavigator.add(new FileData("text1.txt",10,"r"));
    fileNavigator.add(new FileData("text2.txt",1,"a"));
    fileNavigator.add(new FileData("text3.txt",100,"b"));
    fileNavigator.add(new FileData("text4.txt",1200,"c"));
    fileNavigator.add(new FileData("text5.txt",1300,"d"));
    fileNavigator.add(new FileData("text6.txt",5,"e"));
    fileNavigator.add(new FileData("tex.txt",3,"e"));
    fileNavigator.add(new FileData("text7.txt",1600,"t"));

    Map<String,String> test= new HashMap<>();

    test.put("a","s");
    test.put("a","s1");
    test.put("a","s2");
    test.put("a","s3");

    Collection<String> values = test.values();

    for (String value : values) {
      System.out.println(value);
    }
//    List<FileData> test= fileNavigator.sortBySize();
//
//    List<FileData> test2  = fileNavigator.find("e");
//    for (FileData fileData : test2) {
//      System.out.println(fileData.getName());
//    }
  }
}