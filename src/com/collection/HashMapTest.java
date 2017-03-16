package com.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest
{
    public static void main(String[] args)
    {
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 1000000; i++)
        {
            map.put(i + "", "hello world");
        }
        long begin1 = System.currentTimeMillis();
        Iterator iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext())
        {
            Map.Entry entry = (Map.Entry) iterator1.next();
            Object key1 = entry.getKey();
            //Object val1 = entry.getValue();
        }
        long end1 = System.currentTimeMillis();
        System.out.println("map.entrySet方式变量花费的时间为:" + (end1 - begin1));
        long begin2 = System.currentTimeMillis();
        Iterator iterator2 = map.keySet().iterator();
        while (iterator2.hasNext())
        {
            Object key2 = iterator2.next();
         //   Object val2 = map.get(key2);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("map.keySet方式变量花费的时间为:" + (end2 - begin2));
    }
}
