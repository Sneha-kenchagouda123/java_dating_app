package com.dating_app.service;
import com.dating_app.model.User;
import com.dating_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user); // Save the user to the database
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    public List<User> getRecommendations(User user) {
        List<User> potentialMatches = userRepository.findByGenderNot(user.getGender());

        // Log the potential matches
        System.out.println("Potential Matches: " + potentialMatches);

        return potentialMatches.stream()
                .sorted(Comparator
                        .comparingInt((User u) -> -getInterestMatchScore(user, u))
                        .thenComparingInt(u -> Math.abs(u.getAge() - user.getAge()))
                )
                .limit(2)
                .collect(Collectors.toList());
    }
    private int getInterestMatchScore(User user1, User user2) {
        return (int) user1.getInterests().stream()
                .filter(interest -> user2.getInterests().contains(interest))
                .count();
    }
}
