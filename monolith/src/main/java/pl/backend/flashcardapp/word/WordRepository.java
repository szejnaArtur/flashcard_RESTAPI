package pl.backend.flashcardapp.word;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface WordRepository extends JpaRepository<Word, Long> {

    Optional<Word> findById(Long aLong);

    <S extends Word> S save(S entity);

    <S extends Word> List<S> saveAll(Iterable<S> entities);

    void deleteById(Long id);

}
