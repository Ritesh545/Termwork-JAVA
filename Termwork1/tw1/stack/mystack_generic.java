package stack;
import java.util.*;
public class mystack_generic <E>
 {

    public  int top;
    public  E s[]; 

     public mystack_generic ()
     {
     top=-1;
     this.s =(E[]) new Object[4];
     }

       public int push (E item)
          {
            if(top>=3)
               {
                 return -1;
               }
            else
                {
                 this.s[++top]=item;
                 return 1;
  
                }
           }

    public E pop () 
     {
       if(top<0)
          {
          return null;
          }
          return s[top--];
      }


     }

 

