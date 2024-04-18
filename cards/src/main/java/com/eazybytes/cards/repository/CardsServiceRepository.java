package com.eazybytes.cards.repository;
import com.eazybytes.cards.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsServiceRepository extends JpaRepository<Card,Long> {
}
