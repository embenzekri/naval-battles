package com.nespresso.sofa.recruitment.navalbattles.ship;

import com.nespresso.sofa.recruitment.navalbattles.attackbehavior.AttackBehavior;
import com.nespresso.sofa.recruitment.navalbattles.attackbehavior.DelocalizedAttackBehavior;
import com.nespresso.sofa.recruitment.navalbattles.racebehavior.DispacementAndMastsRaceBehavior;
import com.nespresso.sofa.recruitment.navalbattles.racebehavior.RaceBehavior;
import com.nespresso.sofa.recruitment.navalbattles.ship.state.AliveShip;
import com.nespresso.sofa.recruitment.navalbattles.ship.state.DestroyedShip;
import com.nespresso.sofa.recruitment.navalbattles.ship.state.ShipState;

public class Ship {

	protected static final double SPEEDBONNUS = 0.5;

	protected RaceBehavior raceBehavior;
	protected AttackBehavior attackBehavior;
	protected ShipState shipState;

	public Ship(int displacement, int mastsCount) {
		raceBehavior = new DispacementAndMastsRaceBehavior(displacement,
				mastsCount);
	}

	public Ship(int dispacementsCount, int mastsCount, int canonsCount) {
		this(dispacementsCount, mastsCount);
		raceBehavior.addCanonsCountMalus(canonsCount);
		shipState = new AliveShip();
		attackBehavior = new DelocalizedAttackBehavior(dispacementsCount,
				mastsCount, canonsCount);
	}

	public Ship returnRaceWinner(Ship secondShip) {
		return raceBehavior.returnRaceWinner(this, secondShip);
	}

	public Ship returnBattleWinner(Ship opponentSide) {
		while (!isDestroyed() && !opponentSide.isDestroyed()) {
			takeDamagesFrom(opponentSide);
			opponentSide.takeDamagesFrom(this);
		}
		return isDestroyed() ? opponentSide : this;
	}

	public void takeDamagesFrom(Ship fromShip) {
		attackBehavior.takeDamages(this, fromShip);
	}

	public void calculateTeamBonnus(int extraShipsCount) {
		attackBehavior.calculateTeamBonnus(extraShipsCount);
		
	}

	public void attack(Ship opponentShipToFight) {
		shipState.attack(this, opponentShipToFight);
	}

	public boolean isDestroyed() {
		return shipState.isDestroyed();
	}

	public double getSpeed() {
		return raceBehavior.getSpeed();
	}

	public double getRealDamages() {
		return attackBehavior.getRealDamages();
	}

	public void destroy() {
		this.shipState = new DestroyedShip();
	}

}
