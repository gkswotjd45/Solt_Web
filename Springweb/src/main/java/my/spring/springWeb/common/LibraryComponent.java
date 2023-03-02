package my.spring.springWeb.common;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

// 내가 "수동으로 bean 등록하려면  @bean을 이용해서 bean을 등록시킬 수 있음."
// @bean은 메서드로 붙여야함

// application context을 임의로 등록시켜야 함. @Configuration을 통해 @bean을 등록.
@Configuration
public class LibraryComponent {
	
	//bean을 수동등록.(리턴되는 형태을 객체로 bean 등록) // 메서드 이름이 bean 식별자임.
	@Bean
	public Gson getGson() {
		return new Gson();
	}
}
