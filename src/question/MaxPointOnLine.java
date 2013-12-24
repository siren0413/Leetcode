package question;
import java.util.*;

public class MaxPointOnLine {
	
	public static int maxPoints(Point[] points){
		if(points == null || points.length ==0)
				return 0;
		Map<Point,Integer> map = new HashMap<Point,Integer>();
		Map<Double,Integer> tempMap = new HashMap<Double,Integer>();
		int max = 1;
		for(int i = 0; i < points.length; i++){
			int count = 0;
			for(int j = i; j < points.length; j++){
				if(points[i].equals(points[j])){
					count++;
					continue;
				}
				double slope;
				if(points[i].x == points[j].x)
					slope = Integer.MAX_VALUE;
				else 
					slope = (points[i].y - points[j].y)/(double)(points[i].x - points[j].x);
				if(slope == -0.0)
					slope = 0.0;
				if(tempMap.containsKey(slope)){
					tempMap.put(slope,tempMap.get(slope)+1);
				}else
					tempMap.put(slope,1);
			}
			if(tempMap.isEmpty() && map.isEmpty() && count!=0 ){
				if(count > max)
					max = count;
			}
			for(Integer value: tempMap.values()){
				if(value+count > max)
					max = value+count;
			}
			tempMap.clear();
		}
		
        return max;
	}
	public static void main(String[] args) {
		Point[] points = {
				new Point(84,250),
				new Point(0,0),
				new Point(1,0),
				new Point(0,-70),
				new Point(0,-70),
				new Point(1,-1),
				new Point(21,10),
				new Point(43,90),
				new Point(-42,-230)
//				new Point(0,0),
//				new Point(1,1),
//				new Point(1,-1)
			};
			
			int result = maxPoints(points);
			System.out.println(result);
	}
	
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
     public boolean equals(Object obj){
        Point p = (Point)obj;
        if(x == p.x && y == p.y)
            return true;
		 return false;
    }
 }