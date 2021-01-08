public class Pokemon {
   private String name;
   private Type myType;
   private String[] moveName;
   private int[] moveDamage;
   private Type[] moveType;
   private int[] stats = new int[] { 0, 0, 0, 0, 0, 0 };
   private static final int LEVEL = 5;

   // DEFAULT POKEMON
   public Pokemon() {
      name = "Missingno";
      myType = Type.NORMAL;
      moveName = new String[] { "Scratch" };
      moveDamage = new int[] { 10 };
      moveType = new Type[] { Type.NORMAL };
      stats = new int[] { 50, 50, 50, 50, 50, 50 };
   }

   // CHOSEN POKEMONS
   public Pokemon(String name) {
      this.name = name;
   }

   // TYPES
   public static enum Type {
      ELECTRIC, FIRE, WATER, GRASS, NORMAL
   }

   // CREATES THE MOVES OF THE POKEMON
   public void setType(Type myType) {
      this.myType = myType;
   }

   public void setMoves(String[] moveName) {
      this.moveName = moveName;
   }

   public void setMoveDamage(int[] moveDamage) {
      this.moveDamage = moveDamage;
   }

   public void setMoveType(Type[] moveType) {
      this.moveType = moveType;
   }

   public void setStats(int[] baseStats) {
      this.stats[0] = calcHP(baseStats[0]);
      this.stats[1] = calcStat(baseStats[1]);
      this.stats[2] = calcStat(baseStats[2]);
      this.stats[3] = calcStat(baseStats[3]);
      this.stats[4] = calcStat(baseStats[4]);
      this.stats[5] = calcStat(baseStats[5]);
   }

   public int calcHP(int num) {
      return (((int) (2 * num + 31)) * LEVEL) / 100 + LEVEL + 10;
   }

   public int calcStat(int num) {
      return (((int) (2 * num + 31)) * LEVEL) / 100 + 5;
   }

   // RETURN THE MOVES OF THE POKEMON
   public String getName() {
      return name;
   }

   public String getMove(int moveNum) {
      return moveName[moveNum - 1];
   }

   public int numMoves() {
      return moveName.length;
   }

   public int getDamage(int moveNum) {
      return moveDamage[moveNum - 1];
   }

   public Type getMoveType(int moveNum) {
      return moveType[moveNum - 1];
   }

   public int[] getStats() {
      return stats;
   }

   public Type getMyType() {
      return myType;
   }

   public int getLevel() {
      return LEVEL;
   }

   public double effectiveness(Type type) {
      if (type == Type.GRASS || type == Type.FIRE || type == Type.WATER) {
         return 2.0;
      } else {
         return 1.0;
      }
   }
}
