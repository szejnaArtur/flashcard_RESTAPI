package pl.backend.flashcardApp.word;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.backend.flashcardApp.lesson.SqlLessonQueryRepository;
import pl.backend.flashcardApp.lesson.dto.LessonDto;
import pl.backend.flashcardApp.lesson.query.SimpleLesson;
import pl.backend.flashcardApp.lesson.query.SimpleLessonSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component("wordWarmup")
class Warmup implements ApplicationListener<ContextRefreshedEvent> {

    private final SqlWordRepositories wordRepository;
    private final SqlLessonQueryRepository lessonQueryRepository;

    Warmup(final SqlWordRepositories wordRepository, final SqlLessonQueryRepository lessonQueryRepository) {
        this.wordRepository = wordRepository;
        this.lessonQueryRepository = lessonQueryRepository;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        Optional<LessonDto> optionalLessonPersonalityDto = lessonQueryRepository.findDtoById(2L);
        SimpleLesson lessonPersonality = null;
        if (optionalLessonPersonalityDto.isPresent()) {
            LessonDto dto = optionalLessonPersonalityDto.get();
            lessonPersonality = SimpleLesson.restore(new SimpleLessonSnapshot(dto.getId(), dto.getName(), dto.getLevel(), dto.getMotherLanguage(), dto.getForeignLanguage()));
        }

        Optional<LessonDto> optionalLessonHumanDto = lessonQueryRepository.findDtoById(1L);
        SimpleLesson lessonHuman = null;
        if (optionalLessonHumanDto.isPresent()) {
            LessonDto dto = optionalLessonHumanDto.get();
            lessonHuman = SimpleLesson.restore(new SimpleLessonSnapshot(dto.getId(), dto.getName(), dto.getLevel(), dto.getMotherLanguage(), dto.getForeignLanguage()));
        }

        if (wordRepository.count() == 0) {
            List<Word> words = new ArrayList<>();
            words.add(Word.restore(new WordSnapshot(null, "gullible", "łatwowierny", "adjective", lessonPersonality.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "mean", "skąpy", "adjective", lessonPersonality.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "bright", "bystry", "adjective", lessonPersonality.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "date of birth", "data urodzenia", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "citizenship", "obywatelstwo", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "gender", "płeć", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "given name", "imię", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "male", "męska", "adjective", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "female", "żeńska", "adjective", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "family name", "nazwisko", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "marital status", "stan cywilny", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "middle name", "drugie imię", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "occupation", "zawód", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "spouse", "współmałżonek", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "muscular", "muskularny", "adjective", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "obese", "otyły", "adjective", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "overweight", "z nadwagą", "adjective", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "plump", "pulchny", "adjective", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "skinny", "chudy", "adjective", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "slender", "szczupły", "adjective", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "stocky", "krępy", "adjective", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "curly", "kręcone", "adjective", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "fringe", "grzywka", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "frizzy", "kędzierzawe", "adjective", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "highlights", "pasemka", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "plait", "warkocz", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "ponytail", "kucyk", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "tied in a bun", "zebrać w kok", null, lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "dimple", "dołek", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "freckles", "piegi", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "beauty spot", "pieprzyk", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "piercing", "kolczyk", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "scar", "blizna", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "tattoo", "tatuaż", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "wrinkles", "zmarszczki", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "cape", "peleryna", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "cape cardigan", "rozpinany sweter", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "dressing gown", "szlafrok", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "hoodie", "bluza z kapturem", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "jersey", "sweter", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "sleeve", "rękaw", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "sweatshirt", "bluza", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "bracelet", "bransoletka", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "high heels", "buty na wysokim obcasie", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "motorcycle boots", "buty motocyklowe", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "necklace", "naszyjnik", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "scarf", "szalik", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "slippers", "kapcie", "noun", lessonHuman.getSnapshot())));
            words.add(Word.restore(new WordSnapshot(null, "tie", "krawat", "noun", lessonHuman.getSnapshot())));

            wordRepository.saveAll(
                    words.stream().map(Word::getSnapshot).collect(toList())
            );
        }
    }
}
