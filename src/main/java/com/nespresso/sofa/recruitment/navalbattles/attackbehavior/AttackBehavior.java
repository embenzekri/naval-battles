package com.nespresso.sofa.recruitment.navalbattles.attackbehavior;

import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.List;

import com.nespresso.sofa.recruitment.navalbattles.ship.Ship;
import com.nespresso.sofa.recruitment.navalbattles.ship.components.Canon;

public abstract class AttackBehavior {

	protected static final double DAMAGESBONNUS = 0.15;
	private double displacementPoints;
	private double mastsPoints;
	private double baseDamages;
	private double teamBonnus;
	private List<Canon> canons;

	public AttackBehavior(int dispacementsCount, int mastsCount, int canonsCount) {
		canons = createCanons(canonsCount);
		displacementPoints = calculateDispacementsHitPoints(dispacementsCount);
		mastsPoints = calculateMastsHitPoints(mastsCount);
		baseDamages = calculateDamages(canonsCount);
	}

	private static List<Canon> createCanons(int canonsCount) {
		List<Canon> canons = new ArrayList<Canon>();
		for (int i = 0; i < canonsCount; i++) {
			canons.add(new Canon());
		}
		return canons;
	}

	private double calculateDispacementsHitPoints(int dispacementsCount) {
		return displacementPoints = dispacementsCount;
	}

	private double calculateMastsHitPoints(int mastsCount) {
		return mastsPoints = mastsCount * 1000;
	}

	private double calculateDamages(int canonsCount) {
		return canonsCount * 200;
	}
	public void takeDamages(Ship attacker,Ship adversary) {
		double damages = adversary.getRealDamages();
		if (mastsPoints > 0) {
			damages = damages - mastsPoints;
		}
		if (damages > 0) {
			mastsPoints = 0;
			for (Canon canon : canons) {
				damages = canon.takeDamages(damages);
			}
		} else {
			mastsPoints = abs(damages);
		}
		if (damages > 0) {
			double baseDamages = damages;
			damages = damages - displacementPoints;
			if (damages > 0)
				displacementPoints = 0;
			else
				displacementPoints = displacementPoints - baseDamages;
		}
		testIfDestroyed(attacker);
	}

	private void testIfDestroyed(Ship ship) {
		double hitPoints = displacementPoints;
		for (Canon canon : canons) {
			hitPoints += canon.getHitPoints();
		}
		hitPoints += mastsPoints;
		if (hitPoints == 0)
			ship.destroy();
	}

	public double getRealDamages() {
		return baseDamages + teamBonnus;
	}

	public void calculateTeamBonnus(int extraShipsCount) {
		double calculatedDamagesBonnus = baseDamages * DAMAGESBONNUS;
		teamBonnus = calculatedDamagesBonnus * extraShipsCount;		
	}

}
