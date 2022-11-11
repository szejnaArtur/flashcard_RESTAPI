package pl.backend.flashcardApp.word;

import org.springframework.data.repository.Repository;

interface SqlWordQueryRepository extends WordQueryRepository, Repository<WordSnapshot, Long> {

}
