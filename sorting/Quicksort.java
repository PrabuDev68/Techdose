class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public static int partition(int[] nums, int low ,int high)
    {
        int i = low-1;
        int pivot = nums[high];

        for(int j = low ; j < high ; j++)
        {
            if(pivot >= nums[j])
            {
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,high,i+1);
        return(i+1);
    }

    public static void quickSort(int[] nums,int low , int high)
    {
        if(low < high)
        {
           int p = partition(nums,low,high);
           quickSort(nums,low,p-1);
           quickSort(nums,p+1,high);
        }

    }
    public static void swap(int[] arr , int a , int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
