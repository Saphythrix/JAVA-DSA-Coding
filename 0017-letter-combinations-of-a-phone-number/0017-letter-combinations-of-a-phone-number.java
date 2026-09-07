class Solution {
    HashMap<Character,String> hm=new HashMap<>();
    public List<String> func(String digits,int n,int idx,StringBuilder dairy,List<String> res){
        if(idx==n){
            String str=dairy.toString();
            res.add(str);
            return res;
        }
        String choice=hm.get(digits.charAt(idx));
        for(int i=0;i<choice.length();i++){
            dairy.append(choice.charAt(i));
            func(digits,n,idx+1,dairy,res);
            dairy.deleteCharAt(dairy.length()-1);
        }
        return res;
    }
    public List<String> letterCombinations(String digits) {
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        List<String> res=new ArrayList<>();
        int n=digits.length();
        int idx=0;
        StringBuilder dairy=new StringBuilder();
        return func(digits,n,idx,dairy,res);
    }
}