package me.eatnows.bookmanager.repository;

import me.eatnows.bookmanager.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
