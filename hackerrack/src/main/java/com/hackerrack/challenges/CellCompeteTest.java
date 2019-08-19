package com.hackerrack.challenges;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CellCompeteTest {

	public static void main(String[] args) {
		// eight cells - array of int
		//1 = true; 0 = false
		int[] states = {1, 0,0,0,0,1,0,0};
		int days = 3;
		System.out.println(cellCompete(states,days));
		
	}

	 public static List<Integer> cellCompete(int[] states, int days) {
		 List<Integer> intList = IntStream.of(states).boxed().collect( Collectors.toList() );			
			
		 if(states.length !=8 || days <1) {
			 return intList;
		 }
		 
		 int index, previousValue, nextValue;
		 
		 for(int i =0; i<days; i++) {
			 index = 0;
			 previousValue = 0;
			 nextValue = 0; 
			 
			 //for each cell
			 while(index < states.length) {
				 //check for nextValue
				 //case 1: current calue != last index 
				 if(index < states.length - 1) {
					 nextValue = states[index+1];
				 } else if(index == states.length - 1) {
					 nextValue = 0;
				 }
				 
				 //when nextValue == previous Value
				 //save the curr state and change the state
				 if(nextValue == previousValue) {
					 previousValue = states[index];
					 states[index] = 0;
				 }else {
					 previousValue = states[index];
					 states[index] = 1;
				 }
				 index++;
			 }
		 }
		 intList = IntStream.of(states).boxed().collect( Collectors.toList() );			
		 
		return intList;
		 
	 }
}
