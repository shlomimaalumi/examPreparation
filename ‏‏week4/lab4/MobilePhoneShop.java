package lab4;
/**
 * In this assignment we will design a program that models an online mobile phone shop. The store sells
 * phones, both new and refurbished, and phone accessories. For each purchase, the shop creates a shopping
 * cart with all items in that purchase.
 * In your design, decide for each object if it should be a class or an interface, and think of the
 * correct  way to model the relationships between the objects (implementation, inheritance, composition etc.).
 *
 * The class Item that represents all items for sale in the shop is supplied in the code. Each item has
 * the  following properties and methods:
 *
 * string description - a string describing the item.
 * float cost - the cost of the item.
 * constructor
 * float getCost() - return the cost of the item
 * String getDescription() - returns the description of the item.
 * You will need to implement the objects in the following list:
 *
 * 1. Phone – represents a phone for sale in the shop. It has all the properties and methods of an Item
 * and  in addition:
 *
 * int manufactureYear - the year the phone was manufactured.
 * 2. RefurbishedPhone – represents a phone that has been refurbished. In addition to the regular phone
 * properties and methods, each      refurbished phone has:
 * int discountPercent - discount in percentage over the original price of the phone.
 * String getDescription() - returns the phone description with the prefix "Refurbished ".
 * float getCost() - return the cost of the phone after the discount.
 * 3. Accessory – represents an accessory for sale in the shop.  It has all the properties and methods of
 * an  Item and in addition:
 * String model - the model of the phone that it is compatible with.
 * String getModel() - returns the model.
 * String getDescription() - returns the accessory description with the model as a prefix.
 * 4. Cart – represents a shopping cart that holds an array of items. The API of the class:
 * constructor - initialize the array of items. You can assume that there will be maximum 100 items in the
 * cart.
 * float getCost() – return the total cost of all items in the cart.
 *  float getShippingFee() – calculates the shipping fee of the cart. Each item in the cart adds 1$ to the
 *  fee, but if the total cost of the cart is more than 1000$, the cart gets free shipping.
 * void addItem(Item item) – adds an item to the cart.
 * Item[] getItems() – return a copy of the array of items in the cart (No need to deep copy the items).
 *
 * */

/**
 * this example shows the use of inheritance and composition to model an online mobile phone shop and
 * demonstrates the use of inheritance and composition to model the relationships between the objects.
 * */
import java.util.Arrays;

class Item {
    private String description;
    private float cost;

    public Item(String description, float cost) {
        this.description = description;
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }
}

class Phone extends Item {
    private final int manufactureYear;

    public Phone(String description, float cost, int manufactureYear) {
        super(description, cost);
        this.manufactureYear = manufactureYear;
    }
}

class RefurbishedPhone extends Phone {

    private final int discountPercent;

    public RefurbishedPhone(String description, float cost, int manufactureYear, int discountPercent) {
        super(description, cost, manufactureYear);
        this.discountPercent = discountPercent;

    }

    public String getDescription() {
        return "Refurbished " + super.getDescription();
    }

    public float getCost() {
        return super.getCost() * discountPercent / 100;
    }
}

class Accessory extends Item {
    private final String model;

    public Accessory(String description, float cost, String model) {
        super(description, cost);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return model + super.getDescription();
    }
}

class Cart {
    private final Item[] items;
    private int counter;

    public Cart() {
        this.items = new Item[100];
        counter = 0;
    }

    public float getCost() {
        float s = 0;
        for (Item i : items) {
            if (i==null){
                break;
            }
            s += i.getCost();
        }
        return s;
    }

    public void addItem(Item item) {
        if (counter >= 100) {
            return;
        }
        items[counter++] = item;
    }

    public float getShippingFee() {
        return (getCost() <= 1000) ? counter : 0;
    }

    public Item[] getItems() {
        return Arrays.copyOf(items, counter);
    }
}

public class MobilePhoneShop {
    public static void main(String[] args) {

        Item secondHandIphone = new RefurbishedPhone("Iphone14", 1400, 2022, 50);
        Item screenProtector = new Accessory("Screen protector", 10, "Iphone14");

        Cart myShoppingCart = new Cart();
        myShoppingCart.addItem(secondHandIphone);
        myShoppingCart.addItem(screenProtector);

        System.out.println("The items in the cart:");
        for (Item item : myShoppingCart.getItems()) {
            System.out.println("*Item :" + item.getDescription() + " cost: " + item.getCost());
        }

        System.out.println("Total cost of cart including shipping fee is: " + ((float) myShoppingCart.getCost() + (float) myShoppingCart.getShippingFee()));
    }
}
