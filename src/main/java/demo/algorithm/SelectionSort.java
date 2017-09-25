package demo.algorithm;

/**
* @Title: 选择排序算法 
* @Description: 算法描述：对于给定的一组记录，经过第一轮比较后得到最小的记录，然后将该记录与第一个记录的位置进行交换；
* 接着对不包括第一个记录以外的其他记录进行第二轮比较，得到最小的记录并与第二个记录进行位置交换；
* 重复该过程，直到进行比较的记录只有一个时为止。
* @author lei.wang
* @date 2017年9月25日 下午2:17:25 
* @version v1.0
 */
public class SelectionSort {
	
	/**
	* @Title: selectionSort
	* @Description: 平均O(n^2),最好O(n^2),最坏O(n^2);空间复杂度O(1);不稳定;简单
	* @param @param a    参数
	* @return void    返回类型
	* @throws
	 */
	public static void selectionSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int k = i;
			// 找出最小值的小标
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[k]) {
					k = j;
				}
			}
			// 将最小值放到排序序列末尾
			if (k > i) {
				int tmp = a[i];
				a[i] = a[k];
				a[k] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[] b = { 49, 38, 65, 97, 76, 13, 27, 50 };
		for (int i : b){
			System.out.print(i + " ");
		}
		selectionSort(b);
		System.out.println();
		for (int i : b){
			System.out.print(i + " ");
		}
	}
}
