package com.nespresso.sofa.recruitment.navalbattles;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.nespresso.sofa.recruitment.navalbattles.ship.Ship;

public class Race {

	private List<Ship> ships;

	public Race(Ship... ships) {
		paseShips(ships);
	}

	private void paseShips(Ship... ships) {
		this.ships = Arrays.asList(ships);
	}

	public Ship winner() {
		Iterator<Ship> shipsIterator = ships.iterator();
		Ship winner = shipsIterator.next();
		while (shipsIterator.hasNext()) {
			Ship ship = (Ship) shipsIterator.next();
			winner = ship.returnRaceWinner(winner);
		}
		return winner;
	}

}
