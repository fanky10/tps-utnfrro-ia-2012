package org.grupoia.main;

import java.util.ArrayList;
import java.util.List;

public class CombinationArray {
	// alternate implementation
	public static void comb2(String s) {
		comb2("", s);
	}

	private static void comb2(String prefix, String s) {
		System.out.println(prefix);
		for (int i = 0; i < s.length(); i++){
			String newPrefix = prefix + s.charAt(i);
			String newString = s.substring(i+1);
			comb2(newPrefix,newString);
		}
	}

	// read in N from command line, and print all subsets among N elements
//	public static void main(String[] args) {

//	}

	public static void combiString(List<String> string) {
		combiString(new ArrayList<String>(), string);
	}

	public static void combiString(List<String> prefix, List<String> string) {
		System.out.println(prefix);
		for (int i = 0; i < string.size(); i++) {
			//to the prefix list add the current element
			prefix.add(string.get(i));
			//recursive call
			List<String> newList = string.subList(i+1, string.size()); 
			combiString(prefix,newList);
		}
	}
	public static void main(String args[]){
		oldSkull();
		System.out.println("Fin del oldSkull");
		newWay();
		System.out.println("Fin del newWay");
		
	}
	private static void newWay(){
		List<String> elements = new ArrayList<String>();
		elements.add("a");
		elements.add("b");
		elements.add("c");
		combiString(elements);
	}
	private static void oldSkull(){
		int N = 3;// Integer.parseInt(args[0]);
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String elements = alphabet.substring(0, N);

		System.out.println("nuestra super implementacion!");

		comb2(elements);
		System.out.println();
	}

}
