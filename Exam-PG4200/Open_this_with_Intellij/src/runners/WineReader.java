package runners;

import java.io.*;
import java.util.*;

public class WineReader {
    //Sets two files to read
    static String redFile = "src/resources/wine+quality/winequality-red.csv";
    static String whiteFile = "src/resources/wine+quality/winequality-white.csv";

    //Method that reads column 10 from both files
    public static List<Double> readFile(String filename) throws IOException {
        List<Double> tempList = new ArrayList<>();
        //Creates a reader to read the files, line by line
        BufferedReader br = new BufferedReader(new FileReader(filename));

        //Reads the first line so it can be ignored later
        String firstLine = br.readLine();

        //Sets the line variable
        String line;

        //Sets line from above and reads until the reader has empty lines
        while ((line = br.readLine()) != null) {
            //Splits lines content with ;
            String[] parts = line.split(";");
            //Grabs line nr. 10
            double alcohol = Double.parseDouble(parts[10]);
            tempList.add(alcohol);
        }

        //closes reader
        br.close();
        //returns the list with alcohol for loadAlcoholValues below
        return tempList;
    }

    //Reads file redFile, adds return from readFile to wineList. Does the same for whiteFile's return

    public static List<Double> loadAlcoholValues() throws IOException {
        List<Double> wineList = new ArrayList<>();

        //redList
        for (double value : readFile(redFile)) {
            wineList.add(value);
        }

        //whiteList
        for (double value : readFile(whiteFile)) {
            wineList.add(value);
        }

        return wineList;
    }
}