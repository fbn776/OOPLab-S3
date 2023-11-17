class DataNode {
    public DataNode left;
    public DataNode right;
    public int data;

    public DataNode(DataNode left, DataNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }
}
class DoublyLinkedList {
    public final static int ERROR = -999999;
    private final DataNode header = new DataNode(null, null, -1);

    public void addFront(int data) {
        DataNode temp = new DataNode(header, header.right, data);
        if(header.right != null) {
            header.right.left = temp;
        }
        header.right = temp;
    }

    public int delete(int key) {
        DataNode temp = header.right;
        while(temp != null && temp.data != key) {
            temp = temp.right;
        }

        if(temp == null) {
            System.out.println("Item not found");
            return ERROR;
        }

        temp.left.right = temp.right;
        if(temp.right != null) {
            temp.right.left = temp.left;
        }
        System.out.println("Deleted: " + temp.data);
        return temp.data;
    }
    public void display() {
        DataNode temp = header.right;

        while(temp != null) {
            System.out.println("Data: " + temp.data);
            temp = temp.right;
        }
    }
}


public class DLInkedListPgm {
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();

        dl.addFront(10);
        dl.addFront(12);
        dl.addFront(18);
        dl.addFront(19);
        dl.addFront(8);

        dl.display();
        dl.delete(12);
        dl.display();
        dl.delete(10);
        dl.display();
        dl.delete(293);
    }
}
