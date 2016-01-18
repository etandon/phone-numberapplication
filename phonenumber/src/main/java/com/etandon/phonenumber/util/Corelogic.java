/**
 * 
 */
package com.etandon.phonenumber.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author eshantandon
 *
 */
public class Corelogic {

	/**
	 * @param args
	 */
	static final HashMap<Character,String> map = new HashMap<Character,String>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 5703978087672535195L;

	{
		put('0',"0");
		put('1',"1");
		put('2',"2ABC");
        put('3',"3DEF");
        put('4',"4GHI");
        put('5',"5JKL");
        put('6',"6MNO");
        put('7',"7PQRS");
        put('8',"8TUV");
        put('9',"9WXYZ");
    }} ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Corelogic testclass=new Corelogic();
        //System.out.println(testclass.findtotalCobmination("1"));
        //System.out.println(testclass.findtotalCobmination("5"));
        //System.out.println(testclass.findtotalCobmination("202"));
        //System.out.println(testclass.findtotalCobmination("9082749705"));
        //System.out.println(testclass.findtotalCobmination("9999999999"));
        //for(int i=0;i<26;i++){findNextChar((char) ('A'+i));}
        //for(int i=0;i<10;i++){findNextChar((char) ('0'+i));}
        String nextinput="ABCDEFG";
        //System.out.println(testclass.findNextWord("50L"));
        for(int i=0;i<100;i++)
           {
            nextinput=(testclass.findNextWord(nextinput));
            System.out.println(nextinput);
           }
	}
	
	public int findtotalCobmination(String input){
		int result=1;
		for(int i=0;i<input.length();i++)
		   {
			char letter=input.charAt(i);
			result=result*(map.get(letter).length());
		   }
		return result;
	}
	
	public ArrayList<String> findResultswithindex(String input,int startIndex,int endIndex)
	     {
		   ArrayList<String> result=new ArrayList<String>();
		   int[] currentIndex=new int[input.length()];
		   
		   return null;
	     }
	
	public String findNextWord(String input)
	    {
		  boolean carry=true;
		  int index=0;
		  int length=input.length();
		  StringBuilder outputBuilder = new StringBuilder(input);
		  while(carry)
		       {
			    char currentChar=input.charAt(length-1-index);
			    ArrayList<Object> nextCharFlag=findNextChar(currentChar);
			    outputBuilder.setCharAt(length-1-index,(char) nextCharFlag.get(0));
			    carry=(boolean) nextCharFlag.get(1);
			    index++;
		       }
		  return outputBuilder.toString(); 
 		
	    }
	public static ArrayList<Object> findNextChar(char input)
	    {
		   String inputString=Character.toString(input);
		   char outputChar = 0;
		   Boolean carry=false;
		   if(inputString.matches("[A-BD-EG-HJ-KM-NP-RT-UW-Y]"))
		   {
			   outputChar=(char) (inputString.charAt(0)+1);
		   }
		   else if(inputString.matches("[2-9]"))
		   {
			   if(input=='2') {outputChar='A';}
			   else if(input=='3') {outputChar='D';}
			   else if(input=='4') {outputChar='G';}
			   else if(input=='5') {outputChar='J';}
			   else if(input=='6') {outputChar='M';}
			   else if(input=='7') {outputChar='P';}
			   else if(input=='8') {outputChar='T';}
			   else if(input=='9') {outputChar='W';}
		   }
		   else if((input =='0') || (input=='1'))
		   {
			   carry=true;
			   outputChar=input;
		   }
		   else
		    {
			   carry=true;
			   if(input=='C') {outputChar='2';}
			   else if(input=='F') {outputChar='3';}
			   else if(input=='I') {outputChar='4';}
			   else if(input=='L') {outputChar='5';}
			   else if(input=='O') {outputChar='6';}
			   else if(input=='S') {outputChar='7';}
			   else if(input=='V') {outputChar='8';}
			   else if(input=='Z') {outputChar='9';}
		    }   
		   ArrayList<Object> results=new ArrayList<Object>();
		   results.add(outputChar);
		   results.add(carry);
		   //System.out.println(results.get(0));
		   //System.out.println(results.get(1));
		   return results;
	    }
	

}
