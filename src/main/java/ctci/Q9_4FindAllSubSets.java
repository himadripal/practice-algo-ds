package ctci;

import java.util.*;

/**
 * Created by 371865 on 3/21/2017.
 */
public class Q9_4FindAllSubSets {

    public static void main(String[] args){
        int[] arr = {100,10,50,70,20,90};
        System.out.println(selectTopMUsingQuickSelect(arr,4));

        quickSort(arr,0,arr.length-1);
        System.out.println();
        for(int i=0; i <= arr.length-1; i++){
            System.out.print(arr[i]+",");
        }

        System.out.println("hima".substring(0,0));
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 1; i < 4; i++) {
            list.add(random.nextInt(10));
        }
        System.out.println(list);
        ArrayList<ArrayList<Integer>> subsets = formAllSubsets(list,0);
        System.out.println(subsets.toString());
        System.out.println();
        System.out.println("-------------------");
        HashMap<Character,Integer> map = new HashMap<>();
        String s = "ABC";
        for(int i=0; i < s.length(); i++){
            map.put(s.charAt(i),i);
        }
        ArrayList<String> strings = getAllPermutations(s);
        System.out.println(strings.size());
        for(String s1 :strings ){
            System.out.print("["+s1+"] ");
        }
        System.out.println();
        System.out.println(longestPalindromicSubS("bac"));
    }
    private static ArrayList<ArrayList<Integer>> formAllSubsets(ArrayList<Integer> set, int i){
        ArrayList<ArrayList<Integer>> result = null;
            if(set.size()==i){
                result = new ArrayList<>();
                result.add(new ArrayList<>());
            }else{
                result = formAllSubsets(set,i+1);
                ArrayList<ArrayList<Integer>> resultByAddingElem = new ArrayList<>();
                int elem = set.get(i);
                for(ArrayList<Integer> previousSubSet : result){
                    ArrayList<Integer> subsetByAddingElem = new ArrayList<>();
                    subsetByAddingElem.addAll(previousSubSet);
                    subsetByAddingElem.add(elem);
                    resultByAddingElem.add(subsetByAddingElem);
                }
                result.addAll(resultByAddingElem);
            }
            return result;
    }



    private static ArrayList<String> getAllPermutations(String s){

        if(s==null) return null;
        ArrayList<String> permutations = new ArrayList<>();
        if(s.length()==0){
            permutations.add("");
            return permutations;
        }else{
            char c = s.charAt(0);
            String remaining = s.substring(1);
            ArrayList<String> words = getAllPermutations(remaining);
            for(String word : words){
                for(int i=0; i<= word.length(); i++){
                    permutations.add(word.substring(0,i)+c+word.substring(i));
             }
            }
            //permutations.addAll(words);
        }
        return permutations;
    }

    private static String longestPalindromicSubS(String str){
        int n = str.length();
       // List<String> palindromeStr = new LinkedList<>();
        int maxLength=0;
        boolean[][] table = new boolean[n][n];
        //for all palindrom starting i to j will have table[i][j]=true
        //single chars are palindrome
        for(int i=0; i < n ; i++){
            table[i][i]=true;
            maxLength=1;
        }
        //double repeating chars are palidrome
        int startIdx=0;
        for(int i=0; i < n-1 ; i++){
            if(str.charAt(i)==str.charAt(i+1)){
                maxLength=2;
                startIdx=i;
            }
        }
        //for all length > 2 till n
        for(int len=3; len <=n;len++){
            for(int i=0; i<n-len+1;i++){
                int j=i+len-1;
                if(table[i+1][j-1] && str.charAt(i)==str.charAt(j)){
                    table[i][j]=true;
                    if(len > maxLength) {
                        startIdx = i;
                        maxLength = len;
                    }
                }
            }
        }
        String result = str.substring(startIdx,startIdx+maxLength);
        return result;
    }

    private static int selectTopMUsingQuickSelect(int[] arr,int k){
        int lo=0,hi=arr.length-1;

        while(lo<=hi){
            int j = partition(arr,lo,hi);
            if(j==k) break;
            if(j < k){
                lo=j+1;
            }else{
                hi=j-1;
            }
        }
        return arr[k-1];
    }
    private static int partition(int[] arr,int lo, int hi){
        int i=lo;
        int j=hi+1;
        int pivot = arr[lo];
        while(i <= j){
            while( arr[++i] > pivot){
                if(i == arr.length-1){
                    break;
                }
            }
            while (arr[--j] < pivot){
                if(j == 0){
                    break;
                }
            }
            if(i >= j) break;
            swap(arr,i,j);
        }
        swap(arr,lo,j);
        return j;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;
    }

    private static void quickSort(int[] arr,int lo,int hi){
        if(lo >=hi) return;
        int j = partition(arr,lo,hi);
        quickSort(arr,lo,j-1);
        quickSort(arr,j+1,hi);
    }
}
