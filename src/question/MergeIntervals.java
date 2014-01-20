package question;

import beans.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by admin on 1/19/14.
 */
public class MergeIntervals {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals,new intervalComparator());
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end >= intervals.get(i + 1).start) {
                intervals.get(i).start = Math.min(intervals.get(i).start, intervals.get(i + 1).start);
                intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
                intervals.remove(i + 1);
                i--;
            }
        }

        return intervals;
    }

   static class intervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.valueOf(o1.start).compareTo(Integer.valueOf(o2.start));
        }
    }



    // test
    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        System.out.println(merge(list));
    }

}
