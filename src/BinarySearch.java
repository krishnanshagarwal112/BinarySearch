public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {7};
        int target = 7;
        int ans = binarySearch(arr,target);
        System.out.println(ans);
    }
    // return the index
    // return -1 if it does not exist
    static int binarySearch(int[] arr, int target){
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
            else if(arr[middle] == target){
                return middle;
            }
        }
        return -1;
    }
}