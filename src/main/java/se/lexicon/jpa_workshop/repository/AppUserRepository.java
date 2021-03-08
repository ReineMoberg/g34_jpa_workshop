package se.lexicon.jpa_workshop.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.jpa_workshop.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    /*
    saveAll
    findById
    existById
    findAll
    deleteById
    delete
    deleteAll
    */

    Optional<AppUser> findByEmail(String email);

    Optional<AppUser> findByEmailIgnoreCase(String email);

    List<AppUser> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);

    @Query("select a from AppUser a where a.firstName = :firstName and a.lastName = :lastName")
    List<AppUser> myCustomQueryFNAndLN(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("select a from AppUser a where LOWER(a.firstName) = LOWER(:firstName) and lower(a.lastName) = lower(:lastName)")
    List<AppUser> myCustomQueryFNAndLNIgnoreCase(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
