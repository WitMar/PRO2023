package second.debug.hidden;

public class ObjectAnalyzer {


    public static boolean processElementAtIndex(final Object[] myArray,
                                                final int i) {
        final Object o = myArray[i];

        if (o == null) {
            System.out.println("Something is wrong with the " + (i + 1) + suffix(i +
                    1) + " object... :(\n\n");
            return false;
        }

        return true;
    }

    private static String suffix(int i) {
        i = i % 10;

        String suffix = "th";
        switch (i) {
            case 1:
                suffix = "rst";
                break;
            case 2:
                suffix = "nd";
                break;
            case 3:
                suffix = "rd";
                break;
        }
        return suffix;
    }

}

