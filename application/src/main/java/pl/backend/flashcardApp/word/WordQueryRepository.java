package pl.backend.flashcardApp.word;

import pl.backend.flashcardApp.word.dto.WordDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface WordQueryRepository {

    List<WordDto> findAllBy();

    List<WordDto> findAllByLessonId(Long id);

    Optional<WordDto> findDtoById(Long id);

    <T> Set<T> findBy(Class<T> type);

}
