public class perfectSquare {
    public static void main(String[] args) {
        int ele = 2;
        System.out.println(mySqrt(ele));

        System.out.println(isPerfectSquare(ele));

    }
    public static boolean isPerfectSquare(long num) {
        long start = 0;
        long end = num ;
        while(start <= end){
            long mid = start + (end - start)/2;

            if(mid * mid > num){
                end = mid - 1;
            }
            else if(mid * mid < num){
                start = mid +1;
            }
            else if (mid * mid == num){
                return true;
            }

        }
        return false;
    }

    public static int mySqrt(long num) {
        long start = 0;
        long end = num ;
        int ans = 0;

        while(start <= end){
            long mid = start + (end - start)/2;

            if(mid * mid > num){
                end = mid - 1;
            }
            else if(mid * mid < num){
                start = mid + 1;
            }
            else if (mid * mid == num){
                return (int)mid ;
            }
            ans = (int)end;

        }
        return ans ;
    }
}
