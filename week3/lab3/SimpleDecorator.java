package lab3;
/**
 * In this assignment we will add enhancements to the code of a basic computer game.
 * In the game we have characters that can attack each other, and depending on their attack and defense forces, the attack can succeed or fail.
 *
 * In the code we have the interface GameCharacter that defines the API of a character in the game:
 *
 * getDescription - returns a string that describes the character
 * getAttackForce - returns the attack force of the character
 * getDefenseForce - returns the defense force of the character
 * We have two concrete classes that implement game characters: Person and Dragon. Each character class has a constant attack and defense forces.
 *
 * In addition we have the game class with the following methods:
 *
 * attack - that receives an attacker character and a defender character and returns true if the attacker defeated the defender and false otherwise.
 * main - that initializes a hero character as a Person and an evilDragon character  as a Dragon, prints their description, and prints "The hero defeated the evil dragon" if the attack of the hero on the dragon was successfull.
 * We want to create more complex game characters by adding one or more of the following to the basic character:
 *
 * a sword - a character with a sword adds the sword to the description, and the attack force of the character is multiplied by 2.
 * an invisible shield - a character with an invisible shield does not change its description but the defense force of the character is increased by 10.
 * a helmet -  a character with a helmet adds the helmet to the description, and the defense force of the character is increased by 10.
 * The assignment:
 * Use the decorator design pattern and add to the code the following classes:
 * CharacterSword - for a character with a sword
 * CharacterInvisibleShield - for a character with an invisible shield
 * CharacterHelmet - for a character with a helmet
 * In the main method:
 *
 * 4. Initialize the hero character with two swords and a helmet.
 * 5. Initialize the evil dragon character with an invisible shield.
 * */


/**
 * in this example, we are using the decorator design pattern to add new functionality to the game characters.
 * the decorator design pattern is used to add new functionality to an object without changing its structure.
 * to create a decorator, we will do the following:
 * 1. create an interface that will be the base interface of the object we want to decorate.
 * 2. create a class that will implement the base interface.
 * 3. create a decorator interface that will extend the base interface.
 * 4. create a class that will implement the decorator interface.
 * 5. in the decorator class, create a field that will hold the object we want to decorate.
 * 6. in the decorator class, create a constructor that will receive the object we want to decorate.
 * 7. in the decorator class, override the methods of the base interface, and add the new functionality.
 * 8. in the main method, create an instance of the object we want to decorate, and pass it to the decorator class.
 * 9. use the decorator class to add the new functionality to the object.
 * */

interface GameCharacter {
    String getDescription();
    int getAttackForce();
    int getDefenseForce();
}

class Person implements GameCharacter {

    public static final int ATTACK_FORCE = 15;
    public static final int DEFENSE_FORCE = 10;

    @Override
    public String getDescription() {
        return "I am a person";
    }

    @Override
    public int getAttackForce() {
        return ATTACK_FORCE;
    }

    @Override
    public int getDefenseForce() {
        return DEFENSE_FORCE;
    }
}

class Dragon implements GameCharacter {

    public static final int ATTACK_FORCE = 20;
    public static final int DEFENSE_FORCE = 15;

    @Override
    public String getDescription() {
        return "I am a dragon";
    }

    @Override
    public int getAttackForce() {
        return ATTACK_FORCE;
    }

    @Override
    public int getDefenseForce() {
        return DEFENSE_FORCE;
    }
}

interface CharacterDecorator extends GameCharacter {}

class CharacterSword implements CharacterDecorator{
    private GameCharacter objectToDecorate;
    public CharacterSword(GameCharacter objectToDecorate){
        this.objectToDecorate=objectToDecorate;
    }
    @Override
    public String getDescription(){
        return objectToDecorate.getDescription() + " with a sword";
    }
    public int getAttackForce(){
        return objectToDecorate.getAttackForce()*2;
    }
    public int getDefenseForce(){
        return objectToDecorate.getDefenseForce();
    }
}

class CharacterHelmet implements CharacterDecorator{
    private GameCharacter objectToDecorate;
    public CharacterHelmet( GameCharacter objectToDecorate){
        this.objectToDecorate=objectToDecorate;
    }
    public String getDescription(){
        return objectToDecorate.getDescription() + " with a helmet";
    }
    public int getAttackForce(){
        return objectToDecorate.getAttackForce();
    }
    public int getDefenseForce(){
        return objectToDecorate.getDefenseForce()+10;
    }
}

class CharacterInvisibleShield implements CharacterDecorator{
    private GameCharacter objectToDecorate;
    public CharacterInvisibleShield( GameCharacter objectToDecorate){
        this.objectToDecorate=objectToDecorate;
    }
    public String getDescription(){
        return objectToDecorate.getDescription() ;
    }
    public int getAttackForce(){
        return objectToDecorate.getAttackForce();
    }
    public int getDefenseForce(){
        return objectToDecorate.getDefenseForce()+10;
    }
}

/*add CharacterSword, CharacterHelmet and CharacterInvisibleShield decorators HERE!!!*/

class SimpleDecorator {
    public static boolean attack(GameCharacter attacker, GameCharacter defender){
        return attacker.getAttackForce()-defender.getDefenseForce()>0;
    }

    public static void main(String[] args) {
        //Initialize hero with two swords and a helmet!
        GameCharacter hero = new CharacterHelmet(new CharacterSword(new CharacterSword(new Person())));
        // Initialize evilDragon with an invisible shield!
        GameCharacter evilDragon = new CharacterInvisibleShield(new Dragon());

        System.out.println(hero.getDescription());
        System.out.println(evilDragon.getDescription());

        if(attack(hero,evilDragon)){
            System.out.println("The hero defeated the evil dragon");
        }
    }
}


