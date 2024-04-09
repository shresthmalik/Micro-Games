/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shresth2020;

import java.util.*;
/**
 *
 * @author ASUSJI
 */
public class CalendarClass {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int[][] c1 = new int[6][13];
        
        c1[1][1]  = 3; c1[1][2]  = 0;	c1[1][3]  = 3;	c1[1][4]  = 2;	c1[1][5]  = 3;	c1[1][6]  = 2;	c1[1][7]  = 3;	c1[1][8]  = 3;	c1[1][9]  = 2;	c1[1][10] = 3;	c1[1][11] = 2;	c1[1][12] = 3;
        c1[0][1]  = 3; c1[0][2]  = 1;	c1[0][3]  = 3;	c1[0][4]  = 2;	c1[0][5]  = 3;	c1[0][6]  = 2;	c1[0][7]  = 3;	c1[0][8]  = 3;	c1[0][9]  = 2;	c1[0][10] = 3;	c1[0][11] = 2;	c1[0][12] = 3;
	
        for(int i=1;i<=12;++i){
            c1[2][i] = c1[1][i];
            c1[3][i] = c1[1][i];
        }
        
    int[][] c2 = new int[100001][13];
		
    c1[0][12] = 3;
    c2[0][12] = 3;
        
    for(int i=1;i<=1751;++i) {
			
	for(int j=1;j<=12;++j) {
				
            if(j==1){
                c2[i][j] = ( c2[i-1][12] + c1[(i-1)%4][12] )%7 ; 	
            }else if(j>=2 && j<=12) {
		c2[i][j] = ( c2[i][j-1] + c1[i%4][j-1] )%7 ;
            }else System.out.println("Invalid Month1");
	}
    }
    
    {int i = 1752;			
        for(int j=1;j<=12;++j) {	//loop for calculating c2 on 1752
			
	if(j==1){
                c2[i][j] = ( c2[i-1][12] + c1[(i-1)%4][12] )%7 ; 	
	}else if(j>1 && j<=8) {
                c2[i][j] = ( c2[i][j-1] + c1[i%4][j-1] )%7 ;
	}else if(j==9) {
        	c2[1752][9]	= 9;
	}else if (j==10)     c2[1752][10] = 0;
	else if (j>10 && j<=12) {
        	c2[i][j] = ( c2[i][j-1] + c1[i%4][j-1] )%7 ;
	}
	else     System.out.println("Invalid Month2");
	}
    }
		
    for(int i=1753;i<=100000;++i) {		//loop for calculating c2 after 1752
			
	if(i%100==0 && i%400!=0) {
           
            for(int j=1;j<=12;++j) {
											//Imagine i = 1800
		if(j==1){
			c2[i][j] = ( c2[i-1][12] + c1[(i-1)%4][12] )%7 ;
		}else if(j==2 || (j>=4 && j<=12)) {
			c2[i][j] = ( c2[i][j-1] + c1[i%4][j-1] )%7 ;  	
		}else if(j==3) {
			c2[i][j] = ( c2[i][j-1] + c1[i%4][j-1] - 1)%7 ;
		}else System.out.println("Invalid Month3");
            }
	}else			
            
            for(int j=1;j<=12;++j) {
				
		if(j==1){
                	c2[i][j] = ( c2[i-1][12] + c1[(i-1)%4][12] )%7 ; 
		}else if(j>1 && j<=12) {
                        c2[i][j] = ( c2[i][j-1] + c1[i%4][j-1] )%7 ;
		}else System.out.println("Invalid Month4");
            }
    }
    
    System.out.println("Enter Year: ");
	int year = scan.nextInt();
		
    System.out.println("Enter Month: ");
	int month = scan.nextInt();
	
 /*   System.out.println("Enter Date: ");    
        int date = scan.nextInt();
 */       

    int C1, C2=0;     
    C1 = c1[year%4][month];
    C2 = c2[year][month];
    int C = 10*C1 + C2;
    
    System.out.println('\n'+"Month code is "+C+'\n');
    
    String[] w = new String[8];
    w[1] = "MON";   w[2] = "TUE";   w[3] = "WED";   w[4] = "THU";   w[5] = "FRI";   w[6] = "SAT";   w[7] = "SUN";	
		
    if(C2!=9) {
	for(int i=1, j=1, l=1;i<=28+C1;){				//loop for showing calendar
            for(int k=1;k<=7 && i<=28+C1;++k) {
	
                if(l<=7){System.out.print(" " + w[l]);	++l;}
		else if(j<C2) { System.out.print("    ");
					++j;}
		else {  if(i<10)	System.out.print("   "+i);
                        else if( i>=10)  	System.out.print("  "+i);
                        ++i;
		}
            }
	System.out.println();
	}
    }else {
        C2 = C2%7;
	for(int i=1, j=1, l=1;i<=28+C1;){				//loop for showing calendar
            for(int k=1;k<=7 && i<=28+C1;++k) {
	
                if(l<=7){System.out.print(" " + w[l]);	++l;}
		else if(j<C2) { System.out.print("    ");
				++j; }
		else {  if(i<=2)	System.out.print("   "+i);
			if(i==3)	i=14;
			if(i>=10)	System.out.print("  "+i);
			++i;
                    }
            }
	System.out.println();
												
	}
    }
    }

}
