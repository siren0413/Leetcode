package question;

import beans.Interval;

import java.util.ArrayList;

/**
 * Created by admin on 1/19/14.
 */
public class InsertInterval {


    // best solution
    public static ArrayList<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> list = new ArrayList<>();
        for(Interval interval : intervals){
            if(interval.end < newInterval.start){
                list.add(interval);
            }else if(interval.start > newInterval.end){
                list.add(newInterval);
                newInterval = interval;         // set the new interval
            }else{
                newInterval = new Interval(Math.min(interval.start,newInterval.start),Math.max(interval.end,newInterval.end));
            }
        }
        list.add(newInterval);

        return list;
    }



    // secondary
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        for (int i = 0; i < intervals.size(); i++) {
            if (newInterval.start <= intervals.get(i).start && newInterval.end >= intervals.get(i).start) {
                intervals.get(i).start = newInterval.start;
            }
            if (newInterval.end >= intervals.get(i).end && newInterval.start <= intervals.get(i).end) {
                intervals.get(i).end = newInterval.end;
            }
        }

        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end >= intervals.get(i + 1).start) {
                intervals.get(i).end = intervals.get(i + 1).end;
                intervals.remove(i + 1);
                i--;
            } else if (intervals.get(i).end < newInterval.start && intervals.get(i + 1).start > newInterval.end) {
                intervals.add(i + 1, newInterval);
            }
        }
        if (intervals.get(0).start > newInterval.end) intervals.add(0, newInterval);
        if (intervals.get(intervals.size() - 1).end < newInterval.start) intervals.add(newInterval);

        return intervals;
    }




    // test
    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        Interval i1 = new Interval(2, 5);
        Interval i2 = new Interval(6, 7);
        Interval i3 = new Interval(8, 9);
        list.add(i1);
        list.add(i2);
        list.add(i3);
        System.out.println(insert2(list, new Interval(0, 10)));
    }
}
