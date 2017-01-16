package org.academiadecodigo.MapEditor;

import java.io.*;
import java.util.Scanner;

/**
 * Created by tomasamaro on 25/10/16.
 */
public class FileManager {


    public char[] readFile(String inputFile) throws IOException {

        BufferedReader fileReader = null;
        char[] charArray = null;

        fileReader = new BufferedReader(new FileReader(inputFile));

        String line;
        String lineToArray = "";
        while ((line = fileReader.readLine()) != null) {

            lineToArray = lineToArray + line + "\n";

        }

        fileReader.close();
        return lineToArray.toCharArray();


    }

    public void writeFile(char[] contentToRead, String path) throws IOException {

        try (FileWriter outputFile = new FileWriter(path)) {


            outputFile.write(contentToRead);


            outputFile.close();
        }

    }

}
