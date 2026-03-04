// staring hasing project 
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class openHash{

    private static class Entry{
        String key;
        String value;

        Entry(String k, String v){
            key = k;
            value = v;

        }
    }

    private Entry[]table;
    private int m;
    private int size =0;

    public openHash (int m){
        this.m = m;
        table = new Entry[m];
    }

    public int hash(String key){
        return Math.abs(key.hashCode())%m;
    }

    public boolean isFull(){
        return size ==m;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    public void insert (String key, String value){
        if(isFull()) return;

        int index = hash(key);
        while (table[index]!=null){
            if(table[index].key.equals(key)){
                table[index].value = value;
                return;;
            }index = (index +1) %m ;

        }table [index ]= new Entry(key,value);
        size++;
    }
     public String lookup (String key){
        int index = hash(key);
        int start = index ;

        while (table[index]!=null){
            if(table[index].key.equals(key)){
               return table[index].value;
            }index = (index +1) %m ;
            if (index == start)break;

        }return null;
    }
