package se.lexicon.jpa_workshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpa_workshop.entity.AppUser;

import java.util.Optional;

@DataJpaTest
public class AppUserRepositoryTest {
    @Autowired
    AppUserRepository testObject;

    AppUser appUser;
    @BeforeEach
    public void setup(){
        appUser= new AppUser("Mehrdad","Javan","mehrdad.javan@lexicon.se");
        testObject.save(appUser);
    }


    @Test
    public void test_find_by_id(){
       Optional<AppUser> findAppUser = testObject.findById(1);
        Assertions.assertTrue(findAppUser.isPresent());
        Assertions.assertEquals("Mehrdad",findAppUser.get().getFirstName());
        System.out.println("----------------------------------");
        System.out.println("findAppUser.toString() = " + findAppUser.toString());

    }



    @Test
    public void test_find_by_email(){
        Optional<AppUser> findAppUser = testObject.findByEmail("mehrdad.javan@lexicon.se");
        Assertions.assertTrue(findAppUser.isPresent());
        Assertions.assertEquals("Mehrdad",findAppUser.get().getFirstName());
        Assertions.assertEquals("mehrdad.javan@lexicon.se",findAppUser.get().getEmail());
        System.out.println("----------------------------------");
        System.out.println("findAppUser.toString() = " + findAppUser.toString());
    }

    @Test
    public void test_find_by_email_ignoreCase(){
        Optional<AppUser> findAppUser = testObject.findByEmailIgnoreCase("MEHRDAD.javan@lexicon.se");
        Assertions.assertTrue(findAppUser.isPresent());
        Assertions.assertEquals("Mehrdad",findAppUser.get().getFirstName());
        Assertions.assertEquals("mehrdad.javan@lexicon.se",findAppUser.get().getEmail());
        System.out.println("----------------------------------");
        System.out.println("findAppUser.toString() = " + findAppUser.toString());
    }

    @Test
    public void test_delete(){
      //boolean result =  testObject.deleteById(1);
    }

}
