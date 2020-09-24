package algorithms;




/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 *
 *
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 *
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 *
 *
 *
 * @author wuxiaobiao
 * @date 2020-09-24 : 16:05
 */
public class _11_ContainerWithMostWater {


    /**
     * Runtime: 308 ms, faster than 21.74% of Java online submissions for Container With Most Water.
     * Memory Usage: 40 MB, less than 42.92% of Java online submissions for Container With Most Water.
     *
     */
    public int maxArea(int[] height) {

        int len = height.length;

        int area = 0;

        for (int i=0;i<len;i++) {
            for (int j=i+1;j<len;j++) {
                int ar = Math.min(height[i], height[j])*(j-i);
                if (ar > area) {
                    area = ar;
                }
            }
        }
        return area;
    }

}
