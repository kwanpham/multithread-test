package threadpool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by https://github.com/kwanpham
 */
public class ThreadPoolExecutorCrawlData {

    public static void main(String[] args) throws IOException {
        //Set the URL to connect
        String url="http://whiskyhathanh.com/danh-muc-san-pham/single-malt-whisky/";

        //Fetch and parse HTML file from the web into a Document object
        Document document= Jsoup.connect(url).ignoreHttpErrors(true).get();
        Elements elements = document.select("#main > div > div.col.large-9 > div > div.products.row.row-small.large-columns-4.medium-columns-3.small-columns-2 > div");

        int corePoolSize = 5;
        int maximumPoolSize = 20;
        int queueCapacity = 100;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, // Số corePoolSize
                maximumPoolSize, // số maximumPoolSize
                10, // thời gian một thread được sống nếu không làm gì
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueCapacity)); // Blocking queue để cho request đợi
        // 1000 request đến dồn dập, liền 1 phát, không nghỉ
        
        for (Element elementTemp : elements) {
            executor.execute(new RequestHandler(elementTemp));
        }

        executor.shutdown();

       

    }
}

