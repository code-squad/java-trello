package codesquad.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import codesquad.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByEmail(String email);
}
