package crawler;

/**
 * 
 * @author gshen
 *
 */
public interface LinkHandler {
	
	
	/**
	 * 
	 * @param link
	 * @throws Exception
	 */
    public void queueLink(String link) throws Exception;

    
    /**
     * 
     * @param link
     * @return
     */
    public  boolean visited(String link);
    

    /**
     * 
     * @param link
     */
    public void addVisited(String link);
    
    
    /**
     * 
     * @return
     */
    public int size();


}
