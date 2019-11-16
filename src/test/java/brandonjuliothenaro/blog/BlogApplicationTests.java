package brandonjuliothenaro.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

	@Test
	void applicationRunsSuccessfullyTest() {
		SpringApplication
			.run(BlogApplication.class, new String[]{})
			.close();
	}

}
