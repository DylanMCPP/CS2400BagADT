package dwmichalak.cs2400.bagadt;

public interface BagInterface<T> {
    
    /** 
     * gets the current size of the bag
     * @return an integer, the number of objects in the bag
     */
    public int getCurrentSize();

    /**
     * checks whether or not the bag is empty
     * @return true if there are any objects in the bag, otherwise false
     */
    public boolean isEmpty();

    /**
     * adds an object to some location in the bag
     * @param newEntry the Object to be added to the bag
     * @return true if the add is successful, otherwise false
     */
    public boolean add(T newEntry);

    /**
     * removes the first object from the bag and returns it
     * @return
     */
    public T remove();

    /**
     * removes one instance of anEntry from the bag
     * @param anEntry the object reference to be removed
     * @return true, if successful
     */
    public boolean remove(T anEntry);

    /**
     * clears all entries from the bag
     */
    public void clear();

    /**
     * shows the number of times anEntry appears in the bag
     * @param anEntry the entry that will have its frequency counted
     * @return an int, the number of times the entry appears in the bag
     */
    public int getFrequencyOf(T anEntry);

    /**
     * shows whether or not anEntry exists in the bag
     * @param anEntry the entry that will be searched for
     * @return true, if at least 1 instance of anEntry appears in the bag
     */
    public boolean contains(T anEntry);

    /**
     * allocates memory for a brand new array containing the contents of the bag
     * @return the new array T[]
     */
    public T[] toArray();
}
