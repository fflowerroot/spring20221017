package lecture.p07core;

import org.springframework.stereotype.Component;

@Component //?

//Indicates that an annotated class is a "component".
//Such classes are considered as candidates for auto-detection 
//when using annotation-based configuration and classpath scanning. 
//Other class-level annotations may be considered as identifying a component as well, 
//typically a special kind of component:e.g. the @Repository annotation or AspectJ's @Aspect annotation.
//Since:2.5Author:Mark Fisher
//See Also:RepositoryServiceControllerorg.springframework.context.annotation.ClassPathBeanDefinitionScanner

public class Controller {

}
