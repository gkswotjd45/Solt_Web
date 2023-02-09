package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 이파일이 우리 cofing.xml을 가지고 마이 바티스 factory 만들어주는 형태.
public class MyBatisConnectionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	   
	   static {
	      
	      String resource = "./SqlMapConfig.xml"; //이 설정을 기반을 팩토리가 만들어짐. 
	      // 이 xml 파일은 자바 파일이 아닌 , 리소스 임. => 이 리소스는 ./ 현재 mybatis 클래스 위치의 폴더기준을 찾음
	      try {
	         Reader reader = Resources.getResourceAsReader(resource);
	         
	         if( sqlSessionFactory == null ) {
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	         }
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }
	   
	   
	   public static SqlSessionFactory getSqlSessionFactory() {
	      return sqlSessionFactory;
	      
	      //결과적을 sqlsesion = > 실질적으로 map형태로 반환. (쿼리를 만들어내는 공장을 반환)
	      //sql 세션을 만들어냄.
	   }
	
}
