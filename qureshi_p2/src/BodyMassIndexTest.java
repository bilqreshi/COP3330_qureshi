import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    private BodyMassIndex b;

    @BeforeEach
    public void init() {
        b = new BodyMassIndex(75, 180);
    }

    @Test
    public void testBmiScore() {
        double score = BodyMassIndex.BmiScore(b);

        assertEquals(22.5, score);
    }

    @Test
    public void testBmiCategory() {
        String category = BodyMassIndex.BmiCategory(BodyMassIndex.BmiScore(b));

        assertEquals("Normal weight", category);
    }

    @Test
    public void testBmiCategoryUnderweight() {
        BodyMassIndex c;
        c = new BodyMassIndex(75, 140);

        String category = BodyMassIndex.BmiCategory(BodyMassIndex.BmiScore(c));

        assertEquals("Underweight", category);
    }

    @Test
    public void testBmiCategoryNormalweight() {
        BodyMassIndex c;
        c = new BodyMassIndex(66, 140);

        String category = BodyMassIndex.BmiCategory(BodyMassIndex.BmiScore(c));

        assertEquals("Normal weight", category);
    }

    @Test
    public void testBmiCategoryOverweight() {
        BodyMassIndex c;
        c = new BodyMassIndex(75, 200);

        String category = BodyMassIndex.BmiCategory(BodyMassIndex.BmiScore(c));

        assertEquals("Overweight", category);
    }

    @Test
    public void testBmiCategoryObesity() {
        BodyMassIndex c;
        c = new BodyMassIndex(75, 240);

        String category = BodyMassIndex.BmiCategory(BodyMassIndex.BmiScore(c));

        assertEquals("Obesity", category);
    }
}