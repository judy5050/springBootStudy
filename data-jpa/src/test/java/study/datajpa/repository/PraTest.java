package study.datajpa.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Pra;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class PraTest {

    @Autowired PraRepository praRepository;
    @Test
    public void praTest(){
        Pra aaa = new Pra("AAA");
        praRepository.save(aaa);
    }


}
