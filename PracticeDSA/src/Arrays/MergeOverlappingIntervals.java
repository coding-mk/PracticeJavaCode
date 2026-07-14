//Merge Overlapping Intervals
/*Problem Description

Given a collection of intervals, merge all overlapping intervals.



Problem Constraints

1 <= Total number of intervals <= 100000.



Input Format

First argument is a list of intervals.



Output Format

Return the sorted list of intervals after merging all the overlapping intervals.



Example Input

Input 1:

[1,3],[2,6],[8,10],[15,18]


Example Output

Output 1:

[1,6],[8,10],[15,18]


Example Explanation

Explanation 1:

Merge intervals [1,3] and [2,6] -> [1,6].
so, the required answer after merging is [1,6],[8,10],[15,18].
No more overlapping intervals present.
 */
package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {

public class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
 }

  public static void main(String[] args) {
    
  }

  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new IntervalComp());
        ArrayList<Interval> res;
        Interval inter;
        int n = intervals.size();
        res = new ArrayList<>();
        
        for (int i = 0; i < n;) {
            
            inter = new Interval(intervals.get(i).start, intervals.get(i).end);
            Interval next;
            i++;
            
            while (i < n) {
                next = intervals.get(i);
                if (overlap(inter, next)) {
                    inter.end = Math.max(inter.end, next.end);
                    i++;
                } else {
                    break;
                }
            }
            
            res.add(inter);
            
        }
        
        return res;
    }
    
    private boolean overlap(Interval int1, Interval int2) {
        
        if (int1.end >= int2.start && int1.start <= int2.end)
            return true;
            
        return false;
        
    }
    
    private class IntervalComp implements Comparator<Interval> {
        
        @Override
        public int compare(Interval interval1, Interval interval2) {
            int cmp =  Integer.compare(interval1.start, interval2.start);
            if (cmp != 0)
                return cmp;
            cmp = Integer.compare(interval1.end, interval2.end);
            return cmp;
        }
        
    }
}
