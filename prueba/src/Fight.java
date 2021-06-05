

public class Fight {
	int[] livePoints = new int[2];
	private boolean finished;
	private String[] fighterNames = new String[2];

	public Fight() {
	}

	public synchronized boolean hasFinished() {
		if (livePoints[0] <= 0 || livePoints[1] <= 0) {
			finished = true;
		}
		return finished;
	}

	public synchronized boolean hit(int puncherIndex, int hitPower, int casterIndex) {
		livePoints[casterIndex] = livePoints[casterIndex] - hitPower;

		System.out.println("==================================================================");
		if (hitPower > 0) {
			System.out.println(fighterNames[puncherIndex] + " Ha golpeado a " + fighterNames[casterIndex]
					+ " y le ha hecho un daño de: " + hitPower);
		} else if (hitPower <= 0) {

			System.out.println(fighterNames[puncherIndex] + " Ha fallado el golpe contra " + fighterNames[casterIndex]);
		}
		System.out.print("Vidas Restantes: ");
		System.out.print(fighterNames[puncherIndex] + " " + livePoints[puncherIndex] + " ");
		System.out.println(fighterNames[casterIndex] + " " + livePoints[casterIndex]);
		System.out.println("==================================================================");

		return hasFinished();

	}

	public void addFighter(Fighter fighter) {
		livePoints[fighter.getMyCorner()] = fighter.getInitialLifePoints();
		fighterNames[fighter.getMyCorner()] = fighter.fighterName;
	}

	public void fin() {
		System.out.println("El combate ha acabado, el ganador es: ");
		if (livePoints[0] > 0) {
			System.out.println(fighterNames[0] + " Con una vida de: " + livePoints[0]);
		} else {
			System.out.println(fighterNames[1] + " Con una vida de: " + livePoints[1]);

		}

	}

}
