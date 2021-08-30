package study.datajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
public class JpaBaseEntity {

    @Column(updatable = false)
    private LocalDateTime createDate;
    private LocalDateTime upDateTime;

    @PrePersist
    public void prePersist(){
        LocalDateTime now =LocalDateTime.now();
        createDate=now;
        upDateTime=now;

    }

    @PreUpdate
    public void preUpdate(){
        upDateTime=LocalDateTime.now();
    }
}
