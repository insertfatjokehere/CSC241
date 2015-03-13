public class Sort {


   int binarySearch(Textbook[] lib, Textbook search, int start, int end){
      if ((end - start) <= 1) {
          return -1;
      } else {
          
	  int midpoint = (end + start) / 2;
           if (lib[midpoint].compareTo(search) < 0){
	     return binarySearch(lib, search, midpoint, end);
	   } else if (lib[midpoint].compareTo(search) > 0 && lib[midpoint].compareTo(search) != 1) {
	      return binarySearch(lib, search, start, midpoint);
	   } else {
             return midpoint;
	   }

      }
   }



   void quickSort(Textbook[] list, int low, int high){
      int leftIndex = low;
      int rightIndex = high + 1;
      Textbook pivot, temp;
      pivot = list[leftIndex];

      do {
         do {
	    leftIndex++;
	 } while (leftIndex <= high && list[leftIndex].toString().compareTo(pivot.toString()) < 0);
	 
	 do {
	    rightIndex--;
	 } while (list[rightIndex].toString().compareTo(pivot.toString()) > 0);
      
	 if (leftIndex < rightIndex){
            temp = list[leftIndex];
	    list[leftIndex] = list[rightIndex];
	    list[rightIndex] = temp;
	 }

      } while (leftIndex <= rightIndex);

      temp = list[low];
      list[low] = list[rightIndex];
      list[rightIndex] = temp;

      // Recursive methods to sort left and right of the pivot
      if (low < rightIndex){
        quickSort(list, low, rightIndex);
      }

      if (leftIndex < high){
        quickSort(list, leftIndex, high);
      }


   }

}	
