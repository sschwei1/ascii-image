package ioHandler;

import AsciiImage.*;

import java.io.File;
import java.io.FileWriter;
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

    public static void GenerateOutput(ImageData imgData){
        FileHandler.GenerateOutput(imgData.GetImage(), imgData.GetInputPath());
    }

    public static void GenerateOutput(String content, String inPath){
        FileHandler.GenerateOutput(new String[]{content}, inPath);
    }

    public static void GenerateOutput(String[] lines, String inPath){
        String content = String.join("\r\n", lines);
        String outPath = InToOutPath(inPath);

        File out = new File(outPath);

        try {
            out.createNewFile();
            FileWriter fw = new FileWriter(out);
            fw.write(content);
            fw.close();
        }
        catch(Exception ex){

        }
    }

    private static String InToOutPath(String inPath){
        char[] inPathChars = inPath.toCharArray();
        inPathChars[inPath.length() - 2] = 'c';

        return String.valueOf(inPathChars);
    }
}