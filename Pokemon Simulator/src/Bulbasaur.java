public class Bulbasaur extends Pokemon {
   private static String[] moveName = new String[] { "Tackle", "Vine Whip" };
   private static int[] moveDamage = new int[] { 40, 45 };
   private static Type[] moveType = new Type[] { Type.NORMAL, Type.GRASS };
   private static Category[] moveCategory = new Category[] { Category.PHYSICAL, Category.PHYSICAL };
   private static int[] priority = new int[] { 0, 0 };
   private static int[] baseStats = new int[] { 45, 49, 49, 65, 65, 45 };

   public Bulbasaur() {
      super("BULBASAUR");
      setType(Type.GRASS, Type.POISON);
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
      if (type == Type.FIRE) {
         return 2.0;
      } else if (type == Type.WATER || type == Type.ELECTRIC) {
         return 0.5;
      } else if (type == Type.GRASS) {
         return 0.25;
      } else {
         return 1.0;
      }
   }
}