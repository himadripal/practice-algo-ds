package also.slns;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 371865 on 3/7/2017.
 */
public class IsolatedCustomer {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Map<String,Integer> isoLatedCategory = new HashMap<>();
        while(in.hasNext()){
            //String line = in.nextLine();
            //String[] words = line.split(" ");
            String user = in.next();
            String category = in.next();
            Map<String,String> usersVsCategory = new HashMap<>();
            String retrivedCat = usersVsCategory.get(user);
            int numOfIsolated = isoLatedCategory.getOrDefault(category,0);
            if(retrivedCat==null){
                usersVsCategory.put(user,category);
                isoLatedCategory.put(category,numOfIsolated+1);
            }else{
                if(category.equals(retrivedCat)){
                    isoLatedCategory.put(category,numOfIsolated+1);
                }else{
                    isoLatedCategory.put(category,numOfIsolated-1);
                }
            }
        }
    }
}
