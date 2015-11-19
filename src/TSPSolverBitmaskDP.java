import java.util.ArrayList;

public class TSPSolverBitmaskDP {
	private static final double INF = 500000;
	ArrayList<Vertex> points = new ArrayList<>();
	int mask[];
	int weight[];
	public TSPSolverBitmaskDP() {
		points = Helper.takeInputs();
		System.out.println(points);
		mask = new int[points.size()];
		for(int i = 0 ; i < points.size() ;i++)
		{
			mask[i] = (int) Math.pow(2, i);
//			System.out.println(Integer.toBinaryString(mask[i]));
		}
		System.out.println(solveByBitmaskDP(0,1,0));
	}
	private double solveByBitmaskDP(int currentIndex, int bitmask, int indexOfPreviousPointTaken) {
		System.out.println("current index " + currentIndex+" bitmask "+bitmask+ " prev index "+ indexOfPreviousPointTaken);
		if(currentIndex == points.size() && bitmask != (1<<points.size())-1)
		{
			return INF;
		}else if(currentIndex == points.size() && bitmask == (1<<points.size())-1)
		{
			System.out.println("here");
			return 0;
		}
		double minVal = Double.MAX_VALUE;
		int choosenIndex = -1;
		for(int i = 1 ; i < points.size();i++)
		{
			int msk = ~(int)Math.pow(2, i);
			
			if((msk & bitmask) == bitmask)
			{
				int tempBitmask = bitmask | mask[i];
				double val = solveByBitmaskDP(i, tempBitmask, currentIndex)+points.get(currentIndex).getDistance(points.get(i));
				System.out.println(val);
				if(val < minVal)
				{
					choosenIndex = i;
					minVal = val;
				}
			}
		}
		if(choosenIndex != -1)
		{
			
		}
		return minVal;
	}
}
