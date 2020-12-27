package models;

public class Book implements Comparable<Book>{
	private long id;
	private String name;
	private String author;
	private String publisher;
	private float price;
	private String location;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	//mặc định so sánh theo id
	@Override
	public int compareTo(Book o) {
		if(this.id == o.id) {
			return 0;
		}else if(this.id > o.id){
			return 1;
		}else {
			return -1;
		}
	}
	
	
}
