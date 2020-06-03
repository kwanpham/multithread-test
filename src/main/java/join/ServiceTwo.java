package join;

/**
 * Created by https://github.com/kwanpham
 */
public class ServiceTwo implements Runnable {

    @Override
    public void run() {
        System.out.println("service two");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Started service Two");
    }

}