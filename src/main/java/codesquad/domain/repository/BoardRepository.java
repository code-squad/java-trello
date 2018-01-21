package codesquad.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import codesquad.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
