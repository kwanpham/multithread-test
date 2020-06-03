package join;

/**
 * Created by https://github.com/kwanpham
 */
public class ServiceThree implements Runnable {

    @Override
    public void run() {
        System.out.println("service Threee");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Started service Three");
    }

}