class Solution {
    public int[] sortArray(int[] nums) 
    {
       // selection sort


        for(int i = 0 ; i < nums.length-1 ; i++)
        {
            int min = i;
            for(int j = i+1 ; j < nums.length ; j++)
            {
                if(nums[min] > nums[j])
                {
                    min = j;
                }
            }
            
            if(min != i)
            {
                int tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
            
        }
        return nums

        


        // bubble sort 
        
        
        for(int i = 0 ; i < nums.length-1;i++)
        {
            boolean flag = false;
            for(int j = 0 ; j<nums.length-1-i; j++)
            {
                if(nums[j] > nums[j+1])
                {
                    flag = true;
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
            if(flag == false)
            {
                return nums;
            }
        }
        

        // merge sort

        
        int[] sortedArray = mergeSort(nums,0,nums.length-1);
        return sortedArray;
        

        //insertion sort

        for(int  i =1 ; i<nums.length;i++)
        {
            int current  = nums[i];
            int j = i-1 ;
            while(j>=0 && nums[j] > current)
            {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = current;
        }
        return nums;

        
    }
    // merge function
    public static int[] mergeSort(int arr[] , int l ,int r)
    {
        if(l == r)
        {
            int[] last = new int[1];
            last[0] = arr[l];
            return last;
        }
        int mid = (l+r)/2;
        int[] first = mergeSort(arr,l,mid);
        int[] second = mergeSort(arr,mid+1,r);

        int[] merged = merge(first,second);
        return merged;
    }
    // merge two sorted arrays
    public static int[] merge(int arr1[], int arr2[])
    {
        int i=0,j=0,k=0;
        int sorted[] = new int[arr1.length + arr2.length];
        while(i!= arr1.length && j!= arr2.length)
        {
            if(arr1[i] < arr2[j])
            {
                sorted[k++] = arr1[i++]; 
            }
            else
            {
                sorted[k++] = arr2[j++];
            }
        }
        while(i!= arr1.length)
        {
            sorted[k++] = arr1[i++];
        }
        while(j!= arr2.length)
        {
            sorted[k++] = arr2[j++];
        }
        return sorted;
    }
}
