package Scheduling;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Optimized
{
	public void optimized(ArrayList<Node> arrSchedule, int start, int dist)
	{
		System.out.println("applying optimized technique");
		Node strt = new Node();
		strt.pro = start;
		strt.flag = true;
		arrSchedule.add(strt);
		Node arr[] = new Node[arrSchedule.size()];
		for(int i = 0; i < arrSchedule.size(); i++)
		{
			arr[i] = new Node();
		}
		for(int i = 0; i < arrSchedule.size(); i++)
		{
			arr[i].pro = arrSchedule.get(i).pro;
			arr[i].flag = arrSchedule.get(i).flag;
		}
		int max = arr[0].pro;
		for(int i = arrSchedule.size() - 1; i >= 0; i--)
		{
			for(int j = 0; j <= i - 1; j++)
			{
				if(arr[j].pro > arr[j + 1].pro)
				{
					int temp1 = arr[j].pro;
					boolean temp2 = arr[j].flag;
					arr[j].pro = arr[j + 1].pro;
					arr[j].flag = arr[j + 1].flag;
					arr[j + 1].pro = temp1;
					arr[j + 1].flag = temp2;
				}
			}
		}
		System.out.println("Path: ");
		int totalresult = 0;
		for(int i = 0; i < arrSchedule.size(); i++)
		{
			System.out.print(arr[i].pro + "  ");
			if(i + 1 == arrSchedule.size()) break;
			totalresult += abs(arr[i].pro - arr[i + 1].pro);
		}
		System.out.println();
		System.out.println("Result: " + totalresult);
	}
}
