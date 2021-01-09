public class Pokemon {
   private String name;
   private Type[] myType;
   private String[] moveName;
   private int[] moveDamage;
   private Type[] moveType;
   private Category[] moveCategory;
   private int[] priority;
   private int[] stats = new int[] { 0, 0, 0, 0, 0, 0 };
   private static final int LEVEL = 10;

   // DEFAULT POKÉMON
   public Pokemon() {
      name = "Missingno";
      myType = new Type[] { Type.NORMAL, Type.NONE };
      moveName = new String[] { "Scratch" };
      moveDamage = new int[] { 10 };
      moveType = new Type[] { Type.NORMAL };
      moveCategory = new Category[] { Category.PHYSICAL };
      priority = new int[] { 0 };
      stats = new int[] { 50, 50, 50, 50, 50, 50 };
   }

   // CHOSEN POKÉMON
   public Pokemon(String name) {
      this.name = name;
   }

   // WHAT IS THE MOVE?
   public static enum Type {
      ELECTRIC, FIRE, WATER, GRASS, NORMAL, POISON, NONE
   }

   public static enum Category {
      PHYSICAL, SPECIAL
   }

   // CREATES THE MOVES OF THE POKÉMON
   public void setType(Type myType, Type myType2) {
      this.myType = new Type[] { myType, myType2 };
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

   public void setMoveCategory(Category[] moveCategory) {
      this.moveCategory = moveCategory;
   }

   public void setMovePriority(int[] priority) {
      this.priority = priority;
   }

   // SETS THE STATS
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

   // RETURN THE MOVES OF THE POKÉMON
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

   public Category getMoveCategory(int moveNum) {
      return moveCategory[moveNum - 1];
   }

   public int getMovePriority(int moveNum) {
      return priority[moveNum - 1];
   }

   public int[] getStats() {
      return stats;
   }

   public int getHP() {
      return stats[0];
   }

   public Type[] getMyType() {
      return myType;
   }

   public int getLevel() {
      return LEVEL;
   }

   // RETURNS A DOUBLE DEPENDING ON EFFECTIVENESS
   public double effectiveness(Type type) {
      if (type == Type.GRASS || type == Type.FIRE || type == Type.WATER) {
         return 2.0;
      } else {
         return 1.0;
      }
   }
}
