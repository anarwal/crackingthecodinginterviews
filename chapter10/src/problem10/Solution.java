package problem10;

/**
 * Created by abhimanyunarwal on 2/28/17.
 * Rank from stream: Imagine you are reading in a stream of integers. Periodically you wish to be able to look up the
 * rank of a number x (the number of values less than or equal to x). Implement the data structures and algorithms to
 * support  these operations. That is, implement the method track(int x), which is called when each number is generated
 * and the method getRankOfNumber(int x), which returns the number of values less than or equal to x (not including itself)
 * Example:
 * Stream (in order of appearance): 4,1,4,4,5,9,7,13,3
 * getRankOfNumber(1) = 0
 * getRankOfNumber(3) = 1
 * getRankOfNumber(4) = 3
 */
public class Solution {

  //Create data Structure class Node
  public class Node {
      public int lSize = 0;
      public Node nodeL, nodeR;
      public int data = 0;

      public Node(int d) {
          data = d;
      }

      Node root = null;

      public void insert(int num) {
          if (num < data) {
              if (nodeL != null) {
                  nodeL.insert(num);
              } else {
                  nodeL = new Node(num);
                  lSize++;
              }
          } else {
              if (nodeR != null) {
                  nodeR.insert(num);
              } else {
                  nodeR = new Node(num);
              }
          }

      }

      public void track(int num) {
          if (root == null) {
              root = new Node(num);
          } else {
              root.insert(num);
          }
      }

      public int getRank(int number) {
          return root.getRankOfNumber(number);
      }

      public int getRankOfNumber(int x) {
          if (x == data) {
              return lSize;
          } else if (x < data) {
              if (nodeL == null) {
                  return -1;
              } else {
                  return nodeL.getRankOfNumber(x);
              }
          } else {
              int rRank = nodeR == null ? -1 : nodeR.getRankOfNumber(x);
              if (rRank == -1) {
                  return -1;
              } else {
                  return lSize + 1 + rRank;
              }
          }
      }


  }
}
