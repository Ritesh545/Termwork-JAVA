import stack.*;
import java.util.Scanner;
public class TestDriver
  {
    public static void main(String [] args)
      {
       System.out.println("enter test case between 1 to 10");
   
  // for(;;)
      for (int j = 1; j <= 9; j++)    
        {
        mystack_generic <Integer> a1=new mystack_generic<Integer> ();
        mystack_generic <Double> a2=new mystack_generic<Double> ();
        mystack_generic <Character> a3=new mystack_generic<Character> ();
   
       // System.out.println("enter test case between 1 to 10");

       //     mystack s1=new mystack();
      //  Scanner sc=new Scanner(System.in);
      //  int choice=sc.nextInt();

         switch(j)
          {
           case 1: a1.push(10);
                   a1.push(20);
                   a1.push(30);
             int x=a1.push(40);
                    if (x == 1)
                         {
                        System.out.println ("TEST CASE 1 : PASSED");
                         }
                     else
                       {
                        System.out.println ("TEST CASE 1 : FAILED");
                       }                              
                   break;
            case 2:
                   a2.push(20.0);
                   a2.push(10.0);
                   a2.push(30.0);
              int y=a2.push(40.0);
                   if (y == 1)
                         {
                        System.out.println ("TEST CASE 2 : PASSED");
                         }
                     else
                       {
                        System.out.println ("TEST CASE 2 : FAILED");
                       }
                      break;
           case 3: a3.push('c');
                   a3.push('x');
                   a3.push('d');
             int z=a3.push('e');
                     if (z == 1)
                         {
                        System.out.println ("TEST CASE 3 : PASSED");
                         }
                     else
                       {
                        System.out.println ("TEST CASE 3 : FAILED");
                       }
                     break;
             case 8: System.exit(0);
                   break;


          }
    }
 }
}
                   
