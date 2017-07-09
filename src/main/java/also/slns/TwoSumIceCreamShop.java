package also.slns;

import java.util.*;

public class TwoSumIceCreamShop {
    static class IceCream{
        private int ID;
        private int cost;
        public IceCream(int id, int Cost){
            ID = id;
            cost = Cost;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            IceCream a[] = new IceCream[n];
            for(int a_i=0; a_i < n; a_i++){
                IceCream iceCream = new IceCream(a_i+1,in.nextInt());
                a[a_i] = iceCream ;
            }
            TwoSumIceCreamShop s = new TwoSumIceCreamShop();
            s.quickSort(a,0,a.length-1);

            System.out.println(s.findPair(a,m));
        }
    }

    private  void swap(IceCream[] arr, int i, int j){
        IceCream temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private  void quickSort(IceCream[] arr,int lo, int hi){
        if(hi <= lo) return;
        int j = partition(arr,lo,hi);
        quickSort(arr,lo,j-1);
        quickSort(arr,j+1,hi);

    }
    private  int partition(IceCream[] arr, int lo, int hi){
        int i=lo, j=hi+1;
        while(true){
            while(arr[++i].cost < arr[lo].cost){
                if(i==hi) break;
            }
            while(arr[--j].cost > arr[lo].cost){
                if(j==lo) break;
            }
            if(i >= j) break;
            swap(arr,i,j);
        }
        swap(arr,lo,j);
        return j;
    }
    private  String findPair(IceCream[] arr, int number){
        int left = 0, right= arr.length-1;
        while(true){
            int sum = arr[left].cost + arr[right].cost;
            if(sum==number){
                int idLeft = arr[left].ID;
                int idRight = arr[right].ID;
                String returnStr = idLeft +" "+ idRight;
                if(idLeft > idRight){
                    returnStr = idRight +" "+ idLeft;
                }
                return returnStr;
            }else if(sum > number){
                if(right==0) break;
                right = right-1;
            }else{
                if(left == arr.length-1) break;
                left = left+1;
            }
        }
        return null;
    }
}
