package crawler;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 
 * @author gshen
 *
 */
public class WebCrawler implements LinkHandler {
	
	
  private final Collection<String> visitedLinks = Collections.synchronizedSet(new HashSet<String>());
  private String url;
  private ExecutorService execService;

  
  /**
   * 
   * @param startingURL
   * @param maxThreads
   */
  public WebCrawler(String startingURL, int maxThreads) {
      this.url = startingURL;
      execService = Executors.newFixedThreadPool(maxThreads);
  }

  public void queueLink(String link) throws Exception {
      startNewThread(link);
  }

  public int size() {
      return visitedLinks.size();
  }

  public void addVisited(String s) {
      visitedLinks.add(s);
  }

  public boolean visited(String s) {
      return visitedLinks.contains(s);
  }

  private void startNewThread(String link) throws Exception {
      execService.execute(new LinkFinder(link, this));
  }

  private void startCrawling() throws Exception {
      startNewThread(this.url);
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws Exception {
      new WebCrawler("http://www.baidu.com", 64).startCrawling();
  }

}
