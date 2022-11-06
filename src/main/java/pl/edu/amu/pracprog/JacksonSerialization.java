package pl.edu.amu.pracprog;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import model.Employee;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JacksonSerialization {

    final static Logger logger = Logger.getLogger(JacksonSerialization.class);

    public static void serializeDemo(ObjectMapper mapper, String fileSuffix) throws IOException {
        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        List<Employee> employees = new ArrayList<>();

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        Employee employee = objectsCreator.getEmp();
        Employee employee2 = objectsCreator.getEmp2();

        employees.add(employee);
        employees.add(employee2);

        //Serialize to file and string
        mapper.writeValue(new File("result." + fileSuffix), employees);
        String jsonString = mapper.writeValueAsString(employees);

        logger.info("Printing serialized original object " + fileSuffix);
        System.out.println(jsonString);

        //Deserialize from file
        List<Employee> deserializedEmployees = mapper.readValue(
                new File("result." + fileSuffix), new TypeReference<List<Employee>>(){});

        //Give a rise
        deserializedEmployees.get(0).setSalary(deserializedEmployees.get(0).getSalary() * 2);

        //Serialize back
        mapper.writeValue(new File("result-modified." + fileSuffix), deserializedEmployees);
        String modifiedJsonString = mapper.writeValueAsString(deserializedEmployees);
        logger.info("Printing serialized modified object " + fileSuffix);
        System.out.println(modifiedJsonString);
    }

    public static void deserializeDemo(ObjectMapper mapper, String fileSuffix) throws IOException {
        //Deserialized employee object from employees.* file in resources
        InputStream employeeIs = JacksonSerialization.class.getClassLoader().
                getResourceAsStream("employee." + fileSuffix);

        //Read value - set class type of serialization
        Employee deserializedEmployee = mapper.readValue(employeeIs, Employee.class);

        //Give employee big salary
        deserializedEmployee.setSalary(100000);

        String modifiedSerialzied = mapper.writeValueAsString(deserializedEmployee);
        logger.info("Printing modified re-serialized employee to" + fileSuffix);

        System.out.println(modifiedSerialzied);
    }

    public static void main(String[] args) throws IOException {

        ObjectMapper jsonMapper = new ObjectMapper();
        //ObjectMapper xmlMapper = new XmlMapper();
        //serializeDemo(xmlMapper, "xlm");
        jsonMapper.registerModule(new JodaModule());
        serializeDemo(jsonMapper, "json");
        deserializeDemo(jsonMapper, "json");

    }
}


