package coding;

/**
 * Created by chuan on 2018/12/2.
 */
public class IntersectNode {
    public Node getLoopNode(Node head){
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }
        Node n1=head.next;// n1-->slow
        Node n2=head.next.next;// n2-->fast
        while(n1!=n2){
            if(n2.next==null||n2.next.next==null){
                return null;
            }
            n1=n1.next;
            n2=n2.next.next;
        }
        n2=head;// 从头再走一遍
        while(n1!=n2){
            n1=n1.next;
            n2=n2.next;
        }
        return n1;
    }

    /**
     * 两个无环的链表
     * @param head1
     * @param head2
     * @return
     */
    public Node noLoop(Node head1,Node head2){
        if(head1==null||head2==null){
            return null;
        }
        Node cur1=head1;
        Node cur2=head2;
        int len1=0;
        int len2=0;
        while(cur1.next!=null){
            len1++;
            cur1=cur1.next;
        }
        while(cur2.next!=null){
            len2++;
            cur2=cur2.next;
        }

        if(cur1!=cur2){
            return null;
        }
        // 如果尾节点相同 必定存在环
        cur1=head1;
        cur2=head2;
        if(len1>len2){
            int n=len1-len2;
            while(n>0){
                n--;
                cur1=cur1.next;
            }
        }
        if(len1<len2){
            int n=len2-len1;
            while(n>0){
                n--;
                cur2=cur2.next;
            }
        }
        while(cur1!=cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }
    public Node bothLoop(Node head1,Node head2,Node loop1,Node loop2){
        if(loop1==loop2){
            Node cur1=head1;
            Node cur2=head2;
            int n=0;
            while(cur1!=loop1){
                n++;
                cur1=cur1.next;
            }
            while (cur2!=loop2){
                n--;
                cur2=cur2.next;
            }

            cur1=n>0?head1:head2;
            cur2=cur1==head1?head2:head1;
            n=Math.abs(n);
            while(n!=0){
                n--;
                cur1=cur1.next;
            }

            while(cur1!=cur2){
                cur1=cur1.next;
                cur2=cur2.next;
            }
            return cur1;
        }else{
            Node cur1=loop1.next;
             while(cur1!=loop1){
                 if(cur1==loop2){
                     // loop1 loop2 都可返回
                     return loop1;
                 }
                 cur1=cur1.next;
             }
             return null;
        }
    }

    public Node getIntersectNode(Node head1,Node head2){
        if(head1==null|| head2==null){
            return null;
        }

        Node loop1=getLoopNode(head1);
        Node loop2=getLoopNode(head2);
        //都无环
        if(loop1==null&&loop2==null){
            return noLoop(head1,head2);
        }
        // 都有环
        if(loop1!=null&&loop2!=null){
            return bothLoop(head1,head2,loop1,loop2);
        }
        // 一个有一个没有，肯定不相交
        return null;
    }
}
