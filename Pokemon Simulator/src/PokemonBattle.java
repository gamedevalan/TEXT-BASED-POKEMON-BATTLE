import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
   // The amount of Pokémon classes created.
   public static final int MAX_POKEMONS = 5;

   // What positions in the array are the specific stats located in?
   public static final int HEALTH_POINTS = 0;
   public static final int ATTACK = 1;
   public static final int DEFENSE = 2;
   public static final int SP_ATTACK = 3;
   public static final int SP_DEFENSE = 4;
   public static final int SPEED = 5;

   public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      Random rand = new Random();
      Pokemon[] pokemonArr = new Pokemon[MAX_POKEMONS];
      createPokemon(pokemonArr);
      boolean switchPokemon = true;
      while (switchPokemon) {
         int choice = choosePokemon(scan, pokemonArr);
         // get the Pokémon you chose from the array
         Pokemon player = pokemonArr[choice - 1];
         showPokemon(player);
         switchPokemon = playPokemon(scan, rand, player, pokemonArr);
      }
   }

   // Create your opponent and put into an array.
   public static void createPokemon(Pokemon[] pokemonArr) {
      pokemonArr[0] = new Bulbasaur();
      pokemonArr[1] = new Charmander();
      pokemonArr[2] = new Squirtle();
      pokemonArr[3] = new Pikachu();
      pokemonArr[4] = new Eevee();
   }

   public static int choosePokemon(Scanner scan, Pokemon[] pokemonArr) {
      System.out.println("Who would you like to be your STARTER?");
      // list the Pokémon available
      for (int i = 0; i < pokemonArr.length; i++) {
         System.out.print(i + 1 + ". " + pokemonArr[i].getName().charAt(0)
               + pokemonArr[i].getName().substring(1).toLowerCase());
         System.out.print(" - " + pokemonArr[i].getMyType()[0]);
         if (pokemonArr[i].getMyType()[1] != Pokemon.Type.NONE) {
            System.out.print(", " + pokemonArr[i].getMyType()[1]);
         }
         System.out.println();
      }
      int choice = 0;
      choice = validInput("Enter the number of the Pokémon you want: ", scan, choice,
            pokemonArr.length);
      return choice;
   }

   // Checks if a valid input (number and between 1 to a max number)
   public static int validInput(String prompt, Scanner scan, int choice, int limit) {
      System.out.print(prompt);
      boolean done = false;
      while (!done) {
         String num = scan.nextLine();
         if (isNumeric(num)) {
            choice = Integer.parseInt(num);
            if (!(choice > 0 && choice <= limit)) {
               System.out.print("NOT a valid number.\n\n" + prompt);
            } else {
               done = true;
            }
         } else {
            System.out.print("NOT a valid number.\n\n" + prompt);
         }
      }
      return choice;
   }

   // Check to see if the input is a number.
   public static boolean isNumeric(String str) {
      try {
         // convert string to integer
         Integer.parseInt(str);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }

   // Show the stats of your chosen Pokémon.
   public static void showPokemon(Pokemon player) {
      System.out.println();
      System.out.print("You chose... " + player.getName() + "!");
      System.out.println(" (Level " + player.getLevel() + ")");
      String[] stat = new String[] { "HP", "Attack", "Defense", "Sp.Attack", "Sp.Defense",
            "Speed" };
      System.out.printf("%s", stat[0]);
      System.out.printf("%9s", stat[1]);
      System.out.printf("%10s", stat[2]);
      System.out.printf("%12s", stat[3]);
      System.out.printf("%13s", stat[4]);
      System.out.printf("%8s", stat[5]);
      System.out.println();
      System.out.printf("%s", player.getStats()[0]);
      System.out.printf("%5s", player.getStats()[1]);
      System.out.printf("%9s", player.getStats()[2]);
      System.out.printf("%10s", player.getStats()[3]);
      System.out.printf("%12s", player.getStats()[4]);
      System.out.printf("%13s", player.getStats()[5]);
      System.out.println();
      System.out.println("------------------------------------------------------");
   }

   // Play the turns in Pokémon.
   public static boolean playPokemon(Scanner scan, Random rand, Pokemon player,
         Pokemon[] pokemonArr) {
      boolean playing = true;
      boolean switchPokemon = false;
      int enemyNum = 0;

      while (playing) {
         System.out.println();
         enemyNum = rand.nextInt(pokemonArr.length);
         Pokemon opponent = pokemonArr[enemyNum];
         int[] myCurrentStats = createNewArray(player.getStats());
         System.out.println("A wild " + opponent.getName() + " appeared!");
         int[] oppCurrentStats = createNewArray(opponent.getStats());
         while (myCurrentStats[HEALTH_POINTS] > 0 && oppCurrentStats[HEALTH_POINTS] > 0) {
            System.out.println();
            int moveChoice = chooseMove(player, opponent, scan);
            int oppMoveChoice = rand.nextInt(opponent.numMoves()) + 1;
            String[] turnOrder = new String[] { "Player", "Opponent" };
            whoIsFaster(player, opponent, myCurrentStats[SPEED], oppCurrentStats[SPEED], turnOrder,
                  moveChoice, oppMoveChoice, rand);
            attackPhase(player, opponent, turnOrder, moveChoice, myCurrentStats, oppCurrentStats,
                  oppMoveChoice, rand);
            health(player, myCurrentStats[HEALTH_POINTS], opponent, oppCurrentStats[HEALTH_POINTS]);
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

   // Display the health info of both Pokémon.
   public static void health(Pokemon player, int myHp, Pokemon opponent, int oppHp) {
      System.out.println();
      System.out.println(player.getName() + "'s HP = " + myHp + " / " + player.getHP());
      System.out.println(
            "The opposing " + opponent.getName() + "'s HP = " + oppHp + " / " + opponent.getHP());
      System.out.println("------------------------------------------------------");
   }

   // Create a copy of the stats without changing it
   public static int[] createNewArray(int[] arr) {
      int[] copiedStats = new int[arr.length];
      for (int i = 0; i < arr.length; i++) {
         copiedStats[i] = arr[i];
      }
      return copiedStats;
   }

   // Input move choice.
   public static int chooseMove(Pokemon player, Pokemon opponent, Scanner scan) {
      int choice = 0;
      whatWillAPokemonDo(player);
      // checks if a valid input (number and between 1 - num moves)
      choice = validInput(whatWillAPokemonDo(player), scan, choice, player.numMoves());
      return choice;
   }

   // Display move choices.
   public static String whatWillAPokemonDo(Pokemon player) {
      String prompt = "What will " + player.getName() + " do?\n";
      for (int num = 1; num <= player.numMoves(); num++) {
         prompt += num + ". " + player.getMove(num) + " -- TYPE: " + player.getMoveType(num)
               + " -- POWER: " + player.getDamage(num) + " -- CATEGORY: "
               + player.getMoveCategory(num) + "\n";
      }
      prompt += "Enter the move number: ";
      return prompt;
   }

   // Change the array if the opponent is faster (higher speed/ priority).
   public static void whoIsFaster(Pokemon player, Pokemon opponent, int mySpeed, int oppSpeed,
         String[] turnOrder, int moveChoice, int oppMoveChoice, Random rand) {
      if (player.getMovePriority(moveChoice) == opponent.getMovePriority(oppMoveChoice)) {
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
      } else if (opponent.getMovePriority(oppMoveChoice) > player.getMovePriority(moveChoice)) {
         turnOrder[0] = "Opponent";
         turnOrder[1] = "Player";
      }
   }

   // Play out the chosen moves.
   public static void attackPhase(Pokemon player, Pokemon opponent, String[] turnOrder,
         int moveChoice, int[] myCurrentStats, int[] oppCurrentStats, int oppMoveChoice,
         Random rand) {
      String first = turnOrder[0];
      if ("Player".equals(first)) {
         printMovePrompt("PLAYER", player, moveChoice);
         turn("PLAYER", oppCurrentStats, player, opponent, moveChoice,
               myCurrentStats[whichAttackStat(player, moveChoice)],
               oppCurrentStats[whichDefenseStat(player, moveChoice)], rand);
         if (oppCurrentStats[HEALTH_POINTS] > 0) {
            printMovePrompt("OPPO", opponent, oppMoveChoice);
            turn("OPPO", myCurrentStats, opponent, player, oppMoveChoice,
                  oppCurrentStats[whichAttackStat(opponent, oppMoveChoice)],
                  myCurrentStats[whichDefenseStat(opponent, oppMoveChoice)], rand);
         }
      }

      else {
         printMovePrompt("OPPO", opponent, oppMoveChoice);
         turn("OPPO", myCurrentStats, opponent, player, oppMoveChoice,
               oppCurrentStats[whichAttackStat(opponent, oppMoveChoice)],
               myCurrentStats[whichDefenseStat(opponent, oppMoveChoice)], rand);
         if (myCurrentStats[HEALTH_POINTS] > 0) {
            printMovePrompt("PLAYER", player, moveChoice);
            turn("PLAYER", oppCurrentStats, player, opponent, moveChoice,
                  myCurrentStats[whichAttackStat(player, moveChoice)],
                  oppCurrentStats[whichDefenseStat(player, moveChoice)], rand);
         }
      }
      faint(player, opponent, myCurrentStats, oppCurrentStats);
   }

   public static int whichAttackStat(Pokemon currentPokemon, int moveChoice) {
      if (currentPokemon.getMoveCategory(moveChoice) == Pokemon.Category.PHYSICAL) {
         return ATTACK;
      } else {
         return SP_ATTACK;
      }
   }

   public static int whichDefenseStat(Pokemon attacker, int moveChoice) {
      if (attacker.getMoveCategory(moveChoice) == Pokemon.Category.PHYSICAL) {
         return DEFENSE;
      } else {
         return SP_DEFENSE;
      }
   }

   // Display who fainted.
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

   // Print what moves were chosen.
   public static void printMovePrompt(String attacker, Pokemon currentPokemon, int moveChoice) {
      System.out.println();
      if (attacker.equals("PLAYER")) {
         System.out.println(
               currentPokemon.getName() + " used " + currentPokemon.getMove(moveChoice) + "!");
      } else {
         System.out.println("The wild " + currentPokemon.getName() + " used "
               + currentPokemon.getMove(moveChoice) + "!");
      }
   }

   // Change the health status.
   public static void turn(String attacker, int[] opponentStats, Pokemon currentPokemon,
         Pokemon opponentPokemon, int moveChoice, int attackerStat, int defenderStat, Random rand) {
      int damage = calculateDamage(attackerStat, defenderStat, opponentPokemon, currentPokemon,
            moveChoice, rand);
      opponentStats[HEALTH_POINTS] -= damage;
      if (attacker.equals("PLAYER")) {
         System.out.print("The opposing ");
      }
      System.out.println(opponentPokemon.getName() + " took " + damage + " damage!");
   }

   // Calculate the damage calculate (integer).
   public static int calculateDamage(int attackStat, int defenseStat, Pokemon opponentPokemon,
         Pokemon currentPokemon, int moveChoice, Random rand) {
      // Same Type Attack Bonus
      double STAB = currentPokemon.getMoveType(moveChoice) == currentPokemon.getMyType()[0]
            || currentPokemon.getMoveType(moveChoice) == currentPokemon.getMyType()[1] ? 1.5 : 1;
      int damage = (((2 * currentPokemon.getLevel()) / 5 + 2) * currentPokemon.getDamage(moveChoice)
            * attackStat / defenseStat) / 50 + 2;
      double randomFactor = (85 + rand.nextInt(100 - 85 + 1)) / 100.0;
      double modifiers = (int) (STAB * randomFactor
            * typeEffectiveness(opponentPokemon, currentPokemon, moveChoice) * 10.0) / 10.0;
      damage = (int) ((damage * modifiers));
      damage = damage < 1 ? 1 : damage; // if damage is less than 1, do some damage
      return damage;
   }

   // Display the effectiveness of the chosen move.
   public static double typeEffectiveness(Pokemon opponentPokemon, Pokemon currentPokemon,
         int moveChoice) {
      // determines the effectiveness of a move to add to the multiplier
      double typeEffectiveness = opponentPokemon
            .effectiveness(currentPokemon.getMoveType(moveChoice));
      if (typeEffectiveness == 0.5) {
         System.out.println("It's not very effective...");
      } else if (typeEffectiveness == 2.0) {
         System.out.println("It's super effective!");
      }
      return typeEffectiveness;
   }

   // Asks if player wants to play again.
   public static boolean keepPlaying(Scanner scan) {
      System.out.println();
      System.out.print("Do you want to continue? ");
      char answer = scan.nextLine().toLowerCase().charAt(0);
      return answer == 'y';
   }

   // Asks if player wants to switch Pokémon.
   public static boolean switchPokemon(Scanner scan) {
      System.out.print("Would you like to switch Pokémon? ");
      char answer = scan.nextLine().toLowerCase().charAt(0);
      System.out.println();
      return answer == 'y';
   }
}
