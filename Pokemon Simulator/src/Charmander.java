public class Charmander extends Pokemon {
   private static String[] moveName = new String[] { "Scratch", "Ember" };
   private static int[] moveDamage = new int[] { 40, 40 };
   private static Type[] moveType = new Type[] { Type.NORMAL, Type.FIRE };
   private static int[] stats = new int[] { 39, 52, 43, 60, 50, 65 };

   public Charmander() {
      super("CHARMANDER");
      setType(Type.FIRE);
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
      if (type == Type.WATER) {
         return 2.0;
      } else if (type == Type.GRASS || type == Type.FIRE) {
         return 0.5;
      } else {
         return 1.0;
      }
   }
}