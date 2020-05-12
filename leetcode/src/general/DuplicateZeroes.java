package general;

public class DuplicateZeroes {
    public void duplicateZeros(int[] arr) {
        int zerocounter =0;
        int len = arr.length-1;
        for (int i = 0; i <= len - zerocounter; i++) {
            if (arr[i] == 0) {
                if (i == len - zerocounter) {
                    arr[len] = 0;
                    len -= 1;
                    break;
                }
                zerocounter++;
            }
        }
        int last = len-zerocounter;

        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + zerocounter] = 0;
                zerocounter--;
                arr[i + zerocounter] = 0;
            } else {
                arr[i + zerocounter] = arr[i];
            }
        }
    }
}
