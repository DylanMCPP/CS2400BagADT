package dwmichalak.cs2400.bagadt;

import java.util.Arrays;

public class ArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private static final int defaultCapacity = 20;
    private int entryCount;
    private boolean integrityOK = false;
    private static final int maximumCapacity = 20480;
    
    /**
     * creates an empty bag with a capacity of 20
     */
    public ArrayBag() {
        this(defaultCapacity);
    }

    /**
     * creates an empty bag with the specified capacity
     * @param capacity the starting capacity desired
     */
    public ArrayBag(int capacity) {
        if (capacity <= maximumCapacity) {
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[capacity]; //cast is okay because all values in new Array are null
            bag = tempBag;
            entryCount = 0;
            integrityOK = true;
        }
        else {
            throw new IllegalStateException("Specified bag capacity" + 
            "exceeds the allowed maximum");
        }
    }

    //throws exception if bag is not initialized
    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException("ArrayBag object is corrupt.");
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
        checkIntegrity();
        if (entryCount == bag.length) {
            if (2*bag.length < maximumCapacity) {
                bag = Arrays.copyOf(bag, 2*bag.length);
            } else
                return false;
        }

        bag[entryCount] = newEntry;
        entryCount++;
        //System.out.println(bag[i]);
        return true;
    }


    /**
     * removes the last object from the bag and returns it
     * @return
     */
    public T remove() {
        checkIntegrity();
        if (entryCount > 0) {
            T removed = bag[entryCount-1];
            bag[entryCount-1] = null;
            entryCount--;
            return removed;
        } else
            throw new IndexOutOfBoundsException("attempted to remove from" + 
            "an empty bag");
    }

    /**
     * removes one instance of anEntry from the bag
     * @param anEntry the object reference to be removed
     * @return true, if successful
     */
    public boolean remove(T anEntry) {
        checkIntegrity();
        int i = 0;
        boolean succ = false;
        while (!bag[i].equals(anEntry) && i < entryCount) {
                i++;
        }
        if (bag[i].equals(anEntry)) {
            bag[i] = null;
            for (int c = i; c < entryCount; c++) {
                T temp = bag[c+1];
                bag[c+1] = null;
                bag[c] = temp;
            }
            entryCount--;
            succ = true;
        }     
        return succ;
    }

    /**
     * clears all entries from the bag
     */
    public void clear() {
        checkIntegrity();
        for (int i = 0; i < bag.length; i++) {
            bag[i] = null;
        }
    }

    /**
     * shows the number of times anEntry appears in the bag
     * @param anEntry the entry that will have its frequency counted
     * @return an int, the number of times the entry appears in the bag
     */
    public int getFrequencyOf(T anEntry) {
        checkIntegrity();
        int frequency = 0;
        for (T entry: bag) {
            if (entry.equals(anEntry))
                frequency++;
        }
        return frequency;
    }

    /**
     * shows whether or not anEntry exists in the bag
     * @param anEntry the entry that will be searched for
     * @return true, if at least 1 instance of anEntry appears in the bag
     */
    public boolean contains(T anEntry) {
        checkIntegrity();
        int i = 0;
        boolean cont = false;
        while (!bag[i].equals(anEntry) && i < entryCount) {
                i++;
        }
        if (bag[i].equals(anEntry)) 
            cont = true;
        return cont;
    }

    /**
     * allocates memory for a brand new array containing the contents of the bag
     * @return the new array T[]
     */
    public T[] toArray() {
        checkIntegrity();
        @SuppressWarnings("unchecked")
        T[] newArray = (T[])new Object[entryCount]; //cast is okay because it works for bag already
        
        //moves bag contents into newArray with no empty spaces
        for(int i = 0; i < entryCount; i++) {
            newArray[i] = bag[i];
        }
        
        return newArray;
    }
}