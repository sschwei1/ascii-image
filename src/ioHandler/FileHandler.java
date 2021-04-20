package ioHandler;

import AsciiImage.AsciiImage;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileHandler {
    private static final String INPUT_FILE_CONDITION = ".i";
    private static final String OUTPUT_FILE_CONDITION = ".o";

    private FileHandler(){}

    public static String[] GetLines(File file){
        return FileHandler.GetLines(file.getPath());
    }

    public static String[] GetLines(String path){
        String[] content = null;

        try (Stream<String> lines = Files.lines(Paths.get(path),Charset.defaultCharset())) {
            content = lines.toArray(String[]::new);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return content;
    }

    public static File[] GetInputFiles(String path){
        File folder = new File(path);
        File[] subFiles = folder.listFiles();

        if(subFiles == null){
            return new File[]{};
        }

        return Arrays.stream(subFiles)
                .filter(e -> e.getName().contains(INPUT_FILE_CONDITION))
                .toArray(File[]::new);
    }
}