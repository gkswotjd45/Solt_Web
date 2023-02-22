package springIoc.anno.Sample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 우리클래스로 부터 bean을 자동으로 등록 ,
@Component("myFood") // 원래 default bean id : myFoodMgr
public class myFoodMgr {
	
	// 자기가 가지고 있는 bean 중에 Food 라는 객체를 사용. // tpye이 동일하면  id 가지고 비교.
		@Autowired
//		@Qualifier(value="unfavoriteFood") // Qualifier가 있으면, 내가 지정한 이름 unfavoriteFood 을 가지고  찾음  => 출력 시 싫어하는 내장탕 수행..
		private Food favoriteFood;  // 좋아하는 음식 객체 필드 선언.
		
		@Autowired
		private Food unfavoriteFood;
		
		public myFoodMgr() {
			System.out.println("MyFoodMgr default 생성자 호출");
		}

		@Override
		public String toString() {
			return  favoriteFood + ", " + unfavoriteFood ;
		}
	
	
	
	
	
//	
//	
//	// 자기가 가지고 있는 bean 중에 Food 라는 객체를 사용. // tpye이 동일하면 id 가지고 비교.
//	@Autowired
//	@Qualifier(value="unfavoriteFood") // Qualifier가 있으면, 내가 지정한 이름 unfavoriteFood 을 가지고  찾음  => 출력 시 싫어하는 내장탕 수행..
//	private Food favoriteFood;  // 좋아하는 음식 객체 필드 선언.
//	
//	@Autowired
//	private Food unfavoriteFood;
//	
//	public myFoodMgr() {
//		System.out.println("MyFoodMgr default 생성자 호출");
//	}
//
//	@Override
//	public String toString() {
//		return  favoriteFood + ", " + unfavoriteFood ;
//	}
//	
}
