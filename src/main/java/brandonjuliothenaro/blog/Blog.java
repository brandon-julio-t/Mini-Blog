package brandonjuliothenaro.blog;

import lombok.*;
import javax.persistence.*;

import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NonNull
    @NotBlank
    private String title;

    @Lob
    @NonNull
    @NotBlank
    private String content;

    public Blog() {
    }

    public Blog(String title, String content) {
    	try {
	    	this.title = title;
	    	this.content = content;
    	} catch (Exception e) {
    		System.err.println(e);
    	}
    }

}