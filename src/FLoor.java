public class FLoor {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 1;
        System.out.println(floor(arr, target));

    }
    static int floor(int[] arr, int target){
        int start = 0;
        int ans = 0;
        int end = arr.length - 1;

        if(arr[start] > target){
            ans = -1;
        }

        while(start <= end){
            int mid = start + ((end - start)/2);
            if(arr[mid] <=  target){
                start = mid + 1;
                ans =  arr[mid];
            }else{
                end = mid - 1;
            }

        }
        return ans;
    }
}
