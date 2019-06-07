package Scheduling;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class SCAN
{
	public void scan(ArrayList<Node> ArrSchedule, int start, int dist, int BoundryS)
	{
		insertion_sort(ArrSchedule);
		int index = find_index(ArrSchedule, start);
		
		System.out.println("\nSCAN Scheduling");
		System.out.println("path :");
		System.out.print(start + "  ");
		
		for(int i = index - 1; i >= 0; i--)
		{
			System.out.print(ArrSchedule.get(i).pro + "  ");
			dist += abs(ArrSchedule.get(i).pro - start);
			start = ArrSchedule.get(i).pro;
		}
		if(ArrSchedule.get(0).pro != BoundryS) System.out.print(BoundryS + "  ");
		
		dist = dist + ArrSchedule.get(ArrSchedule.size() - 1).pro + ArrSchedule.get(0).pro;
		
		for(int i = index; i < ArrSchedule.size(); i++)
		{
			System.out.print(ArrSchedule.get(i).pro + "  ");
		}
		
		System.out.println("\nTotal Distance " + dist);
		
	}
	
	public int find_index(ArrayList<Node> myarr, int position)
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
	
	public void insertion_sort(ArrayList<Node> myarr)
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
}
