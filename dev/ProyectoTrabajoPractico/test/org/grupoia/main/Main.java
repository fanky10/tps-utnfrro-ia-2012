package org.grupoia.main;

import java.util.List;
import java.util.ArrayList;

public class Main {
	//inicio del superproyecto!!
	
	public static void main(String args[]){
		List<String> capitales = new ArrayList<String>();
		capitales.add("Roma");
		capitales.add("Paris");
		capitales.add("Tokyo");
		capitales.add("Londres");
		
		
	}
}


//dead code :DD
//String[][] array = new String[24][4];//capitales.size()][];

//for(int j=0;j<4;j++){
//	int valInf = 6*j;
//	int valSup = valInf+6;//c/seis. array
////	System.out.println("valInf: "+valInf+" valSup: "+valSup);
//	for(int i=valInf;i<valSup;i++){
//		array[i][0] = capitales.get(j);
////		System.out.print(capitales.get(j)+"\t");
////		System.out.println("");
//		for(int k=0;k<3;k++){
//			int linf = 2*k;
//			int lsup = linf+2;
//			for(int w=linf;w<lsup;w++){
//				array[w][1] = capitales.get(k+1);
////				System.out.print(capitales.get(j)+"\t");
////				System.out.println("");
//			}
//		}
//		
//	}
//	System.out.print("\n");
//	for(int i=valInf;i<valSup;i++){
//		array[i][0] = capitales.get(j+1);
//		System.out.print(capitales.get(j+1)+"\t");
//	}
//	System.out.print("\n");
//}
//for(int i=0;i<array.length;i++){
//	for(int x=0;x<array[i].length;x++){
//		System.out.print(array[i][x]+"\t");
//	}
//	System.out.print("\n");
//}