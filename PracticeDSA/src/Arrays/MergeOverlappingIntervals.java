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
import java.util.Comparator;

public class MergeOverlappingIntervals {

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

        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        ArrayList<Interval> ans = merge(intervals);

        for (Interval i : ans) {
            System.out.println("Start: " + i.start + " End: " + i.end);
        }
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        // Sort intervals based on start time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        ArrayList<Interval> result = new ArrayList<>();

        Interval current = new Interval(intervals.get(0).start,
                                        intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {

            Interval next = intervals.get(i);

            // Overlapping intervals
            if (current.end >= next.start) {
                current.end = Math.max(current.end, next.end);
            }
            // Non-overlapping interval
            else {
                result.add(current);
                current = new Interval(next.start, next.end);
            }
        }

        // Add the last interval
        result.add(current);

        return result;
    }
}