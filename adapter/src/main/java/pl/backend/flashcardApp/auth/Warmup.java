package pl.backend.flashcardApp.auth;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("UserAndRoleWarmup")
class Warmup implements ApplicationListener<ContextRefreshedEvent> {

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    Warmup(final UserFacade userFacade, final UserRepository userRepository) {
        this.userFacade = userFacade;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (userRepository.count() == 0) {
            List<Role> roles = new ArrayList<>();
            roles.add(new Role(null, "ROLE_USER"));
            roles.add(new Role(null, "ROLE_MANAGER"));
            roles.add(new Role(null, "ROLE_ADMIN"));
            roles.add(new Role(null, "ROLE_SUPER_ADMIN"));
            roles.add(new Role(null, "ROLE_DEVELOPER"));
            roles.forEach(userFacade::saveRole);

            List<User> users = new ArrayList<>();
            users.add(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
            users.add(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
            users.add(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
            users.add(new User(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));
            users.forEach(userFacade::saveUser);

            userFacade.addRoleToUser("john", "ROLE_USER");
            userFacade.addRoleToUser("john", "ROLE_MANAGER");
            userFacade.addRoleToUser("will", "ROLE_MANAGER");
            userFacade.addRoleToUser("jim", "ROLE_ADMIN");
            userFacade.addRoleToUser("arnold", "ROLE_DEVELOPER");
            userFacade.addRoleToUser("arnold", "ROLE_ADMIN");
            userFacade.addRoleToUser("arnold", "ROLE_USER");
        }
    }
}
