package com.nespresso.sofa.recruitment.navalbattles.ship.state;

import com.nespresso.sofa.recruitment.navalbattles.ship.Ship;

public interface ShipState {

	void attack(Ship ship, Ship opponentShipToFight);

	boolean isDestroyed();

}
