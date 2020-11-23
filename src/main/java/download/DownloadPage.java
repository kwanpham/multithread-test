package download;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by https://github.com/kwanpham
 */
public class DownloadPage {
    public static void main(String args[]) throws IOException {
        download("https://vn.nhbankglobal.com/css/common.css");
    }
    public static void download(String urlString) throws IOException {
        URL url = new URL(urlString);

        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter writer = new BufferedWriter(new FileWriter("kqct\\NotoSansKR-Bold.woff2"));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            System.out.println("Page downloaded.");
        }
    }

    private String getFileName(URL url) throws MalformedURLException {
        String path = url.getPath();

        return null;
    }
}
