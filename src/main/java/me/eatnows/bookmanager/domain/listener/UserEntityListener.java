package me.eatnows.bookmanager.domain.listener;

import me.eatnows.bookmanager.domain.User;
import me.eatnows.bookmanager.domain.UserHistory;
import me.eatnows.bookmanager.repository.UserHistoryRepository;
import me.eatnows.bookmanager.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Component
public class UserEntityListener {

    @PostPersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;
        UserHistory userHistory = new UserHistory();
//        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setUser(user);

        userHistoryRepository.save(userHistory);
    }
}
