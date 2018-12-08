package coding;

import com.google.common.collect.SetMultimap;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chuan on 2018/12/8.
 */
public class RemoveRep {
    /**
     *时间复杂度O(N) 空间复杂度O(N)
     *
     * @param head
     * @return
     */
    public Node removeRep1(Node head){
        if(head==null){
            return null;
        }
        Set<Integer> set=new HashSet<>();
        Node pre=head;
        Node cur=head.next;
        set.add(pre.value);

        while(cur!=null){
            if(set.contains(cur.value)){
                pre.next=cur.next;
            }else{
               set.add(cur.value);
                pre=cur;
            }
            cur=cur.next;
        }
        return head;
    }


    public Node removeRep2(Node head){
        Node cur=head;
        Node pre=null;
        Node next=null;
        while(cur!=null){
            pre=cur;
            next=cur.next;
            while (next!=null){
                if(cur.value==next.value){
                    pre.next=next.next;
                }else{
                    pre=next;
                }
                next=next.next;
            }
            cur=cur.next;
        }
        return head;
    }
}
