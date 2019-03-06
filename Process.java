/**
 * 
 * @author egzonarexhepi
 *
 */
public class Process implements Comparable<Process>{
    private int priorityLevel;
    private int timeRemainingToFinish;
    private int arrivalTime;
    private int timeNotProcess;


    public Process(int arrivalTime, int requiredProcessTime, int priorityLevel){
        this.priorityLevel = priorityLevel;
        this.arrivalTime = arrivalTime;
        timeRemainingToFinish = requiredProcessTime;
        timeNotProcess = 0;
    }

    
    public int getArrivalTime(){
        return arrivalTime;
    }


    public int getPriority(){
        return priorityLevel;
    }


    public int getTimeRemaining(){
        return timeRemainingToFinish;
    }


    public int getTimeNotProcess(){
        return timeNotProcess;
    }

    @Override
    public int compareTo(Process op){
        if(this.priorityLevel < op.priorityLevel){
            return - 1;
        }
        else if(this.priorityLevel > op.priorityLevel){
            return 1;
        }


        else if(this.arrivalTime < op.arrivalTime){
            return 1;
        }
        return 0;
    }


    public void reduceTimeRemaining(){
        timeRemainingToFinish--;
        resetTimeNotProcessed();
    }


    public void timeNotProcessIncrement(){
        timeNotProcess++;
    }


    public void priorityIncrement(){
        priorityLevel++;
    }


    public void resetTimeNotProcessed(){
        timeNotProcess = 0;
    }


    public boolean finish(){
        return getTimeRemaining() == 0;
    }

    public String toString(){
        return "[Priority level: " + getPriority() + ", Process time: " + getTimeRemaining()  +
                ", Arrival time: " + getArrivalTime() + "]";
    }
}