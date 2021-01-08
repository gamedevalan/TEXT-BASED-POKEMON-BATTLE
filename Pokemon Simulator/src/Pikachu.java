public class Pikachu extends Pokemon {
   private static String[] moveName = new String[] { "Tackle", "ThunderShock" };
   private static int[] moveDamage = new int[] { 40, 40 };
   private static Type[] moveType = new Type[] { Type.NORMAL, Type.ELECTRIC };
   private static int[] stats = new int[] { 35, 55, 30, 50, 40, 90 };

   public Pikachu() {
      super("PIKACHU");
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

   public double effectiveness(Type type) {
      return 1.0;
   }

}
