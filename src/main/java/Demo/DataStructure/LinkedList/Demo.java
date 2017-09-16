package Demo.DataStructure.LinkedList;

/**
 * java模拟单向链表!
 *
 */
public class Demo 
{
    public static void main( String[] args ){
    	
    	LinkedList<String> linkedList = new LinkedList<String>();
    	linkedList.add("test");
    	linkedList.add("test1");
    	linkedList.add("test2");
    	
    	System.out.println(linkedList.get(0));
    	System.out.println(linkedList.get(1));
    	System.out.println(linkedList.get(2));
    	System.out.println(linkedList.get(3));
    	System.out.println(linkedList.size());
    }
}
