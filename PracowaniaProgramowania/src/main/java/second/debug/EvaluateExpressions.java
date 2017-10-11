package second.debug;

import second.debug.hidden.ObjectMaker;

import java.util.List;

/**
 * Exercise 2: Using the Expression Window in the Debug perspective.
 *
 * @author Mark Hiner
 */
public class EvaluateExpressions {

    public static void main(final String... args) {
        // Let's make a list of 100000 objects
        final List<Integer> myList = ObjectMaker.getList(100000);

        // Now let's process some objects from our list

        // Process first object
        processElementAtIndex(myList, 0);

        // Process middle object
        processElementAtIndex(myList, 100000 / 2);

        // Process last object
        processElementAtIndex(myList, 100000 - 1);
    }

    private static void processElementAtIndex(final List<Integer> list,
                                              final int index)
    {
        // First let's check our method arguments to see if they're valid
        if (index < 0 || index >= list.size()) {
            throw new IllegalArgumentException(
                    "If you don't mind, I would prefer not to process your object...");
        }
        System.out.println(100 * list.get(index));

        // OK now we can process the argument.
        // ... just kidding, I'm totally going to delete your precious objects.
        list.set(index, null);
    }
}
