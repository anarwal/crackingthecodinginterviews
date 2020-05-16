package general;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestAbsoluteFilePath {
    public static int lengthLongestPath(String input) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int res = 0;
        for (String s : input.split("\n")) {
            int lvl = s.lastIndexOf("\t") + 1;
            while (lvl + 1 < st.size()) st.pop();
            int len = st.peek() + s.length() - lvl + 1;  // include "\"
            if (s.contains(".")) res = Math.max(res, len - 1);
            st.push(len);
        }
        return res;
    }
    public static void main(String[] args){
        int result = lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
        System.out.print(result);
    }
}
