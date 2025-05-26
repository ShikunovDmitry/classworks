package com.itacademy.aqa.proxy;

public interface File {
  void read();
}

//Real object
class ReadFile implements File{
  private String fileName;

  public ReadFile(String fileName){
    this.fileName = fileName;
    loadFile(); // Heavy operation with file system
  }

  private void  loadFile(){
    System.out.println("File loading");
  }

  @Override
  public void read() {
    System.out.println("Reading of file");
  }
}

class ProxyFile implements File{
  String fileName;
  ReadFile readFile;



  public ProxyFile(String fileName){
    this.fileName = fileName;
  }
  @Override
  public void read() {
    if(readFile == null){
      readFile = new ReadFile(fileName);
    }
    readFile.read();
  }

}
