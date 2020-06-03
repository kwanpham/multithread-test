package callback.asynchronous;



import javax.swing.*;
import java.awt.*;

/**
 * Created by https://github.com/kwanpham
 */
public class GiaoDien extends Canvas {
    private Download download;

    private Graphics g = this.getGraphics();
    /**
     * phuong thuc khoi tao Giao dien, dong thoi dat lang nghe su kien download
     */
    public GiaoDien() {
        download = new Download();

    }

    @Override
    public void update(Graphics g) {
      getGraphics().drawImage(i, 50,60, this);
    }

    private void showImage(byte[] bytes) {
        Toolkit t= Toolkit.getDefaultToolkit();
        if (bytes ==null){
            i=t.getImage("image/pngtree-red-error-icon-button-image_1357105.jpg");
        } else {
            i=t.createImage(bytes);
        }

        update(g);

    }


    private void nhanDownload() {
        /** dat lang nghe su kien download */
        download.addDownloadListener(new Download.CapNhat() {
            @Override
            public void capNhatGiaoDien(byte[] bytes) {
                showImage(bytes);
            }
        });
        download.download();

    }

    private Image i;



    @Override
    public void paint(Graphics g) {
        Toolkit t= Toolkit.getDefaultToolkit();
        Image i=t.getImage("image/p3.gif");
        g.drawImage(i, 50,60, this);
        g.dispose();

    }

    private void setup(){
        Toolkit t= Toolkit.getDefaultToolkit();
        i=t.getImage("image/p3.gif");
    }

    public static void main(String[] args) throws Exception {
        GiaoDien giaoDien = new GiaoDien();
//
        giaoDien.setup();

        JFrame f=new JFrame();
        f.add(giaoDien);
        f.setSize(800,800);
        //f.setLayout(null);
        f.setVisible(true);

        giaoDien.nhanDownload();
    }
}
