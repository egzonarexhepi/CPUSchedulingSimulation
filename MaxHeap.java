/**
 * 
 * using an array list to implement a maxheap
 * 
 */
import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>>{
	
	public static final int heapRoot = 1;
    private int size;
    private ArrayList<T> maxh;


	public MaxHeap()
    {
        maxh = new ArrayList<>();
        maxh.add(null);
    }
	
	
    public void maxHeapify(int index){
        int larger;
        int toleft = (index * 2);
        int toRight = (index * 2) + 1;

        if(toleft <= size && maxh.get(toleft).compareTo(maxh.get(index)) == 1){
            larger = toleft;
        }
        else
            larger = index;

        if(toRight <= size && maxh.get(toRight).compareTo(maxh.get(larger)) == 1){
            larger = toRight;
        }

        if(larger != index){
            swap(index, larger);
            maxHeapify(larger);
        }
    }
    
    public void buildMaxHeap(){
        size = maxh.size() - 1;
        for (int i =(maxh.size()) / 2; i > 0 ; i--){
            maxHeapify(i);
        }
    }
    
    public T maximum(){
        return maxh.get(heapRoot);
      }

    public void heapSort() {
        buildMaxHeap();
        int  heapSize = size;
        for (int i = heapSize; i > heapRoot; i--){
            swap(heapRoot,i);
            size--;
            maxHeapify(heapRoot);
        }

        size = maxh.size() - 1;
    }
    
    public void insert(T key){
        maxh.add(heapRoot,key);
        size = maxh.size();
        buildMaxHeap();
    }
    
    
    public T get(int index){
        if(index < heapRoot){
        	System.out.println("Invalid Input");
        }
        return maxh.get(index);
    }

    public T extractMax() {
        if(size < heapRoot){
        	System.out.println("Invalid Input");
        }

        T max = maxh.remove(heapRoot);
        size--;
        buildMaxHeap();
        return max;
    }
    
    public void increaseKey(int index, T key){
        if(key.compareTo(maxh.get(index)) == -1) {
        	System.out.println("Invalid Input");
        }

        maxh.set(index,key);
        while (index  > heapRoot && maxh.get((index / 2 ) + 1).compareTo(maxh.get(index)) == -1){
            swap(index,((index / 2) + 1));
            index = ((index / 2) + 1);
        }
        maxHeapify(heapRoot);
    }
    
    private void swap(int p, int j){
        T temp = maxh.get(p);
        maxh.set(p, maxh.get(j));
        maxh.set(j,temp);
    }
    
    public ArrayList<T> getMaxHeap(){
        return maxh;
    }
    

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        return maxh.toString();
    }


	public void clearMaxHeap() {
		   maxh.clear();
	       maxh.add(null);		
	}
    
}
