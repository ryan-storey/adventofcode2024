package adventofcode2024.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IOUtils {
    public static List<String> readFileIntoList(String file) {
        Scanner s;
        try {
            s = new Scanner(new File(file));
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNext()){
                list.add(s.nextLine());
            }
            s.close();
            return list;   
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<List<String>> splitSeparatedList(List<String> list, String delimiter)
    {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        for (String line : list) {
            list1.add(line.split(delimiter)[0]);
            list2.add(line.split(delimiter)[1]);
        }
        return Arrays.asList(list1, list2);
    }
}