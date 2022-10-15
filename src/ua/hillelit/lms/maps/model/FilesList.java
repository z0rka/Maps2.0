package ua.hillelit.lms.maps.model;

import java.util.LinkedList;
import java.util.List;

public class FilesList {
  private final List<FileData> files = new LinkedList<>();

  public FilesList(FileData file) {
    this.add(file);
  }

  public void add(FileData file){
    files.add(file);
  }

  public List<FileData> getFiles() {
    return files;
  }
}
