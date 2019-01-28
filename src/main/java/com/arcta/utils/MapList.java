package com.arcta.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapList<K extends Comparable<? super K>,T> implements Serializable{

    public Map<K, ArrayList<T>> mapList;

    public MapList(){
        this.mapList = new HashMap<>();
    }

    public Set<K> keys(){
        return this.mapList.keySet();
    }


    public void put(K key, T listElement){
        mapList.putIfAbsent(key, new ArrayList<>());
        mapList.get(key).add(listElement);
    }

    public void addAll(K key, Collection<T> elements){
        mapList.putIfAbsent(key, new ArrayList<>());
        mapList.get(key).addAll(elements);
    }

    public void merge(Map<K,T> map){
        for (K k : map.keySet()) {
            mapList.putIfAbsent(k, new ArrayList<T>());
            mapList.get(k).add(map.get(k));
        }
    }

    public void merge(K key, List<T> listElements){
        mapList.putIfAbsent(key, new ArrayList<>());
        mapList.get(key).addAll(listElements);
    }

    public List<T> get(K key) {
        return mapList.get(key);
    }

    public List<K> orderedKeys(){
        List<K> list = new ArrayList<>(this.mapList.keySet());
        Collections.sort(list);
        return list;
    }

    public void output(){
        for (K key : mapList.keySet()) {
            System.out.println(key);
            for (T element : mapList.get(key)) {
                System.out.println("\t" + element);
            }
        }
    }
}
