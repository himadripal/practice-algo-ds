package also.slns; /**
 * Created by 371865 on 12/18/2016.
 * hacker rank problem world code sprint 8
 * Find minimum cost to connect every city with library
 * min( noOfRoadToRepair * roadRepairCost and libraryInEachCity * libraryBuildingCost)
 */
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class LibraryAndRoad {
    private int[] citites;
    private int[] connectedCities;
   // private int noOfComponents = 0;
    //private boolean allConnected = false;


    public LibraryAndRoad(int n){
        citites = new int[n];
        connectedCities = new int[n];
        for(int i=0; i < n ; i++){
            citites[i] = i;
            connectedCities[i] = 1;
        }
        //noOfComponents = n;
    }
    public boolean connect(int p, int q){
        int rootP = root(p);
        int rootQ = root(q);

        if(rootP == rootQ){
            return false;
        }
        if(connectedCities[rootP] >= connectedCities[rootQ]){
            citites[q] = rootP;
            connectedCities[rootP] = connectedCities[rootP] + connectedCities[rootQ];
            connectedCities[rootQ] = 0;

        }else{
            citites[p] = rootQ;
            connectedCities[rootQ] = connectedCities[rootQ]+ connectedCities[rootP];
            connectedCities[rootP] = 0;

        }
        return true;
    }
    public int root(int p){
        while(p != citites[p]){
            p=citites[p];
        }
        return p;
    }
    public int connnectedComponents(){
        int connComp = 0;
        for(int i=0; i <connectedCities.length;i++ ){
            if(connectedCities[i]>0){
                connComp++;
            }
        }
        return connComp;
    }
    public boolean connected(int p, int q){
        return (root(p) == root(q));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LibraryAndRoad lbrd = null;

        List<String> listString = null;
        try {
            URI uri = LibraryAndRoad.class.getResource("input_lbrd1").toURI();
            listString = Files.readAllLines(Paths.get(uri));
        }catch (Exception e){
            e.printStackTrace();
        }

        int q = Integer.valueOf(listString.remove(0));//in.nextInt();//
        long[] outPut = new long[q];
        for(int a0 = 0; a0 < q; a0++) {
            String s = listString.remove(0);
            String[] inputArr = s.split(" ");
            //System.out.println(s);
            long n = Long.valueOf(inputArr[0]);//in.nextInt(); //
            lbrd = new LibraryAndRoad((int) n);
            long m = Integer.valueOf(inputArr[1]);//in.nextInt();//
            long x = Long.valueOf(inputArr[2]);//in.nextInt(); ;//
            long y = Long.valueOf(inputArr[3]);//in.nextInt();//
            // lbrd.connect(0,1);
            //lbrd.connect(n,n+1);
            long noOfRegions = n;
            long roadCost = 0;
            for (int a1 = 0; a1 < m; a1++) {
                String st = listString.remove(0);
                String[] inputArrCities = st.split(" ");
                int city_1 = Integer.valueOf(inputArrCities[0]);//in.nextInt();
                int city_2 = Integer.valueOf(inputArrCities[1]);//in.nextInt();//
                if (noOfRegions > 1 && lbrd.connect(city_1 - 1, city_2 - 1)) {
                    noOfRegions--;
                    roadCost += y;
                }
            }
            long minCost = n * x;
            //for (int i = 1; i <= noOfRegions; i++){
                long cost = noOfRegions * x + roadCost;
                if (minCost > cost) minCost = cost;
            //}
            //System.out.println(n+" "+m+" "+x+" "+y+" "+noOfRegions+" "+roadCost/y);
            System.out.println(String.valueOf(minCost));

        }

    }
}

