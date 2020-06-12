package pt.adentis.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;

import pt.adentis.api.AdentisApplication;
import pt.adentis.api.service.FizzBuzz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = AdentisApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class FizzBuzzTest {
	public static void main(String[] args) {
        System.out.println(new FizzBuzz().outPut());
    }

    @Test
    public void inicio() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.Start();
        assertEquals("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz", actual);
    }

    @Test
    public void sortudo() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.Validator();
        assertEquals("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz", actual);
    }

    @Test
    public void checkBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.outPut();
        assertTrue(actual.contains("buzz: 3"));
    }
    
    @Test
    public void checkFizzBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.outPut();
        assertTrue(actual.contains("fizzbuzz: 1"));
    }
    
    @Test
    public void checkFizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.outPut();
        assertTrue(actual.contains("fizz: 4"));
    }
    
    @Test
    public void checkLuck() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.outPut();
        assertTrue(actual.contains("lucky: 2"));
    }
    
    @Test
    public void checkInteger() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.outPut();
        assertTrue(actual.contains("fizzbuzz: 1"));
    }
    
    @Test
    public void contar() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.outPut();
        String actualCheck = fizzBuzz.Validator();
        assertTrue(actual.contains("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz"));
        assertTrue(actual.contains(actualCheck));
    }
}
