//Merge Intervals
/*Problem Description

You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.



Problem Constraints

0 <= |intervals| <= 105



Input Format

First argument is the vector of intervals

second argument is the new interval to be merged



Output Format

Return the vector of intervals after merging



Example Input

Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:

Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


Example Output

Output 1:

 [ [1, 5], [6, 9] ]
Output 2:

 [ [1, 9] ]


Example Explanation

Explanation 1:

(2,5) does not completely merge the given intervals
Explanation 2:

(2,6) completely merges the given intervals
 */
package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
  public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

  public static void main(String[] args) {
    ArrayList<Interval> intervals = new ArrayList<>();

        // intervals.add(new Interval(1, 3));
        // intervals.add(new Interval(6, 9));

        // ArrayList<Interval> ans = insert(intervals, new Interval(2, 5));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        ArrayList<Interval> ans = insert(intervals, new Interval(2, 6));

        for (Interval i : ans) {
            System.out.println("Start: " + i.start + " End: " + i.end);
        }
  }

  public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<Interval>();
        for(int i=0;i<intervals.size();i++){
            if(intervals.get(i).end < newInterval.start){
                ans.add(intervals.get(i));
            }else if(newInterval.end < intervals.get(i).start){
                ans.add(newInterval);
                while(i<intervals.size()){
                    ans.add(intervals.get(i));
                    i++;
                }
                return(ans);
            }else{
                newInterval.start = Math.min(intervals.get(i).start,newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end,newInterval.end);
            }
        }
        ans.add(newInterval);
        return(ans);
    }
}
