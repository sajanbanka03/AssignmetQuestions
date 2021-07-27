package test;

public class removeConsecutive01 
{
	public static void main(String[] args) {
		String str = "111000";
		int len = str.length();
		char[] arr = str.toCharArray();
		
		while(len>2)
		{
			System.out.println("Inside while");
			for(int i=1;i<len;i++)
			{
				System.out.println("inside for");
				int t = str.indexOf("10", i);
				System.out.println(t);
				if((arr[i]=='0' && arr[i-1]=='1') || (arr[i]=='1'&& arr[i-1]=='0'))
				{
					System.out.println("Value of i"+ i);
					String s1 = str.substring(0,i-1);
					System.out.println("Substring 1 "+s1);
					String s2 = str.substring(i+1);
					System.out.println("Substring 2 "+s2);
					str=s1+s2;
					System.out.println("New string "+str);
				}
				else 
					i++;
			}
			len = str.length();
		}
		System.out.println("length of string is: "+ str.length()+ "for String "+str);
	}
}
