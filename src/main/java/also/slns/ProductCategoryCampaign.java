package also.slns;

import java.util.*;

/**
 * Created by 371865 on 3/22/2017.
 */
public class ProductCategoryCampaign {
    public static void main(String[] args){
        /*  bob8472  books
            nikhil55 pets
            bob8472 movies
            keisha91 pets
            nikhil55 pets
            isa600  books
            isa600 pets
            zhang02 books
         */
        HashMap<String,String> inputMap = new HashMap<>();
        Scanner in = new Scanner(System.in);
        Set<String> nonIsoLatedCat = new TreeSet<>();
        Set<String> isolatedCat = new TreeSet<>();
        int count=0;
        for(int i=0; i< 8; i++){
           // String input = in.next();
           // String[] inputArr = input.split(" ");
            String user=in.next();
            String cat=in.next();
            String prevCat = inputMap.get(user);

            if(prevCat==null){
                 inputMap.put(user,cat);
            }else{
                if(!prevCat.equals(cat)){
                   inputMap.remove(user);
                }
            }

        }
        System.out.println("Isocated Cat - "+findIsoCatedCategoryCount(inputMap));
    }
    public static int findIsoCatedCategoryCount(HashMap<String,String> inputMap){
               HashMap<String,Integer> outputMap = new HashMap<>();
               int maxCount=0;
               for(String s : inputMap.values()){
                    int count = outputMap.get(s)==null?0:outputMap.get(s);
                    outputMap.put(s,count+1);
                   if(outputMap.get(s)> maxCount){
                       maxCount = outputMap.get(s);
                       System.out.println(s+"->"+maxCount);
                   }
               }
               return maxCount;
    }
}
