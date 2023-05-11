package game;
import java.util.ArrayList;
import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

public class moderator extends Observable implements Runnable{
	
	private static moderator m;
	public final int N = 2;
	public int mn=0;
	ArrayList<Integer> mlist=new ArrayList<>();
	private moderator(){
		System.out.println("Moderator Started");
	}
	public static synchronized moderator getInstance() {
		if(m==null)
			m=new moderator();
		return m;		
	}
	 synchronized int getno()
	{  System.out.print("Moderator Generated:");
	    mlist.add(ThreadLocalRandom.current().nextInt(0, 50 + 1));
	    return mlist.get(mlist.size()-1);
	 }
	@Override
	public void run() {

		while(mn<10&&play.gameover==0)
		{ System.out.println(m.getno());
	      setChanged();
	      play.a=mlist.get(mn);
	      notifyObservers();
	        
	    m.mn++;	
		try {  
		    Thread.sleep(1000);
			} catch(InterruptedException e) {}
		}
		play.gameover=1;
	}
}	
	