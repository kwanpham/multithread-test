package callback.synchronous;

/**
 * Created by https://github.com/kwanpham
 */
public class Download {

    public interface CapNhat {
        public void capNhatGiaoDien(int giaTri);
    }

    private CapNhat capNhat;

    /**
     * @param capNhat
     *            lang nghe su kien download
     */
    public void addDownloadListener(CapNhat capNhat) {
        this.capNhat = capNhat;
    }

    public void download() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Dang download...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /**
             * Khi goi capNhat.capNhatGiaoDien(i); thi phuong thuc nay se tu
             * dong duoc goi trong giao dien
             * */

            capNhat.capNhatGiaoDien(i);
        }
        System.out.println("Ket thuc download");
    }
}
