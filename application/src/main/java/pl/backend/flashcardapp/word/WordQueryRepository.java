package pl.backend.flashcardapp.word;

import pl.backend.flashcardapp.word.dto.WordDto;
import pl.backend.flashcardapp.word.dto.WordWithoutPartOfSpeechDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface WordQueryRepository {

    List<WordDto> findAllBy();

    List<WordDto> findAllByLessonId(Long id);

    Optional<WordDto> findDtoById(Long id);

    List<WordWithoutPartOfSpeechDto> findAllWithPairCodeBy();

    <T> Set<T> findBy(Class<T> type);

}
