package also.slns;

import coursera.excer.MaxPriorityQueue;

import java.util.*;

/**
 * Created by hpal on 3/18/2017.
 */
public class RearrangeCharacterNoRepeat {
    //aaadcbbe
    //aa
    //aaabcccd
    public static void main(String[] args){
        String s="aaaaabcde";
        String reS = reArrange(s,s.length());
        System.out.println(reS);
        System.out.println(Math.round(7/2));
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }

   private static MaxPriorityQueue<Item> countChars(char[] chars){
       Map<Character,Integer> charCount = new HashMap<>();

       //int[] charCount = new int[26];
       for(int i=0; i < chars.length; i++){
           if(charCount.containsKey(chars[i])){
               charCount.put(chars[i],charCount.get(chars[i])+1);
           }else{
               charCount.put(chars[i],1);
           }
       }
       MaxPriorityQueue<Item> queue = new MaxPriorityQueue<>(charCount.size());
       for(char c: charCount.keySet()){
           queue.insert(new Item(c,charCount.get(c)));
       }
       //Arrays.sort(charCount);
       return queue;
   }
   private static class Item implements Comparable<Item>{
       char c;
       int count;
       public Item(char c,int count){
        this.c =c;
        this.count = count;
       }
       @Override
       public int compareTo(Item o) {
           if(this.count > o.count) return 1;
           else if(this.count < o.count) return -1;
           else return 0;
       }
   }
   private static String reArrange(String s, int len){
       char[] chars = s.toCharArray();
        MaxPriorityQueue<Item> queue = countChars(chars);
       int possiblePosition = (len%2==0)?len/2:len+1/2;
       if(queue.peek().count > possiblePosition) return "Not Possible";
      // char[] charsRe = new char[len];
       int lastOdd=1;
       int lastEven=0;
      int i=0;
      while(queue.size() > 0){
           Item item = queue.delMax();
           char c = item.c;
           int count = item.count;
           while(count>0){
               if(i%2==0) {
                   if(lastEven < len) {
                       chars[lastEven] = c;
                       lastEven += 2;
                   }else {
                       chars[lastOdd] = c;
                       lastOdd+=2;
                   }
                   count--;
               }else{
                   if(lastOdd < len) {
                       chars[lastOdd] = c;
                       lastOdd += 2;
                   }else{
                       chars[lastEven] = c;
                       lastEven += 2;
                   }
                   count--;
               }
           }
          i++;
      }

       return String.valueOf(chars);
   }
}
