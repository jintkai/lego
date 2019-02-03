package com.jon.legoweb;

import com.legoapi.entity.HttpLog;
import com.legoapi.utils.HttpClientTool;
import org.testng.annotations.Test;

import java.util.*;

@Test
public class HttpClientToolsTest {

    HttpClientTool httpClientTool = new HttpClientTool();

    @Test
    public void testGet() {
        HttpLog resp = httpClientTool.getClient("www.baidu.com");
        System.out.println(resp.getCode());
    }

    public void testPostUrlEncoder() {
//        Resp resp = httpClientTool.postClient("http://localhost:11000/api/project/vague?key=1",1,'1');
        List<Map<String, String>> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "这个");
        list.add(map);
        HttpLog resp = httpClientTool.postClient("http://localhost:11000/api/project/vague", 1, list);
        System.out.println(resp.getCode());
    }

    public void testPostDataForm() {
        List<Map<String, String>> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "这个");
        list.add(map);
        HttpLog resp = httpClientTool.postClient("http://localhost:11000/api/project/vague", 2, list);
        System.out.println(resp.getCode());
    }

    public void test2() {
        int[] a = new int[]{1, 2, 6, 4, 5};
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.println(gregorianCalendar.getTime().toString());
        gregorianCalendar.add(Calendar.DAY_OF_MONTH,3);
        System.out.println(gregorianCalendar.getTime().toString());
        int[] b = Arrays.copyOf(a, 10);
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
    }

    public void test03(){
        List<String> l = new ArrayList<String>();
    }
}
