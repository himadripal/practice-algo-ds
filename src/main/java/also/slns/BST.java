package also.slns;

import java.util.*;
import java.util.Queue;

/**
 * Created by hpal(mehimu@gmail.com) on 12/8/2016.
 *
 * Many utility functions on BST ( binary search tree)
 *  hieght of tree
 *  predecessor and successor
 *  top view of binary tree
 *  bottom view of binary tree
 *  Breadth First and Depth First Search
 *  replace with sum of higher nodes
 *  create a binary search tree from a sorted array
 *  insert, find and delete node in bst
 *  is bst a mirror?
 *  check if its a bst
 *
 */
public class BST {
    public class Node{
        int val;
        Node left;
        Node right;
        int level;
        int hDist;
        public Node(int val){
            this.val= val;
        }
    }
    public Node insert(int val,Node root) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.val) {
                root.left = insert(val, root.left);
        } else if(val >root.val) {
                root.right = insert(val,root.right);
        }
        return root;
    }

    public Node find(int val,Node root){
        if(root == null || root.val == val){
            return root;
        }
        if(val < root.val){
            return find(val,root.left);
        }else if(val > root.val){
            return find(val,root.right);
        }
        return root;
    }

    public Node deleteNode(int data,Node root){

        //return null if node is null
        if(root == null) return root;
        //same as search - if less than root then left sub stree
        if(data <root.val){
            //if deleting a node from left subtree return value of deleteNode is
            //set as left recursively to correct the tree
            root.left = deleteNode(data,root.left);
        }else if(data > root.val){ //otherwise right subtree
            //if deleting a node from right subtree return value of deleteNode is
            //set as right recursively to correct the tree
            root.right = deleteNode(data,root.right);
        }else{ //match found
            if(root.left == null && root.right==null) {
                root = null;
            }else if(root.right == null) {
                root = root.left;
            }else if(root.left == null){
                root=root.right;
            }else{
                //root.val = minValueRight(root.right);
                //root.right = deleteNode(root.val,root.right);
                root.val = maxValueLeft(root.left);
                root.left = deleteNode(root.val,root.left);
            }
        }
        return root;
    }

    int minValueRight(Node root){
        if(root.left == null) return root.val;
        else return minValueRight(root.left);
    }
    int maxValueLeft(Node root){
        if(root.right == null) return root.val;
        else return maxValueLeft(root.right);
    }

    public void inOrdertraver(Node root){
        if(root !=null){
            inOrdertraverSal(root.left);
            System.out.print(root.val);
            inOrdertraverSal(root.right);
        }
    }

    public void inOrdertraverSal(Node root){
        if(root !=null){
            inOrdertraverSal(root.left);
            System.out.print(root.val+" ");
            inOrdertraverSal(root.right);
        }
    }

    public static void main(String[] args){
        BST bst = new BST();
        Node root = bst.insert(3,null);
        bst.insert(2,root);
        bst.insert(5,root);
        bst.insert(1,root);
        bst.insert(4,root);
        bst.insert(5,root);
        bst.insert(6,root);

        /**
         *          3
     *          2       5
*          1        4       6
         */
        System.out.println("checkBST - "+ bst.checkBST(root));
        System.out.println("checkBSTMinMax - "+ bst.checkBSTMinMax(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println(heightOfATree(root));
        /*
        System.out.println("Before deletion - ");
        bst.inOrdertraverSal(root);
        bst.deleteNode(3,root);
        System.out.println();
        System.out.println("After deletion - ");*/
        bst.inOrdertraverSal(root);

        //System.out.println(printNodeAndLevel(root,1));

        boolean result = findSumInPath(root,6);
        System.out.println("result - "+result);
        int sum = 10;
        Set<String> paths = bfsOnBinaryTree(root,10);

        for(String s : paths){
            System.out.println(s);
        }




        topViewOfBST(root);
        //System.out.println(bst.minValue(root.right));
       // System.out.println("abc".compareTo("abd"));
        //System.out.println("abd".compareTo("abc"));
        bottomViewOfBTree(root);

        System.out.println("Replace with higher sum node");
        replaceWithSumOfHigherNode(root,0);
        System.out.println();
        bst.inOrdertraverSal(root);
        System.out.println();
        bst.isMirrorTest();

        //isMirror()
        Node root1 = bst.insert(50,null);
        bst.insert(30, root1);
        bst.insert(20,root1);
        bst.insert(40,root1);
        bst.insert(70,root1);
        bst.insert(60,root1);
        bst.insert(80,root1);
        //Node pre=null;
        //Node succ=null;
        //Node[] nodes = findPredecessorAndSuccessor(root1,65,pre,succ);
        System.out.println("path exists " + findSumInPath(root1,120));
        List<String> dfsPaths = new ArrayList<>();
        HashMap<Integer,String> elementsAtLevelMap= new HashMap<>();
        dfsBST(root1,120,dfsPaths,"",0,elementsAtLevelMap);
        if(dfsPaths.size()==0){
            System.out.println("no path with sum -"+ 120);
        }
        for(int i=0; i < dfsPaths.size(); i++){
            System.out.println("dfs path - "+(i+1)+"="+dfsPaths.get(i));
        }
        findPredecessorAndSuccessor(root1,65);
        System.out.println("pre - "+pre.val);
        System.out.println("succ -"+succ.val);
        System.out.println();
        System.out.println("also.slns.BST Creation");
        //Node createdRoot = null;
        int[] arr = {40,50,55,60,75,80,85};
       Node createdRoot = bst.createBST(arr,0,arr.length-1);
        bst.inOrdertraverSal(createdRoot);
    }
    static Node pre=null,succ=null;
    Node previous = null;
    boolean checkBST(Node root) {
        if(root != null){
            boolean result = checkBST(root.left);
            if(!result) return false;
            if(previous != null && root.val <= previous.val) return false;
            previous = root;
            return checkBST(root.right);
        }
        return true;
    }

    boolean checkBSTMinMax(Node root, int min, int max){
        if(root == null) return true;
        //should be between min and max.. greater than left and less than right
        //min = leftValue, max = rightValue;
        if(root.val <= min || root.val >= max){
            return false;
        }
        //for each node - left should be less than root.val
        boolean checkLeft = checkBSTMinMax(root.left,min,root.val);
        //for each node right should be greater than root.val
        boolean checkRight = checkBSTMinMax(root.right,root.val,max);
        return checkLeft && checkRight;
    }



   static int printNodeAndLevel(Node root,int level){
        if(root==null){
            return 0;
            //System.out.println("Level 0");
        }
        System.out.println();
       System.out.println("Node.val = "+root.val+" Level = "+level);

       level = printNodeAndLevel(root.left,level+1);
       /*if(root.val == 4){
           level =0;
       }*/
       //if(level!=0) return level;

       level = printNodeAndLevel(root.right,level+1);
       return level;
    }

    /*public static boolean isSubTree(Node t1,Node t2){

    }*/

    public static boolean findSumInPath(Node root,int sum){
        boolean result=false;
        if(root==null) return false;
        if(sum==0) return true;
         result = findSumInPath(root.left,sum-root.val);
        //System.out.println("sum"+sum);
        result = findSumInPath(root.right,sum-root.val);
        return result;
    }

    private static Set<String> bfsOnBinaryTree(Node root,int sum){
        Set<String> paths = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        String[] elementsAtLevel = new String[heightOfATree(root)];
        root.level=0;
        queue.add(root);
        String path ="";
        int heightOfTree = 0;
        while (!queue.isEmpty()){
            Node current = queue.poll();
            if(current.level > heightOfTree){
                heightOfTree = current.level;
            }
            System.out.println("val -"+current.val+" -> level -"+current.level);
           // sum = sum-current.val;
            path+=current.val+"->";
            elementsAtLevel[current.level] = elementsAtLevel[current.level]+","+current.val;
           /* if(sum==0){
                paths.add(path);
            }*/
            if(current.left!=null){
                current.left.level=current.level+1;
                queue.add(current.left);
            }
            if(current.right!=null){
                current.right.level = current.level+1;
                queue.add(current.right);
            }
        }

        for(int i =0; i < elementsAtLevel.length; i++){
            System.out.println("elements at level- "+i+"="+elementsAtLevel[i]);
        }
        System.out.println("height of the tree - "+(heightOfTree+1));
        return paths;
    }

    private static void dfsBST(Node root,int sum,List<String> paths,String path,int level,HashMap<Integer,String> elementsAtLevel){
        if(root==null){
            return;
        }
        sum=sum-root.val;
        path=path+"->"+root.val;
        elementsAtLevel.put(level,elementsAtLevel.get(level)+","+root.val);
        if(sum==0){
            paths.add(path);
            path="";
            return;
        }
        if(root.left!=null) dfsBST(root.left,sum,paths,path,level+1,elementsAtLevel);
        if(root.right!=null) dfsBST(root.right,sum,paths,path,level+1,elementsAtLevel);
    }

    private static int heightOfATree(Node root){
        if(root==null) return 0;
        int leftHeight = heightOfATree(root.left);
        int rightHeight = heightOfATree(root.right);
        int treeHeight = Math.max(leftHeight,rightHeight);
        return 1+treeHeight;
    }

    private static void topViewOfBST(Node root){
        SortedMap<Integer,Node> hdNodeMap = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        root.hDist=0;
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
           if(!hdNodeMap.containsKey(node.hDist)){
               hdNodeMap.put(node.hDist,node);
           }
           if(node.left!=null){
               node.left.hDist = node.hDist-1;
               queue.add(node.left);
           }
           if(node.right!=null){
               node.right.hDist=node.hDist+1;
               queue.add(node.right);
           }
        }
        System.out.println();
        System.out.println("Top View -----");
        for(int i : hdNodeMap.keySet()){
            System.out.print(hdNodeMap.get(i).val+" ");
        }
    }

    private static void bottomViewOfBTree(Node root){
        Queue<Node> queue = new LinkedList<>();
        root.hDist=0;
        queue.add(root);
        HashMap<Integer,Integer> hdNodeMap = new HashMap<>();
        while(!queue.isEmpty()){
            Node node = queue.poll();
            hdNodeMap.put(node.hDist,node.val);
            if(node.left!=null){
                node.left.hDist = node.hDist-1;
                queue.add(node.left);
            }
            if(node.right!=null){
                node.right.hDist=node.hDist+1;
                queue.add(node.right);
            }
        }
        System.out.println();
        System.out.println("Bottom View -----");
        for(int i:hdNodeMap.keySet()){
            System.out.print(hdNodeMap.get(i)+" ");
        }
    }

    private static int replaceWithSumOfHigherNode(Node root,int sum){
        if(root==null){
            return sum;
        }
        sum = replaceWithSumOfHigherNode(root.right,sum);
        sum = sum+root.val;
        root.val = sum - root.val;
        sum = replaceWithSumOfHigherNode(root.left,sum);
        return sum;
    }
    private  void isMirrorTest(){

        Node root = new Node(1);
        //tree.root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        boolean mirror = isMirror(root,root);
        System.out.println("mirror - "+mirror);


    }

    private static boolean isMirror(Node node1, Node node2){
        if(node1==null && node2==null) return true;
        if((node1==null && node2!=null)||(node1!=null && node2==null)) return false;
        if(node1.val==node2.val) {
            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        }
        return false;
    }

    private static void findPredecessorAndSuccessor(Node root, int key){
       if(root!=null) {
           if (root.val == key) {
               //right most in left subtree
               if (root.left != null) {
                   Node temp = root.left;
                   while (temp.right != null) {
                       temp = temp.right;
                   }
                   pre = temp;
               }
               //left most of right is successor
               if (root.right != null) {
                   Node temp = root.right;
                   while (temp.left != null) {
                       temp = temp.left;

                   }
                   succ = temp;
               }
           } else if (root.val > key) {
               succ = root;
               findPredecessorAndSuccessor(root.left, key);
           } else if (root.val < key) {
               pre = root;
               findPredecessorAndSuccessor(root.right, key);
           }
       }
    }

    public static Node maxValue(Node root){
        if(root.right==null) return root;
        return maxValue(root.right);
    }

    public static void successorPredecessor(Node root, int val) {
        if (root != null) {
            if (root.val == val) {
                // go to the right most element in the left subtree, it will the
                // predecessor.
                if (root.left != null) {
                    Node t = root.left;
                    while (t.right != null) {
                        t = t.right;
                    }
                    pre = t;
                }
                if (root.right != null) {
                    // go to the left most element in the right subtree, it will
                    // the successor.
                    Node t = root.right;
                    while (t.left != null) {
                        t = t.left;
                    }
                    succ = t;
                }
            } else if (root.val > val) {
                // we make the root as successor because we might have a
                // situation when value matches with the root, it wont have
                // right subtree to find the successor, in that case we need
                // parent to be the successor
                succ = root;
                successorPredecessor(root.left, val);
            } else if (root.val < val) {
                // we make the root as predecessor because we might have a
                // situation when value matches with the root, it wont have
                // right subtree to find the predecessor, in that case we need
                // parent to be the predecessor.
                pre = root;
                successorPredecessor(root.right, val);
            }
        }
       // System.out.println("root is null");
    }

    private Node createBST(int[] arr,int lo, int hi){
        if(lo > hi) return null;
        int mid = lo + (hi-lo)/2;

        Node node = new Node(arr[mid]);
        node.left = createBST(arr,lo,mid-1);
        node.right= createBST(arr,mid+1,hi);
        return node;
    }

}
