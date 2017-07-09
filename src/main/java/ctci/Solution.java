package ctci;
import edu.princeton.cs.algs4.In;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Given N integers, count the total pairs of integers that have a difference of
 * K.
 *
 * Input Format 1st line contains N & K (integers). 2nd line contains N numbers
 * of the set. All the N numbers are assured to be distinct.
 *
 * Output Format One integer saying the number of pairs of numbers that have a
 * diff K.
 *
 * Constraints: N <= 10^5 0 < K < 10^9 Each integer will be greater than 0 and
 * at least K away from 2^31-1
 *
 * Sample Input #00:
 *
 * 5 2 1 5 3 4 2 Sample Output #00:
 *
 * 3 Sample Input #01:
 *
 * 10 1 363374326 364147530 61825163 1073065718 1281246024 1399469912 428047635
 * 491595254 879792181 1069262793 Sample Output #01: 0
 *
 * Link: https://www.hackerrank.com/challenges/pairs
 *
 *
 */
public class Solution {

    /**
     * Function which creates a an integer array from string consisting of
     * integers separated by spaces. Throws a {@link IllegalArgumentException}
     * if the number of integers present in the string is not equal to the size
     * expected
     *
     * @param elements
     *            : String containing integers separated by a space
     * @param size
     *            : the expected number of integers in the string supplied
     * @return : an int array which contains size number of integers
     */
    private static int[] getElements(String elements, int size) {

        String[] elementsArray = elements.trim().split(" ");

        if (elementsArray.length != size)
            throw new IllegalArgumentException("Number of elements in the list does not match the size provided");

        int[] numbers = new int[size];
        int index = 0;

        // extract integers
        for (String ele : elementsArray) {
            numbers[index++] = Integer.parseInt(ele);
        }
        return numbers;
    }

