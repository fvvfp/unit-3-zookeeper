import java.util.Random;

public class Animal {

    // creat a private instance variable to store the animal type (e.g. "Tiger" or "Bear" or any other type of animal)
    private String animalType;
    
    // create Static/class variable to track how many Animal objects have been created
    private static int count;
    
    // No-argument constructor:
    // - Creates a random animal type using the randomAnimalType() method you should write in this class
    public Animal() {
      animalType = randomAnimalType();
      count++;
    }

    // Write a constructor that takes an animal type parameter
    public Animal(String animalType) {
      this.animalType = animalType;
      count++;
    }

    // Create a getter/accessor method that returns the static variable that counts how many
    // animals have been instantiated
    public static int getCount() {
      return count;
    }

    // Create a getter/accessor method for returning the animal type
    public String getAnimalType() {
      return animalType;
    }

    // Create a setter method for updating the animal type
    public void setAnimalType(String animalType) {
      this.animalType = animalType;
    }

    // Creat a speak() method that uses the animal type and returns
    // a sound based on the animal type. You can just return a String with the animal noise
    public String speak() {
      switch(animalType) {
         case "dolphin":
            return "clickclickWHEEEEE";
         case "donkey":
            return "heehaw";
         case "frog":
            return "ribbitCROAKribbit";
         case "hyena":
            return "hEehEehee";
         case "lion":
            return "ROAR";
         case "snake":
            return "hissss";
         case "dove":
            return "who cooks for you";
         case "goat":
            return "GaAAAAaaaAaAAAAaAA";
      }
      return "";
    }

    // Create the speakBackward() method that calls speak() and returns the reversed String
    public String speakBackward() {
      String speech = speak();
      String returning = "";
      for (int i = speech.length() - 1; i >= 0; i--) {
         returning += speech.charAt(i);
      }
      return returning;
    }

    // Create the toString() method which returns friendly description of the animal
    public String toString() {
      return "(Animal type: " + animalType + ", Speech: " + speak() + ")";
    }

    // Create a static method called "randomAnimalType" that returns a random
    // animale type
    // HINT: Decide how many animal types you want to be able to create, pick a random number
    // and then use if/else/if statements to determine what the animal should say
    public static String randomAnimalType() {
      int r = (int)(Math.random()*8.0);
      switch(r) {
         case 0:
            return "dolphin";
         case 1:
            return "donkey";
         case 2:
            return "frog";
         case 3:
            return "hyena";
         case 4:
            return "lion";
         case 5:
            return "snake";
         case 6:
            return "dove";
         case 7:
            return "goat";
      }
      return "";
    }
    
    
    public static void main(String[] args) {
      Animal a = new Animal("dolphin");
      System.out.println(a);
      System.out.println(a.getAnimalType());
      System.out.println(a.speak());
      System.out.println(a.speakBackward());
      a.setAnimalType("frog");
      System.out.println(a);
      System.out.println(a.getAnimalType());
      System.out.println(a.speak());
      System.out.println(a.speakBackward());
      
      for (int i = 0; i < 3; i++) {
         System.out.println();
         a = new Animal();
         System.out.println(a.speak());
         System.out.println(a.speakBackward());
      }
      
      System.out.println("\n" + Animal.getCount());
    }
}
