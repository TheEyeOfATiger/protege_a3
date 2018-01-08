import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.*;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String args[]) {
        readOntology();
        createOntology();
        writeOntology();
    }

    static void readOntology() {
        String filename = "ontology.owl";

        try {
            File file = new File(filename);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

            model.read(reader, null);

            int numbers = 0;
            Iterator classIter = model.listClasses();
            while (classIter.hasNext()) {
                OntClass ontClass = (OntClass)classIter.next();
                String uri = ontClass.getURI();
                String nameClass = ontClass.getLocalName();
                if (uri != null) {
                    System.out.println(uri);
                }
                if (nameClass != null) {
                    System.out.println(nameClass);
                    numbers++;
                }
            }
            System.out.println(numbers);
            model.write(System.out, "RDF/XML-ABBREV");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void createOntology() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);

        String uriBase = "http://www.something.com/myontology";

        model.createOntology(uriBase);

        OntClass person = model.createClass(uriBase + "#Person");
        OntClass module = model.createClass(uriBase + "#Module");
        OntClass diploma = model.createClass(uriBase + "#Diploma");
        OntClass student = model.createClass(uriBase + "#Student");
        OntClass professor = model.createClass(uriBase + "#Professor");

        person.addSubClass(student);
        person.addSubClass(professor);
    }

    static void writeOntology() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        File file = new File("C:\\Users\\Beniamin\\Documents\\IntelliJ Projects\\ModifyOntology\\newOntology.owl");
        StringWriter sw = new StringWriter();
        model.write(sw, "RDF/XML-ABBREV");
        String owlCode = sw.toString();

        try {
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
