package general;

public class FindMaxDepthAndStringParenthesis {
        static Character maxDepth(String S) {
            int current_max = 0; // current count
            int max = 0; // overall maximum count
            int n = S.length();
            char ch = '\0';

            // Traverse the input string
            for (int i = 0; i < n; i++) {
                if (S.charAt(i) == '(') {
                    current_max++;

                    // update max if required
                    if (current_max > max) {
                        max = current_max;
                         ch = S.charAt(i+1);
                    }
                } else if (S.charAt(i) == ')') {
                    if (current_max > 0) {
                        current_max--;
                    } else {
                        return null;
                    }
                }
            }

            // finally check for unbalanced string
            if (current_max != 0) {
                return null;
            }

            return ch;
        }

        // Driver program
        public static void main(String[] args) {
            String s = "( ((X)) (((Y))) )";
            System.out.println(maxDepth(s));
        }
}
