package sorting;

/**
 * Created by abhimanyunarwal on 2/26/17.
 * Sort Big File: Imagine you have a 20 GB file with one string per line. Explain how you would sort the file.
 */
public class Solution {

      /*
      As the question asks just for explanation, I would go ahead and explain my approach. DUe to large size of file
      it is not advisable to use traditional method of sorting to read file and sort because when we will start reading
      RAM will run out-of-memory due to large size of file. Therefore we will read file in small chunks and sort it. We
      will read a specific amount of data from file, sort it and then store it in a temp file. We do this for the whole
      file. After we have complete file sorted we will use mergesort logic to merge these sorted temp files. This approach
      is also known as External Sorting
      */
}
