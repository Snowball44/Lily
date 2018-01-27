
package lily;

import java.util.Comparator;


public class CompareEnding implements Comparator<EndingResult> {

  
   @Override
   public int compare(EndingResult object1, EndingResult object2)
   {
      return object1.getName().compareTo(object2.getName());
   }
}
