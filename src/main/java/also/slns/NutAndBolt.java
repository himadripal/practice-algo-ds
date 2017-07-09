package also.slns;

/**
 * Created by 371865 on 4/17/2017.
 */
public class NutAndBolt {

    private static int compare(String a, String b){
            if(a.toUpperCase().equals(b)) return 0;
            if(a.compareTo(b)> 0) return -1;
            if(a.compareTo(b) < 0 ) return 1;

        return 2;
    }
    public static void sortNutsAndBolts(String[] nuts, String[] bolts) {
        sortArr(nuts,bolts,0,nuts.length-1);
        //sortArr(bolts,nuts,0,nuts.length-1);
    }
    private static void swap(String[] arr, int i,int j){
        String temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static int partition(String[] arr,int lo,int hi,String pivot){
        int i=lo-1;
        int j=hi+1;

        while(lo < hi){
            while(compare(arr[++i],pivot) < 0){
                if(i==hi) break;
            }
            while(compare(arr[--j],pivot)>0){
                if(j==lo) break;
            }
            if(i>=j) break;
            swap(arr,i,j);
        }
       // swap(arr,hi,j);
        return j;
    }


    private static void sortArr(String[] nuts, String bolts[],int lo,int hi){
        if(hi<=lo) return;
        int j = partition(nuts,lo,hi,bolts[hi]);
        partition(bolts,lo,hi,nuts[j]);
        sortArr(nuts,bolts,lo,j-1);
        sortArr(nuts,bolts,j+1,hi);
    }
    public static void main(String[] args){
       // String[] nuts = {"ab","bc","gg","dd"};
       // String[] bolts = {"BC","AB","DD","GG"};
        String[] nuts ={"aah","abnj","blint","code","hj","juw","juy","as","ww","www","wwww","w"};
        String[] bolts ={"B","T","Q","TQ","W","TRW","HJK","JKK","JJKJK","HJUYUYU","AB","AF"};

        sortNutsAndBolts(nuts,bolts);
        Sorting.printArray(nuts);
        Sorting.printArray(bolts);
        System.out.println(compare("bc","ab"));
    }

}
