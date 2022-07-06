public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int target = 3;
        int ans = orderAgnosticBS(arr,target);
        System.out.println(ans);

    }
    static int orderAgnosticBS(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        // CHECK IF ARRAY IS ASC OR DESC
        boolean isAsc = arr[start] < arr[end];


        while(start <= end) {
            int middle = start + (end - start)/2;

            // common condition
            if(arr[middle] == target){
                return middle;
            }
            // if asc
            if(isAsc){
                if(arr[middle] < target){
                    start = middle + 1;
                } else{
                    end = middle - 1;
                }
            }
            // if desc
            else{
                if(arr[middle] < target){
                    end = middle - 1;
                } else{
                    start = middle + 1;
                }
            }
        }
        return -1;


    }
}
