package pl.backend.flashcardapp.word;

import java.util.List;
import java.util.Optional;

interface WordRepository {

    int count();

    Optional<Word> findById(Long aLong);

    Word save(Word entity);

    List<Word> saveAll(Iterable<Word> entities);

    void deleteById(Long id);

}
