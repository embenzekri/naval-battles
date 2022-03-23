package com.nespresso.sofa.recruitment.navalbattles.attackbehavior;

import com.nespresso.sofa.recruitment.navalbattles.ship.components.Canon;

public class LocalizedAttackBehavior extends AttackBehavior {

	public LocalizedAttackBehavior(int dispacementsCount, int mastsCount,
			int canonsCount) {
		super(dispacementsCount, mastsCount, canonsCount);
	}

	@Override
	protected double calculateDamages() {
		int aliveCanonsCount = calculateAliveCanonsCount();
		return aliveCanonsCount * CANON_DAMAGES_BONNUS;
	}

	private int calculateAliveCanonsCount() {
		int aliveCanonCount = 0;
		for (Canon canon : canons) {
			if (!canon.isDetroyed())
				aliveCanonCount++;
		}
		return aliveCanonCount;
	}
	
}
