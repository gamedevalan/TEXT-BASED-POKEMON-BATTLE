public class Eevee extends Pokemon {
   private static String[] moveName = new String[] { "Tackle", "Quick Attack" };
   private static int[] moveDamage = new int[] { 40, 40 };
   private static Type[] moveType = new Type[] { Type.NORMAL, Type.NORMAL };
   private static Category[] moveCategory = new Category[] { Category.PHYSICAL, Category.PHYSICAL };
   private static int[] priority = new int[] { 0, 1 };
   private static int[] baseStats = new int[] { 55, 55, 50, 45, 65, 55 };

   public Eevee() {
      super("EEVEE");
      setType(Type.NORMAL);
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
      return 1.0;
   }
}