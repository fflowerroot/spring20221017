package lecture.p01lombok;

import lombok.Data;
@Data // All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor!

public class JavaBean5 {
	
	private String name;
	private int age;
	
}
