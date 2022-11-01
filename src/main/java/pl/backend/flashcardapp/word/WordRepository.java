package pl.backend.flashcardapp.word;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface WordRepository extends JpaRepository<Word, Long> {

    List<Word> findAllByLessonId(Long id);

}
