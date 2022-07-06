public class RotatedArray {
    public static void main(String[] args) {
        int[] arr = {15,18,1,2,4,5,9};
        int target = 7;
        System.out.println(numberOfRotations(arr));

    }
    // https://leetcode.com/problems/search-in-rotated-sorted-array/
    public static int searchInRotatedArray(int[] nums, int target) {
        int ans1 = binarySearch(nums,target,0,pivot(nums));
        if (ans1 == -1){
            int ans2 = binarySearch(nums,target,pivot(nums) +  1,nums.length -1);
            return ans2;
        }
        return ans1;
    }

    public static int numberOfRotations(int[] arr){
        int pivot = pivot(arr);
        return pivot + 1;
    }

    public static int pivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            // 4 cases
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid; // found the answer
            }
            else if(arr[mid] < arr[mid-1]){
                return mid -1;
            }
            else if(arr[mid] <= arr[start]){
                end = mid -1;
            }
            else{
                start = mid;
            }
        }

        return  -1;
    }

    public static int pivotWithDuplicate(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            // 4 cases
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid; // found the answer
            }
            else if(arr[mid] < arr[mid-1]){
                return mid -1;
            }
           // If the elements at middle, start, end are equal, then skip the duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                // skip the duplicates

                //Note that they can't be pivots
                if(arr[start] > arr[start + 1]){
                    return start;
                }
                start++;
                if(arr[end] <  arr[end - 1]){
                    return end-1;
                }
                end--;
            }
            // Left side is sorted
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid +1;
            } else{
                end = mid - 1;
            }
        }

        return  -1;
    }

    public static int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end) {
//            int middle = (start + end)/2;   // this might exceed range
            int middle = start + (end - start)/2;

            if(nums[middle] < target){
                start = middle + 1;
            }
            else if(nums[middle] > target ){
                end = middle - 1;
            }
            else if(nums[middle] == target){
                return middle;
            }
        }
        return -1;
    }
}
