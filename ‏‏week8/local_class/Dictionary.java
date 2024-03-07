/**
 * in this example, we have a Dictionary class that contains a list of TripletItem objects.
 * we want to be able to iterate over the list of TripletItem objects, so we implement the Iterable interface.
 * we use a local class to implement the Iterator interface.
 *
 * to implement the Iterator interface, we need to implement the hasNext() and next() methods.
 * */

package local_class;

import java.util.ArrayList;
import java.util.Iterator;

class TripletItem {
	private final String name;
	private final String value;
	private final int id;

	public TripletItem(String n, String v, int id) {
		name = n;
		value = v;
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("[%s, %s, %d]", name, value, id);
	}
}

class Dictionary implements Iterable<TripletItem> {
	private final ArrayList<TripletItem> dict = new ArrayList<>();

	void add(TripletItem item) {
		dict.add(item);
	}

	public Iterator<TripletItem> iterator() {
		/* local class */

		Iterator<TripletItem> iter=new Iterator<TripletItem>(){
			int index = 0;

			// Checks if the next element exists
			public boolean hasNext() {
				return index < dict.size();
			}

			// moves the cursor/iterator to next element
			public TripletItem next() {
				return dict.get(index++);
			}
		};
		return iter;
	}
}

class Main {
	public static void main(String[] args) {
		Dictionary dict = new Dictionary();
		dict.add(new TripletItem("#1", "A", 543));
		dict.add(new TripletItem("#2", "B", 6542));
		dict.add(new TripletItem("#3", "C", 875));
		for (TripletItem tripletItem : dict) {
			System.out.println(tripletItem);
		}
	}
}


