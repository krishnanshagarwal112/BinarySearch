public class Mountain {
    public static void main(String[] args) {
        int[] arr = {0,1,2,4,9,8,7,3};
        int target = 3;
        System.out.println(findInMountainArray(arr,target));

    }
    // https://leetcode.com/problems/peak-index-in-a-mountain-array/
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid]  > arr[mid + 1]){
                // you are in decreasing part of the array
                // this may be the answer
                // therefore we will look at the left
                end = mid;
            } else{
                // you are in ascending part of the array
                start = mid + 1;
            }
        }
        // In the end the start will be at the highest element
        // start and end are always trying to find the max element
        // when start will be equal to end, they will be pointing at the same element
        return start;
    }

    // https://leetcode.com/problems/find-in-mountain-array/
    static int findInMountainArray(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);
        int ans1 = orderAgnosticBS(arr,target,0,peak);
        if(ans1 == -1){
            int ans2 = orderAgnosticBS(arr,target,peak + 1,arr.length - 1);
            return ans2;
        }
        return ans1;
    }
    static int orderAgnosticBS(int[] arr, int target,int start,int end){
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
