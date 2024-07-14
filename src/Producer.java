public class Producer implements Runnable{

    private SharedResource shared;

    public Producer(SharedResource shared){
        this.shared = shared;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 6; i++) {
            try {
                shared.produce(i);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
