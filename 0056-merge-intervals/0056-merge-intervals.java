class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int s1=intervals[0][0];
        int e1=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int s2=intervals[i][0];
            int e2=intervals[i][1];
            if(e1>=s2){             //Merge intervals
                e1=Math.max(e1,e2);
                continue;
            }
            res.add(new ArrayList<>(Arrays.asList(s1,e1)));
            s1=s2;
            e1=e2;
        }
        res.add(new ArrayList<>(Arrays.asList(s1,e1)));
        int list[][]=new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            list[i][0]=res.get(i).get(0);
            list[i][1]=res.get(i).get(1);
        }
        return list;
    }
}