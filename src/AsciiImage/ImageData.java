package AsciiImage;

import ioHandler.FileHandler;
import ioHandler.IOHandler;

public class ImageData {
    private static final String DEFAULT_PATH = "./files/file.i";

    int height;
    int width;

    boolean valid;
    String errorMessage;

    String[] image;
    String inputPath;

    public ImageData(){
        this.height = 0;
        this.width = 0;
        this.valid = true;
        this.errorMessage = null;
        this.image = null;
        this.inputPath = ImageData.DEFAULT_PATH;
    }

    public String[] GetImage(){
        return this.valid ? this.image : null;
    }

    public int[] GetImageSize(){
        return this.valid ? new int[]{this.height, this.width} : null;
    }

    public String GetError(){
        return this.valid ? null : this.errorMessage;
    }

    public void Print(){
        FileHandler.GenerateOutput(this.valid ? this.width + " " + this.height : this.errorMessage, this.inputPath);
    }

    public String GetInputPath(){
        return this.inputPath;
    }
}
