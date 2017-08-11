package cn.interheart.hr.service;

import cn.interheart.hr.hr.web.DeviceDto;
import cn.interheart.hr.hr.web.HrDataDto;
import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by think on 2017/5/31.
 */
public class HrDataCSVUtil {
    private static final Logger logger = LoggerFactory.getLogger(HrDataCSVUtil.class);
    public static List<DeviceDto> uploadDevice(InputStream file) throws Exception {
        CSVReader csvReader = new CSVReader(new InputStreamReader(file, Charset.forName("utf-8")));
        List<String[]> list = csvReader.readAll();
        list.remove(0);
        list.remove(0);
        List<DeviceDto> deviceList = new ArrayList<>();
        list.forEach(strings -> {
            String mac = strings[1]; //MAC
            String name = strings[2]; //姓名
            int age = Integer.valueOf(strings[3]);
            logger.debug("mac:"+mac+",name:"+name +",age: " + age);
            deviceList.add(new DeviceDto(mac, name,age));
        });
        return deviceList;
    }

    public static List<HrDataDto> uploadData(InputStream file) throws Exception{
        CSVReader csvReader = new CSVReader(new InputStreamReader(file, Charset.forName("utf-8")));
        List<HrDataDto> hrDataDtos = new ArrayList<>();
        Map<String,List<Integer>> dataMap = new HashMap<>();

        String[] names =   csvReader.readNext();
        String[] nameIndex = new String[names.length];//保存名称的顺序
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            name = name.contains(Character.toString('\uFEFF')) ? new StringBuffer(name).deleteCharAt(name.indexOf('\uFEFF')).toString() : name;
            dataMap.put(name,new ArrayList<>());
            nameIndex[i] = name;
        }
        //读取姓名
        List<String[]> datas = csvReader.readAll();
        for (String[] data : datas) {
            for (int i = 0; i < data.length; i++) {
                String name = nameIndex[i];
                dataMap.get(name).add(Integer.valueOf(data[i]));
            }
        }

        dataMap.forEach((s, bytes) -> {
            bytes.forEach(hr -> {
                HrDataDto data = new HrDataDto(hr,s);
                hrDataDtos.add(data);
            });
        });
        return hrDataDtos;
    }
}
