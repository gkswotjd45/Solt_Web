package springIoc.sample4;

import java.util.Calendar;
import java.util.GregorianCalendar;

// 이클래스는 bean을 만들 수 없음. => 추상클래스 형태므로, 그럼에도 필드를 통해 인스턴스를 새엉.
public abstract class AbstarctDay {

	public abstract String dayInfo();
	
	// static 메서드는 instance 없이 호출이 가능.
	// 특정 메서드를 이용해서 객체를 만들어 냄. => 원래 추상클래스에서는 객체 생성할 수 없음  
	// 그래서 이걸  팩토리 메서드  통해  "객체를 만들수 있음"
	public static AbstarctDay getInstance()  {
		//오늘 날짜의 요일을 알아봄.
		// 오늘 날짜에 대한 요일을 알아낼 수 있음. => 캘린더 생성
		GregorianCalendar cal = new GregorianCalendar();
		
		// 요일에 대한 정보를 숫자형해로 뽑아냄.
		int day = cal.get(Calendar.DAY_OF_WEEK); 
		// 해당 날짜에 대한 요일을 숫자로 알려줌.
		// 1. 일요일   2.월요일  3.화요일
		AbstarctDay my_day = null;
		switch (day) {
		case 1:
			my_day = new Sunday();
			break;
		case 2:
			my_day = new Monday();
			break;
		case 3:
			my_day = new Tuesday();
			break;	
		}
		return my_day;
	}
}
