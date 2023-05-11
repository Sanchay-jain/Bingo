package game;

import java.util.Arrays;

public class play {
	 static int[] w=new int[10];
	 static int a;
		static int gameover=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		moderator m=moderator.getInstance();		
		int i,j;
	 player p[]=new player[m.N];
	 for(i=0;i<m.N;i++)
	 { p[i]=new player(m, i+1);
	 }
	 Arrays.fill(w,0);
	 Thread t= new Thread(m);
	 t.start();
	 Thread[] tp=new Thread[m.N];
	 for(i=0;i<m.N;i++)
	 {  tp[i]=new Thread(p[i]);
		 tp[i].start();
	 }
   
	
	 while(play.gameover==0)
		 try { Thread.sleep(400); 
		     }catch(InterruptedException e) {}
	 for(i=0;i<m.N;i++)
				{
				  if(w[i]==1)
				  { for(j=0;j<m.N;j++)
					  System.out.println("Player "+(j+1)+" matches: "+ p[j].getfound());
					  System.out.println("Player "+(i+1)+" wins");	   	      
				    System.exit(0);
				  } 
				}	
	 for(j=0;j<m.N;j++)
		  System.out.println("Player "+(j+1)+" matches "+ p[j].getfound());
	System.out.println("Nobody won");
}
}