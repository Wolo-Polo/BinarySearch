package process;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import models.Book;
import utils.GenerateData;
import utils.RandomUtil;
//import utils.SortUtil;

public class Test {
	public static void test() {
		
	}
	
	public static void main(String[] args) throws IOException {
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
		FileOutputStream fos = new FileOutputStream("data/DataTest.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		//System.out.println("===intArray: ");
		dos.writeBytes("intArray:\n");
		for(int i=0; i<intArray.length; i++) {
			//System.out.print(intArray[i]+"  ");
			dos.writeBytes(intArray[i]+"  ");
		}
		dos.writeBytes("\n");
		
		//System.out.println("===stringArray: ");
		dos.writeBytes("stringArray:\n");
		for(int i=0; i<stringArray.length; i++) {
			//System.out.print(stringArray[i]+"  ");
			dos.writeBytes(stringArray[i]+"  ");
		}
		dos.writeBytes("\n");
		
		//System.out.println("===objectArray: ");
		dos.writeBytes("objectArray:\n");
		for(int i=0; i<objectArray.length; i++) {
			//System.out.print(((Book) objectArray[i]).getId()+"  ");
			dos.writeBytes(((Book) objectArray[i]).getId()+"  ");
		}
		dos.writeBytes("\n");
		
		//System.out.println("===intList: ");
		dos.writeBytes("intList:\n");
		for(int i=0; i<intList.size(); i++) {
			//System.out.print(((Book) objectArray[i]).getId()+"  ");
			dos.writeBytes(((Book) objectArray[i]).getId()+"  ");
		}
		dos.writeBytes("\n");
		
		//System.out.println("===stringList: ");
		dos.writeBytes("stringList:\n");
		for(int i=0; i<stringList.size(); i++) {
			//System.out.print(stringList.get(i)+"  ");
			dos.writeBytes(stringList.get(i)+"  ");
		}
		dos.writeBytes("\n");
		
		//System.out.println("===objectList: ");
		dos.writeBytes("objectList:\n");
		for(int i=0; i<objectList.size(); i++) {
			//System.out.print(((Book)objectList.get(i)).getId()+"  ");
			dos.writeBytes(((Book)objectList.get(i)).getId()+"  ");
		}
		dos.close();
		
		//log test
		//create object process excel file
		Workbook wb2007 = new XSSFWorkbook();
		Sheet sheet = wb2007.createSheet("Report");
		//init
		int rowIndex=0;
		final int METHOD_NAME=0;
		final int NUMBER_OF_ELEMENT=1;
		final int KEY_LOCATION=2;
		final int START_TIME=3;
		final int END_TIME=4;
		final int EXECUTION_TIME=5;
		int keyLocation=RandomUtil.randomNumber(0, 9999);
		long startTime=0;
		long endTime=0;
		long executionTime=0;
		String formula=null;
		final int MAX_REPEAT=10;
		int count=MAX_REPEAT;
		//create header
		Row row;
		row = sheet.createRow(rowIndex);
		Cell cell;
		
		cell = row.createCell(METHOD_NAME);
		cell.setCellValue("Tên phương thức");
		
		cell = row.createCell(NUMBER_OF_ELEMENT);
		cell.setCellValue("Số lượng phần tử");
		
		cell = row.createCell(KEY_LOCATION);
		cell.setCellValue("Vị trí key");
		
		cell = row.createCell(START_TIME);
		cell.setCellValue("Bắt đầu lúc\n(tính bằng nano giây của hệ thống)");
		
		cell = row.createCell(END_TIME);
		cell.setCellValue("Kết thúc lúc\n(tính bằng nano giây của hệ thống)");
		
		cell = row.createCell(EXECUTION_TIME);
		cell.setCellValue("Thời gian chạy (nano giây)");
		
		//log data
		System.out.println("====================LOG TEST binarySearchByRecursionImpl===============");
		BinarySearch binarySearchByRecursion = new BinarySearchByRecursionImpl();
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInArray(intArray, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInArray(intArray, intArray[keyLocation]);
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInObjectArray(objectArray, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInObjectArray(objectArray, objectArray[keyLocation]);
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInArray(stringArray, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInArray(stringArray, stringArray[keyLocation]);
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInObjectArray(objectArray, key, comparator)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInObjectArray(objectArray, objectArray[keyLocation], new Comparator<Object>() { //anonymous class 
				
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
			});
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInArray(intArray, leftIndex, rightIndex, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInArray(intArray, 0, intArray.length-1, intArray[keyLocation]);
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInObjectArray(objectArray, leftIndex, rightIndex, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInObjectArray(objectArray, 0, objectArray.length-1, objectArray[keyLocation]);
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInArray(stringArray, leftIndex, rightIndex, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInArray(stringArray, 0, stringArray.length-1, stringArray[keyLocation]);
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInObjectArray(objectArray, leftIndex, rightIndex, key, comparator)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInObjectArray(objectArray, 0, objectArray.length-1, objectArray[keyLocation], new Comparator<Object>() {
				
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
			});
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInList(intList, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInList(intList, intList.get(keyLocation));
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInObjectList(objectList, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInObjectList(objectList, (Object) objectList.get(keyLocation));
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInList(stringList, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInList(stringList, stringList.get(keyLocation));
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInObjectList(objectList, key, comparator)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInObjectList(objectList, objectList.get(keyLocation), new Comparator<Object>() {

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
			});
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInList(intList, leftIndex, rightIndex, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInList(intList, 0, intList.size()-1, intList.get(keyLocation));
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInObjectList(objectList, leftIndex, rightIndex, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInObjectList(objectList, 0, objectList.size()-1, objectList.get(keyLocation));
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInList(stringList, leftIndex, rightIndex, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInList(stringList, 0, stringList.size()-1, stringList.get(keyLocation));
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByRecursionImpl binarySearchInObjectList(objectList, leftIndex, rightIndex, key, comparator)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByRecursion.binarySearchInObjectList(objectList, 0, objectList.size()-1, objectList.get(keyLocation), new Comparator<Object>() {

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
			});
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		System.out.println("====================LOG TEST BinarySearchByNonRecursionImpl===============");
		BinarySearch binarySearchByNonRecursion = new BinarySearchByNonRecursionImpl();
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInArray(intArray, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInArray(intArray, intArray[keyLocation]);
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInObjectArray(objectArray, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInObjectArray(objectArray, objectArray[keyLocation]);
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInArray(stringArray, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInArray(stringArray, stringArray[keyLocation]);
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInObjectArray(objectArray, key, comparator)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInObjectArray(objectArray, objectArray[keyLocation], new Comparator<Object>() { //anonymous class 
				
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
			});
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInArray(intArray, leftIndex, rightIndex, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInArray(intArray, 0, intArray.length-1, intArray[keyLocation]);
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInObjectArray(objectArray, leftIndex, rightIndex, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInObjectArray(objectArray, 0, objectArray.length-1, objectArray[keyLocation]);
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInArray(stringArray, leftIndex, rightIndex, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInArray(stringArray, 0, stringArray.length-1, stringArray[keyLocation]);
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInObjectArray(objectArray, leftIndex, rightIndex, key, comparator)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInObjectArray(objectArray, 0, objectArray.length-1, objectArray[keyLocation], new Comparator<Object>() {
				
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
			});
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInList(intList, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInList(intList, intList.get(keyLocation));
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInObjectList(objectList, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInObjectList(objectList, (Object) objectList.get(keyLocation));
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInList(stringList, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInList(stringList, stringList.get(keyLocation));
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInObjectList(objectList, key, comparator)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInObjectList(objectList, objectList.get(keyLocation), new Comparator<Object>() {

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
			});
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInList(intList, leftIndex, rightIndex, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInList(intList, 0, intList.size()-1, intList.get(keyLocation));
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInObjectList(objectList, leftIndex, rightIndex, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInObjectList(objectList, 0, objectList.size()-1, objectList.get(keyLocation));
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInList(stringList, leftIndex, rightIndex, key)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInList(stringList, 0, stringList.size()-1, stringList.get(keyLocation));
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		count=MAX_REPEAT;
		while(count-->0) {
			keyLocation=RandomUtil.randomNumber(0, 9999);
			rowIndex++;
			row=sheet.createRow(rowIndex);
			
			cell = row.createCell(METHOD_NAME);
			cell.setCellValue("binarySearchByNonRecursionImpl binarySearchInObjectList(objectList, leftIndex, rightIndex, key, comparator)");
			
			cell = row.createCell(NUMBER_OF_ELEMENT);
			cell.setCellValue(intArray.length);
			
			cell = row.createCell(KEY_LOCATION);
			cell.setCellValue(keyLocation);

			startTime=System.nanoTime();
			binarySearchByNonRecursion.binarySearchInObjectList(objectList, 0, objectList.size()-1, objectList.get(keyLocation), new Comparator<Object>() {

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
			});
			endTime=System.nanoTime();
			
			cell = row.createCell(START_TIME);
			cell.setCellValue(startTime);
			
			cell = row.createCell(END_TIME);
			cell.setCellValue(endTime);
			
			executionTime= endTime - startTime;
			cell = row.createCell(EXECUTION_TIME);
			cell.setCellValue(executionTime);
			
		}
		rowIndex++;
		row=sheet.createRow(rowIndex);
		cell = row.createCell(EXECUTION_TIME-1);
		cell.setCellValue("Thời gian TB:");
		cell = row.createCell(EXECUTION_TIME);
		formula="SUM(F"+(rowIndex-10)+":F"+(rowIndex-1)+")/10";
		cell.setCellFormula(formula);
		
		
		
		//auto size column
		for(int i=0; i<6; i++) {
			sheet.autoSizeColumn(i);			
		}
		String filePath="data/ReportTest.xlsx";
		OutputStream os = new FileOutputStream(filePath);
		wb2007.write(os);
		wb2007.close();
		
		System.out.println("Test success!");
	}
}
