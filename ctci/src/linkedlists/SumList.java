package linkedlists;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by abhimanyunarwal on 3/30/20.
 * SumList: Two numbers are represented by linked list in reverse order (7->1->6) means 617, find the sum of two numbers and return it as list.
 */

public class SumList {
    public static LinkedList<Integer> sumList(LinkedList<Integer> l1, LinkedList<Integer> l2){
        LinkedList<Integer> response = new LinkedList<>();
        int num1 =0;
        for(int i=l1.size()-1; i>=0; --i ){
            num1 = 10*num1 + l1.get(i);
        }
        int num2 =0;
        for(int j=l2.size()-1; j>=0; --j ){
            num2 = 10*num2 + l2.get(j);
        }
        int sum = num1+num2;
        while(sum>0){
            response.addLast(sum %10);
            sum /= 10;
        }
        return response;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        int lenl1 = scanner.nextInt();
        int lenl2 = scanner.nextInt();
        for(int i=0; i<lenl1; i++){
            l1.add(scanner.nextInt());
        }
        for(int j=0; j<lenl2; j++){
            l2.add(scanner.nextInt());
        }
        LinkedList<Integer> response = sumList(l1, l2);
        for(int k=0; k<response.size(); k++){
            System.out.print(response.get(k)+"->");
        }
        scanner.close();
    }
}
