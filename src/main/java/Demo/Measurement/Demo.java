package Demo.Measurement;

/**
 * 计算机计量单位!
 * 1 Byte = 8 Bits （位）
 * 1 KB = 1024 Bytes （字节）
 * 1 MB = 1024 KB （千字节）
 * 1 GB = 1024 MB （兆）
 */
public class Demo 
{
    public static void main( String[] args ){
    	System.out.println("你".getBytes().length);
    	System.out.println("你".length());
    	System.out.println("1".getBytes().length);
    	System.out.println(StringSize.getPrintSize("你".getBytes().length));
    	System.out.println(StringSize.getPrintSize("你".length()));
    	System.out.println(StringSize.getPrintSize("1".getBytes().length));
    	
    }
}
