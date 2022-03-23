package com.nespresso.sofa.recruitment.navalbattles.racebehavior;

import com.nespresso.sofa.recruitment.navalbattles.ship.Ship;

public class DispacementAndMastsRaceBehavior implements RaceBehavior {
	private double speed;

	public DispacementAndMastsRaceBehavior(int displacement, int mastsCount) {
		speed = displacement / mastsCount;
	}

	@Override
	public Ship returnRaceWinner(Ship firstShip, Ship secondShip) {
		if (firstShip.getSpeed() > secondShip.getSpeed())
			return secondShip;
		return firstShip;
	}

	@Override
	public void addCanonsCountMalus(double canonsCount) {
		double speedPenalty = speed * 0.5;
		speed = speed + (canonsCount * speedPenalty);
	}

	public double getSpeed() {
		return speed;
	}

	@Override
	public void addBonnus(double bonnus) {
		double calculatedSpeedBonnus = speed * bonnus;
		speed = speed - calculatedSpeedBonnus;

	}

}
