package my.spring.springWeb.sample09;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import my.spring.springWeb.sample09.vo.User;
//Rester 기반 핸들러 
@RestController
@RequestMapping(value = "Body")
public class responseBodyController {
	// responsebody을 통해 그대로 전달방식.
	// url에 특정정보를 땡겨서 사용 함 (get방식) // pathvariable를 이용 // //jsp파일을 전달하는 방식이 아닌 데이터를
	// // 직접찍음
	@RequestMapping(value = "text/{id}", produces = "text/plain; charset=UTF-8")
//	@ResponseBody
	public String method01(@PathVariable String id) {
		return "<h1>이것은 소리없는 아우성 " + id + "</h1>";
	}

	@RequestMapping(value = "textObject/{id}", produces = "text/plain; charset=UTF-8")
//	@ResponseBody 
	public ResponseEntity<String> method02(@PathVariable String id) {
		// data는 문자열 형태
		String msg = "<h1>이것은 소리없는 아우성 " + id + "</h1>";
		// header정보를 만들어야 함 (객체로 표현)
		HttpHeaders headers = new HttpHeaders();
		// media type ㅡ mine type 지정 => 객체화 지정.
//		headers.setContentType(new MediaType("text","plain",Charset.forName("UTF-8")));
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8"))); // html로 엎어 써짐;
//		ResponseEntit은 메시지, 헤더, 상태코드를 명시하여 반환
//		return new ResponseEntity<String>(msg,headers,HttpStatus.OK);
		return new ResponseEntity<String>(msg, headers, HttpStatus.CREATED); // 201번 - 서버쪽에서 뭔가가 생성되었다. 회원가입시 회원 정보 객체가
																				// 생김.
	}

	@RequestMapping(value = "json/{name}", produces = "application/json; charset=UTF-8")
//	@ResponseBody
	public User method03(@PathVariable String name) {
		User user = new User();
		user.setName(name);
		user.setAddr("서울");
		// produce와 리턴타입을 보고 알아서 json으로 변환.
		return user;
	}
}
