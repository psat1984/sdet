package com.sdet.JavaActivity1;

public class Actitvity1_2 {
	public static void main(String[] args) {
	
		//Integer[] test= new Integer[] {10, 77, 10, 54, -11, 10};
		int[] test1 = {10, 77, 10, 54, -11, 10};
		int number=10;
		int addValue=30;
		int finalResult=addresult(test1,number,addValue);
		System.out.println("Result: " + finalResult);
	
	
	}
	
	private static int addresult(int[] test1,int number,int addValue) {
	int sumValue=0;
		for (int element : test1) {
		    if (element == number) {
		    	sumValue+=number;
		    	 if (sumValue == addValue) {
		                break;
		            }
		        
		    }
		}
		return sumValue;	
	}
	
}
