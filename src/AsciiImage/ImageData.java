package AsciiImage;

import ioHandler.FileHandler;
import ioHandler.IOHandler;

public class ImageData {
    int height;
    int width;

    boolean valid;
    String errorMessage;

    String[] image;

    public ImageData(){
        this.height = 0;
        this.width = 0;
        this.valid = true;
        this.errorMessage = null;
        this.image = null;
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
        IOHandler.Print(this.valid ? this.width + " " + this.height : this.errorMessage);
    }
}
