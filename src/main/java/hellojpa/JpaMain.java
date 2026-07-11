package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        // 애플리케이션 로딩 시점에 딱 1개만 생성(싱글톤) - 데이터베이스 연결을 비롯한 것들이 준비됨
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml 의 <persistence-unit name="hello">
        // 트랜잭션 단위 - 자바 컬렉션으로 이해하면 됨
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 가져옴 (DB 커넥션 하나 받아옴)
        EntityTransaction et = em.getTransaction();
        // 트랜잭션 시작
        et.begin();

        try {
            // code
            /*
             * 1. 회원 등록
             */
            /*
            Member member = new Member();
            // member.setId(1L);
            // member.setName("HelloA");
            member.setId(2L);
            member.setName("HelloB");

            em.persist(member);
            */

            /*
             * 2. 회원 단건 조회
             */
            /*
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
            */

            /*
             * 3. 회원 삭제
             */
            /*
            Member findMember = em.find(Member.class, 2L);
            em.remove(findMember);
            */

            /*
             * 4. 회원 수정
             */
            /*
            Member findMember = em.find(Member.class, 1L); // EntityManager 로 엔티티 가져오면 JPA가 관리
            findMember.setName("HelloJPA"); // 바뀌면 트랜잭션 커밋 직전에 UPDATE 쿼리 날림
            */

            /*
             * 5. 회원 전체 조회
             */
            List<Member> result = em.createQuery("select m from Member as m", Member.class) // ANSI SQL 지원하는 대부분의 쿼리 지원
                                    // 페이징
                                    // .setFirstResult(1)
                                    // .setMaxResults(10)
                                    .getResultList(); // 객체 대상 쿼리 - 방언에 맞게 번역하여 SQL 생성

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            // commit
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            // DB 커넥션을 물고있기 때문에 사용 후 꼭 닫아야 함
            em.close();
        }
        // 애플리케이션 종료 시점에 EntityManagerFactory 닫기
        emf.close();
    }

}