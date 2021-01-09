package utils;

import java.util.ArrayList;
import java.util.List;

import models.Book;

public class GenerateData {
	public int[] generateIntArray() {
		//int size=RandomUtil.randomNumber(5, 10);
		int size=10000;//lấy số phần tử là 10000 để test hiệu năng
		int[] result= new int[size];
		for(int i=0; i<size; i++) {
			result[i]=RandomUtil.randomNumber(0, 10000);
		}
		
		return result;
	}

	public String[] generateStringArray() {
		//int size=RandomUtil.randomNumber(5, 10);
		int size=10000;//lấy số phần tử là 10000 để test hiệu năng
		String[] result= new String[size];
		for(int i=0; i<size; i++) {
			result[i]=RandomUtil.randomString();
		}
		
		return result;
	}
	
	public List<Integer> generateIntList() {
		//int size=RandomUtil.randomNumber(5, 10);
		int size=10000;//lấy số phần tử là 10000 để test hiệu năng
		List<Integer> result= new ArrayList<>();
		for(int i=0; i<size; i++) {
			result.add(RandomUtil.randomNumber(0, 10000));
		}
		
		return result;
	}
	
	public List<String> generateStringList(){
		//int size=RandomUtil.randomNumber(5, 10);
		int size=10000;//lấy số phần tử là 10000 để test hiệu năng
		List<String> result= new ArrayList<>();
		for(int i=0; i<size; i++) {
			result.add(RandomUtil.randomString());
		}
		
		return result;
	}
	
	public Book generateBook() {
		Book book= new Book();
		book.setName(RandomUtil.randomString());
		book.setAuthor(RandomUtil.randomString());
		book.setPublisher(RandomUtil.randomString());
		book.setPrice((float) RandomUtil.randomNumber(10000, 1000000));
		book.setLocation(RandomUtil.randomString());
		
		return book;
	}
	
	public Book[] generateBookArray() {
		//int size=RandomUtil.randomNumber(5, 10);
		int size=10000;//lấy số phần tử là 10000 để test hiệu năng
		Book[] result= new Book[size];
		for(int i=0; i<size; i++) {
			result[i]=generateBook();
			result[i].setId(i);
		}
		
		return result;
	}
	
	public List<Object> generateBookList() {
		//int size=RandomUtil.randomNumber(5, 10);
		int size=10000;//lấy số phần tử là 10000 để test hiệu năng
		List<Object> result= new ArrayList<>();
		for(int i=0; i<size; i++) {
			result.add(generateBook());
			((Book) result.get(i)).setId(i);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		GenerateData generateData= new GenerateData();
		List<Object> list= generateData.generateBookList();
		System.out.println(list);
	}
}
