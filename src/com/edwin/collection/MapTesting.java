package com.edwin.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTesting {
    public static void main(String[] args) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("apple", "苹果");
        linkedHashMap.put("watermelon", "西瓜");
        linkedHashMap.put("banana", "香蕉");
        linkedHashMap.put("peach", "桃子");

        Iterator iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("");

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("apple", "苹果");
        hashMap.put("watermelon", "西瓜");
        hashMap.put("banana", "香蕉");
        hashMap.put("peach", "桃子");

        Iterator iter = hashMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
