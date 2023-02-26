package my.spring.springWeb.sample02.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter 
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Data
public class User {
	private String userName;
	private int userAge;
	private String userDept;
	private String userAddress;
	

	
}
