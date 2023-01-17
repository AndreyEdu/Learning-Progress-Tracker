package tracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckInputTest {

    @Test
    void onlyASCII() {
        CheckInput checkInput = new CheckInput("afds fas fas@fas.ca");
        boolean str = checkInput.onlyASCII("fas");
        assertTrue(str);
    }

    @Test
    void correctEmail() {
        CheckInput checkInput = new CheckInput("fasd fas FAs@g.c");
        boolean email = checkInput.checkEmail();
        assertTrue(email);
    }

    @Test
    void checkApostrophesAndHyphens() {
        CheckInput checkInput = new CheckInput("`afds fas fas@fas.ca");
        boolean str = checkInput.onlyASCII("`afds");
        assertFalse(str);

        checkInput = new CheckInput("-afds fas fas@fas.ca");
        str = checkInput.onlyASCII("-afds");
        assertFalse(str);

        checkInput = new CheckInput("afds- fas fas@fas.ca");
        str = checkInput.onlyASCII("afds-");
        assertFalse(str);

        checkInput = new CheckInput("afds fas` fas@fas.ca");
        str = checkInput.onlyASCII("fas`");
        assertFalse(str);

        checkInput = new CheckInput("`-a f`-a fas@fas.ca");
        str = checkInput.onlyASCII("f`-a");
        assertFalse(str);
    }
}