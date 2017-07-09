package also.slns;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 371865 on 4/12/2017.
 */
public class ZigZagString {
    public static void main(String[] args){
        System.out.println(convert("ABCD",3));
        System.out.println(reverse(-321));
    }
    public static String convert(String s, int numRows) {
        if(s==null ||s.length()==0) return s;
        if(s.length() <= numRows) return s;
        if(numRows <= 1) return s;
        int key=0;
        boolean downward = true;
        boolean upward = false;
        Map<Integer, StringBuilder> lines = new TreeMap();

        for(int i=0; i < s.length(); i++){
            if(downward){
                key++;
            }else if(upward){
                key--;
            }
            addToLineMap(s, key, lines, i);
            if(key==numRows){
                upward=true;
                downward=false;
            }else if(key==1){
                upward=false;
                downward=true;
            }
        }
        return String.join("",lines.values());
    }

    private static void addToLineMap(String s, int key, Map<Integer, StringBuilder> lines, int i) {
        char c = s.charAt(i);
        StringBuilder sbd = lines.get(key);
        if(sbd==null){
            sbd = new StringBuilder();
            lines.put(key,sbd.append(c));
        }else{
            lines.put(key,sbd.append(c));
        }
    }

    public static int reverse(int x) {
        boolean negative=false;
        if(x < 0){
            negative=true;
            x=x*(-1);
        }
        StringBuilder output= new StringBuilder();
        String s = x+"";
        for(int i=s.length()-1; i>=0; i--){
            output.append(s.charAt(i));
        }
        int r = 0;
        try{
            r = Integer.valueOf(output.toString());
        }catch(Exception e){
            return r;
        }
        if(r < 0){
            return 0;
        }
        if(negative) return r*(-1);
        return r;
    }
}
