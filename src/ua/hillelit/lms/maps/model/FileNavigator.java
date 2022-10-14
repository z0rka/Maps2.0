package ua.hillelit.lms.maps.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class FileNavigator {

private Map<String,FileData> files = new HashMap();

  public FileNavigator() {}

  public void add(FileData file){
    files.put(file.getPathToFile() , file);
  }

  public List find(String path){
    List<FileData> filesWithExactPath = new ArrayList<>();
    Set<String> keys = files.keySet();

    for (String key : keys) {
      if(key == path){
        filesWithExactPath.add(files.get(key));
      }
    }

    return filesWithExactPath;
  }

  public List filterBySize(int fileSize){
    Collection<FileData> values = files.values();
    List<FileData> filesByBytes = new ArrayList<>();

    for (FileData value : values) {
      if(value.getFileSize() < fileSize){
        filesByBytes.add(value);
      }
    }

    return filesByBytes;
  }

  public void remove(String path){
    files.remove(path);
  }

  public List sortBySize(){
    Collection<FileData> values = files.values();
    List<FileData> sortedFiles= new LinkedList<>();

    for (FileData value : values) {
      sortedFiles.add(value);
    }

   sortedFiles.sort(Comparator.comparing(FileData::getFileSize));

    return sortedFiles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileNavigator that = (FileNavigator) o;
    return Objects.equals(files, that.files);
  }

  @Override
  public int hashCode() {
    return Objects.hash(files);
  }
}
