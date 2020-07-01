package threadpool;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RequestHandler implements Runnable {
    Element element;

    @SneakyThrows
    @Override
    public void run() {
        Element aTag = element.select("a").first();
        String href = aTag.attr("href").replace("https" , "http");
        Document document= Jsoup.connect(href).ignoreHttpErrors(true).get();

       Element productName = document.select("html > body > div:nth-of-type(1) > main > div > div:nth-of-type(2) > div > div:nth-of-type(1) > div > div:nth-of-type(2) > h1").get(0);
        Element productPrice = document.select("html > body > div:nth-of-type(1) > main > div > div:nth-of-type(2) > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2) > p > span").get(0);
        Element productDetail = document.select("#tab-description").get(0);

        System.out.println(String.format("%s $s $s" , productName.text() , productPrice.text() , productDetail.text()));
    }
}