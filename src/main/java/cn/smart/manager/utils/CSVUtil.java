package cn.smart.manager.utils;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created By victorrrr on 2017/8/14
 */
public class CSVUtil {

    public static void parseData(InputStream inputStream) {
        CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
        HashMap<String, List<String>> dataMap = new HashMap<>();
        String[] names = new String[0];
        try {
             names = csvReader.readNext();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] namesIndex = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            name = name.contains(Character.toString('\uFEFF')) ?
                    new StringBuffer(name).deleteCharAt(name.indexOf('\uFEFF')).toString() : name;
            dataMap.put(name, new ArrayList<>());
            namesIndex[i] = name;
        }
        List<String[]> dataList = null;
        try {
            dataList = csvReader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (String[] data : dataList) {
            for (int i = 0; i < data.length; i++) {
                String name = namesIndex[i];
                dataMap.get(name).add(data[i]);
            }
        }
        dataMap.forEach((str, strs) -> {
            strs.forEach(s -> {
                //todo
            });
        });
    }

}
