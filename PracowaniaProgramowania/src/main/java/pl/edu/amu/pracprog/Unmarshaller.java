package pl.edu.amu.pracprog;

import model2.Employee;
import model2.ObjectFactory;

import javax.security.auth.login.Configuration;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.InputStream;

public class Unmarshaller {

    private  JAXBContextCreator contextCreator = new JAXBContextCreator();
    private  ClassLoadingUtil classLoadingUtil = new ClassLoadingUtil();

    public Employee unmarshallConfiguration(InputStream stream) {
        if (stream == null) {
            throw new IllegalArgumentException("Stream is NULL. Cannot read XML.");
        }
        try {
            JAXBContext ctx;
            try {
                ctx = contextCreator.create("model2", classLoadingUtil.getClassloader());
            } catch (JAXBException e) {
                ctx = null;
            }
            if (ctx == null) {
                ctx = contextCreator.create("model2", ObjectFactory.class.getClassLoader());
            }
            javax.xml.bind.Unmarshaller um = ctx.createUnmarshaller();
            @SuppressWarnings("unchecked")
            JAXBElement<Employee> el = (JAXBElement<Employee>) um.unmarshal(stream);
            return el.getValue();
        } catch (JAXBException ue) {
            throw new IllegalStateException("Cannot parse holidays XML file.", ue);
        }
    }

    public class JAXBContextCreator {
        public JAXBContext create(String packageName, ClassLoader classLoader) throws JAXBException {
            return JAXBContext.newInstance(packageName, classLoader);
        }
    }

}

