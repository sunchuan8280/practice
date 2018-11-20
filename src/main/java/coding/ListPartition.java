package coding;

/**
 * Created by chuan on 2018/11/20.
 */
public class ListPartition {
    public Node listPartition1(Node head,int pivot){
        if(head==null){
            return head;
        }
        int len=0;
        Node cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        Node[] nodeArr=new Node[len];
        cur=head;
        for(int i=0;i<nodeArr.length;i++){
            nodeArr[i]=cur.next;
            cur=cur.next;
        }
        arrPartition(nodeArr,pivot);
        int i=0;
        for(i=1;i<nodeArr.length;i++){
            nodeArr[i-1].next=nodeArr[i];

        }
        nodeArr[i-1].next=null;
        return nodeArr[0];
        }

        public void arrPartition(Node[] nodeArr,int pivot){
            int small=-1;
            int big=nodeArr.length;
            int index=0;
            while(index!=big){
                if(nodeArr[index].value<pivot){
                    small++;
                    swap(nodeArr,small,index);
                    index++;
                }else if(nodeArr[index].value==pivot) {
                    index++;
                }else{
                    swap(nodeArr,--big,index++);
                }
            }

        }
        public void swap(Node[] nodeArr,int a,int b){
            Node tmp=nodeArr[a];
            nodeArr[a]=nodeArr[b];
            nodeArr[b]=tmp;
        }
    }
