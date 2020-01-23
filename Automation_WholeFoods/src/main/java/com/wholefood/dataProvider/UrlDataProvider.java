package com.wholefood.dataProvider;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UrlDataProvider {
@Test
    public static String fileRead() throws IOException {

        String fileName = "src/main/java/com/wholefood/dataProvider/inputFile.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
         while((line =br.readLine())!=null)

        {
            //process the line
            return line;
        }
    return "";
}


}
