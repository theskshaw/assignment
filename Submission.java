/* Created by Shashikant Shaw
   Date: 29-March-2019 Time: 23:45 IST
*/
import java.util.*;
class Student{
	String name;
	double marks;
	int token;
	int status;
}
class Submission{

	Student ob[];
	int served=0;
	public void main_work()
	{
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int i=0;
		ob=new Student[n];
		while(n-->0)
		{
			String s=sc.next();
			if(s.equals("ENTER"))
			{
				s=sc.next();
				double m=sc.nextDouble();
				int t=sc.nextInt();
				ob[i]=new Student();
				ob[i].name=s;
				ob[i].marks=m;
				ob[i].token=t;
				ob[i].status=0;
				arrange(i+1);
				
				i++;
			}
			else if(s.equals("SERVED"))
			{	

				for(int j=0;j<i;j++)
				{
					if(ob[j].status==0){
						ob[j].status=1;
						break;
					}
				}
			}
		}
		print(i);
	}
	public void arrange(int n)
	{	
		Student temp;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1-i;j++)
			{
				if(ob[j].marks<ob[j+1].marks)
				{
					temp=ob[j];
					ob[j]=ob[j+1];
					ob[j+1]=temp;
				}
				else if(ob[j].marks==ob[j+1].marks)
				{
					if((ob[j].name).compareTo(ob[j+1].name)>0)
					{
						temp=ob[j];
						ob[j]=ob[j+1];
						ob[j+1]=temp;
					}
					else if((ob[j].name).compareTo(ob[j+1].name)==0)
					{
						if(ob[j].token>ob[j+1].token)
						{
							temp=ob[j];
							ob[j]=ob[j+1];
							ob[j+1]=temp;
						}
					}
				}
			}
		}
	}
	public void print(int n)
	{
		for(int i=0;i<n;i++)
		{	
			if(ob[i].status==0)
			System.out.println(ob[i].name);
		}
	}
	public static void main(String args[])
	{
		Submission ob=new Submission();
		ob.main_work();
	}
}
