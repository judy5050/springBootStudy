package study.datajpa.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Pra {
    @Id
    @GeneratedValue
    private Long id;

    private String praName;

    public Pra(String praName) {
        this.praName = praName;
    }
}
