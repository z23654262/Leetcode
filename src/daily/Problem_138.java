package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 138.���ƴ����ָ�������
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * @author sfzhang
 * @since 2021��7��22��
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
        //������ϣ��
        Map<Node,Node> map = new HashMap<Node,Node>();
        //������������next��random��
        Node temp = head;
        while(temp!=null){
        	Node newNode = new Node(temp.val);
        	map.put(temp, newNode);
        	temp = temp.next;
        }
        //���next��random��ϵ
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
