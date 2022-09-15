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

    public boolean remove(T anEntry);

    public void clear();

    public int getFrequencyOf(T anEntry);

    public boolean contains(T anEntry);

    public T[] toArray();
}
