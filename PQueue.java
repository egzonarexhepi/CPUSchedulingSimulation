/**
 * using a maxHeap to implement a priority queue
 * 
 * @author egzonarexhepi
 *
 */
public class PQueue {
    private MaxHeap<Process> queue;

    public PQueue(){
        queue = new MaxHeap<>();
    }


    public Process dePQueue(){
        return queue.extractMax();
    }


    public void update(int timeToIncrementPriority, int maxLevel){
        for(int i = MaxHeap.heapRoot; i <= queue.size(); i++){
            Process p = queue.get(i);
            p.timeNotProcessIncrement();
            if(timeToIncrementPriority <= p.getTimeNotProcess()){
                if(p.getPriority() < maxLevel)
                {
                    p.priorityIncrement();
                }
                p.resetTimeNotProcessed();
            }
        }
        queue.buildMaxHeap();
    }

 
    public void enPQueue(Process p){
        queue.insert(p);
    }


    public boolean isEmpty(){
        return queue.size() < MaxHeap.heapRoot;
    }

 
    public void clearQueue(){
    	queue.clearMaxHeap();
    }

    public String toString(){
        return queue.toString();
    }
}