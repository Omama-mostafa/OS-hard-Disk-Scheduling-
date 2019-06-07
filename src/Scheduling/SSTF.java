package Scheduling;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class SSTF
{
	public void sstf(ArrayList<Node> arrSchedule, int start, int dist)
	{
		System.out.println("\nSSTF Scheduling");
		System.out.println("Path : ");
		System.out.print(start + "  ");
		
		for(int i = 0; i < arrSchedule.size(); i++)
		{
			MinClass mini = CalcMin(arrSchedule, start);
			System.out.print(arrSchedule.get(mini.index).pro + "  ");
			arrSchedule.get(mini.index).flag = true;
			start = arrSchedule.get(mini.index).pro;
			dist += mini.mini;
		}
		System.out.println("\nTotal Distance " + dist);
	}
	
	public MinClass CalcMin(ArrayList<Node> arr, int start)
	{
		MinClass mini = new MinClass();
		mini.mini = 100000000;
		mini.index = -1;
		for(int i = 0; i < arr.size(); i++)
		{
			if(!arr.get(i).flag)
			{
				int diff = abs(arr.get(i).pro - start);
				if(mini.mini > diff)
				{
					mini.mini = diff;
					mini.index = i;
				}
			}
		}
		return mini;
	}
	
	class MinClass
	{
		int mini;
		int index;
	}
}
