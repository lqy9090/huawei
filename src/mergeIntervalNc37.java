import java.util.ArrayList;
import java.util.Comparator;

public class mergeIntervalNc37 {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int len = intervals.size();
        if(len <= 1) return intervals;
        intervals.sort(Comparator.comparingInt(a -> a.start));
//        sortByStart(intervals, 0, len - 1);

        Interval lastInterval = intervals.get(0);
        ArrayList<Interval> list = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            Interval interval = intervals.get(i);
            System.out.println("first: "+interval.start + " " + interval.end);
            if (interval.start <= lastInterval.end) {
//                System.out.println("start: " + interval.start + " end: " + lastInterval.end);
                lastInterval.start = Math.min(interval.start, lastInterval.start);
                lastInterval.end = Math.max(interval.end, lastInterval.end);
                if (i == len - 1) {
                    list.add(lastInterval);
                }
            } else {
                Interval newInterval = new Interval(lastInterval.start, lastInterval.end);
                list.add(newInterval);
                lastInterval.start = interval.start;
                lastInterval.end = interval.end;
                if (i == len - 1) {
                    list.add(lastInterval);
                }
            }

        }
        return list;
    }

    public static void sortByStart(ArrayList<Interval> intervals, int left, int right) {
        if (left > right) return;
        int i = left;
        int j = right;
        Interval base = intervals.get(left);

        while (i < j) {
            while (i < j && intervals.get(j).start >= base.start) {
                j--;
            }
            while (i < j && intervals.get(i).start <= base.start) {
                i++;
            }

            if (i < j) {
                Interval temp = intervals.get(i);
                intervals.set(i, intervals.get(j));
                intervals.set(j, temp);
            }
        }

        intervals.set(left, intervals.get(i));
        intervals.set(i, base);
        sortByStart(intervals, left, i - 1);
        sortByStart(intervals, i + 1, right);
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(0, 0));
//        intervals.add(new Interval(80, 100));
//        intervals.add(new Interval(150, 180));

        mergeIntervalNc37 solution = new mergeIntervalNc37();
        ArrayList<Interval> merge = solution.merge(intervals);
        for (Interval interval : merge) {
            System.out.println(interval.start + " " + interval.end);
        }

    }
}
