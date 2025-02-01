package fr.esiea.inf3132tp2024.view.play.start;

import fr.esiea.inf3132tp2024.controller.AppSettings;
import fr.esiea.inf3132tp2024.controller.AttackManager;
import fr.esiea.inf3132tp2024.controller.MonstreManager;
import fr.esiea.inf3132tp2024.model.Game;
import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.attack.file.AttackFactory;
import fr.esiea.inf3132tp2024.model.attack.file.AttackTemplate;
import fr.esiea.inf3132tp2024.model.consumable.Consumable;
import fr.esiea.inf3132tp2024.model.consumable.ConsumableGen;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.file.GlobalMonsterFactory;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.api.common.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.terminal.dialog.TInfoDialog;
import fr.esiea.inf3132tp2024.view.main.menu.MainMenu;
import fr.esiea.inf3132tp2024.view.play.chooseMonster.ChooseMonsterView;
import fr.esiea.inf3132tp2024.view.play.game.GameView;

import java.util.ArrayList;
import java.util.Random;

public class OkButton extends TButton {
    private static final String[] randomPseudos = new String[]{"Aloy", "Joel", "Ellie", "Kratos", "Masterchief", "Sam Porter Bridges", "Claire Redfield", "Ada Wong", "Shepard", "Mason", "Capitaine Price", "Steve", "Conor", "Amicia", "Ezio", "Chell", "Tina", "Jesse Faden", "Carl Johnson", "Ulfric Sombrage", "Aerith", "Tifa", "Yuna", "Trevor", "Claudette", "Lara Croft", "Nancy", "Eleven", "Nathan Drake", "Peter Parker"};

    private final MainMenu mainMenu;
    private final PlayMenu playMenu;
    private ArrayList<MonsterTemplate> listMonstrePlayerOne;
    private ArrayList<MonsterTemplate> listMonstrePlayerTwo;

    public OkButton(MainMenu mainMenu, PlayMenu playMenu, ArrayList<MonsterTemplate> listMonstrePlayerOne, ArrayList<MonsterTemplate> listMonstrePlayerTwo) {
        super("Lancer la partie");
        this.mainMenu = mainMenu;
        this.playMenu = playMenu;
        this.listMonstrePlayerOne = listMonstrePlayerOne;
        this.listMonstrePlayerTwo = listMonstrePlayerTwo;
    }

