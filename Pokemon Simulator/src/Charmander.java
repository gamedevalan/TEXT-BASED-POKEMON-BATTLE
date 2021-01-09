public class Charmander extends Pokemon {
   private static String[] moveName = new String[] { "Scratch", "Ember" };
   private static int[] moveDamage = new int[] { 40, 40 };
   private static Type[] moveType = new Type[] { Type.NORMAL, Type.FIRE };
   private static Category[] moveCategory = new Category[] { Category.PHYSICAL, Category.SPECIAL };
   private static int[] priority = new int[] { 0, 0 };
   private static int[] baseStats = new int[] { 39, 52, 43, 60, 50, 65 };

   public Charmander() {
      super("CHARMANDER");
      setType(Type.FIRE);
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

   public void setStats(int[] baseStats) {
      super.setStats(baseStats);
   }

   public void setMovePriority(int[] priority) {
      super.setMovePriority(priority);
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