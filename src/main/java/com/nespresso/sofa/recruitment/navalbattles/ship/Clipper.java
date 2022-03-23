package com.nespresso.sofa.recruitment.navalbattles.ship;

public class Clipper extends Ship{

	private static final double SPEEDBONNUS = 0.2;

	public Clipper(int displacement, int mastsCount) {
		super(displacement, mastsCount);
		raceBehavior.addBonnus(SPEEDBONNUS);
	}

}
