package dwmichalak.cs2400.bagadt;

import java.util.Arrays;

public class ArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private static final int defaultCapacity = 20;
    private int entryCount = 0;
    private static final int maximumCapacity = 20480;
    

    public ArrayBag() {
        this(defaultCapacity);
    }

    public ArrayBag(int capacity) {
        if (capacity <= maximumCapacity) {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[capacity];
            bag = tempBag;
        }
        else {
            throw new IllegalStateException("Specified bag capacity exceeds the allowed maximum");
        }
    }
    /** 
     * gets the current size of the bag
     * @return an integer, the number of objects in the bag
     */
    public int getCurrentSize() {
        return entryCount;
    }

    /**
     * checks whether or not the bag is empty
     * @return true if there are any objects in the bag, otherwise false
     */
    public boolean isEmpty() {
        return entryCount == 0;
    }

    /**
     * adds an object to the first empty location in the bag
     * @param newEntry the Object to be added to the bag
     * @return true if the add is successful, otherwise false
     */
    public boolean add(T newEntry) {
        if (entryCount == bag.length)
            bag = Arrays.copyOf(bag, 2*bag.length);
        
        int i = 0;
        while(bag[i] != null) {
            i++;
        }

        bag[i] = newEntry;
        entryCount++;
        //System.out.println(bag[i]);
        return true;
    }


    /**
     * removes the first object from the bag and returns it
     * @return
     */
    public T remove() {
        
        int i = 0;
        while(bag[i] == null) {
            i++;
        }

        T removed = bag[i];
        bag[i] = null;
        entryCount++;

        return removed;
    }

    /**
     * removes one instance of anEntry from the bag
     * @param anEntry the object reference to be removed
     * @return true, if successful
     */
    public boolean remove(T anEntry) {
        return false;
    }

    /**
     * clears all entries from the bag
     */
    public void clear() {

    }

    /**
     * shows the number of times anEntry appears in the bag
     * @param anEntry the entry that will have its frequency counted
     * @return an int, the number of times the entry appears in the bag
     */
    public int getFrequencyOf(T anEntry) {
        return 0;
    }

    /**
     * shows whether or not anEntry exists in the bag
     * @param anEntry the entry that will be searched for
     * @return true, if at least 1 instance of anEntry appears in the bag
     */
    public boolean contains(T anEntry) {
        return false;
    }

    /**
     * allocates memory for a brand new array containing the contents of the bag
     * @return the new array T[]
     */
    public T[] toArray() {
        return (T[])new Integer[1];
    }
}