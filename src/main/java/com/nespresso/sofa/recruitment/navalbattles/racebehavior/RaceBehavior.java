package com.nespresso.sofa.recruitment.navalbattles.racebehavior;

import com.nespresso.sofa.recruitment.navalbattles.ship.Ship;

public interface RaceBehavior {
	Ship returnRaceWinner(Ship firstShip, Ship secondShip);

	double getSpeed();

	void addCanonsCountMalus(double canonsCount);

	void addBonnus(double bonnus);
}
