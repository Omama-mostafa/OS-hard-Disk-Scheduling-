package Scheduling;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class FCFS
{
	
	public void fcfs(ArrayList<Node> arrSchedule, int start, int dist)
	{
		System.out.println("FCFS Scheduling");
		System.out.println("Path : ");
		System.out.print(start + "  ");
		
		for(int i = 0; i < arrSchedule.size(); i++)
		{
			dist += abs(arrSchedule.get(i).pro - start);
			start = arrSchedule.get(i).pro;
		}
		
		for(int i = 0; i < arrSchedule.size(); i++)
		{
			System.out.print(arrSchedule.get(i).pro + "  ");
		}
		System.out.println();
		System.out.print("Total Distance " + dist);
	}
}
