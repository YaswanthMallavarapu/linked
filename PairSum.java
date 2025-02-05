/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        Node tail=head;
        Node start=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        while(tail.data>start.data){
            int sum=start.data+tail.data;
            if(sum==target){
               ArrayList<Integer> ans1=new ArrayList<>();
               ans1.add(start.data);
               ans1.add(tail.data);
               ans.add(ans1);
               tail=tail.prev;
               start=start.next;
            }
            else if(sum>target){
                tail=tail.prev;
                
            }
            else{
                start=start.next;
            }
        }
        return ans;
    }
}
        
