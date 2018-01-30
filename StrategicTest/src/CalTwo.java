import java.sql.*;
import java.util.*;

public class CalTwo implements CalScore
{
	public double calScore(double[] a)
	{
		double score=0,sum=0;
		Arrays.sort(a);
		for(int i=1;i<a.length-1;i++){
			sum=sum+a[i];
		}
		score=sum/(a.length-2);
		return score;
	}
}
