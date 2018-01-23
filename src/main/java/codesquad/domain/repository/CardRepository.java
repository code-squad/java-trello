package codesquad.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import codesquad.domain.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

}
