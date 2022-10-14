package ua.hillelit.lms.maps.model;

public class FileData {
  private String name;
  private int fileSize;
  private String pathToFile;

  public FileData(String name, int fileSize, String pathToFile) {
    this.name = name;
    this.fileSize = fileSize;
    this.pathToFile = pathToFile;
  }

  public String getName() {
    return name;
  }

  public int getFileSize() {
    return fileSize;
  }

  public String getPathToFile() {
    return pathToFile;
  }
}
