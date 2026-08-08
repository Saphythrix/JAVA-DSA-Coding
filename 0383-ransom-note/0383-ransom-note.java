class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> need=new HashMap<>();
        HashMap<Character,Integer> have=new HashMap<>();
        for(char ch:ransomNote.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0)+1);

        }
        for(char ch:magazine.toCharArray()){
            have.put(ch,have.getOrDefault(ch,0)+1);

        }
        for(Character ch:need.keySet()){
            if(!have.containsKey(ch)){
                return false;
            }
            if(need.get(ch)>have.get(ch)){
                return false;
            }
        }
        return true;
    }
}