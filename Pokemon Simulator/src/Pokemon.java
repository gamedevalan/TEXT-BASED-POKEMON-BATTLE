public class Pokemon {
   private String name;
   private Type myType;
   private String[] moveName;
   private int[] moveDamage;
   private Type[] moveType;
   private int[] stats;

   // DEFAULT POKEMON
   public Pokemon() {
      name = "Missingno";
      myType = Type.NORMAL;
      moveName = new String[] { "Scratch" };
      moveDamage = new int[] { 10 };
      moveType = new Type[] { Type.NORMAL };
      stats = new int[] { 15, 5, 5, 5, 5, 10 };
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

   public void setStats(int[] stats) {
      this.stats = stats;
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

   public boolean equals(Object ob) {
      boolean result = ob instanceof Pokemon;
      if (result) {
         Pokemon p = (Pokemon) ob;
         result = this.name.equals(p.name);
      }
      return result;
   }
}
