class Solution {
    public boolean judgeCircle(String moves) {
        int[] m=new int[4];
        for(int i =0;i<moves.length();i++)
        {
            if(moves.charAt(i)=='U')
                m[0]+=1;
            if(moves.charAt(i)=='D')
                m[1]+=1;
            if(moves.charAt(i)=='L')
                m[2]+=1;
            if(moves.charAt(i)=='R')
                m[3]+=1;
        }
        if(m[0]==m[1]&&m[2]==m[3]){
            return true;}
        else {
            return false;}
    }
}
