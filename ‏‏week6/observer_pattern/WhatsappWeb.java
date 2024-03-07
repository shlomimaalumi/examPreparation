/**
 * in this class we are implementing the Observer interface and we are overriding the update method
 * this is an example of using the observer pattern
 */

package observer_pattern;

public class WhatsappWeb implements Observer{

    private String name;
    private String data;
    private WhatsappMessage tm;

    public WhatsappWeb(WhatsappMessage tm, String name){
        this.tm = tm;
        this.name = name;
    };

    @Override
    public void update() {
        data = tm.getData();
        System.out.println("From observer " + name + ": " + data);
    }

    public String getData(){
        return data;
    }
}
