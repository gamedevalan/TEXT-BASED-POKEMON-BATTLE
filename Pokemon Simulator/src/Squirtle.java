public class Squirtle extends Pokemon {
   private static String[] moveName = new String[] { "Tackle", "Water Gun" };
   private static int[] moveDamage = new int[] { 40, 40 };
   private static Type[] moveType = new Type[] { Type.NORMAL, Type.WATER };
   private static Category[] moveCategory = new Category[] { Category.PHYSICAL, Category.SPECIAL };
   private static int[] priority = new int[] { 0, 0 };
   private static int[] baseStats = new int[] { 44, 48, 65, 50, 64, 43 };

   public Squirtle() {
      super("SQUIRTLE");
      setType(Type.WATER);
      setMoves(moveName);
      setMoveDamage(moveDamage);
      setMoveType(moveType);
      setStats(baseStats);
      setMoveCategory(moveCategory);
      setMovePriority(priority);
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

   public void setMoveCategory(Category[] moveCategory) {
      super.setMoveCategory(moveCategory);
   }

   public void setMovePriority(int[] priority) {
      super.setMovePriority(priority);
   }

   public void setStats(int[] baseStats) {
      super.setStats(baseStats);
   }

   public double effectiveness(Type type) {
      if (type == Type.GRASS || type == Type.ELECTRIC) {
         return 2.0;
      } else if (type == Type.WATER || type == Type.FIRE) {
         return 0.5;
      } else {
         return 1.0;
      }
   }
}