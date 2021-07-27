package test;

public class removeDigitsfromString 
{
	public static void main(String[] args) {
		String str = "12abctr43i";
		String strNew = "";
		for(int i=0; i<str.length();i++)
		{
			if(!Character.isDigit(str.charAt(i)))
			{
				strNew = strNew+str.charAt(i);
			}
		}
		
		System.out.println("New String After removing digits: "+strNew);
	}
}
