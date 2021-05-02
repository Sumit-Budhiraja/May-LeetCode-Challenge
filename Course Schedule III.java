class Solution {
    public int scheduleCourse (int [][] courses) {
        if (courses.length == 0 || courses == null)
            return 0;
        
        // Keep a max heap w.r.t. higest duration, i.e. courses [i][0]  
        Queue <int []> heap = new PriorityQueue (new Comparator <int []> () {
            public int compare (int a [], int b []) {
                if (a [0] < b [0])
                    return 1;
                else if (a [0] > b [0])
                    return -1;
                else
                    return 0;
            }
        });
        
        // Sort courses in increasing order of lastDay, i.e. courses [i][1]
        Arrays.sort (courses, new Comparator <int []> () {
           public int compare (int a [], int b []) {
               if (a [1] > b [1])
                   return 1;
               else if (a [1] < b [1])
                   return -1;
               else
                   return 0;
           } 
        });
        int time = 0;
        for (int i = 0; i < courses.length; i++) {
            time += courses [i][0];
            heap.add (courses [i]);
            if (time > courses [i][1])
                time -= heap.poll()[0];
        }
        return heap.size();
    }
}