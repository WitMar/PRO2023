//package classFromXml;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBElement;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;
//
//import model2.Employee;
//import model2.ObjectFactory;
//
//public class UnmarshallerExample {
//    public static void main(String[] args) throws JAXBException, FileNotFoundException {
//        JAXBContext jaxbContext     = JAXBContext.newInstance( ObjectFactory.class );
//        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//
//        InputStream inStream = new FileInputStream( "classes.xml" );
//        Employee employee = ((JAXBElement<Employee>) jaxbUnmarshaller.unmarshal( inStream )).getValue();
//        System.out.println(employee.getId() + " " + employee.getName());
//    }
//}