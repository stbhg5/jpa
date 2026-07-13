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

    // 엔티티 클래스 생성자 사용시, JPA 는 내부적으로 리플렉션을 쓰며 동적으로 객체생성을 하기 때문에, 기본 생성자가 필요하다. (접근 제어자는 상관 없음)
    public Member() {}

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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