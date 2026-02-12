//Link : https://leetcode.com/problems/car-pooling/description/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001];
        for(int[] trip:trips){
            int pass = trip[0];
            int from = trip[1];
            int to = trip[2];

            stops[from]+=pass;
            stops[to]-=pass;
        }
        int currPass = 0;
        for(int i=0;i<1001;i++){
            currPass +=stops[i];

            if(currPass>capacity)return false;
        }
        return true;
    }
}