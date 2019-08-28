package d200063.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")

public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CategoryId;
	 
	private String Categoryname;
	
	private String Categorydesc;

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryname() {
		return Categoryname;
	}

	public void setCategoryname(String categoryname) {
		Categoryname = categoryname;
	}

	public String getCategorydesc() {
		return Categorydesc;
	}

	public void setCategorydesc(String categorydesc) {
		Categorydesc = categorydesc;
	}

}
