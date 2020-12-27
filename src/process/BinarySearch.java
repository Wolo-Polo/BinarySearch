package process;

import java.util.Comparator;
import java.util.List;

/**
 * @author Truong
 *
 */
public interface BinarySearch {
	//binary search with primitive data type and wrapper class
	/**
	 * @param intArray mảng chứa các phần tử số nguyên đã được sắp xếp
	 * @param key phần tử cần tìm kiếm
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInArray(int[] intArray, int key);
	
	/**
	 * @param intArray mảng chứa các phần tử số nguyên đã được sắp xếp
	 * @param leftIndex giới hạn dưới của đoạn tìm kiếm trong mảng truyền vào
	 * @param rightIndex giới hạn trên của đoạn tìm kiếm trong mảng truyền vào
	 * @param key phần tử cần tìm kiếm
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInArray(int[] intArray, int leftIndex, int rightIndex, int key);
	
	/**
	 * @param stringArray mảng chứa các phần tử chuỗi đã được sắp xếp
	 * @param key key phần tử cần tìm kiếm
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInArray(String[] stringArray, String key);
	
	/**
	 * @param stringArray mảng chứa các phần tử chuỗi đã được sắp xếp
	 * @param leftIndex giới hạn dưới của đoạn tìm kiếm trong mảng truyền vào
	 * @param rightIndex giới hạn trên của đoạn tìm kiếm trong mảng truyền vào
	 * @param key phần tử cần tìm kiếm
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInArray(String[] stringArray, int leftIndex, int rightIndex, String key);
	
	/**
	 * @param intList danh sách (List) chứa các phần tử số nguyên đã được sắp xếp
	 * @param key phần tử cần tìm kiếm
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInList(List<Integer> intList, int key);
	
	/**
	 * @param intList danh sách (List) chứa các phần tử số nguyên đã được sắp xếp
	 * @param leftIndex giới hạn dưới của đoạn tìm kiếm trong danh sách (List) truyền vào
	 * @param rightIndex giới hạn trên của đoạn tìm kiếm trong danh sách (List) truyền vào
	 * @param key phần tử cần tìm kiếm
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInList(List<Integer> intList, int leftIndex, int rightIndex, int key);
	
	/**
	 * @param stringList danh sách (List) chứa các phần tử chuỗi đã được sắp xếp
	 * @param key phần tử cần tìm kiếm
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInList(List<String> stringList, String key);
	
	/**
	 * @param stringList danh sách (List) chứa các phần tử chuỗi đã được sắp xếp
	 * @param leftIndex giới hạn dưới của đoạn tìm kiếm trong danh sách (List) truyền vào
	 * @param rightIndex giới hạn trên của đoạn tìm kiếm trong danh sách (List) truyền vào
	 * @param key phần tử cần tìm kiếm
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInList(List<String> stringList, int leftIndex, int rightIndex, String key);
	
	
	//binary search with complex data type
	/**
	 * @param objectArray mảng chứa các phần tử kiểu đối tượng đã được sắp xếp theo tiêu chí tìm kiếm
	 * @param key phần tử cần tìm kiếm
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */ 
	int binarySearchInObjectArray(Object[] objectArray, Object key);
	
	/**
	 * @param objectArray mảng chứa các phần tử kiểu đối tượng đã được sắp xếp theo tiêu chí tìm kiếm
	 * @param leftIndex giới hạn dưới của đoạn tìm kiếm trong mảng truyền vào
	 * @param rightIndex giới hạn trên của đoạn tìm kiếm trong mảng truyền vào
	 * @param key phần tử cần tìm kiếm
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInObjectArray(Object[] objectArray, int leftIndex, int rightIndex, Object key);
	
	/**
	 * @param objectArray mảng chứa các phần tử kiểu đối tượng đã được sắp xếp theo tiêu chí tìm kiếm
	 * @param key phần tử cần tìm kiếm
	 * @param comparator truyền vào 1 class hiện thực (implement) interface Comparator dùng để so sánh 2 phần tử. 
	 * nó trả về 0 nếu 2 phần tử = nhau, trả về 1 nếu phần tử 1 lớn hơn và trả về -1 nếu phần tử 1 nhỏ hơn
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInObjectArray(Object[] objectArray, Object key, Comparator<Object> comparator);
	
	/**
	 * @param objectArray mảng chứa các phần tử kiểu đối tượng đã được sắp xếp theo tiêu chí tìm kiếm
	 * @param leftIndex giới hạn dưới của đoạn tìm kiếm trong mảng truyền vào
	 * @param rightIndex giới hạn trên của đoạn tìm kiếm trong mảng truyền vào
	 * @param key phần tử cần tìm kiếm
	 * @param comparator truyền vào 1 class hiện thực (implement) interface Comparator dùng để so sánh 2 phần tử.
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInObjectArray(Object[] objectArray, int leftIndex, int rightIndex, Object key, Comparator<Object> comparator);
	
	/**
	 * @param objectList danh sách (List) chứa các phần tử kiểu đối tượng đã được sắp xếp theo tiêu chí tìm kiếm
	 * @param key phần tử cần tìm kiếm
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInObjectList(List<Object> objectList, Object key);
	
	/**
	 * @param objectList danh sách (List) chứa các phần tử kiểu đối tượng đã được sắp xếp theo tiêu chí tìm kiếm
	 * @param leftIndex giới hạn dưới của đoạn tìm kiếm trong danh sách truyền vào
	 * @param rightIndex giới hạn trên của đoạn tìm kiếm trong danh sách truyền vào
	 * @param key phần tử cần tìm kiếm
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInObjectList(List<Object> objectList, int leftIndex, int rightIndex, Object key);
	
	/**
	 * @param objectList danh sách (List) chứa các phần tử kiểu đối tượng đã được sắp xếp theo tiêu chí tìm kiếm
	 * @param key phần tử cần tìm kiếm
	 * @param comparator truyền vào 1 class hiện thực (implement) interface Comparator dùng để so sánh 2 phần tử.
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInObjectList(List<Object> objectList, Object key, Comparator<Object> comparator);
	
	/**
	 * @param objectList danh sách (List) chứa các phần tử kiểu đối tượng đã được sắp xếp theo tiêu chí tìm kiếm
	 * @param leftIndex giới hạn dưới của đoạn tìm kiếm trong danh sách truyền vào
	 * @param rightIndex giới hạn trên của đoạn tìm kiếm trong danh sách truyền vào
	 * @param key phần tử cần tìm kiếm
	 * @param comparator truyền vào 1 class hiện thực (implement) interface Comparator dùng để so sánh 2 phần tử.
	 * @return trả về vị trí của key nếu tìm thấy, trả về -1 nếu không tìm thấy
	 */
	int binarySearchInObjectList(List<Object> objectList, int leftIndex, int rightIndex, Object key, Comparator<Object> comparator);
	
}
