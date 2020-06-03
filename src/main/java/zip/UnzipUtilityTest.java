package zip;

/**
 * Created by https://github.com/kwanpham
 */
public class UnzipUtilityTest {

    public static void main(String[] args) {
        String zipFilePath = "D:\\Downloads\\Compressed\\Photoshop CS6.zip";
        String destDirectory = "F:/Pics";
        UnzipUtility unzipper = new UnzipUtility();
        try {
            unzipper.unzip(zipFilePath, destDirectory);
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
    }
}
