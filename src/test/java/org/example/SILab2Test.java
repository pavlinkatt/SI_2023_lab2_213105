package org.example;
import jdk.jfr.Percentage;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    private List<String> createList(String... elems) {

        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void everybranch(){
        List<User> users = new ArrayList<>();

        //test1
        String username1="pavlinka15";
        String password1 = "softversko123";
        String email1 = null;
        User user1 = new User(username1, null, email1);
        users.add(user1);
        RuntimeException ex;
        ex=assertThrows(RuntimeException.class, ()-> SILab2.function(user1, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //test2
        String username2=null;
        String password2 = "pipi";
        String email2 = "ana.anna@hotmail.com";
        User user2 = new User(username2, password2, email2);
        users.add(user2);
        assertEquals(false, SILab2.function(user2,users));

        //test3
        String username3="Marija";
        String password3 = "pavlinkatt";
        String email3 = "exaMple@hotmail.com";
        User user3 = new User(username3, password3, email3);
        users.add(user3);
        assertEquals(false, SILab2.function(user3,users));

        //test4
        String username4="stefan";
        String password4 = "stefan1$3 s h";
        String email4 = "stefan@yahoo.com";
        User user4 = new User(username4, password4, email4);
        assertEquals(false, SILab2.function(user4,users));

        //test5
        String username5="marko";
        String password5 = "an drej123@";
        String email5 = "marko@yahoo.com";
        User user5 = new User(username5, password5, email5);
        assertEquals(false, SILab2.function(user5,users));
    }
    @Test
    void multiplecondition(){
        List<User> users=new ArrayList<>();

        //test1
        User u1=null;
        RuntimeException except;
        except=assertThrows(RuntimeException.class, () -> SILab2.function(u1,users));
        assertTrue(except.getMessage().contains("Mandatory information missing!"));

        //test2
        String username2="Marija";
        String password2 = null;
        String email2 = "mac@gmail.com";
        User u2 = new User(username2, password2, email2);
        except=assertThrows(RuntimeException.class, () -> SILab2.function(u2,users));
        assertTrue(except.getMessage().contains("Mandatory information missing!"));

        //test3
        String username3="Ana";
        String password3 = "maci123";
        String email3 = null;
        User u3 = new User(username3, password3, email3);
        except=assertThrows(RuntimeException.class, () -> SILab2.function(u3,users));
        assertTrue(except.getMessage().contains("Mandatory information missing!"));

        //test4
        String username4="Stefan";
        String password4 = "stefce01";
        String email4= "stef@yahoo.com";
        User u4 = new User(username4, password4, email4);
        assertFalse(SILab2.function(u4,users));
    }
}
