package general;

import java.util.*;

public class RemoveSubFolders {
    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() -o2.length();
            }
        });
        List<String> result = new ArrayList<>();
        Set<String> hset = new HashSet<>();
        for(int i=0; i<folder.length; i++){
            if(folder[i].length() == 2){
                hset.add(folder[i]);
                result.add(folder[i]);
            }
            String[] strArray = folder[i].split("/");
            StringBuilder sb = new StringBuilder();
            boolean exists= false;
            sb.append("/");
            for(int j=1; j<strArray.length; j++){
                sb.append(strArray[j]);
                if(hset.contains(sb.toString())){
                    exists =true;
                    break;
                }
                else sb.append("/");
            }
            if(!exists){
                hset.add(folder[i]);
                result.add(folder[i]);
            }
            exists= false;

        }
        return result;
    }

    public static void main(String[] args){
        int m = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        String[] arr = new String[m];
        for(int i=0; i<m;i++){
            arr[i] = scanner.next();
        }
        List<String> result = removeSubfolders(arr);
        for(String s: result){
            System.out.println(s);
        }
        scanner.close();
    }
}
