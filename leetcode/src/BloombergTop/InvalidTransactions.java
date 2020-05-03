package BloombergTop;

import java.util.*;


class InvalidTransactions {
    class Transaction {
        String name;
        int time;
        int amount;
        String city;

        @Override
        public String toString() {return name + ","+time+","+amount+","+city;}
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

        if (!isAmountValid(trans[0])) {
            alist.add(trans[0].toString());
        }

        for (int i = 1; i < trans.length; i++) {

            if (!isTimeValid(trans[i - 1], trans[i])) {
                alist.add(trans[i].toString());
            } else if (!isAmountValid(trans[i])) {
                alist.add(trans[i].toString());
            }
        }
        return alist;
    }

    static boolean isAmountValid(Transaction str) {
        if (str.amount > 1000) {
            return false;
        }
        return true;
    }

    static boolean isTimeValid(Transaction s1, Transaction s2) {
        if (s1.time < s2.time + 60) {
            if (s1.name.equals(s2.name)) {
                if (!(s1.city.equals(s2.city))) {
                    return false;
                }
            }
        }
        return true;
    }

}
