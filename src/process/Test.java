package process;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Book;
import utils.GenerateData;
//import utils.SortUtil;

public class Test {
	public static void main(String[] args) {
		//init data
		GenerateData generateData= new GenerateData();
		int[] intArray= generateData.generateIntArray();
		String[] stringArray= generateData.generateStringArray();
		Object[] objectArray= generateData.generateBookArray();
		List<Integer> intList= generateData.generateIntList();
		List<String> stringList= generateData.generateStringList();
		List<Object> objectList= generateData.generateBookList();
		
		//sort
		Arrays.sort(intArray);
		Arrays.sort(stringArray, new Comparator<String>() {//anonymous class 

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2);
			}
			
		});
		Arrays.sort(objectArray, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				if(((Book) o1).getId()==((Book) o1).getId()) {
					return 0;
				}else if(((Book) o1).getId()>((Book) o1).getId()) {
					return 1;
				}else {
					return -1;
				}
				
			}
		});
		Collections.sort(intList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
			
		});
		Collections.sort(stringList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		Collections.sort(objectList, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				if(((Book) o1).getId()==((Book) o1).getId()) {
					return 0;
				}else if(((Book) o1).getId()>((Book) o1).getId()) {
					return 1;
				}else {
					return -1;
				}
			}
			
		});
		
		//log data
		System.out.println("===intArray: ");
		for(int i=0; i<intArray.length; i++) {
			System.out.print(intArray[i]+"  ");
		}
		System.out.println("find: "+ intArray[3]);
		
		System.out.println("===stringArray: ");
		for(int i=0; i<stringArray.length; i++) {
			System.out.print(stringArray[i]+"  ");
		}
		System.out.println("find: "+ stringArray[3]);
		
		System.out.println("===objectArray: ");
		for(int i=0; i<objectArray.length; i++) {
			System.out.print(((Book) objectArray[i]).getId()+"  ");
		}
		System.out.println("find: "+ ((Book) objectArray[3]).getId());
		
		System.out.println("===intList: ");
		for(int i=0; i<intList.size(); i++) {
			System.out.print(intList.get(i)+"  ");
		}
		System.out.println("find: "+ intList.get(3));
		
		System.out.println("===stringList: ");
		for(int i=0; i<stringList.size(); i++) {
			System.out.print(stringList.get(i)+"  ");
		}
		System.out.println("find: "+ stringList.get(3));
		
		System.out.println("===objectList: ");
		for(int i=0; i<objectList.size(); i++) {
			System.out.print(((Book)objectList.get(i)).getId()+"  ");
		}
		System.out.println("find: "+ ((Book)objectList.get(3)).getId());
		
		//log test
		//case đúng sẽ hiển thị ra vị trí là 3 (vì mình lấy phần từ ở vị trí số 3 ra để tìm kiếm)
		System.out.println("====================LOG TEST binarySearchByRecursionImpl===============");
		BinarySearch binarySearchByRecursion = new BinarySearchByRecursionImpl();
		
		System.out.println("Test binarySearchInArray(intArray, key): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInArray(intArray, intArray[3]));
		
		System.out.println("Test binarySearchInObjectArray(objectArray, key): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInObjectArray(objectArray, objectArray[3]));
		
		System.out.println("Test binarySearchInArray(stringArray, key): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInArray(stringArray, stringArray[3]));
		
		System.out.println("Test binarySearchInObjectArray(objectArray, key, comparator): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInObjectArray(objectArray, objectArray[3], new Comparator<Object>() { //anonymous class 
			
			@Override
			public int compare(Object o1, Object o2) {
				//ép kiểu sang Book
				//chọn thuộc tính để tìm
				//lưu ý: để tìm theo thuộc tính nào thì phải sắp xếp theo thuộc tính đó
				//ở đây đang sort theo id thì mình sẽ demo tìm kiếm theo id
				if(((Book) o1).getId() == ((Book) o2).getId()) {
					return 0;
				}else if(((Book) o1).getId() > ((Book) o2).getId()) {
					return 1;
				}else {
					return -1;
				}
			}
		}));
		
		System.out.println("Test binarySearchInArray(intArray, leftIndex, rightIndex, key): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInArray(intArray, 0, intArray.length-1, intArray[3]));
		
		System.out.println("Test binarySearchInObjectArray(objectArray, leftIndex, rightIndex, key): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInObjectArray(objectArray, 0, objectArray.length-1, objectArray[3]));
		
		System.out.println("Test binarySearchInArray(stringArray, leftIndex, rightIndex, key): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInArray(stringArray, 0, stringArray.length-1, stringArray[3]));
		
		System.out.println("Test binarySearchInObjectArray(objectArray, leftIndex, rightIndex, key, comparator): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInObjectArray(objectArray, 0, objectArray.length-1, objectArray[3], new Comparator<Object>() {
			
			@Override
			public int compare(Object o1, Object o2) {
				//ép kiểu sang Book
				//chọn thuộc tính để tìm
				//lưu ý: để tìm theo thuộc tính nào thì phải sắp xếp theo thuộc tính đó
				//ở đây đang sort theo id thì mình sẽ demo tìm kiếm theo id
				if(((Book) o1).getId() == ((Book) o2).getId()) {
					return 0;
				}else if(((Book) o1).getId() > ((Book) o2).getId()) {
					return 1;
				}else {
					return -1;
				}
			}
		}));
		
		System.out.println("Test binarySearchInList(intList, key): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInList(intList, intList.get(3)));
		
		System.out.println("Test binarySearchInObjectList(objectList, key): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInObjectList(objectList, (Object) objectList.get(3)));
		
		System.out.println("Test binarySearchInList(stringList, key): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInList(stringList, stringList.get(3)));
		
		System.out.println("Test binarySearchInObjectList(objectList, key, comparator): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInObjectList(objectList, objectList.get(3), new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				//ép kiểu sang Book
				//chọn thuộc tính để tìm
				//lưu ý: để tìm theo thuộc tính nào thì phải sắp xếp theo thuộc tính đó
				//ở đây đang sort theo id thì mình sẽ demo tìm kiếm theo id
				if(((Book) o1).getId() == ((Book) o2).getId()) {
					return 0;
				}else if(((Book) o1).getId() > ((Book) o2).getId()) {
					return 1;
				}else {
					return -1;
				}
			}
		}));
		
		System.out.println("Test binarySearchInList(intList, leftIndex, rightIndex, key): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInList(intList, 0, intList.size()-1, intList.get(3)));
		
		System.out.println("Test binarySearchInObjectList(objectList, leftIndex, rightIndex, key): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInObjectList(objectList, 0, objectList.size()-1, objectList.get(3)));
		
		System.out.println("Test binarySearchInList(stringList, leftIndex, rightIndex, key): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInList(stringList, 0, stringList.size()-1, stringList.get(3)));
		
		System.out.println("Test binarySearchInObjectList(objectList, leftIndex, rightIndex, key, comparator): ");
		System.out.println("Found at: " + binarySearchByRecursion.binarySearchInObjectList(objectList, 0, objectList.size()-1, objectList.get(3), new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				//ép kiểu sang Book
				//chọn thuộc tính để tìm
				//lưu ý: để tìm theo thuộc tính nào thì phải sắp xếp theo thuộc tính đó
				//ở đây đang sort theo id thì mình sẽ demo tìm kiếm theo id
				if(((Book) o1).getId() == ((Book) o2).getId()) {
					return 0;
				}else if(((Book) o1).getId() > ((Book) o2).getId()) {
					return 1;
				}else {
					return -1;
				}
			}
		}));
		
		
		System.out.println("====================LOG TEST BinarySearchByNonRecursionImpl===============");
		BinarySearch binarySearchByNonRecursion = new BinarySearchByNonRecursionImpl();
		
		System.out.println("Test binarySearchInArray(intArray, key): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInArray(intArray, intArray[3]));
		
		System.out.println("Test binarySearchInObjectArray(objectArray, key): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInObjectArray(objectArray, objectArray[3]));
		
		System.out.println("Test binarySearchInArray(stringArray, key): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInArray(stringArray, stringArray[3]));
		
		System.out.println("Test binarySearchInObjectArray(objectArray, key, comparator): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInObjectArray(objectArray, objectArray[3], new Comparator<Object>() {
			
			@Override
			public int compare(Object o1, Object o2) {
				//ép kiểu sang Book
				//chọn thuộc tính để tìm
				//lưu ý: để tìm theo thuộc tính nào thì phải sắp xếp theo thuộc tính đó
				//ở đây đang sort theo id thì mình sẽ demo tìm kiếm theo id
				if(((Book) o1).getId() == ((Book) o2).getId()) {
					return 0;
				}else if(((Book) o1).getId() > ((Book) o2).getId()) {
					return 1;
				}else {
					return -1;
				}
			}
		}));
		
		System.out.println("Test binarySearchInArray(intArray, leftIndex, rightIndex, key): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInArray(intArray, 0, intArray.length-1, intArray[3]));
		
		System.out.println("Test binarySearchInObjectArray(objectArray, leftIndex, rightIndex, key): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInObjectArray(objectArray, 0, objectArray.length-1, objectArray[3]));
		
		System.out.println("Test binarySearchInArray(stringArray, leftIndex, rightIndex, key): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInArray(stringArray, 0, stringArray.length-1, stringArray[3]));
		
		System.out.println("Test binarySearchInObjectArray(objectArray, leftIndex, rightIndex, key, comparator): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInObjectArray(objectArray, 0, objectArray.length-1, objectArray[3], new Comparator<Object>() {
			
			@Override
			public int compare(Object o1, Object o2) {
				//ép kiểu sang Book
				//chọn thuộc tính để tìm
				//lưu ý: để tìm theo thuộc tính nào thì phải sắp xếp theo thuộc tính đó
				//ở đây đang sort theo id thì mình sẽ demo tìm kiếm theo id
				if(((Book) o1).getId() == ((Book) o2).getId()) {
					return 0;
				}else if(((Book) o1).getId() > ((Book) o2).getId()) {
					return 1;
				}else {
					return -1;
				}
			}
		}));
		
		System.out.println("Test binarySearchInList(intList, key): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInList(intList, intList.get(3)));
		
		System.out.println("Test binarySearchInObjectList(objectList, key): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInObjectList(objectList, (Object) objectList.get(3)));
		
		System.out.println("Test binarySearchInList(stringList, key): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInList(stringList, stringList.get(3)));
		
		
		System.out.println("Test binarySearchInObjectList(objectList, key, comparator): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInObjectList(objectList, (Object) objectList.get(3), new Comparator<Object>() {
		  
			@Override
			public int compare(Object o1, Object o2) {
				//ép kiểu sang Book
				//chọn thuộc tính để tìm
				//lưu ý: để tìm theo thuộc tính nào thì phải sắp xếp theo thuộc tính đó
				//ở đây đang sort theo id thì mình sẽ demo tìm kiếm theo id
				if(((Book) o1).getId() == ((Book) o2).getId()) {
					return 0;
				}else if(((Book) o1).getId() > ((Book) o2).getId()) {
					return 1;
				}else {
					return -1;
				}
			}
		}));
		 
		
		System.out.println("Test binarySearchInList(intList, leftIndex, rightIndex, key): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInList(intList, 0, intList.size()-1, intList.get(3)));
		
		System.out.println("Test binarySearchInObjectList(objectList, leftIndex, rightIndex, key): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInObjectList(objectList, 0, objectList.size()-1, (Object) objectList.get(3)));
		
		System.out.println("Test binarySearchInList(stringList, leftIndex, rightIndex, key): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInList(stringList, 0, stringList.size()-1, stringList.get(3)));
		
		System.out.println("Test binarySearchInObjectList(objectList, leftIndex, rightIndex, key, comparator): ");
		System.out.println("Found at: " + binarySearchByNonRecursion.binarySearchInObjectList(objectList, 0, objectList.size()-1, (Object) objectList.get(3), new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				//ép kiểu sang Book
				//chọn thuộc tính để tìm
				//lưu ý: để tìm theo thuộc tính nào thì phải sắp xếp theo thuộc tính đó
				//ở đây đang sort theo id thì mình sẽ demo tìm kiếm theo id
				if(((Book) o1).getId() == ((Book) o2).getId()) {
					return 0;
				}else if(((Book) o1).getId() > ((Book) o2).getId()) {
					return 1;
				}else {
					return -1;
				}
			}
		}));
		
	}
}
