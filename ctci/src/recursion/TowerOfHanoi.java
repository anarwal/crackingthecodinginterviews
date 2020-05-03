package recursion;

import java.util.Stack;

/**
 * Created by abhimanyunarwal on 3/7/17.
 * Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes
 * which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom
 * (i.e., each disk sits on top of an even larger one). You have the following  constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto another tower.
 * (3) A disk cannot be placed on top of a smaller disk.
 * Write a program to move the disks from the first tower to the last using stacks.
 */


public class TowerOfHanoi {

    public void main(String[] args) {
        int n=3;
        Tower[] tower = new Tower[n];
        for(int i=0; i<3;i++){
            tower[i]=new Tower(i);
        }

        for (int j=n-1; j>=0; j--){
            tower[0].add(j);
        }

        tower[0].moveDisks(n, tower[2], tower[1]);
        toh(n, "A","B", "C");
    }

    //Recursive Approach (easy way)
    public static void toh(int n, String start, String buffer, String destination){

        if(n==0){
            return;
        }
        else if(n>0){
            toh(n-1, start, destination, buffer);
            System.out.println(start+" > "+destination);
            toh(n-1, buffer, start, destination);
        }
    }


    //Iterative Approach using Stack
    class Tower{

        public Stack<Integer> disks;
        public int index;

        public Tower(int t) {
            disks = new Stack<>();
            index = t;
        }

        //Add a disk to stack
        public void add(int d){

            if(disks.isEmpty() && disks.peek()<0){
                System.out.println("Error");
            }else{
                disks.push(d);
            }

        }

        //Pop and Push top Disk from a tower
        public void moveTop(Tower tower){
            int top = disks.pop();
            tower.add(top);
        }


        //TOH logic for moving disks from source to destination using buffer
        public void moveDisks(int n, Tower destination, Tower buffer){

            if(n>0){
                moveDisks(n-1, buffer, destination);
                moveTop(destination);
                buffer.moveDisks(n-1, destination, this);

            }
        }
    }
}
