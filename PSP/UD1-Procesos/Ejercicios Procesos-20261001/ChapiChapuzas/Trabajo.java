package ChapiChapuzas;

import java.io.File;

public class Trabajo {
    
    File sourcePath, destinationPath;
    String language;

    Trabajo(File sourcePath, String language, File destinationPath){
        this.destinationPath = destinationPath;
        this.sourcePath = sourcePath;
        this.language = language;
    }

    public File getDestinationPath() {
        return destinationPath;
    }

    public String getLanguage() {
        return language;
    }

    public File getSourcePath() {
        return sourcePath;
    }
}
