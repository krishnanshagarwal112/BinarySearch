import java.util.Arrays;

public class FirstLastSorrtedArray {
    public static void main(String[] args) {
        int[] arr = {5,7,7,7,7,8};
        int ele = 7;
        int[] sol = searchRange(arr,ele);
        System.out.println(Arrays.toString(sol));
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int start = find(nums,target,true);
        int end = find(nums,target,false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    // this function will return the value of target
    static int find(int[] arr, int target, boolean findStartIndex){
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
//            int middle = (start + end)/2;   // this might exceed range
            int middle = start + (end - start)/2;

            if(arr[middle] < target){
                start = middle + 1;
            }
            else if(arr[middle] > target ){
                end = middle - 1;
            }
            else{
                // Potential answer found
                ans = middle;
                if(findStartIndex){
                    end = middle - 1;
                } else{start = middle +1;
                };

            }
        }
        return ans;
    }
}