    @Override
    public void execute() {
        String playerOneName = getPlayerName(playMenu.getPlayerOneNameField().getText());
        String playerTwoName = getPlayerName(playMenu.getPlayerTwoNameField().getText());

        Terminal.getInstance().show(new TInfoDialog(DialogType.HISTORY,
                playerOneName + " et " + playerTwoName + " marchaient tranquillement sur la route 42 quand soudain, un Magicarpe surgit hors d'un étang… pour s'écraser misérablement sur le sol.\n\n" +
                        playerOneName + " éclata de rire :\n" +
                        "- HA ! Magicarpe est vraiment le Pokémon le plus inutile !\n\n" +
                        playerTwoName + ", rouge de colère, pointa un doigt accusateur :\n" +
                        "- Retire immédiatement ce blasphème ! Magicarpe deviendra un puissant Léviator !\n\n" +
                        playerOneName + " croisa les bras en haussant un sourcil :\n" +
                        "- Ouais, bah en attendant, il fait juste des plouf.\n\n" +
                        playerTwoName + " dégaina une Poké Ball, furieux :\n" +
                        "- Tu vas payer cet affront !\n\n" +
                        "Ainsi débuta un combat légendaire… pour l'honneur d'un Magicarpe."));

        long seed = getSeed(playMenu.getSeedField().getText());

        playMenu.stopLoopingMode();

        Random random = new Random(seed);
        Player playerOne;
        Player playerTwo;

        if (listMonstrePlayerOne.isEmpty()) {
            playerOne = new Player(playerOneName, new Monster[]{
                    generateRandomMonster(random),
                    generateRandomMonster(random),
                    generateRandomMonster(random)}, new Consumable[]{ConsumableGen.getRandomConsumable(random), ConsumableGen.getRandomConsumable(random), ConsumableGen.getRandomConsumable(random)});

        } else {
            playerOne = new Player(playerOneName, 
            new Monster[]{
                GlobalMonsterFactory.createMonster(random, listMonstrePlayerOne.get(0), new Attack[]{
                    generateRandomAttackNormalOrType(random, listMonstrePlayerOne.get(0).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerOne.get(0).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerOne.get(0).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerOne.get(0).getType())
                }),
                GlobalMonsterFactory.createMonster(random, listMonstrePlayerOne.get(1), new Attack[]{
                    generateRandomAttackNormalOrType(random, listMonstrePlayerOne.get(1).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerOne.get(1).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerOne.get(1).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerOne.get(1).getType())
                }),
                GlobalMonsterFactory.createMonster(random, listMonstrePlayerOne.get(2), new Attack[]{
                    generateRandomAttackNormalOrType(random, listMonstrePlayerOne.get(2).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerOne.get(2).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerOne.get(2).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerOne.get(2).getType())
                })
            }, new Consumable[]{ConsumableGen.getRandomConsumable(random), ConsumableGen.getRandomConsumable(random), ConsumableGen.getRandomConsumable(random), ConsumableGen.getRandomConsumable(random)});
        }

        if (listMonstrePlayerTwo.isEmpty()) {
            playerTwo = new Player(playerTwoName, new Monster[]{
                    generateRandomMonster(random),
                    generateRandomMonster(random),
                    generateRandomMonster(random)}, new Consumable[]{ConsumableGen.getRandomConsumable(random), ConsumableGen.getRandomConsumable(random), ConsumableGen.getRandomConsumable(random)});
        } else {
            playerTwo = new Player(playerTwoName, 
            new Monster[]{
                GlobalMonsterFactory.createMonster(random, listMonstrePlayerTwo.get(0), new Attack[]{
                    generateRandomAttackNormalOrType(random, listMonstrePlayerTwo.get(0).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerTwo.get(0).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerTwo.get(0).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerTwo.get(0).getType())
                }),
                GlobalMonsterFactory.createMonster(random, listMonstrePlayerTwo.get(1), new Attack[]{
                    generateRandomAttackNormalOrType(random, listMonstrePlayerTwo.get(1).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerTwo.get(1).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerTwo.get(1).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerTwo.get(1).getType())
                }),
                GlobalMonsterFactory.createMonster(random, listMonstrePlayerTwo.get(2), new Attack[]{
                    generateRandomAttackNormalOrType(random, listMonstrePlayerTwo.get(2).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerTwo.get(2).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerTwo.get(2).getType()),
                    generateRandomAttackNormalOrType(random, listMonstrePlayerTwo.get(2).getType())
                })
            }, new Consumable[]{ConsumableGen.getRandomConsumable(random), ConsumableGen.getRandomConsumable(random), ConsumableGen.getRandomConsumable(random), ConsumableGen.getRandomConsumable(random)});
        }

        Game game = new Game(seed, random, playerOne, playerTwo);

        // Choose default monster
        // Player one
        do {
            ChooseMonsterView chooseMonsterView = new ChooseMonsterView(playerOne, playerTwo, false);
            Terminal.getInstance().show(chooseMonsterView);
        } while (playerOne.getCurrentMonster() == null);
        // Player two
        do {
            ChooseMonsterView chooseMonsterView = new ChooseMonsterView(playerTwo, playerTwo, false);
            Terminal.getInstance().show(chooseMonsterView);
        } while (playerTwo.getCurrentMonster() == null);

        // Stop menu music
        AudioTrack menuAudioTrack = mainMenu.getMenuAudioTrack();
        if (menuAudioTrack != null) {
            menuAudioTrack.stop();
        }

        // Start game
        Terminal.getInstance().show(new GameView(game));

        // Restart menu music
        if (menuAudioTrack != null) {
            menuAudioTrack.setVolume(AppSettings.getInstance().getMusicVolume());
            menuAudioTrack.restart();
        }
    }

    private String getPlayerName(String inputName) {
        if (inputName.isBlank()) {
            return randomPseudos[new Random().nextInt(randomPseudos.length)];
        }
        return inputName;
    }

    private long getSeed(String inputSeed) {
        if (inputSeed.isBlank()) {
            return new Random().nextLong();
        } else {
            try {
                return Long.parseLong(inputSeed);
            } catch (NumberFormatException ex) {
                long seed = 0;
                for (char c : inputSeed.toCharArray()) {
                    seed += c;
                }
                return seed;
            }
        }
    }

    private static Monster generateRandomMonster(Random random) {
        MonsterTemplate monsterTemplate = MonstreManager.getInstance().getRandomMonstreModel(random);
        return GlobalMonsterFactory.createMonster(random, monsterTemplate, new Attack[]{
                generateRandomAttackNormalOrType(random, monsterTemplate.getType()),
                generateRandomAttackNormalOrType(random, monsterTemplate.getType()),
                generateRandomAttackNormalOrType(random, monsterTemplate.getType()),
                generateRandomAttackNormalOrType(random, monsterTemplate.getType())});
    }

    private static Attack generateRandomAttackNormalOrType(Random random, Types type) {
        AttackTemplate attackTemplate = AttackManager.getInstance().getRandomAttackModel(random);
        if (attackTemplate.getType() == type || attackTemplate.getType() == Types.NORMAL) {
            return AttackFactory.createAttack(random, attackTemplate);
        }
        return generateRandomAttackNormalOrType(random, type);
    }
}