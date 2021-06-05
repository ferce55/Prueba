

import java.util.Random;

public class Fighter extends Thread {
	private int initialLifePoints;
	private int maxHitPower;
	private int hitDelay;
	private int oppositeCorner;
	private int myCorner;
	private Fight fight;
	public String fighterName;

	public Fighter(String fighterName, int initialLifePoints, int maxHitPower, int hitDelay) {
		if (initialLifePoints >= 1 && initialLifePoints <= 100) {
			if (maxHitPower >= 1 && maxHitPower <= 10) {
				if (hitDelay >= 50 && hitDelay <= 200) {
					this.initialLifePoints = initialLifePoints;
					this.maxHitPower = maxHitPower;
					this.hitDelay = hitDelay;
					this.fighterName = fighterName;
				} else {
					System.out.println("el tiempo de descanso debe estar entre 50 y 200");
				}
			} else {
				System.out.println("la potencia de golpe debe estar entre 1 y 10");
			}
		} else {
			System.out.println("la vida del luchador debe estar entre 1 y 100");
		}

	}

	public void joinFight(Fight fight, int myCorner, int oppositeCorner) {
		this.fight = fight;
		this.myCorner = myCorner;
		this.oppositeCorner = oppositeCorner;
		fight.addFighter(this);
	}

	public synchronized void run() {
		while (!fight.hasFinished()) {
			fight.hit(myCorner, getHitPower(), oppositeCorner);
			try {
				sleep(hitDelay);
			} catch (InterruptedException e) {
			}
		}
		fight.fin();
		System.exit(0);

	}

	public int getInitialLifePoints() {
		return initialLifePoints;
	}

	public int getMyCorner() {
		return myCorner;
	}

	private int getHitPower() {
		Random rnd = new Random();
		int golpe = (int) (rnd.nextDouble() * maxHitPower + 1);
		return golpe;
	}

}
