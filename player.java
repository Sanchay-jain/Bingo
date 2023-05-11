package game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ThreadLocalRandom;

public class player implements Runnable,Observer{
	Observable o;
	int reset=0;
	ArrayList<Integer> card = new ArrayList<>();
	private int id;
	private int found;
	int i=0;
	player(Observable o,int id)
 {   this.o=o;
    o.addObserver(this);
		i=0;
 	 found=0;
 	this.id=id;
     System.out.println("Player card "+this.id);   
	  for(i=0;i<10;i++)
	     card.add(ThreadLocalRandom.current().nextInt(0, 50 + 1));
	  System.out.println(card);   
 }
	
	boolean checkno(int g)
	{   if(card.contains(g))
	      { i=card.indexOf(g);
	       card.remove(i);
	       found++;
	       return true;
	      }
	    return false;
	}
	int getfound()
	{ return found;
	}
	@Override
	public void run() {
		
		while(play.gameover==0)
	       { while(reset==0)
		 {try { 
			   Thread.sleep(100);
			 
		      }catch(InterruptedException e) {}
	}		  
		   if(checkno(play.a))
			    if(found==3)
			   	{ play.w[this.id-1]=1;
			   	  play.gameover=1;
			   	}
			  reset=0;  
			  
	}
	}

	@Override
	public void update(Observable ob, Object g) {		
		this.reset=1;	 
}
}
