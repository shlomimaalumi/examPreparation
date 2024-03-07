package abstract_vs_interface;

public interface Interface {
	// can only have public, final static fields
	public static final int CONSTANT = 2;

	// can have abstract public methods
	public void publicFunc(int a);

	//or implemented default or private methods
	private void privateFunc(){
		publicFunc(CONSTANT);
	}

	default void defaultFunc(int iterations){
		for (int i = 0; i < iterations; i++)
			privateFunc();
	}
}
