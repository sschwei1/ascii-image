import AsciiImage.AsciiImage;
import AsciiImage.ImageData;

import java.util.Date;

public class Main {
    public static final String Folder = "A01";

    public static void main(String[] args) {
        ImageData[] ex1 = AsciiImage.GetImageDataFromFolder("./files/A01/");

        for(ImageData imgData : ex1){
            imgData.Print();
        }
    }
}