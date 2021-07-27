package test;

public class newConsequetive 
{
	public static void main(String[] args) {
		String str = "0101011011011";
		int len = str.length();
		char[] arr = str.toCharArray();
		int n=0;
		String str1 = "";
		String str2 = "";
		
		while(len>1)
		{
		if(str.contains("10"))
		{
			n = str.indexOf("10",0);
			System.out.println("Index of 10: "+n);
			str1= str.substring(0,n);
			str2 = str.substring(n+2);
			str = str1+str2;
			len = str.length();
			System.out.println("Modified str: " +str+ "its length "+len);
		}
		
		else if(str.contains("01"))
		{
			n= str.indexOf("01",0);
			str1= str.substring(0,n);
			str2 = str.substring(n+2);
			str = str1+str2;
			len = str.length();
		}
		else
			break;
		}
		
		System.out.println("Final length: "+len+" Final String "+str);
	}

}
