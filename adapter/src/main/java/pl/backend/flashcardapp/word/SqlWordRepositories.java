package pl.backend.flashcardapp.word;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface SqlWordRepositories extends Repository<SqlWord, Long> {

    int count();

    Optional<SqlWord> findById(Long id);

    SqlWord save(SqlWord entity);

    List<SqlWord> saveAll(Iterable<SqlWord> entities);

    void deleteById(Long id);
}

