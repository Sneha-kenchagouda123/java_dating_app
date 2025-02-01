package com.dating_app.service;
import com.dating_app.model.User;
import com.dating_app.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RecommendationServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RecommendationService recommendationService;

    @Test
    public void testGetRecommendations() {
        User user1 = new User(1L, "User 1", "Female", 25, Arrays.asList("Cricket", "Chess"));
        User user2 = new User(2L, "User 2", "Male", 27, Arrays.asList("Cricket", "Football", "Movies"));
        User user3 = new User(3L, "User 3", "Male", 26, Arrays.asList("Movies", "Tennis", "Football", "Cricket"));
        User user4 = new User(4L, "User 4", "Female", 24, Arrays.asList("Tennis", "Football", "Badminton"));

        when(userRepository.findByGenderNot("Male")).thenReturn(Arrays.asList(user1, user4));

        List<User> recommendations = recommendationService.getRecommendations(user2);
        assertEquals(2, recommendations.size());
        assertEquals("User 1", recommendations.get(0).getName());
        assertEquals("User 4", recommendations.get(1).getName());
    }
}
