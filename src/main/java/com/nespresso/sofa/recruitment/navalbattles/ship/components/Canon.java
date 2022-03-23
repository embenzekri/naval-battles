package com.nespresso.sofa.recruitment.navalbattles.ship.components;

public class Canon {
	private boolean isDestroyed = false;
	private double hitPoints;

	public Canon() {
		hitPoints = 100;
	}

	public double takeDamages(double damages) {
		if (isDestroyed)
			return damages;

		double difference = damages - hitPoints;
		if (difference > 0) {
			isDestroyed = true;
			hitPoints = 0;
			return difference;
		} else {
			hitPoints -= damages;
			return 0;
		}
	}

	public boolean isDetroyed() {
		return isDestroyed;
	}

	public double getHitPoints() {
		return hitPoints;
	}
}
