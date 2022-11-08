package pl.backend.flashcardapp.word;

import org.springframework.data.repository.Repository;

interface SqlWordQueryRepository extends WordQueryRepository, Repository<SqlWord, Long> {

}
