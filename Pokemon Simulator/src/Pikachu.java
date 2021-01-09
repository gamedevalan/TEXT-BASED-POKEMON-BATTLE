public class Pikachu extends Pokemon {
   private static String[] moveName = new String[] { "Tackle", "ThunderShock" };
   private static int[] moveDamage = new int[] { 40, 40 };
   private static Type[] moveType = new Type[] { Type.NORMAL, Type.ELECTRIC };
   private static Category[] moveCategory = new Category[] { Category.PHYSICAL, Category.SPECIAL };
   private static int[] priority = new int[] { 0, 0 };
   private static int[] baseStats = new int[] { 35, 55, 30, 50, 40, 90 };

   public Pikachu() {
      super("PIKACHU");
      setType(Type.ELECTRIC, Type.NONE);
      setMoves(moveName);
      setMoveDamage(moveDamage);
      setMoveType(moveType);
      setStats(baseStats);
      setMoveCategory(moveCategory);
      setMovePriority(priority);
   }

   public void setType(Type myType, Type myType2) {
      super.setType(myType, myType2);
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
      return 1.0;
   }

}
