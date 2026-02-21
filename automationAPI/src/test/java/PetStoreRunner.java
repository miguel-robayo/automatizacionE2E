import com.intuit.karate.junit5.Karate;

public class PetStoreRunner {

    @Karate.Test
    Karate testPetStore(){
        return Karate.run("petStore").relativeTo(getClass());
    }
}
