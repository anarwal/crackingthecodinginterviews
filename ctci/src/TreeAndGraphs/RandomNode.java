package TreeAndGraphs;


import java.util.Random;

/**
 * Created by abhimanyunarwal on 4/13/20.
 * Random Node: Implement a BST class from scratch  to insert, find and delete. It also has a method getRandomNode(),
 * which return random node from tree. All nodes should be equally likely to be chosen.
 */


public class RandomNode {
    // Using Inorder traversal along with the approach where nodes are returned with 1/N probability. As number of left nodes != right nodes so while picking anything
    // from left node = left_size*1/N

    private int data;
    public RandomNode node;
    public RandomNode left;
    RandomNode right;
    private int size;

    public RandomNode(int data) {
            data = data;
            size =1;
    }

    public RandomNode getRandomNode(){
        int leftSize = left ==null ? 0 :left.size();
        Random random = new Random();
        int index = random.nextInt(size);
        if(index < leftSize){
            return left.getRandomNode();
        }else if( index == leftSize){
            return  this;
        }else{
            return right.getRandomNode();
        }
    }

    public void insertInOrder(int d){
        if(d <= data){
            if(left == null){
                left = new RandomNode(d);
            }else{
                left.insertInOrder(d);
            }
        }else{
            if(right == null){
                right = new RandomNode(d);
            }else{
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public int size() {return size;}
    public int data() {return data;}

    public RandomNode find(int d){
        if (d == data){
            return this;
        }else if(d<data){
            return left != null ? left.find(d) : null;
        }else if (d>data){
            return right != null ? right.find(d) : null;
        }
        return null;
    }
}
