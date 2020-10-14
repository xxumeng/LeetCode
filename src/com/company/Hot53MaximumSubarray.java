package com.company;

public class Hot53MaximumSubarray {

    /*
    思路1
    * */
    public int maxSubArray(int[] nums){
        int pre=0,max_res = 0;
        for (int num: nums) {
            pre = Math.max(num, pre+num);
            max_res = Math.max(max_res, pre);

        }
        return max_res;
    }

    /*
   思路2 分治法，线段树区间合并法 解决多次询问的 区间连续上升子序列问题 区间最大子段和问题
   * */
    //区间维护的信息
    class Status{
        //lSum 以l为左端点，最大的子段和；rSum 以r为右端点，最大的子段和
        //iSUM 区间和； mSum 区间最大子段和
        public int lSum,rSum,iSUM,mSum;
        public Status(int lSum,int rSum,int iSUM,int mSum){
            this.lSum = lSum;
            this.rSum = rSum;
            this.iSUM = iSUM;
            this.mSum = mSum;
        }
    }
    //区间的合并
    public Status pushUp(Status left, Status right){
        int lSum = Math.max(left.lSum, left.iSUM + right.lSum);
        int rSum = Math.max(right.rSum, left.rSum + right.iSUM);
        int iSum = left.iSUM + right.iSUM;
        int mSUm = Math.max(Math.max(left.mSum, right.mSum), left.rSum + right.lSum);
        return new Status(lSum, rSum,iSum,mSUm);
    }
    //分治递归
    public Status getInfo(int[] nums, int l, int r){

        if (l==r){
            return new Status(nums[l],nums[l],nums[l],nums[l]);
        }
        int m = (l+r)>>1;
        Status left = getInfo(nums, l, m);
        Status right = getInfo(nums, m+1, r);
        return pushUp(left, right);

    }
    public int maxSubArray2(int[] nums){
        return getInfo(nums, 0, nums.length-1).mSum;
    }

    public static void main(String[] args) {
        Hot53MaximumSubarray s = new Hot53MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = s.maxSubArray(nums);
        int res2 = s.maxSubArray2(nums);
        System.out.println(res);
        System.out.println(res2);
    }
}
