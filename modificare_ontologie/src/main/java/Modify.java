import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

import java.io.*;
import java.util.*;


public class Modify {

    public static void main(String args[]) {
        // Deci putem face un program care sa faca ontologia de la zero astfel :
        // Intr-un while pana la citirea lui "q" citim clase pe care le adaugam in ontologie
        // apoi trebuie sa facem subclasele, apoi facem la fel pt citirea proprietatilor
        // apoi dupa ce am facut aceste lucruri facem asignarea prop la clase,
        // pt adaugarea de adnotari la prop si clase

//----------------------------------------

        //addClassToOntology();
        //assignedProperty();
        //getProperty();
        addLabelForProperty();
    }

    static void addAnnotationForProperty() {
    }

    static void addLabelForProperty() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";
        String uriRoot = "http://www.w3.org/2002/07/owl";

        ObjectProperty teach = model.createObjectProperty(uriBase + "#teach");
        teach.addLabel("teach", null);

        File file = new File("C:\\Users\\Beniamin\\Documents\\IntelliJ Projects\\ModifyOntology\\ontology.owl");
        StringWriter sw = new StringWriter();
        model.write(sw, "RDF/XML-ABBREV");
        String owlCode = sw.toString();

        try {
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void assignedProperty() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";
        String uriRoot = "http://www.w3.org/2002/07/owl";

        OntClass beniamin = model.getOntClass(uriBase + "#beniamin");

        // create object properties(uriBase + "#teach");
        ObjectProperty teach = model.createObjectProperty(uriBase + "#teach");
        //teach.setDomain(professor);
        //teach.setRange(module);


        Scanner sc = new Scanner(System.in);
        System.out.println("Write another name for class");
        String newClass = sc.next();
        sc.close();

        // asignare proprietate pe o clasa
        //asignare proprietati claselor cu equivalent with
        SomeValuesFromRestriction svfr =
                model.createSomeValuesFromRestriction(null, teach, beniamin);
        beniamin.addEquivalentClass(svfr);


        File file = new File("C:\\Users\\Beniamin\\Documents\\IntelliJ Projects\\ModifyOntology\\ontology.owl");
        StringWriter sw = new StringWriter();
        model.write(sw, "RDF/XML-ABBREV");
        String owlCode = sw.toString();

        try {
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void getProperty() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";
        String uriRoot = "http://www.w3.org/2002/07/owl";

        OntClass ontClass = model.getOntClass(uriRoot + "#Thing");

        Iterator propIter = ontClass.listDeclaredProperties();
        int numbers = 0;
        while (propIter.hasNext()) {
            OntProperty property = (OntProperty) propIter.next();
            numbers++;
            System.out.println(property.getLocalName());
        }
        System.out.println(numbers);

    }

    static void addClassToOntology() {
        System.out.println("....");

        Scanner sc = new Scanner(System.in);
        System.out.println("Add a new class name");
        String newClass = sc.next();
        sc.close();

        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";
        String uriRoot = "http://www.w3.org/2002/07/owl";

        OntClass ontClass = model.createClass(uriBase + "#" + newClass);

        //model.getOntClass(uriBase + "#Patologia_Vertebromedulara_neurochirurgicala").addSubClass(ontClass);

        //model.getOntClass(uriRoot + "#Thing").addSubClass(ontClass);

        File file = new File("C:\\Users\\Beniamin\\Documents\\IntelliJ Projects\\ModifyOntology\\ontology.owl");
        StringWriter sw = new StringWriter();
        model.write(sw, "RDF/XML-ABBREV");
        String owlCode = sw.toString();

        try {
            FileWriter fw = new FileWriter(file);
            fw.write(owlCode);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}