public class Squirtle extends Pokemon {
   private static String[] moveName = new String[] { "Tackle", "Water Gun" };
   private static int[] moveDamage = new int[] { 40, 40 };
   private static Type[] moveType = new Type[] { Type.NORMAL, Type.WATER };
   private static int[] stats = new int[] { 20, 9, 13, 12, 12, 10 };

   public Squirtle(String name) {
      super(name);
      setType(Type.WATER);
      setMoves(moveName);
      setMoveDamage(moveDamage);
      setMoveType(moveType);
      setStats(stats);
   }

   public void setType(Type myType) {
      super.setType(myType);
   }

   public void setMoves(String[] moveName) {
      super.setMoves(moveName);
   }

   public void setMoveDamage(int[] moveDamage) {
      super.setMoveDamage(moveDamage);
   }

   public void setMoveType(Type[] moveType) {
      super.setMoveType(moveType);
   }

   public void setStats(int[] stats) {
      super.setStats(stats);
   }
}