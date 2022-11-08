package second.junit;

import java.util.Locale;

public class ProcessQuery {

    HttpQueryClass queryClass;

    public ProcessQuery(HttpQueryClass queryClass) {
        this.queryClass = queryClass;
    }

    public String process(String param) {
        return queryClass.query(param).toUpperCase();
    }

}
