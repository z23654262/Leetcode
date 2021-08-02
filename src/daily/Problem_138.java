package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 138.复制带随机指针的链表
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * @author sfzhang
 * @since 2021年7月22日
 */
public class Problem_138 {

}
//Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
        	return null;
        }
        //创建哈希表
        Map<Node,Node> map = new HashMap<Node,Node>();
        //构造新链表（无next和random）
        Node temp = head;
        while(temp!=null){
        	Node newNode = new Node(temp.val);
        	map.put(temp, newNode);
        	temp = temp.next;
        }
        //添加next和random关系
        temp = head;
        while(temp!=null){
        	Node newNode = map.get(temp);
        	if(temp.next!=null){
        		newNode.next=map.get(temp.next);
        	}
        	if(temp.random!=null){
        		newNode.random=map.get(temp.random);
        	}
        	temp = temp.next;
        }
        return map.get(head);
    }
}
