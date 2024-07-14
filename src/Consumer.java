public class Consumer implements Runnable{

    private SharedResource shared;
    public Consumer(SharedResource shared){
        this.shared = shared;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 6; i++) {
            try {
                shared.consume();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
