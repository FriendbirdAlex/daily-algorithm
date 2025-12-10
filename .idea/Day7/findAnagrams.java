class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>result=new ArrayList<>();
        int window=p.length();
        if(s.length()<p.length()){
            return result;
        }
        int pcount[]=new int[26];
        int scount[]=new int[26];
        for(int i=0;i<window;i++){
            pcount[p.charAt(i)-'a']++;
            scount[s.charAt(i)-'a']++;
        }
        if (Arrays.equals(pcount, scount)) {
            result.add(0);
        }
        for(int i=0;i<s.length()-window;i++){
            scount[s.charAt(i) - 'a']--;
            scount[s.charAt(i + p.length()) - 'a']++;
            if (Arrays.equals(pcount, scount)) {
                result.add(i+1);
            }
        }return result;
    }
}