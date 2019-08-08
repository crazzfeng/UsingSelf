package help1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan(value="cn.darkFurious.mapper")
public class DarkFuriousApplication {

	public static void main(String[] args) {
		Date date = new Date(-1000,1,15);

		/*Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Date time = calendar.getTime();*/
		System.err.println(date.getTime());
		//SpringApplication.run(DarkFuriousApplication.class, args);
	}

}
