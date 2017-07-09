package also.slns;

/**
 * Created by Himadri Pal (mehimu@gmail.com) on 6/27/2017.
 */
public class Division {


    public static int divide(int dividend, int divisor) {
        if(dividend==0) return dividend;
        if(dividend==divisor) return 1;
        int multiple=0;
        if(divisor==1){
            return dividend;
        }
        if(divisor==-1){
            if(dividend > 0){
                return Integer.valueOf("-"+dividend);
            }else{
                long dividendL = Long.valueOf((dividend+"").substring(1));
                if(dividendL >=Integer.MAX_VALUE) return Integer.MAX_VALUE;
                else{
                    return (int) dividendL;
                }
            }
        }

        long absDividend = dividend;
        long absDivisor = divisor;
        if(dividend < 0){
            absDividend = Long.valueOf((dividend+"").substring(1));
        }
        if(divisor < 0){
            absDivisor = Long.valueOf((divisor+"").substring(1));
        }
        if(absDividend < absDivisor) return 0;

        long result = devideRec(absDividend,absDivisor);
        if(result >= Integer.MAX_VALUE) result =(int) Integer.MAX_VALUE;
        if((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)) return Integer.valueOf("-"+result);
        return (int)result;

    }

    private static int  devideRec(long dividend,long divisor){

        if(dividend < divisor) return 0;

        int qoutient=1;
        long sum=divisor;
        while( (sum+sum) <= dividend){
            sum+=sum;
            qoutient+=qoutient;
        }
        return qoutient+devideRec(dividend - sum,divisor);
    }


    public static void main(String[] args){
        System.out.println(divide(-2147483648,-11));
        System.out.println("-------------");
    }



}
//-2147483648
//-1
