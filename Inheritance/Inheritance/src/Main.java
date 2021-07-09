import com.umar.Animal;
import com.umar.Dog;

public class Main {


    //static methods cannot access instance methods and instance variables directly
    //they are used when no data is required from instance of a class (from (this))
    //we cannot use this keyword in static

    //A method that does not use instance variables should be static
    //CLassName.methodname or simple method name if in same class

    public static void main(String[] args) {

        Animal animal = new Animal("Animal",1,1,5,5);
        Dog dog = new Dog("yorkie",5,6,2,4,1,32,"browndoggo");
        dog.eat();
        dog.chew();
        dog.eat();
        dog.walk();
        dog.run();


        //
        dog.move(5);
            dog.walk();

            // A House
        //Class is a blueprint for a house a PLAN
        //Insantiate Instance when you use new keyword to create an object
        //house has an address .. a physical location .. this is known as reference
        //we can pass reference inside functions parameters
        //however this means that there is still only 1 house
        // and we are only passsing reference to the object

        //we need to keep in mind which object the reference addresses
        //that determines which objects value will change


        //overloading is compile time polymorphism
    }
}
