package codesquad.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import codesquad.domain.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long> {

}
