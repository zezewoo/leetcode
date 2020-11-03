package algorithms;





/**
 * @author wxb
 * @date 2020-11-02 : 11:36
 */



public class _42_TrappingRainWater {



    public static void main(String[] args) {

        _42_TrappingRainWater trappingRainWater = new _42_TrappingRainWater();

        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int heightB[] = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};

        int a = trappingRainWater.trap(heightB);
        int b = trappingRainWater.trap(heightB);


    }


    public int trap(int[] height) {

        int n = height.length;
        if (n < 3) return 0;

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int val = height[i];
            int leftHeight = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftHeight = Math.max(leftHeight, height[j]);
            }
            int righHeigth = 0;
            for (int j = i + 1; j < n; j++) {
                righHeigth = Math.max(righHeigth, height[j]);
            }
            if (val < Math.min(leftHeight, righHeigth)) {
                ans += Math.min(leftHeight, righHeigth) - val;
            }
        }
        return ans;
    }

}
