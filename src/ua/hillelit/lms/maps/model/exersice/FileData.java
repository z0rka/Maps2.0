package ua.hillelit.lms.maps.model.exersice;

public class FileData {

  private final String fileName;
  private final int fileSize;
  private final String path;

  public FileData(String fileName, int fileSize, String path) {
    this.fileName = fileName;
    this.fileSize = fileSize;
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
