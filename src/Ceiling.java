public class Ceiling {
    public static void main(String[] args) {
        int[] arr = {2,7,8,9,14,16,18};
        int target = 17;
        System.out.println(ceil(arr, target));

    }
    static int ceil(int[] arr, int target){
        int start = 0;
        int ans = 0;
        int end = arr.length - 1;

        if(arr[end] < target){
            ans = -1;
        }
        while(start <= end){
            int mid = start + ((end - start)/2);
            if(arr[mid] >=  target){
                end = mid - 1;
                ans =  arr[mid];
            }else{
                start = mid + 1;
            }
        }
        return ans;
    }
}
