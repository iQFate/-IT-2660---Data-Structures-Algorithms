public class Main {
  public static void main(String[] args) {
    String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    String bestCase = "A";

    long startTime = System.nanoTime();   // * Initialize startTime here
    int index = match(text, bestCase);
    long endTime = System.nanoTime();   // * Initialize endTime here
    long elapsedTime = endTime - startTime;   // * Calculate elapsedTime here
    
    if (index >= 0)
      System.out.println("best-case input matched at index " + index);
    else
      System.out.println("best-case input unmatched");  

    System.out.println("Best case elapsed time: " + elapsedTime + " ns");

    String worstCase = "XYZ123";
    
    startTime = System.nanoTime();     // * Initialize startTime here
    index = match(text, worstCase);
    endTime = System.nanoTime();     // * Initialize endTime here
    elapsedTime = endTime - startTime;     // * Calculate elapsedTime here
    
    if (index >= 0)
      System.out.println("worst-case input matched at index " + index);
    else
      System.out.println("worst-case input unmatched");  

    System.out.println("Worst case elapsed time: " + elapsedTime + " ns");
  }

  // Return the index of the first match. -1 otherwise.
  public static int match(String text, String pattern) {
    for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
      if (isMatched(i, text, pattern))
        return i;
    }

    return -1;
  }
	
  // Test if pattern matches text starting at index i
  private static boolean isMatched(int i, String text, 
      String pattern) {
    for (int k = 0; k < pattern.length(); k++) {
      if (pattern.charAt(k) != text.charAt(i + k)) {
        return false;
      }
    }
    
    return true;
  }
}