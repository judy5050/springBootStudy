package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;


@Slf4j
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)

)
public class AutoAppConfig {


    /**
     * 자동 의존관계 주입 vs 수동 의존관계 주입
     */
//    @Bean(name = "memberMemberRepository")
//    MemberRepository memberRepository(){
//        System.out.println("스프링 자동 수동 의존관계");
//        return new MemoryMemberRepository();
//    }
}
