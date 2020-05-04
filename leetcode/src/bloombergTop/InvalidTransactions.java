package bloombergTop;

import java.util.*;

class InvalidTransactions {
    class Transaction {
        String name;
        int time;
        int amount;
        String city;

        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        Transaction[] trans = new Transaction[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            String[] data = transactions[i].split(",");
            trans[i] = new Transaction();
            trans[i].name = data[0];
            trans[i].time = Integer.parseInt(data[1]);
            trans[i].amount = Integer.parseInt(data[2]);
            trans[i].city = data[3];

        }

        //sorted
        Arrays.sort(trans, (t1, t2) -> {
            return t1.time - t2.time;
        });

        List<String> alist = new ArrayList<>();

        for (int i = 0; i < trans.length; ++i) {
            for (int j = 0; j < trans.length; ++j) {
                if (i == j) continue;
                if (trans[i].amount > 1000) {
                    alist.add(trans[i].toString());
                    break;
                } else if (trans[i].name.equals(trans[j].name) && !trans[j].city.equals(trans[i].city) && Math.abs(trans[i].time - trans[j].time) <= 60) {
                    alist.add(trans[i].toString());
                    break;
                }
            }
        }

        return alist;
    }
}
