package brandonjuliothenaro.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedDb(BlogRepository blogRepo) {
		return args -> {
			for (int i = 1; i <= 3; i++) {
				blogRepo.save(new Blog("Lorem Ipsum #" + i, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sed semper magna, in egestas orci. Phasellus ullamcorper erat quis purus iaculis facilisis. Fusce ac erat eu elit ultricies viverra quis vel nisl. Duis faucibus vulputate ante, in gravida nibh vestibulum a. Cras et ex commodo, tristique metus pellentesque, tincidunt eros. Curabitur vitae finibus nisl.\n\nSed quis dapibus ligula, a tempus quam. Pellentesque condimentum vitae arcu sed auctor. Donec tempus tortor vitae orci iaculis, nec faucibus eros suscipit. Sed a est id justo semper rutrum et eu leo. Vivamus imperdiet ex at tincidunt aliquet. Vestibulum libero enim, faucibus vitae scelerisque nec, dignissim quis urna. Suspendisse sodales purus vel urna sollicitudin vehicula. Nunc vulputate lacinia nunc, et faucibus felis ornare pretium. Nunc nibh sapien, ultrices eget aliquet sit amet, hendrerit vitae tortor. Aenean mollis odio nec quam pulvinar blandit. Nam vitae purus in tellus ultrices rhoncus. Maecenas a dictum felis, vitae suscipit nisi. Vivamus et efficitur libero. Phasellus vitae nunc vitae nibh placerat malesuada. Donec vestibulum auctor purus, quis luctus justo tempus id. In placerat ornare elit. Fusce at lectus luctus eros interdum congue. Quisque scelerisque est vel imperdiet congue."));
			}
		};
	}

}
