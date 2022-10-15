package ua.hillelit.lms.maps.model;

import java.util.Random;

public class FileData {
private final String fileName;
private final int fileSize;
private final String path;

  public FileData(String fileName, String path) {
    Random random = new Random();
    this.fileName = fileName;
    this.fileSize =random.nextInt(50);
    this.path = path;
  }

  public String getFileName() {
    return fileName;
  }

  public int getFileSize() {
    return fileSize;
  }

  public String getPath() {
    return path;
  }
}
