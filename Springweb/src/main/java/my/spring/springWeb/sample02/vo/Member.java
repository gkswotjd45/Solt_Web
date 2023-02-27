package my.spring.springWeb.sample02.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member{
	
	private String name; 
	private String phone;
	private String id;
	private String password;
	
}





// 아래 간단한 설명.
//@Getter 
//
////@NoArgsConstructor // 인자 없는 기본생성자를 만드는 구문 
//@AllArgsConstructor // 모든 private 필드를 가지고 있는 생성자를 만드는 구문, (3개 필드를 가지고 있는 생성자)
//@RequiredArgsConstructor // 필요로 가지고 있는 인자에 대한 생성자를 만드는 구문, => 추가적으로 @NonNull을 지정하여 해당 필드는 null값이 아니어야 하는 형태로 만듬.
//@ToString  // 각각 필드에 대한 값들을 나태남. // 그럼 일부 인자를 제외한 tostring으로 하고 싶을 땐  @ToString.Exclude 명시.(특정 private 필드)
//@EqualsAndHashCode // 객체 값을 비교하기 위한 형태.
//
//public class Member {
//
////	@NonNull
//	private String memberName;
//	@ToString.Exclude
//	private int memberAge; // 해당 필드에서만 Stter 자동적으로 만듬.
////	@NonNull
//	private String memberAddr; 
//	
//	
////	public Member(String memberName,  String memberAddr) {
////		
////		
////	}
////	
//
//	
//	
////	
////	public Member() {
////		// TODO Auto-generated constructor stub
////	}
////
////	public String getMemberName() {
////		return memberName;
////	}
////
////	public void setMemberName(String memberName) {
////		this.memberName = memberName;
////	}
////
////	public int getMemberAge() {
////		return memberAge;
////	}
////
////	public void setMemberAge(int memberAge) {
////		this.memberAge = memberAge;
////	}
////
////	public String getMemberAddr() {
////		return memberAddr;
////	}
////
////	public void setMemberAddr(String memberAddr) {
////		this.memberAddr = memberAddr;
////	}
////	
////	
//}
