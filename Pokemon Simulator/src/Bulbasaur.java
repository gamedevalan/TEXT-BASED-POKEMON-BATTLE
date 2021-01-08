public class Bulbasaur extends Pokemon {
   private static String[] moveName = new String[] { "Tackle", "Vine Whip" };
   private static int[] moveDamage = new int[] { 40, 45 };
   private static Type[] moveType = new Type[] { Type.NORMAL, Type.GRASS };
   private static int[] stats = new int[] { 45, 49, 49, 65, 65, 45 };

   public Bulbasaur() {
      super("BULBASAUR");
      setType(Type.GRASS);
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
      if (type == Type.FIRE) {
         return 2.0;
      } else if (type == Type.WATER || type == Type.GRASS || type == Type.ELECTRIC) {
         return 0.5;
      } else {
         return 1.0;
      }
   }
}