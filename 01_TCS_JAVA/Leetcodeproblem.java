import java.util.ArrayList;


class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        ArrayList<Integer> numbers = new ArrayList<>();

         for(int i=1;i<height.length;i++){
            if(height[i-1]>threshold){
                numbers.add(i);
            }
         }
         return numbers;

    }
}