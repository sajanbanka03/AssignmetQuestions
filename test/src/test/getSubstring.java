package test;

public class getSubstring 
{
	public static void main(String[] args) {
		String str1 = "fulsome";
		String str2 = "wonderful";
		
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		String last = "";
		boolean flag = false;
		
		for(int i=0; i<ch1.length;i++)
		{
			for(int j=i; j<ch2.length;j++)
			{
				if(ch1[i]==ch2[j])
				{
					flag = true;
					last = last+String.valueOf(ch1[i]);
				}
			}
		}
		
		if(flag==true)
		{
			System.out.println("Substring is: "+last);
			System.out.println("Length of substring is: "+last.length());
		}
		else
		{
			System.out.println(false);
		}
	}
}
