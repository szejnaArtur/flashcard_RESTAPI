package pl.backend.flashcardapp.word;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.flashcardapp.word.dto.WordDto;
import pl.backend.flashcardapp.word.dto.WordWithoutPartOfSpeechDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface WordQueryRepository extends JpaRepository<Word, Long> {

    List<WordDto> findAllBy();

    List<WordDto> findAllByLessonId(Long id);

    Optional<WordDto> findDtoById(Long id);

    List<WordWithoutPartOfSpeechDto> findAllWithPairCodeBy();

    <T> Set<T> findBy(Class<T> type);

}
