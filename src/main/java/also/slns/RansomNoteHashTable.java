package also.slns;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 371865 on 12/15/2016.
 */
public class RansomNoteHashTable {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public RansomNoteHashTable(String magazine, String note) {
        magazineMap= new HashMap<String,Integer>();
        noteMap= new HashMap<String,Integer>();
        if(magazine != null || !magazine.equals("")){
            for(String word : magazine.split(" ")){
                Integer count = magazineMap.get(word);
                if(count == null){
                    count=1;
                }else{
                    count++;
                }
                magazineMap.put(word,count);
            }
        }
        if(note != null || !note.equals("")){
            for(String word : note.split(" ")){
                Integer count = noteMap.get(word);
                if(count == null){
                    count=1;
                }else{
                    count++;
                }
                noteMap.put(word,count);
            }
        }
    }

    public boolean solve() {
        boolean returnValue=true;
        for(String noteKey : noteMap.keySet()){
            if(magazineMap.get(noteKey) < noteMap.get(noteKey)){
                returnValue=false;
                break;
            }
        }
        return returnValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        RansomNoteHashTable s = new RansomNoteHashTable(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
