package test;

import java.util.HashMap;
import java.util.Map;

public class getCharCount {
	public static void main(String[] args) {
		String str = "templesample";
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		char[] chr = str.toCharArray();
		for(Character c : chr)
		{
			if(!map.containsKey(c))
			{
				map.put(c, 1);
			}
			else
				map.put(c, (map.get(c))+1);
		}
		
		for(Map.Entry<Character, Integer> entry: map.entrySet())
		{
			System.out.println("Character: "+entry.getKey() + " count: "+entry.getValue());
		}
	}

}
