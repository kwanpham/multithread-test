package join;

/**
 * Created by https://github.com/kwanpham
 */
public class ServiceOne implements Runnable {

    @Override
    public void run() {
        System.out.println("service One");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Started service One");
    }
}