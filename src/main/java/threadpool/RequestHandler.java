package threadpool;

import org.jsoup.nodes.Element;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RequestHandler implements Runnable {
    Element element;

    @Override
    public void run() {
        Element aTag = element.select("a").first();
        String href = aTag.attr("href");
        System.out.println(href);
    }
}