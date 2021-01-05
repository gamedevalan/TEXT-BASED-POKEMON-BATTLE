public class Pikachu extends Pokemon {
   private static String[] moveName = new String[] { "Tackle", "ThunderShock" };
   private static int[] moveDamage = new int[] { 40, 40 };
   private static Type[] moveType = new Type[] { Type.NORMAL, Type.ELECTRIC };
   private static int[] stats = new int[] { 20, 13, 10, 11, 9, 15 };

   public Pikachu(String name) {
      super(name);
      setType(Type.ELECTRIC);
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
