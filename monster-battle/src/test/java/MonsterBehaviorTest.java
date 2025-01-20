import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonsterBehaviorTest {
    // Testlerin başlangıcında kullanılacak canavarlar, battle manager, game state ve monster pool tanımları
    private Monster goblin, dragon, elf, grayWolf;
    private BattleManager battleManager;
    private GameState gameState;

    @BeforeEach
    public void setup() {
        // Her testten önce çağrılan metot; canavarları, battle manager'ı, game state'i ve monster pool'u başlatır
        goblin = new Goblin();
        dragon = new Dragon();
        elf = new Elf();
        grayWolf = new GrayWolf();
        battleManager = new BattleManager();
        gameState = GameState.getInstance();
        gameState.resetScore(); // Reset score before each test
    }

    // Test Suite 1: Canavar Davranışları
    @ParameterizedTest
    @CsvSource({
            "Goblin, 30, 5",
            "Dragon, 50, 10",
            "Elf, 40, 7",
            "GrayWolf, 100, 20"
    })
    public void testParameterizedMonsterAttributes(String monsterType, int expectedHealth, int expectedAttackPower) {
        Monster monster = MonsterFactory.createMonster(monsterType);

        assertEquals(expectedHealth, monster.getHealth(), monsterType + "'s health should match the expected value.");
        assertEquals(expectedAttackPower, monster.getAttackPower(), monsterType + "'s attack power should match the expected value.");
    }

    @Test
    public void testBattleVictory() {
        // Bir canavarın savaş sonucunda yenilip yenilmediğini kontrol eder.
        battleManager.battle(goblin, dragon);
        assertTrue(dragon.getHealth() <= 0 || goblin.getHealth() <= 0, "One monster should be defeated after battle.");
    }

    @Test
    public void testMonsterAttackReducesHealth() {
        // Canavarların birbirine saldırdığında sağlıklarının nasıl etkilendiğini test eder.
        Monster goblin = new Goblin();
        Monster dragon = new Dragon();

        assertEquals(50, dragon.getHealth(), "Dragon's initial health should be 50.");

        goblin.attack(dragon);

        // Goblin'in saldırı gücü 5 olduğuna göre, Dragon'un sağlığı 45 olmalı
        assertEquals(45, dragon.getHealth(), "Dragon's health should be reduced by Goblin's attack.");
    }

    @Test
    public void testHealthNotBelowZero() {
        Monster goblin = new Goblin();
        goblin.takeDamage(50); // Goblin'in sağlığı 30, 50 hasar alırsa sağlık 0'dan az olamaz
        assertEquals(0, goblin.getHealth(), "Goblin's health should not go below zero.");
    }




}