    /**
     * Function to print the number of pairs of elements in a non-decreasing
     * array which have k difference in their value
     *
     * @param array
     *            : a non-decreasign array
     * @param arraySize
     *            : size of the array
     * @param k
     *            : the difference
     * @return : total numbers of pairs which have k difference between them
     */
    private static int countAtKDiff(int[] array, int arraySize, int k) {

        int count = 0; // initialize the counter

        for (int i = 0, j = 1; i < arraySize && j < arraySize;) {
            if (array[j] - array[i] == k) { // found a pair
                count++;
                i++;
                j++;
            } else if (array[j] - array[i] < k) { // difference is less than wanted so increment right pointer
                j++;
            } else { // difference is more than wanted so increment the left pointer
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s ="Himadri\n";
        System.out.println(s);
        System.out.println(s.trim());
        System.out.println((Integer)1==(Integer)1);
        System.out.println((Integer)128==(Integer)128);

       /* BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] line1 = input.readLine().trim().split(" ");
            int listSize = Integer.parseInt(line1[0]);
            int k = Integer.parseInt(line1[1]);
            int[] list = getElements(input.readLine(), listSize);

            // sort this  array
            Arrays.sort(list);

            // print the count of pairs which are at k distance
            System.out.println(countAtKDiff(list, listSize, k));

            input.close();
        } catch (NumberFormatException e) {
            System.err.println("Caught NumberFormatException: Error in coverting to interger");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Caught IOException: Error in reading input from stdin");
            e.printStackTrace();
        }*/

        System.out.println("C".substring(1));
       Integer[] arr = new Integer[]{1,2,3};
               //{46158044, 9306314, 51157916, 93803496, 20512678, 55668109, 488932, 24018019, 91386538, 68676911, 92581441, 66802896, 10401330, 57053542, 42836847, 24523157, 50084224, 16223673, 18392448, 61771874, 75040277, 30393366, 1248593, 71015899, 20545868, 75781058, 2819173, 37183571, 94307760, 88949450, 9352766, 26990547, 4035684, 57106547, 62393125, 74101466, 87693129, 84620455, 98589753, 8374427, 59030017, 69501866, 47507712, 84139250, 97401195, 32307123, 41600232, 52669409, 61249959, 88263327, 3194185, 10842291, 37741683, 14638221, 61808847, 86673222, 12380549, 39609235, 98726824, 81436765, 48701855, 42166094, 88595721, 11566537, 63715832, 21604701, 83321269, 34496410, 48653819, 77422556, 51748960, 83040347, 12893783, 57429375, 13500426, 49447417, 50826659, 22709813, 33096541, 55283208, 31924546, 54079534, 38900717, 94495657, 6472104, 47947703, 50659890, 33719501, 57117161, 20478224, 77975153, 52822862, 13155282, 6481416, 67356400, 36491447, 4084060, 5884644, 91621319, 43488994, 71554661, 41611278, 28547265, 26692589, 82826028, 72214268, 98604736, 60193708, 95417547, 73177938, 50713342, 6283439, 79043764, 52027740, 17648022, 33730552, 42851318, 13232185, 95479426, 70580777, 24710823, 48306195, 31248704, 24224431, 99173104, 31216940, 66551773, 94516629, 67345352, 62715266, 8776225, 18603704, 7611906};

               //{83564666, 2976674, 46591497, 24720696, 16376995, 63209921, 25486800, 49369261, 20465079, 64068560, 7453256, 14180682, 65396173, 45808477, 10172062, 28790225, 82942061, 88180229, 62446590, 77573854, 79342753, 2472968, 74250054, 17223599, 47790265, 24757250, 40512339, 24505824, 30067250, 82972321, 32482714, 76111054, 74399050, 65518880, 94248755, 76948016, 76621901, 46454881, 40376566, 13867770, 76060951, 71404732, 21608002, 26893621, 27370182, 35088766, 64827587, 67610608, 90182899, 66469061, 67277958, 92926221, 58156218, 44648845, 37817595, 46518269, 44972058, 27607545, 99404748, 39262620, 98825772, 89950732, 69937719, 78068362, 78924300, 91679939, 52530444, 71773429, 57678430, 75699274, 5835797, 74160501, 51193131, 47950620, 4572042, 85251576, 49493188, 77502342, 3244395, 51211050, 44229120, 2135351, 47258209, 77312779, 37416880, 59038338, 96069936, 20766025, 35497532, 67316276, 38312269, 38357645, 41600875, 58590177, 99257528, 99136750, 4796996, 84369137, 54237155, 64368327, 94789440, 40718847, 12226041, 80504660, 8177227, 85151842, 36165763, 72764013, 36326808, 80969323, 22947547, 76322099, 7536094, 18346503, 65759149, 45879388, 53114170, 92521723, 15492250, 42479923, 20668783, 64053151, 68778592, 3669297, 73903133, 28973293, 73195487, 64588362, 62227726, 17909010, 70683505, 86982984, 64191987, 71505285, 45949516, 28244755, 33863602, 18256044, 25110337, 23997763, 81020611, 10135495, 925679, 98158797, 73400633, 27282156, 45863518, 49288993, 52471826, 30553639, 76174500, 28828417, 41628693, 80019078, 64260962, 5577578, 50920883, 16864714, 54950300, 9267396, 56454292, 40872286, 33819401, 75369837, 6552946, 26963596, 22368984, 43723768, 39227673, 98188566, 1054037, 28292455, 18763814, 72776850, 47192134, 58393410, 14487674, 4852891, 44100801, 9755253, 37231060, 42836447, 38104756, 77865902, 67635663, 43494238, 76484257, 80555820, 8632145, 3925993, 81317956, 12645616, 23438120, 48241610, 20578077, 75133501, 46214776, 35621790, 15258257, 20145132, 32680983, 94521866, 43456056, 19341117, 29693292, 38935734, 62721977, 31340268, 91841822, 22303667, 96935307, 29160182, 61869130, 33436979, 32438444, 87945655, 43629909, 88918708, 85650550, 4201421, 11958347, 74203607, 37964292, 56174257, 20894491, 33858970, 45292153, 22249182, 77695201, 34240048, 36320401, 64890030, 81514017, 58983774, 88785054, 93832841, 12338671, 46297822, 26489779, 85959340};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(plusOne(list).toString());
        System.out.println(permutations("abc"));
    }


    public static int maximumGap(final List<Integer> a) {
        int maxDist = -1;
        int currDist = -1;
        if(a.size() <= 1) return 0;
        for(int i=0; i < a.size(); i++){
            int num1 = a.get(i);
            int j=a.size()-1;
            while(j>i &&  a.get(j)<num1){
                j--;
            }
            currDist = j-i;
            maxDist = Math.max(currDist,maxDist);
            //i=j-1;

        }
        return maxDist;
    }

    //[9,4,5,2,3,7,9]
    //[1,10]
    public static int maximumGap2(final List<Integer> a) {
        int maxDist = -1;
        int currDist = -1;
        if(a.size() <= 1) return 0;
        if(a.get(0)<=a.get(a.size()-1)) return a.size()-1;
        int i=0,j=a.size()-1;
        while(i<j){
            int num1 = a.get(i);
            int num2=a.get(j);
            if(num1>num2) {
                i++;
            }else{
                currDist = j-i;
                maxDist = Math.max(currDist,maxDist);
            }
        }
        return maxDist;
    }

    public static int maximumGap3(final List<Integer> a) {
        if (a.size() <= 1) return 0;
        int maxDist = -1;
        Integer[] leftMin = new Integer[a.size()];
        Integer[] rightMax = new Integer[a.size()];
        leftMin[0] = a.get(0);
        rightMax[a.size() - 1] = a.get(a.size() - 1);

        for (int i = 1, j = a.size() - 2; (i < a.size() && j >= 0); i++, j--) {

            leftMin[i] = Math.min(a.get(i), leftMin[i - 1]);
            rightMax[j] = Math.max(a.get(j), rightMax[j + 1]);

        }
        int k = 0, l = 0;
        while (k < a.size() && l < a.size()) {
            if (leftMin[k] <= rightMax[l]) {
                maxDist = Math.max(maxDist, (l - k));
                l++;
            } else {
                k++;
            }
        }

        return maxDist;
    }

    public static ArrayList<Integer> plusOne(List<Integer> a) {
        int sum=0;
        int counter=1;
        ArrayList<Integer> outputList = new ArrayList();
        sum = a.get(a.size()-1);
        int multiply=1;
        for(int i=a.size()-2; i >= 0; i--){
            sum = sum + ((multiply*10)*a.get(i));
            multiply=multiply*10;
        }
        sum++;
        //System.out.println(sum);
        String output = String.valueOf(sum);
        if(output.length()==1){
            outputList.add(sum);
            return outputList;
        }
        //Collections.reverse();

        Set<Integer> set = new TreeSet<>();
        //Set<Integer> set2 = new

        //System.out.println(output);
        /*for(int i=output.length(); i > 0; i--){
            int pow = (int) Math.pow(10,i);
            int num = sum/pow;

            outputList.add(num);
            sum=sum-pow;
        }*/

        for(int i=0; i < output.length(); i++){
            int num = Integer.valueOf(output.charAt(i)+"");
            outputList.add(num);
        }
        return outputList;
    }

    private static ArrayList<String> permutations(String str){
        if(str==null) return null;
        ArrayList<String> permutations = new ArrayList<>();
        if(str.length()==0){
            permutations.add("");
            return permutations;
        }
        char c = str.charAt(0);//a,//b,//c
        ArrayList<String> outputs = permutations(str.substring(1));
        for(String output : outputs) {
            for (int i = 0; i <= output.length(); i++) {
                String firstPart = output.substring(0,i);
                String endPart = output.substring(i);
                permutations.add(firstPart+c+endPart);

            }
        }
        return permutations;
    }

    private static void firstOccuranceOfNonRepeatingChar(String s){
        Map<Character,Integer> charMap = new TreeMap<>();
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            Integer count = charMap.get(c);
            if(count==null){
                charMap.put(c,i);
            }else{
                charMap.put(c,i);
            }
        }

        for(Character c : charMap.keySet()){
            if(charMap.get(c)>1){
                System.out.println("All are repeated");
            }
        }

        System.out.println();

    }
}