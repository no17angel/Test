package demo.dataStructure.linkedList;

/**
 * java实现单链表
 *
 */
public class LinkedList<E>{
	// 声明头节点
    private Node<E> root;
	// 声明单链表中存储的节点数
    private int size;
    
    public LinkedList(){
        root = new Node<E>();//实例化头节点
    }
    
    /**
     * 向链表中添加元素的方法
     * @param e要添加的元素
     */
    public void add(E e){
        //根据e实例化了一个新的节点对象
        Node<E> node = new Node<E>(e);
        
        //获取root的下一个节点
        Node<E> tnode = root.getNext();
        
        root.setNext(node);//将新的节点作为root的下一个节点
        
        node.setNext(tnode);//将root原来的下一个节点作为新增加节点的下一个节点
        
        size++;//记录添加的节点数
    }
    
    /**
     * 删除指定索引位置的元素
     * @param index索引位置
     * @return 返回删除的元素
     */
    public E remove(int index){
        if(index <= 0 || index > size)
            return null;
        //获取要删除节点的前一个节点
        Node<E> node = select(index-1);
        //获取要删除的节点
        Node<E> dNode = node.getNext();
        //获取要删除节点的后一个节点
        Node<E> nNode = dNode.getNext();
        
        //先建立删除节点的前一个节点和删除节点的后一个节点的关系
        node.setNext(nNode);
        //清除dNode的下一个节点
        dNode.setNext(null);
        
        size--;//计数器减一
        
        return dNode.getE();//返回删除节点中的数据域
    }
    
    /**
     * 获取指定索引位置的元素
     * @param index索引位置
     * @return 返回节点中的数据域
     */
    public E get(int index){
        if(index <= 0 || index > size)
            return null;
        //查找指定索引位置的节点对象
        Node<E> node = select(index);
        //获取节点中的数据域元素并返回
        return node.getE();
    }
    
    /**
     * 获取单链表中存储的元素总数
     * @return 返回size属性
     */
    public int size(){
        return size;
    }
    
    /**
     * 获取指定索引位置的节点对象
     * @param index索引位置
     * @return 返回获取到的节点对象
     */
    private Node<E> select(int index){
        Node<E> node = root.getNext();//将头节点的下一个节点赋给node
        if(index==1)//如果index是1表示是头结点的下一个节点
            return node;//直接返回node
        for(int i=1;i<index;i++){
            node = node.getNext();//获取node的下一个节点
        }
        return node;
    }
    
	public Node<E> getRoot() {
		return root;
	}
	public void setRoot(Node<E> root) {
		this.root = root;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
    
    
}
