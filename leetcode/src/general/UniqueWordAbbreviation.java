package general;

import java.util.HashMap;

public class UniqueWordAbbreviation {
    HashMap<String, String> hmap = new HashMap<>();

    public UniqueWordAbbreviation(String[] dictionary) {
        for(String word: dictionary){
            isUnique(word);
        }
    }

    public boolean isUnique(String word) {
        String abbr = createAbbreviation(word);
        if(hmap.containsKey(abbr)){
            if(hmap.get(abbr).equals(word)){
                return true;
            }else{
                return false;
            }

        }else{
            hmap.put(abbr, word);
            return true;
        }
    }

    public String createAbbreviation(String word){
        StringBuilder sb = new StringBuilder();
        int len = word.length();
        sb.append(word.substring(0,0));
        sb.append(word.substring(1, len-1).length());
        sb.append(word.substring(len-1));
        return sb.toString();
    }
}
