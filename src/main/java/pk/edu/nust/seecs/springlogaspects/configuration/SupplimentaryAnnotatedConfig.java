
package pk.edu.nust.seecs.springlogaspects.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pk.edu.nust.seecs.springlogaspects.bo.CourseBo;
import pk.edu.nust.seecs.springlogaspects.bo.CourseBoImpl;
import pk.edu.nust.seecs.springlogaspects.bo.StudentBo;
import pk.edu.nust.seecs.springlogaspects.bo.StudentBoImpl;

@Configuration
@ComponentScan(basePackages={"pk.edu.nust.seecs.springlogaspects"})
public class SupplimentaryAnnotatedConfig {

    @Bean
    public CourseBo courseManager() {
        return new CourseBoImpl();
    }
    
    @Bean
    public StudentBo studentManager() {
        return new StudentBoImpl();
    }
    
}
