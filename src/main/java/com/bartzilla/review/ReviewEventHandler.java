package com.bartzilla.review;

import com.bartzilla.user.User;
import com.bartzilla.user.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Review.class)
public class ReviewEventHandler {
    private final UserRespository users;

    @Autowired
    public ReviewEventHandler(UserRespository users) {
        this.users = users;
    }

    @HandleBeforeCreate
    public void addReviewerBasedOnLoggedInUser(Review review) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(name);

        review.setReviewer(user);
    }
}
