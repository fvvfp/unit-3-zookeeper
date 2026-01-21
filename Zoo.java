import java.util.Random;

public class Zoo {
   
   /*
    *
    *
    * ZOO CLASS (35, 7 points each)
    *  1) Three private instance variables of type Cage declared (not instantiated inline)
    *  2) No-arg constructor: instantiates ALL cages; each starts with a random Animal
    *  3) Two-arg/overloaded constructor(s): demonstrates constructor overloading
    *  4) howManyAnimals(): returns the total number of Animal objects ever created using Animal class data
    *  5) putAnimalInCage(Cage, Animal): replaces the cage’s animal ONLY if that Cage belongs to this Zoo; returns boolean
    *
    * CAGE CLASS (35, 7 points each)
    *  6) Private instance variable of type Animal
    *  7) No-arg constructor: puts a random Animal in the cage
    *  8) Constructor with Animal parameter: puts that Animal in the cage
    *  9) Accessors/mutators for the Animal field, using this where appropriate
    * 10) toString(): friendly Cage description that includes the Animal’s toString
    *
    * ANIMAL CLASS (30 points, 5 points each )
    * 11) Private instance variable animalType (String)
    * 12) Static counter that tracks how many Animals have been instantiated; incremented in constructors
    * 13) Constructors: no-arg random type, and parameterized type; uses this(...) constructor chaining
    * 14) Getter and setter for animalType
    * 15) speak(): returns a sound based on animalType
    * 16) speakBackward(): returns reversed version of speak() (loop or StringBuilder)
    *
    * NOTE: Style/readability (meaningful names, consistent indentation, no magic numbers) can be used
    * as a tie-breaker if scores are close.
    */

    // Create 3 private instance variables of type Cage.
    // Only DECLARE them here (do not instantiate them in the declaration).
    private Cage cage1;
    private Cage cage2;
    private Cage cage3;
   
    // CONSTRUCTORS
    // 1) No-arg constructor:
    //    - instantiate all 3 cages
    //    - each cage should start with a random Animal
    //    Hint: Cage() can create a random Animal by calling new Animal()
    public Zoo() {
      cage1 = new Cage();
      cage2 = new Cage();
      cage3 = new Cage();
    }

    // 2) Overloaded constructor:
    //    - takes 3 Animal parameters and places them into the 3 cages
    //    - must demonstrate constructor overloading and use "this." at least once
    public Zoo(Animal a1, Animal a2, Animal a3) {
      this.cage1 = new Cage(a1);
      this.cage2 = new Cage(a2);
      this.cage3 = new Cage(a3);
    }

    // howManyAnimals():
    // Returns the number of Animal objects that have been created so far.
    // Hint: use a static/class variable (and likely a static accessor) in Animal.
    public int howManyAnimals() {
      return Animal.getCount();
    }

    // putAnimalInCage(Cage cage, Animal animal):
    // - If the Cage passed in is one of THIS Zoo's cages, replace the Animal inside it and return true.
    // - If the Cage does NOT belong to this Zoo, do nothing and return false.
    // Note: do NOT create any new cages here.
    public boolean putAnimalInCage(Cage cage, Animal animal) {
      if (cage == cage1) {
         cage1.setAnimal(animal);
      } else if (cage == cage2) {
         cage2.setAnimal(animal);
      } else if (cage == cage3) {
         cage3.setAnimal(animal);
      } else {
         return false;
      }
      return true;
    }
    
    public Cage getCageA() {
      return cage1;
    }
    public Cage getCageB() {
      return cage2;
    }
    public Cage getCageC() {
      return cage3;
    }

    // toString():
    // Return a multi-line description of the Zoo including each cage (and the animal inside).
    public String toString() {
      return "(Zoo:\n   Cage 1: " + cage1 + "\n   Cage 2: " + cage2 + "\n   Cage 3: " + cage3 + "\n)";
    }
    
    public static void main(String[] args) {
      Zoo z = new Zoo();
      System.out.println(z);
      
      z = new Zoo(new Animal("dove"), new Animal("snake"), new Animal("donkey"));
      System.out.println(z);
      
      System.out.println(z.getCageA());
      System.out.println(z.getCageB());
      
      z.putAnimalInCage(z.getCageC(), new Animal("dolphin"));
      System.out.println(z);
      
      System.out.println(z.putAnimalInCage(z.getCageC(), new Animal("lion")));
      System.out.println(z.putAnimalInCage(new Cage(), new Animal("lion")));
      
      System.out.println(z.howManyAnimals());
    }
}
