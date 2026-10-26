package Ejercicio5;

import java.io.File;

public class Trabajo {
    private File sourcePath;
    private File destinationPath;
    private String language;

    public Trabajo(File sourcePath, File destinationPath, String language) {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
        this.language = language;
    }

    public File getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(File sourcePath) {
        this.sourcePath = sourcePath;
    }

    public File getDestinationPath() {
        return destinationPath;
    }

    public void setDestinationPath(File destinationPath) {
        this.destinationPath = destinationPath;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
