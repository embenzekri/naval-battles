package com.nespresso.sofa.recruitment.navalbattles.ship.state;

import com.nespresso.sofa.recruitment.navalbattles.ship.Ship;

public class AliveShip implements ShipState {


	
	@Override
	public void attack(Ship ship, Ship opponentShipToFight) {
		opponentShipToFight.takeDamagesFrom(ship); 
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}

}
