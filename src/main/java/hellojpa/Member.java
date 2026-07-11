package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // 꼭 넣기 - JPA가 관리할 객체
// @Table(name = "user") // 테이블명 매핑 가능
public class Member {

    @Id // PK
    private Long id;

    // @Column(name = "username") // 컬럼명 매핑 가능
    private String name;

    // Getter, Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}