class Solution {
    public int findMin(int[] nums) {
       int a;int l= nums.length;
       int i,j=0;
       for(i=1;i<nums.length;i++)
       {
          a=nums[i-1];
          if(nums[i]<a)
          {
            j = i;
            break;
          }
        }
          return nums[j]; 
    }
}