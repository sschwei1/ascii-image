package AsciiImage;

import ioHandler.FileHandler;

import java.io.File;

public class AsciiImage {
    public AsciiImage(){

    }

    public static ImageData GetImageData(String path){
        return AsciiImage.GetImageData(FileHandler.GetLines(path));
    }

    public static ImageData GetImageData(File file){
        return AsciiImage.GetImageData(FileHandler.GetLines(file));
    }

    public static ImageData GetImageData(String[] lines){
        ImageData imgData = new ImageData();

        if(lines.length != 0){
            imgData.width = lines[0].length();
            imgData.height = lines.length;

            for(int i = 1; i < lines.length; i++){
                if (lines[i].length() != imgData.width) {
                    imgData.valid = false;
                    imgData.height = 0;
                    imgData.width = 0;
                    imgData.errorMessage = "INPUT MISMATCH";
                    break;
                }
            }
        }

        return imgData;
    }

    public static ImageData[] GetImageDataFromFolder(String folderPath){
        File[] files = FileHandler.GetInputFiles(folderPath);

        ImageData[] imgDataArr = new ImageData[files.length];

        for(int i = 0; i < files.length; i++){
            imgDataArr[i] = AsciiImage.GetImageData(files[i]);
        }

        return imgDataArr;
    }
}
