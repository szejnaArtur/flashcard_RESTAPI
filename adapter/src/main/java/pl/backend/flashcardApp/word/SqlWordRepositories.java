package pl.backend.flashcardApp.word;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface SqlWordRepositories extends Repository<WordSnapshot, Long> {

    int count();

    Optional<WordSnapshot> findById(Long id);

    WordSnapshot save(WordSnapshot entity);

    List<WordSnapshot> saveAll(Iterable<WordSnapshot> entities);

    void deleteById(Long id);
}

