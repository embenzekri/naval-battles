package com.nespresso.sofa.recruitment.navalbattles;

import java.util.Arrays;
import java.util.List;

import com.nespresso.sofa.recruitment.navalbattles.ship.Ship;
import com.nespresso.sofa.recruitment.navalbattles.ship.Side;

public class Battle {

	private Ship firstSideShip;
	private Side opponentSide;

	public Battle side(Ship ship) {
		this.firstSideShip = ship;
		return this;
	}

	public Battle against(Ship... ships) {
		List<Ship> opponentSideShips = Arrays.asList(ships);
		opponentSide = new Side(opponentSideShips);
		opponentSide.performBattleWithShip(firstSideShip);
		return this;
	}

	public boolean isInTheWinningSide(Ship shipToTest) {
		if (opponentSide.isWinner()) {
			return firstSideShip.equals(shipToTest);
		} else
			return opponentSide.contains(shipToTest);
	}

}
