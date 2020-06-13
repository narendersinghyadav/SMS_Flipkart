package com.flipkart.threadsolution;

class Table{  
	  
	 void printTable(int n){  
		 synchronized(this) {
	     for(int i=1;i<=5;i++){  
	      System.out.println(n*i);  
	      try{  
	       Thread.sleep(1000);  
	      }catch(Exception e){System.out.println(e);}  
	     }  
	  }  
	 }

	}  