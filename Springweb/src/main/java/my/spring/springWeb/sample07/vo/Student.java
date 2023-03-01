package my.spring.springWeb.sample07.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	// command 갳체의 필드명과 일치.
	private int StudentNumber;
	private String studentName;
	private String studentDept;
}
