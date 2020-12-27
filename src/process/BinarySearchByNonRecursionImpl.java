package process;

import java.util.Comparator;
import java.util.List;

import models.Book;

//tìm kiếm nhị phân không đệ quy
public class BinarySearchByNonRecursionImpl implements BinarySearch{
	@Override
	public int binarySearchInArray(int[] intArray, int key) {
		return binarySearchInArray(intArray, 0, intArray.length-1, key);
	}

	//source code tham khảo trên www.geeksforgeeks.org
	@Override
	public int binarySearchInArray(int[] intArray, int leftIndex, int rightIndex, int key) {
		while (leftIndex <= rightIndex) { 
            int mid = leftIndex + (rightIndex - leftIndex) / 2; 
  
            if (intArray[mid] == key) {
            	return mid;             	
            }else if (intArray[mid] > key) {
            	rightIndex = mid - 1;             	
            }else {
            	leftIndex = mid + 1;             	
            }
        } 
  
        return -1; 
	}

	@Override
	public int binarySearchInArray(String[] stringArray, String key) {
		return binarySearchInArray(stringArray, 0, stringArray.length-1, key);
	}

	@Override
	public int binarySearchInArray(String[] stringArray, int leftIndex, int rightIndex, String key) {
		while (leftIndex <= rightIndex) { 
            int mid = leftIndex + (rightIndex - leftIndex) / 2; 
  
            if (stringArray[mid].compareTo(key)==0) {
            	return mid;             	
            }else if (stringArray[mid].compareTo(key) > 0) {
            	rightIndex = mid - 1;             	
            }else {
            	leftIndex = mid + 1;             	
            }
        } 
  
        return -1;
	}

	@Override
	public int binarySearchInList(List<Integer> intList, int key) {
		return binarySearchInList(intList, 0, intList.size()-1, key);
	}
	
	@Override
	public int binarySearchInList(List<Integer> intList, int leftIndex, int rightIndex, int key) {
		while (leftIndex <= rightIndex) { 
            int mid = leftIndex + (rightIndex - leftIndex) / 2; 
  
            if (intList.get(mid) == key) {
            	return mid;             	
            }else if (intList.get(mid) > key) {
            	rightIndex = mid - 1;             	
            }else {
            	leftIndex = mid + 1;             	
            }
        } 
  
        return -1;
	}

	@Override
	public int binarySearchInList(List<String> stringList, String key) {
		return binarySearchInList(stringList, 0, stringList.size()-1, key);
	}
	
	@Override
	public int binarySearchInList(List<String> stringList, int leftIndex, int rightIndex, String key) {
		while (leftIndex <= rightIndex) { 
            int mid = leftIndex + (rightIndex - leftIndex) / 2; 
  
            if (stringList.get(mid).compareTo(key)==0) {
            	return mid;             	
            }else if (stringList.get(mid).compareTo(key) > 0) {
            	rightIndex = mid - 1;             	
            }else {
            	leftIndex = mid + 1;             	
            }
        } 
  
        return -1;
	}

	@Override
	public int binarySearchInObjectArray(Object[] objectArray, Object key) {
		return binarySearchInObjectArray(objectArray, 0, objectArray.length-1, key);
	}
	
	@Override
	public int binarySearchInObjectArray(Object[] objectArray, int leftIndex, int rightIndex, Object key) {
		while (leftIndex <= rightIndex) { 
            int mid = leftIndex + (rightIndex - leftIndex) / 2; 
  
            if (objectArray[mid] == key) {
            	return mid;             	
            }else if (((Book) objectArray[mid]).compareTo((Book) key) > 0) {
            	rightIndex = mid - 1;             	
            }else {
            	leftIndex = mid + 1;             	
            }
        } 
  
        return -1; 
	}

	@Override
	public int binarySearchInObjectArray(Object[] objectArray, Object key, Comparator<Object> comparator) {
		return binarySearchInObjectArray(objectArray, 0, objectArray.length-1, key, comparator);
	}

	@Override
	public int binarySearchInObjectArray(Object[] objectArray, int leftIndex, int rightIndex, Object key,
			Comparator<Object> comparator) {
		while (leftIndex <= rightIndex) { 
            int mid = leftIndex + (rightIndex - leftIndex) / 2; 
  
            if (comparator.compare(objectArray[mid], key)==0) {
            	return mid;             	
            }else if (comparator.compare(objectArray[mid], key) > 0) {
            	rightIndex = mid - 1;             	
            }else {
            	leftIndex = mid + 1;             	
            }
        } 
  
        return -1; 
	}

	@Override
	public int binarySearchInObjectList(List<Object> objectList, Object key) {
		return binarySearchInObjectList(objectList, 0, objectList.size()-1, key);
	}

	@Override
	public int binarySearchInObjectList(List<Object> bookList, int leftIndex, int rightIndex, Object key) {
		while (leftIndex <= rightIndex) { 
            int mid = leftIndex + (rightIndex - leftIndex) / 2; 
  
            if (((Book) bookList.get(mid)).compareTo((Book) key) == 0) {
            	return mid;             	
            }else if (((Book) bookList.get(mid)).compareTo((Book) key) > 0) {
            	rightIndex = mid - 1;             	
            }else {
            	leftIndex = mid + 1;             	
            }
        } 
  
        return -1;
	}

	@Override
	public int binarySearchInObjectList(List<Object> objectList, Object key, Comparator<Object> comparator) {
		return binarySearchInObjectList(objectList, 0, objectList.size()-1, key, comparator);
	}

	@Override
	public int binarySearchInObjectList(List<Object> bookList, int leftIndex, int rightIndex, Object key,
			Comparator<Object> comparator) {
		while (leftIndex <= rightIndex) { 
            int mid = leftIndex + (rightIndex - leftIndex) / 2; 
  
            if (comparator.compare(bookList.get(mid),key)==0) {
            	return mid;             	
            }else if (comparator.compare(bookList.get(mid),key) > 0) {
            	rightIndex = mid - 1;             	
            }else {
            	leftIndex = mid + 1;             	
            }
        } 
        return -1;
	}

}
