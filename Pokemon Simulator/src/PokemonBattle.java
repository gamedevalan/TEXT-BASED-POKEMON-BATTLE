import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
   public static final char MAX_POKEMONS_CHAR = '5';
   public static final int MAX_POKEMONS = 5;
   public static final int HEALTH_POINTS = 0;
   public static final int ATTACK = 1;
   public static final int DEFENSE = 2;
   public static final int SP_ATTACK = 3;
   public static final int SP_DEFENSE = 4;
   public static final int SPEED = 5;

   public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      Random rand = new Random();
      Pokemon[] enemies = new Pokemon[MAX_POKEMONS];
      createEnemies(enemies);
      boolean switchPokemon = true;
      while (switchPokemon) {
         int choice = choosePokemon(scan);
         Pokemon player = createPokemon(choice);
         System.out.println("You chose... " + player.getName() + "!");
         switchPokemon = playPokemon(scan, rand, player, enemies);
      }
   }

   public static int choosePokemon(Scanner scan) {
      System.out.println("Who would you like to be your STARTER?");
      System.out.println("1. Bulbasuar");
      System.out.println("2. Charmander");
      System.out.println("3. Squirtle");
      System.out.println("4. Pikachu");
      System.out.println("5. Eevee");
      System.out.print("Enter a number. ");
      // IN CASE USER INPUTS 'NOT A NUMBER'
      char choice = scan.nextLine().charAt(0);
      while (!(choice > '0' && choice <= MAX_POKEMONS_CHAR)) {
         System.out.print("Not a valid number. Enter a number. ");
         choice = scan.nextLine().charAt(0);
      }
      return choice - 48;
   }

   public static Pokemon createPokemon(int choice) {
      if (choice == 1) {
         return new Bulbasaur("BULBASAUR");
      } else if (choice == 2) {
         return new Charmander("CHARMANDER");
      } else if (choice == 3) {
         return new Squirtle("SQUIRTLE");
      } else if (choice == 4) {
         return new Pikachu("PIKACHU");
      } else {
         return new Eevee("EEVEE");
      }
   }

   public static void createEnemies(Pokemon[] enemies) {
      enemies[0] = new Bulbasaur("BULBASAUR");
      enemies[1] = new Charmander("CHARMANDER");
      enemies[2] = new Squirtle("SQUIRTLE");
      enemies[3] = new Pikachu("PIKACHU");
      enemies[4] = new Eevee("EEVEE");
   }

   public static boolean playPokemon(Scanner scan, Random rand, Pokemon player, Pokemon[] enemies) {

      boolean playing = true;
      boolean switchPokemon = false;
      int enemyNum = 0;

      while (playing) {
         int[] myCurrentStats = createNewArray(player.getStats());
         System.out.println();
         enemyNum = rand.nextInt(MAX_POKEMONS);
         Pokemon opponent = enemies[enemyNum];
         System.out.println();
         System.out.println("A wild " + opponent.getName() + " appeared!");
         int[] oppCurrentStats = createNewArray(opponent.getStats());
         while (myCurrentStats[HEALTH_POINTS] > 0 && oppCurrentStats[HEALTH_POINTS] > 0) {
            System.out.println("");
            int moveChoice = chooseMove(player, opponent, scan);
            String[] turnOrder = new String[] { "Player", "Opponent" };
            whoIsFaster(player, opponent, myCurrentStats[SPEED], oppCurrentStats[SPEED], turnOrder,
                  rand);
            attackPhase(player, opponent, turnOrder, moveChoice, myCurrentStats, oppCurrentStats,
                  rand);
            System.out.println();
            System.out.println(player.getName() + "'s health = " + myCurrentStats[HEALTH_POINTS]);
            System.out.println("The opposing " + opponent.getName() + "'s health = "
                  + oppCurrentStats[HEALTH_POINTS]);
            System.out.println();
         }
         playing = keepPlaying(scan);
         if (playing) {
            switchPokemon = switchPokemon(scan);
            if (switchPokemon) {
               playing = false;
               return true;
            }

         }
      }
      return false;
   }

   // Create a copy of the stats without changing it
   public static int[] createNewArray(int[] arr) {
      int[] copiedStats = new int[arr.length];
      for (int i = 0; i < arr.length; i++) {
         copiedStats[i] = arr[i];
      }
      return copiedStats;
   }

   // Input move choice and see if it's valid
   public static int chooseMove(Pokemon player, Pokemon opponent, Scanner scan) {
      char moveChoice = ' ';

      while (!(moveChoice > '0' && moveChoice <= (char) (48 + player.numMoves()))) {
         System.out.println("What will " + player.getName() + " do?");
         for (int num = 1; num <= player.numMoves(); num++) {
            System.out.println(num + ". " + player.getMove(num));
         }
         moveChoice = scan.nextLine().charAt(0);
         if (!(moveChoice > '0' && moveChoice <= (char) (48 + player.numMoves()))) {
            System.out.print("Not a valid number. ");
         }
      }
      return moveChoice - 48;
   }

   // Change the array if the opponent is faster (higher speed)
   public static void whoIsFaster(Pokemon player, Pokemon opponent, int mySpeed, int oppSpeed,
         String[] turnOrder, Random rand) {
      if (oppSpeed > mySpeed) {
         turnOrder[0] = "Opponent";
         turnOrder[1] = "Player";
      } else if (oppSpeed == mySpeed) {
         int speedTie = rand.nextInt(2);
         if (speedTie == 0) {
            turnOrder[0] = "Opponent";
            turnOrder[1] = "Player";
         }
      }

   }

   // What moves were chosen?
   public static void attackPhase(Pokemon player, Pokemon opponent, String[] turnOrder,
         int moveChoice, int[] myCurrentStats, int[] oppCurrentStats, Random rand) {
      String first = turnOrder[0];
      int oppMoveChoice = rand.nextInt(opponent.numMoves()) + 1;
      if ("Player".equals(first)) {
         printPrompt("PLAYER", player, moveChoice);
         turn("PLAYER", oppCurrentStats, player, opponent, moveChoice, myCurrentStats[ATTACK],
               oppCurrentStats[DEFENSE], rand);
         if (oppCurrentStats[HEALTH_POINTS] > 0) {
            printPrompt("OPPO", opponent, oppMoveChoice);
            turn("OPPO", myCurrentStats, opponent, player, oppMoveChoice, oppCurrentStats[ATTACK],
                  myCurrentStats[DEFENSE], rand);
         }
      }

      else {
         printPrompt("OPPO", opponent, oppMoveChoice);
         turn("OPPO", myCurrentStats, opponent, player, oppMoveChoice, oppCurrentStats[ATTACK],
               myCurrentStats[DEFENSE], rand);
         if (myCurrentStats[HEALTH_POINTS] > 0) {
            printPrompt("PLAYER", player, moveChoice);
            turn("PLAYER", oppCurrentStats, player, opponent, moveChoice, myCurrentStats[ATTACK],
                  oppCurrentStats[DEFENSE], rand);
         }
      }
      faint(player, opponent, myCurrentStats, oppCurrentStats);
   }

   // Faint display
   public static void faint(Pokemon player, Pokemon opponent, int[] myCurrentStats,
         int[] oppCurrentStats) {
      if (myCurrentStats[HEALTH_POINTS] <= 0) {
         myCurrentStats[HEALTH_POINTS] = 0;
         System.out.println(player.getName() + " fainted!");
      } else if (oppCurrentStats[HEALTH_POINTS] <= 0) {
         oppCurrentStats[HEALTH_POINTS] = 0;
         System.out.println("The wild " + opponent.getName() + " fainted!");
      }
   }

   // Print move prompt
   public static void printPrompt(String who, Pokemon currentPokemon, int moveChoice) {
      System.out.println();
      if (who.equals("PLAYER")) {
         System.out.println(
               currentPokemon.getName() + " used " + currentPokemon.getMove(moveChoice) + "!");
      } else {
         System.out.println("The wild " + currentPokemon.getName() + " used "
               + currentPokemon.getMove(moveChoice) + "!");
      }
   }

   // Change the health status
   public static void turn(String who, int[] opponentStats, Pokemon currentPokemon,
         Pokemon opponentPokemon, int moveChoice, int attackerStat, int defenderStat, Random rand) {
      int damage = getDamage(currentPokemon, moveChoice, attackerStat, defenderStat, rand);
      opponentStats[HEALTH_POINTS] -= damage;
      if (who.equals("PLAYER")) {
         System.out.print("The opposing ");
      }
      System.out.println(opponentPokemon.getName() + " took " + damage + " damage!");
   }

   // Get the damage
   public static int getDamage(Pokemon currentPokemon, int moveChoice, int attackerStat,
         int defenderStat, Random rand) {
      return calculateDamage(attackerStat, defenderStat, currentPokemon.getDamage(moveChoice),
            currentPokemon.getMoveType(moveChoice) == currentPokemon.getMyType(), rand);
   }

   // Calculate the damage number integer
   public static int calculateDamage(int attackStat, int defenseStat, int moveDamage,
         boolean isSTAB, Random rand) {
      final int LEVEL = 5;

      double STAB = isSTAB ? 1.5 : 1; // Same Type Attack Bonus
      int damage = (((2 * LEVEL) / 5 + 2) * moveDamage * attackStat / defenseStat) / 50 + 2;
      double randomFactor = (85 + rand.nextInt(100 - 85 + 1)) / 100.0;
      double modifiers = Math.round(STAB * randomFactor * 10.0) / 10.0;
      damage = (int) ((Math.round(damage * modifiers * 10.0)) / 10.0);
      damage = damage < 1 ? 1 : damage; // if damage is less than 1, do some damage
      return damage;

   }

   public static boolean keepPlaying(Scanner scan) {
      System.out.println();
      System.out.print("Do you want to continue? ");
      char answer = scan.nextLine().toLowerCase().charAt(0);
      return answer == 'y';
   }

   public static boolean switchPokemon(Scanner scan) {
      System.out.print("Would you like to switch Pokemons? ");
      System.out.println();
      char answer = scan.nextLine().toLowerCase().charAt(0);
      return answer == 'y';
   }
}
