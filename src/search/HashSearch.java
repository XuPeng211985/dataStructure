package search;

import java.util.Arrays;

/**
 * Created by hpx on 2018/3/9.
 */
public class HashSearch {
    public static void main(String[] args) {
        int[] hash = new int[10];
        int[] key = {7,8,30,11,18,9,14};
        for (int i = 0; i < 7; i++) {
            insertHash(hash,7,key[i]);
        }
        System.out.println(Arrays.toString(hash));
       searchHash(hash,7,32);
    }
    public static void insertHash(int[] hash,int hashLength ,int data){
        int hashAddress = (data * 3) % hashLength;
        while(hash[hashAddress] != 0){
            hashAddress = (hashAddress+1) % hash.length;
        }
        hash[hashAddress] = data;
    }
    public static void searchHash(int[] hash,int hashLength,int data){
        int hashAddress = (data * 3) % hashLength;
        while(hash[hashAddress] != 0 && hashAddress < hashLength){
            if(data == hash[hashAddress]){
                System.out.println("散列号为 ："+hashAddress);
                return ;
            }
            hashAddress = (hashAddress + 1) % hash.length;
        }
    }
}
