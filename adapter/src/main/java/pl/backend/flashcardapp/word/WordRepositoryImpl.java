package pl.backend.flashcardapp.word;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Component
class WordRepositoryImpl implements WordRepository {

    private final SqlWordRepositories repository;

    WordRepositoryImpl(final SqlWordRepositories repository) {
        this.repository = repository;
    }

    @Override
    public int count() {
        return repository.count();
    }

    @Override
    public Optional<Word> findById(final Long id) {
        return repository.findById(id).map(SqlWord::toWord);
    }

    @Override
    public Word save(final Word entity) {
        return repository.save(SqlWord.fromWord(entity)).toWord();
    }

    @Override
    public List<Word> saveAll(final Iterable<Word> entities) {
        return repository.saveAll(
                        StreamSupport.stream(entities.spliterator(), false)
                                .map(SqlWord::fromWord)
                                .collect(toList())
                ).stream()
                .map(SqlWord::toWord)
                .collect(toList());
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}
