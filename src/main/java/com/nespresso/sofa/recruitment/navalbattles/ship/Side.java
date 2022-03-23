package com.nespresso.sofa.recruitment.navalbattles.ship;

import java.util.Iterator;
import java.util.List;

public class Side {

	private List<Ship> ships;
	private boolean isWinner;
	
	public Side(List<Ship> ships) {
		this.ships = ships;
		calculateTeamBonnus(ships);
	}

	private static void calculateTeamBonnus(List<Ship> ships) {
		int aliveShipsCount=0;
		for (Ship ship : ships) {
			if(!ship.isDestroyed())
				aliveShipsCount++;
		}
		int extraShipsCount=aliveShipsCount-=1;
		for (Ship ship : ships) {
			ship.calculateTeamBonnus(extraShipsCount);
		}
	}

	public void performBattleWithShip(Ship otherSideShip) {
		Iterator<Ship> shipsIterator = ships.iterator();
		
		while (shipsIterator.hasNext()){
			Ship opponentShipToFight = shipsIterator.next();
			System.out.println("round");
			performRound(otherSideShip, opponentShipToFight);
			
			if (otherSideShip.isDestroyed()) {
				return;
			}
			calculateTeamBonnus(ships);
		}
		win();
	}


	private void performRound(Ship otherSideShip, Ship opponentShipToFight) {
		while (!otherSideShip.isDestroyed() && !opponentShipToFight.isDestroyed()) {
			System.out.println("attack");
			for (Ship opponentShip : ships) {
				opponentShip.attack(otherSideShip);
			}
			otherSideShip.attack(opponentShipToFight);
		}
	}
	
	public boolean isWinner() {
		return isWinner;
	}

	private void win() {
		isWinner=true;
	}
	public boolean contains(Ship shipToTest) {
		return ships.contains(shipToTest);
	}

	
}