package second.debug;

import second.debug.hidden.ObjectAnalyzer;
import second.debug.hidden.ObjectMaker;

public class ConditionalBreak {

    public static void main(final String... args) {
        // In E2, getList didn't work so well. So let's try an array this time...
        final Object[] myArray = ObjectMaker.getArray(100);

        boolean everythingIsOK = true;
        int i = 0;
        while (i < myArray.length && everythingIsOK) {
            // This time we're using an external library to process objects.
            // If something goes wrong, this is the line where we'll want to set a
            // breakpoint.
            everythingIsOK = ObjectAnalyzer.processElementAtIndex(myArray, i);
            i++;
        }

        if (!everythingIsOK) {
            throw new RuntimeException(
                    "Oh noes - analysis incomplete! See console for more information.");
        }
    }
}
