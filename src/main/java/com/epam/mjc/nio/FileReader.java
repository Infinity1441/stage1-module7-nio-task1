package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileReader {

    public Profile getDataFromFile(File file) {
        List<String> datas = new ArrayList<>();
        String n;
        int i=0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            while ((n = Objects.requireNonNull(bufferedReader).readLine()) != null) {
                String[] split = n.split(" ");
                datas.add(i,split[1]);
                i++;
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return new Profile(datas.get(0),Integer.parseInt(datas.get(1)),datas.get(2),Long.parseLong(datas.get(3)));
    }
}
