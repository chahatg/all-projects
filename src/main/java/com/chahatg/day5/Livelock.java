package com.chahatg.day5;
//2.) Create a livelock problem and solution 


//using scenario where one person wants to 
//walk in through the door and the other wants to 
//walk out through the door. Both keep waiting for the other to walk first
public class Livelock {
	static final WantsToWalkOut personOut = new WantsToWalkOut();
	static final WantsToWalkIn personIn = new WantsToWalkIn();
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() { 
			public void run() {
				personOut.walkOut(personIn);
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				personIn.walkIn(personOut);
			}
		});
		
		t1.start();
		t2.start();
	}
}

class WantsToWalkOut { 
	private boolean walkedOut = false;
	/************* Livelock situation *************/
	public void walkOut(WantsToWalkIn personIn) {
		while(!personIn.hasWalkedIn()) {
			System.out.println("PersonOut: Waiting for other person to walk in");
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("PersonOut: I walked out.");
		walkedOut = true;
	
	}
	
	public boolean hasWalkedOut() {
		return this.walkedOut;
	}
}

class WantsToWalkIn {
	private boolean walkedIn = false;
	/************* Livelock situation ************
	public void walkIn(WantsToWalkOut personOut) {
		while(!personOut.hasWalkedOut()) {
			System.out.println("personIn: Waiting for other person to walk out");
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("personIn: I walked in.");
		walkedIn = true;
	}
	
	public boolean hasWalkedIn() {
		return this.walkedIn;
	}*/
	
	/************* Livelock situation Solution *************/
	public void walkIn(WantsToWalkOut personOut) {
		if(!personOut.hasWalkedOut()) {
			System.out.println("personIn: Thank you for letting me walk in!");
			System.out.println("personIn: I walked in.");
			walkedIn = true;
		}
	}
	
	public boolean hasWalkedIn() {
		return this.walkedIn;
	}

	
}

