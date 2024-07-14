import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> sharedBuffer;
    private int size;

    public SharedResource(int size){
        this.sharedBuffer = new LinkedList<>();
        this.size = size;
    }

    public synchronized void produce(int item) throws Exception{
        while(sharedBuffer.size()==size){
            System.out.println("Resource is Full, producer is waiting for consumer");
            wait();
        }
        sharedBuffer.add(item);
        System.out.println("Produced: "+item);
        notify();
    }

    public synchronized int consume() throws Exception{

        while (sharedBuffer.isEmpty()){
            System.out.println("Buffer is empty, consumer is waiting in producer");
            wait();
        }
        int item = sharedBuffer.poll();
        System.out.println("Consumed: "+item);
        //notify the producer that there is space in the buffer now.
        notify();
        return item;
    }
}