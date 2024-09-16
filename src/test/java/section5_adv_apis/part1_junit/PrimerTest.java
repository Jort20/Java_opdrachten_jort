package section5_adv_apis.part1_junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimerTest {
    private Primer primer;

    @BeforeEach
    public void setup(){
        primer = new Primer();
    }
    @Test
    public void testgetGcPercentage100(){
        primer.setSequence("GCGCGC");
        assertEquals(1.0, primer.getGcPercentage(),"GC percentage is 100%");
    }
    @Test
    public void testgetGcPercentageNothing(){
        primer.setSequence("AAAAAA");
        assertEquals(0.0, primer.getGcPercentage(),"GC percentage is 0%");
    }
    @Test
    public void testgetGcPercentageEmpty(){
        primer.setSequence("");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {primer.getGcPercentage();});
        assertEquals("Sequence is null or empty", exception.getMessage());
    }
    @Test
    public void testgetGcPercentageNull(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {primer.setSequence(null);});
        assertEquals("Sequence cannot be null", exception.getMessage());
    }
    @Test
    public void testgetGcPercentageinvalid(){
        primer.setSequence("ATGZX");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {primer.getGcPercentage();});
        assertTrue(exception.getMessage().contains("Invalid character in sequence"));
    }
    @Test
    public void testgetMeltingTemperaturecorrect(){
        primer.setSequence("GCG");
        assertEquals(12.0,primer.getMeltingTemperature(), 0.1);
    }

    @Test
    public void testgetMeltingTemperaturenothing(){
        primer.setSequence("ATAT");
        assertEquals(8.0,primer.getMeltingTemperature(), 0.1);
    }
    @Test
    public void testgetMeltingTemperatureEmpty(){
        primer.setSequence("");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {primer.getMeltingTemperature();});
        assertEquals("Sequence is null or empty", exception.getMessage());
    }
    @Test
    public void testgetMeltingTemperatureinvalid(){
        primer.setSequence("ATGZX");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {primer.getMeltingTemperature();});
        assertTrue(exception.getMessage().contains("Invalid character in sequence"));
    }
    @Test
    public void testgetMeltingTemperatureNull(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {primer.setSequence(null);});
        assertEquals("Sequence cannot be null", exception.getMessage());
    }
}
