package com.nespresso.sofa.recruitment.navalbattles;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


// 18h10
public class RaceTest {

    // Speed of a ship is its displacement divided by number of mast: the lower the value, the faster the ship
    @Test
    public void fastestShouldWin() {  //18h16

        Ship a = new Ship(20000, 2);
        Ship b = new Ship(7500, 1);

        Race race = new Race(a, b);
        assertThat(race.winner()).isEqualTo(b);
    }

    // a clipper goes 20% faster than a standard ship.
    @Test
    public void clipperGoesFaster() { // 18h 24

        Ship a = new Ship(20000, 2);
        Ship b = new Ship(7500, 1);
        Clipper c = new Clipper(18000, 2);

        Race race = new Race(a, b, c);
        assertThat(race.winner()).isEqualTo(c);
    }


    // any ship can carry cannons, each cannons grant 0.5% cumulative penalty to speed
    @Test
    public void armedShipAreUsuallySlower() { // 18h30

        Ship a = new Ship(7800, 1, 16);
        Ship b = new Ship(8000, 1);

        Race race = new Race(a, b);
        assertThat(race.winner()).isEqualTo(b);
    }




}
