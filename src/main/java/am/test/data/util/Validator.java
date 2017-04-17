package am.test.data.util;

import java.util.Collection;

/**
 * Created by karlen on 4/17/17.
 */
public class Validator {

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }
}
