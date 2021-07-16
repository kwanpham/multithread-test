package callback.asynchronous;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by https://github.com/kwanpham
 */
public class Download {

    public interface CapNhat {
        public void capNhatGiaoDien(byte[] bytes);
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

        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                try {
                    url = new URL(null,"http://i.ytimg.com/vi/qvYQXACJ4es/maxresdefault.jpg");
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    conn.setDoInput(true);
                    conn.connect();
                    InputStream in = new BufferedInputStream(conn.getInputStream());
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    byte[] buf = new byte[1024];
                    int n = 0;
                    while (-1!=(n=in.read(buf)))
                    {
                        out.write(buf, 0, n);
                    }
                    out.close();
                    in.close();
                    byte[] response = out.toByteArray();

                    capNhat.capNhatGiaoDien(response);
                    System.out.println("Kết thức download");
                } catch (Exception e) {
                    capNhat.capNhatGiaoDien(null);
                    System.out.println("Lỗi download");
                    e.printStackTrace();
                }

            }
        }).start();



        System.out.println("Đang download");
    }
}
