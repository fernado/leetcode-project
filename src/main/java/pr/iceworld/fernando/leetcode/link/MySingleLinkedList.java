package pr.iceworld.fernando.leetcode.link;

//单链表
class SingleListNode {
    int val;
    SingleListNode next;
    SingleListNode(){}
    SingleListNode(int val) {
        this.val=val;
    }
}
public class MySingleLinkedList {

    public static void main(String[] args) {
        MySingleLinkedList mySingleLinkedList = new MySingleLinkedList();
        mySingleLinkedList.addAtHead(25);
        mySingleLinkedList.addAtHead(3);
        mySingleLinkedList.addAtHead(5);
        mySingleLinkedList.addAtHead(7);

        System.out.println(mySingleLinkedList.get(2));
        System.out.println(mySingleLinkedList);
        mySingleLinkedList.deleteAtIndex(2);
        System.out.println(mySingleLinkedList);
    }

    //size存储链表元素的个数
    int size;
    //虚拟头结点
    SingleListNode head;

    //初始化链表
    public MySingleLinkedList() {
        size = 0;
        head = new SingleListNode(0);
    }

    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        SingleListNode currentNode = head;
        //包含一个虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    //在链表最前面插入一个节点，等价于在第0个元素前添加
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        //找到要插入节点的前驱
        SingleListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        SingleListNode toAdd = new SingleListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    //删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
	    return;
        }
        SingleListNode pred = head;
        for (int i = 0; i < index ; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MySingleLinkedList{");
        sb.append("size=").append(size);
        sb.append(" --- ");
        SingleListNode h = head;
        boolean flag = false;
        while (h.next != null) {
            sb.append(h.next.val);
            h = h.next;
            sb.append(", ");
            flag = true;
        }
        if (flag) {
            sb.deleteCharAt(sb.length() - 2);
        }
        sb.append("}");
        sb.append("}");
        return sb.toString();
    }
}