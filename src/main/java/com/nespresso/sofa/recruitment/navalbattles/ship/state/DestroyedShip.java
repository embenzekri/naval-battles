package com.nespresso.sofa.recruitment.navalbattles.ship.state;

import com.nespresso.sofa.recruitment.navalbattles.ship.Ship;

public class DestroyedShip implements ShipState {

	@Override
	public void attack(Ship ship, Ship opponentShipToFight) {

	}

	@Override
	public boolean isDestroyed() {
		return true;
	}

}
