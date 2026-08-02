class Solution {
    public int[][] mergeInterval(int[][] arr){
        List<int[]> res=new ArrayList<>();
        int start1=arr[0][0];
        int end1=arr[0][1];
        for(int i=1;i<arr.length;i++){
            int start2=arr[i][0];
            int end2=arr[i][1];
            if(end1>=start2){
                start1=start1;
                end1=Math.max(end1,end2);
                continue;
            }
            res.add(new int[]{start1,end1});
            start1=start2;
            end1=end2;
        }
        res.add(new int[]{start1,end1});
        
        return res.toArray(new int[res.size()][2]);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]>  res=new ArrayList<>();
        boolean insert=false;
        for(int i=0;i<intervals.length;i++){
            int start1=intervals[i][0];
            if(start1>=newInterval[0] && insert==false){
                res.add(newInterval);
            }
            res.add(intervals[i]);
        }
        if(insert==false){
            res.add(newInterval);
        }
        return mergeInterval(res.toArray(new int[res.size()][]));
    }
}
