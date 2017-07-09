package also.slns;

import java.util.Scanner;

/**
 * Given a series of scores - rank them against a series of scores given in decreasing order
 *
 * Sample Input -
 7
 100 100 50 40 40 20 10 // scores of the players on the leatherboard
 4
 5 25 50 120 // scores of the player whose score needs ranking
 Sample Output - ranking
 6
 4
 2
 1
 */
public class ClimbingLeatherBoard {

    static int totalScoresToRank = 0;
    public static class Node{
        int data;
        Node left;
        Node right;
        boolean needRanking;
        int currentRank;
        boolean visited;
        public Node(int n,int currentRank){
            data = n;
            left = null;
            right = null;
            needRanking = false;
            visited = false;
        }
    }


    public static Node insert(int val, Node root, boolean needRank,int currentRank){
        if(root == null){
            root = new Node(val,currentRank);
            root.needRanking=needRank;
            root.currentRank = currentRank;
            if(needRank) System.out.println(currentRank);
            return root;
        }
        if(val == root.data){
             root.needRanking=needRank;
             if(needRank) System.out.println(currentRank);
        }
        if(val < root.data){
           root.left = insert(val,root.left,needRank,root.currentRank +1);

        }else if(val > root.data){
            root.right = insert(val,root.right,needRank,root.currentRank);
            root.currentRank=root.currentRank+1;
        }
        return root;
    }

    public static void traversal(Node root){
        if (root != null && !root.visited){
            traversal(root.left);
           // System.out.println(root.data+","+ root.currentRank);

            if(root.needRanking){
                System.out.println(root.currentRank);
            }
            root.visited=true;
                 //rank++;
            traversal(root.right);
        }

    }

    static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x)
                return binarySearch(arr, l, mid-1, x);
            return binarySearch(arr, mid+1, r, x);
        }
        return l;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //hold the prev Score to include only the unique scores
        int prevScore = 0;
        int maxUniqueScores =0;
        int[] scores = new int[n];
        Node node = null;
        for(int scores_i=0; scores_i <n; scores_i++){
            int score = in.nextInt();
            if(score!= prevScore){
                scores[maxUniqueScores++] = score;
                if(scores_i == 0) {
                    node = insert(score, node,false,1);
                }else{
                    insert(score,node,false,scores_i+1);
                }

            }
            prevScore = score;
        }
        int m = in.nextInt();
        int last = scores.length;
        int first = 0;
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            int aliceScore = in.nextInt();
            alice[alice_i] = aliceScore;
           // insert(aliceScore,node,true,1);
            System.out.println( binarySearch(scores,0,maxUniqueScores-1,aliceScore)+1);
        }
        traversal(node);
    }

}
