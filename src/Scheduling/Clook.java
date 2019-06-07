package Scheduling;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Clook
{
	public static int find_index(ArrayList<Node> myarr, int position)
	{
		int index = -1;
		for(int i = 0; i < myarr.size(); i++)
		{
			if(myarr.get(i).pro > position)
			{
				return index = i;
			}
		}
		return -1;
	}
	
	public static void insertion_sort(ArrayList<Node> myarr)
	{
		
		for(int i = 0; i < myarr.size(); i++)
		{
			Node temp = new Node();
			temp.flag = myarr.get(i).flag;
			temp.pro = myarr.get(i).pro;
			for(int j = i; j > 0; j--)
			{
				while(temp.pro < myarr.get(j - 1).pro)
				{
					myarr.get(j).flag = myarr.get(j - 1).flag;
					myarr.get(j).pro = myarr.get(j - 1).pro;
					myarr.get(j - 1).flag = temp.flag;
					myarr.get(j - 1).pro = temp.pro;
				}
			}
		}
	}
	
	public void clook(ArrayList<Node> ArrSchedule, int start, int dist)
	{
		insertion_sort(ArrSchedule);
		int index = find_index(ArrSchedule, start);
		System.out.println("\nCLOOK Scheduling");
		System.out.println("path :");
		System.out.print(start + "  ");
		
		for(int i = index; i < ArrSchedule.size(); i++)
		{
			System.out.print(ArrSchedule.get(i).pro + "  ");
			dist += abs(ArrSchedule.get(i).pro - start);
			start = ArrSchedule.get(i).pro;
		}
		
		dist += ArrSchedule.get(ArrSchedule.size() - 1).pro - ArrSchedule.get(0).pro;
		
		start = ArrSchedule.get(0).pro;
		for(int i = 0; i < index ; i++)
		{
			System.out.print(ArrSchedule.get(i).pro + "  ");
			dist += abs(ArrSchedule.get(i).pro - start);
			start = ArrSchedule.get(i).pro;
			
		}
		
		System.out.println("\nTotal Distance " + dist);
		
	}
}
