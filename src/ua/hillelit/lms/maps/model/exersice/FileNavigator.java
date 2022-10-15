package ua.hillelit.lms.maps.model.exersice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import ua.hillelit.lms.maps.exeptions.WrongPathExeption;

public class FileNavigator {

  private final Map<String, FilesList> navigator = new HashMap<>();

  private void addValueFromMap(List<FileData> filesList, List<FileData> filesListToReturn,
      int size) {

    filesList.forEach(fileData1 -> {
      if (fileData1.getFileSize() == size) {
        filesListToReturn.add(fileData1);
      }
    });
  }

  private boolean adder(String path, FileData file) throws WrongPathExeption {
    if (!path.equals(file.getPath())) {
      throw new WrongPathExeption("ERROR :File path: " + path + " ,and path you entered: "
          + file.getPath() + " ,are not the same!!");
    }

    if (navigator.containsKey(path)) {
      navigator.get(path).add(file);
      return true;
    }

    navigator.put(file.getPath(), new FilesList(file));
    return true;
  }

  public FileNavigator() {
  }

  public boolean add(String path, FileData file) {

    if (path == null || file == null) {
      System.out.println("Don`t test me with 'null' pls -_- ");
      return false;
    }

    try {
      return adder(path, file);
    } catch (WrongPathExeption e) {
      System.out.println(e.getMessage());
    }

    return false;
  }

  public List<FileData> find(String path) {
    if (path == null) {
      return null;
    }
    return navigator.get(path).getFiles();
  }

  public List<FileData> filterBySize(int size) {
    List<FilesList> filesLists = new ArrayList<>(navigator.values());
    List<FileData> fileData = new ArrayList<>();

    filesLists.forEach(fileList -> addValueFromMap(fileList.getFiles(), fileData, size));

    return fileData;
  }

  public List<FileData> sortBySize() {
    List<FilesList> values = new LinkedList<>(navigator.values());
    List<FileData> sortedFilesList = new LinkedList<>();

    values.forEach(fileList -> sortedFilesList.addAll(fileList.getFiles()));
    sortedFilesList.sort(Comparator.comparing(FileData::getFileSize));

    return sortedFilesList;
  }

  public FilesList remove(String path) {
    return navigator.remove(path);
  }
}
