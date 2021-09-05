package me.eatnows.bookmanager.repository;

import me.eatnows.bookmanager.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
