

public class Main {
	private static String fighter1_name = "Rocky";
	private static int fighter1_lifePoints = 100;
	private static int fighter1_maxHitPower = 10;
	private static int fighter1_hitDelay = 100;
	private static String fighter2_name = "Apollo";
	private static int fighter2_lifePoints = 90;
	private static int fighter2_maxHitPower = 9;
	private static int fighter2_hitDelay = 90;

	public static void main(String[] args) {
		Fighter f1 = new Fighter(fighter1_name, fighter1_lifePoints, fighter1_maxHitPower, fighter1_hitDelay);
		Fighter f2 = new Fighter(fighter2_name, fighter2_lifePoints, fighter2_maxHitPower, fighter2_hitDelay);
		Fight fight = new Fight();
		f1.joinFight(fight, 0, 1);
		f2.joinFight(fight, 1, 0);
		f1.start();
		f2.start();
	}
}