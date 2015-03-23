package com.nespresso.sofa.recruitment.navalbattles;

import org.junit.Test;

import static com.nespresso.sofa.recruitment.navalbattles.Battle.LOCALIZED_DAMAGES;
import static org.assertj.core.api.Assertions.assertThat;

public class BattleTest {


    // each ship has :
    // hull has 1 hit point per ton of displacement
    // 100 hit point per canon
    // 1000 hit point per mast

    // each canon does 200hp damage

    // this is a global fight, damages are not localized, nor impact dynamically ship statistics
    // fight last until one side is sunk

    @Test
    public void fight() {
        Ship a = new Ship(7500, 1, 16);
        Ship b = new Ship(10000, 1, 16);

        Battle battle = new Battle().side(a).against(b);
        assertThat(battle.isInTheWinningSide(b)).isTrue();
    }

    // when the battle is not even in terms of number of ship
    // each ship of the outnumbering team gains an 15 % bonus to it's damages
    // each ship always target the same opponent until it's sunk (once sunk it can not participate to the fight anymore)

    @Test
    public void packfight() {
        Ship a = new Ship(60000, 3, 64);
        Ship b = new Ship(15000, 1, 16);
        Ship c = new Ship(15000, 1, 16);
        Ship d = new Ship(15000, 1, 16);

        Battle battle = new Battle().side(a).against(b, c, d);
        assertThat(battle.isInTheWinningSide(b)).isTrue();
    }


    // damages are now localized and a applied in this order :
    // first mast are destroyed, then cannon, then the hull
    // destroyed part of the ship changes it's characteristics :
    // a destroyed mast reduce overall ship speed
    // a destroyed canon can not fire anymore thus it's ship does less damages
    // a full destroyed hull means the ship has sunk

    @Test
    public void fightWithLocalizedDamages() {
        Ship a = new Ship(7500, 1, 16);
        Ship b = new Ship(10000, 1, 16);

        Battle battle = new Battle(LOCALIZED_DAMAGES).side(a).against(b);
        assertThat(battle.isInTheWinningSide(b)).isTrue();
    }


    // if a ship speed is 50% higher that it's target it can shoot twice each rounds

    @Test
    public void fightWithLocalizedDamagesAndSpeed() {
        Ship a = new Ship(7500, 3, 16);
        Ship b = new Ship(10000, 1, 16);

        Battle battle = new Battle(LOCALIZED_DAMAGES).side(a).against(b);
        assertThat(battle.isInTheWinningSide(a)).isTrue();
    }


}