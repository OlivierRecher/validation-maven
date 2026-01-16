package bankAccountApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void defaultConstructor_initializesWithDefaults() {
        Person person = new Person();
        assertEquals("", person.getName());
        assertEquals('M', person.getGender());
        assertEquals(0, person.getAge());
    }

    @Test
    void shortConstructor_initializesCorrectly() {
        Person person = new Person("Alice", 'F', 30, 165.0f);
        assertEquals("Alice", person.getName());
        assertEquals('F', person.getGender());
        assertEquals(30, person.getAge());
        assertEquals(80, person.getWeight());
    }

    @Test
    void fullConstructor_validatesInput() throws Exception {
        Person person = new Person("Bob", 'M', 25, 75.0f, 180.0f, "Black", "Brown", "bob@test.com");
        assertEquals("Bob", person.getName());
        assertEquals("bob@test.com", person.getEmail());
    }

    @Test
    void setGender_throwsException_forInvalidValue() {
        Person person = new Person();
        assertThrows(Exception.class, () -> person.setGender('X'));
    }

    @Test
    void setHairColor_onlyAcceptsValidColors() {
        Person person = new Person();
        person.setHairColor("Blond");
        assertEquals("Blond", person.getHairColor());

        person.setHairColor("Purple");
        assertEquals("Blond", person.getHairColor());
    }

    @Test
    void setAge_ignoresNegativeValues() {
        Person person = new Person();
        person.setAge(25);
        person.setAge(-5);
        assertEquals(25, person.getAge());
    }

    @Test
    void toString_matchesExpectedFormat() throws Exception {
        Person person = new Person("Dave", 'M', 20, 70.0f, 170.0f, "White", "Green", "dave@test.com");
        String result = person.toString();

        assertTrue(result.contains("Dave"));
        assertTrue(result.contains("White"));
        assertTrue(result.contains("dave@test.com"));
        assertTrue(result.contains(Person.DELIM));
    }
}
