package ua.hillelit.lms.maps.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FileNavigator {
  private final Map<String,FilesList> navigator = new HashMap<>();

  private List<FileData> filterBySize(List<FileData> filesList,int size){
    for (FileData fileData : filesList) {
      if(fileData.getFileSize() > size){
        filesList.remove(fileData);
      }
    }
    return filesList;
  }

  private List<FileData> sortBySize(List<FileData> files){
    files.sort(Comparator.comparing(FileData::getFileSize));
    return files;
  }
  public FileNavigator() {
  }


  public boolean add(FileData file){
    if(navigator.containsKey(file.getPath())){
      navigator.get(file.getPath()).add(file);
      return true;
    }
    navigator.put(file.getPath(),new FilesList(file));
    return true;
  }

  public List<FileData> find(String path){
    return navigator.get(path).getFiles();
  }

  public List<FileData> filterBySize(int size){
    Set<Entry<String, FilesList>> entrySet = navigator.entrySet();
    List<FileData> filesList = new LinkedList<>();
    for (Entry<String, FilesList> stringFilesListEntry : entrySet) {
      filesList.addAll(filterBySize(stringFilesListEntry.getValue().getFiles(),size));
    }
    return filesList;
  }

  public List<FileData> sortBySize(){
    Collection<FilesList> values = navigator.values();
    List<FileData> filesList = new LinkedList<>();

    for (FilesList value : values) {
      filesList.addAll(sortBySize(value.getFiles()));
    }
    return filesList;
  }
  public FilesList remove(String path){
    return navigator.remove(path);
  }
}
