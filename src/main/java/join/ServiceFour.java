package join;

/**
 * Created by https://github.com/kwanpham
 */
public class ServiceFour extends Thread {



    @Override
    public void run() {
        System.out.println("service Four");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Started service Four");
    }
}
