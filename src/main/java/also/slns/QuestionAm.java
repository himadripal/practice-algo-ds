package also.slns;

/**
 * Created by hpal on 3/24/2017.
 */
public class QuestionAm {
    public static void main(String[] args){
        System.out.println(checkIfPossible("acaabbb","ab"));
    }

    private static boolean checkIfPossible(String dest,String delta){
        if(dest==null && delta==null) return true;

        while(dest.length() >= delta.length()){
            dest=dest.replaceAll(delta,"");
            if(dest.length()==0)
                return true;
            //else return false;
            }

        return false;
    }

}
