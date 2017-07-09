package also.slns;

/**
 * Created by hpal(mehimu@gmail.com) on 3/13/2017.
 *
 *
 * * person can climb the stair 3 ways - 1 step, 2 step or 3 step at jump. how may different ways can he climb the stair?
 *
 * Solution -
 *  - with a 1 step jump person can reach to top from n-1
 *  - with a 2 step jump person can reach to top from n-2
 *  - with a 3 step jump person can reach to top from n-3
 *  total number of ways should be - noOfway to reach n-1 + noOfways to reach n-2 + noOfways to reach n-3
 *
 */
public class CountOfWaysDavidStairCase {

    public static void main(String[] args) {
       /* Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(waysDP(n,3));
        }*/
        //System.out.println(ways(5,3));
        System.out.println(waysDP(7,3));
        System.out.println(waysRecursive(7));
    }


    /**
     *  Dynamic Programming solution
     * @param stairs
     * @param steps
     * @return
     */
    public static int waysDP(int stairs, int steps){
        //including 0, hence size in (stairs+1)
        int[] ways = new int[stairs+1];
        //for 0 and 1 - there is only 1 way
        if(stairs <= 1 ) {
            return 1;
        }
        //initialize the 3 base cases
        ways[0] = 1; // there is only 1 way one can climb a 0 stairs
        ways[1]= 1; // 1 stair, so 1 way - take 1 step jump
        ways[2] = 2; // when 2 stairs, one can take a 2 step jump or take 1 step jump twice.
        int way ;
        //start from 3
        for(int i=3; i <= stairs; i++){
            ways[i] = ways[i-1]+ways[i-2]+ways[i-3];
        }
        return ways[stairs];
    }

    /**
     * recursive solution
     * there is only 1 way one can climb a 0 stairs
     * ( stair == 0 return 1;)
     * Account for the negative as well - as n-1, n-2 and n-3
     * cases will call waysRecursive with negative value after base case.
     * @param stairs
     * @return
     */
    public static int waysRecursive(int stairs){
        if(stairs < 0) return 0;
        else if(stairs==0) return 1;
        else return waysRecursive(stairs-1)+waysRecursive(stairs-2)+waysRecursive(stairs-3);
    }
}
