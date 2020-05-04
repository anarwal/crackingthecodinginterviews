package thirtyDaysToCode;

import java.util.*;

public class Dinasour {
        public static void main(String []args){
            List<String> s1 = new ArrayList<>(Arrays.asList("Euoplocephalus,1.97,quadrupedal", "Stegosaurus,1.70,quadrupedal","Tyrannosaurus Rex,4.76,bipedal","Hadrosaurus,1.3,bipedal","Deinonychus,1.11,bipedal","Struthiomimus,1.24,bipedal","Velociraptorr,2.62,bipedal"));

            List<String> s2 = new ArrayList<>(Arrays.asList("Hadrosaurus,1.4,herbivore","Struthiomimus,0.72,omnivore","Velociraptor,1.8,carnivore","Triceratops,0.47,herbivore","Euop,locephalus,2.6,herbivore","Stegosaurus,1.50,herbivore","Tyrannosaurus Rex,6.5,carnivore"));

            HashMap<String,Double> map = new HashMap<>();

            for(String s : s1)
            {
                String[] temp = s.split(",");
                if(temp[2].equals("bipedal"))
                {
                    map.put(temp[0], Double.valueOf(temp[1]));
                }
            }

            for(String s : s2)
            {
                String[] temp = s.split(",");
                if(map.containsKey(temp[0]))
                {
                    map.put(temp[0], map.get(temp[0]) + Double.valueOf(temp[1]));
                }
            }

            PriorityQueue<String> pq = new PriorityQueue<String>((a, b)-> (map.get(a) > map.get(b) ? -1: 1));

            for(String s : map.keySet())
                pq.offer(s);

            List<String> output = new ArrayList<>();
            while(!pq.isEmpty())
            {
                System.out.println(pq.peek());
                System.out.println(map.get(pq.poll()));
            }


        }
}
