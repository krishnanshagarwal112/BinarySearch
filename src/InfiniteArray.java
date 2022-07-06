public class InfiniteArray {
    public static void main(String[] args) {
        // start with box of 2
        int[] arr = {1,2,3,4,5,6,7};
        int target = 4;
        System.out.println(ans(arr,target));

    }
    static int ans(int[] arr, int target){
        /// first find the range
        // lets start with a box of 2
        int start = 0;
        int end = 1;
        while(target > arr[end]){
            int newStart = end + 1; // basically temp
            // double the box value
            // end  = previous end + size of box*2
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(arr,target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end) {
//            int middle = (start + end)/2;   // this might exceed range
            int middle = start + (end - start)/2;

            if(arr[middle] < target){
                start = middle + 1;
            }
            else if(arr[middle] > target ){
                end = middle - 1;
            }
            else if(arr[middle] == target){
                return middle;
            }
        }
        return -1;
    }
}
