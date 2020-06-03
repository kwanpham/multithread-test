package callback.synchronous;

/**
 * Created by https://github.com/kwanpham
 */
public class GiaoDien {
    private Download download;

    /**
     * phuong thuc khoi tao Giao dien, dong thoi dat lang nghe su kien download
     */
    public GiaoDien() {
        download = new Download();
        /** dat lang nghe su kien download */
        download.addDownloadListener(new Download.CapNhat() {
            /**
             * Tu dong duoc goi trong qua trinh download thong qua interface CapNhap
             */
            @Override
            public void capNhatGiaoDien(int giaTri) {
                System.out.println("class giao dien cap nhat duoc: " + giaTri + "%");
            }
        });
    }

    private void nhanDownload() {
        download.download();

    }




    public static void main(String[] args) {
        GiaoDien giaoDien = new GiaoDien();

        giaoDien.nhanDownload();
    }
}
