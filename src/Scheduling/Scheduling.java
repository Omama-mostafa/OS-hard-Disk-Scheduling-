package Scheduling;

import java.util.ArrayList;
import java.util.Scanner;

public class Scheduling
{
	
	public static void main(String[] args)
	{
		ArrayList<Node> arrSchedule = new ArrayList<>();
		Scanner input = new Scanner(System.in);

		int boundaryS, boundaryE;
		System.out.println("please enter boundaries of disk : ");
		boundaryS = input.nextInt();
		boundaryE = input.nextInt();

		System.out.print("please enter number of processes : ");

		int number = input.nextInt();
		for(int i = 0; i < number; i++)
		{
			System.out.print("please enter process number " + (i + 1) + " : ");
			Scanner pro = new Scanner(System.in);
			int process = pro.nextInt();
			if(process >= boundaryS && process <= boundaryE)
			{
				Node obj = new Node();
				obj.pro = process;
				arrSchedule.add(obj);
			}
			else
			{
				i--;
				System.out.println("out of boundary please enter your process again...");
			}
		}

		System.out.print("please enter start point : ");
		Scanner Start = new Scanner(System.in);
		int start = Start.nextInt();

		while(start < boundaryS || start > boundaryE)
		{
			System.out.println("out of boundary please enter start point again...");
			Start = new Scanner(System.in);
			start = Start.nextInt();
		}

//		Node obj = new Node();
//		obj.pro = 98;
//		arrSchedule.add(obj);
//		obj = new Node();
//		obj.pro = 183;
//		arrSchedule.add(obj);
//		obj = new Node();
//		obj.pro = 37;
//		arrSchedule.add(obj);
//		obj = new Node();
//		obj.pro = 122;
//		arrSchedule.add(obj);
//		obj = new Node();
//		obj.pro = 14;
//		arrSchedule.add(obj);
//		obj = new Node();
//		obj.pro = 124;
//		arrSchedule.add(obj);
//		obj = new Node();
//		obj.pro = 65;
//		arrSchedule.add(obj);
//		obj = new Node();
//		obj.pro = 67;
//		arrSchedule.add(obj);
//
//		int start = 53;
//
//		int boundaryS = 0;
//		int boundaryE = 199;

		int dist = 0;
		FCFS obj1 = new FCFS();
		obj1.fcfs(arrSchedule, start, dist);
		System.out.println();
		
		SSTF obj2 = new SSTF();
		obj2.sstf(arrSchedule, start, dist);
		System.out.println();
		
		SCAN obj3 = new SCAN();
		obj3.scan(arrSchedule, start, dist, boundaryS);
		System.out.println();
		
		CSCAN obj4 = new CSCAN();
		obj4.cscan(arrSchedule, start, dist, boundaryS, boundaryE);
		System.out.println();
		
		
		Clook obj5 = new Clook();
		obj5.clook(arrSchedule, start, dist);
		System.out.println();
		
		Optimized obj6 = new Optimized();
		obj6.optimized(arrSchedule, start, dist);
		System.out.println();
	}
}
