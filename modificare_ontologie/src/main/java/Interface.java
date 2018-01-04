import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

import java.util.*;
import java.io.*;


public class Interface {

    public static void main(String args[]) {
        System.out.println("Type 'q' to skip a step...");
        Scanner input = new Scanner(System.in);
        int sw = 0;

/*
        System.out.println("Classes : Ontology");
        while (sw == 0) {
            System.out.println("Add a class name :");
            String string = input.next();
            if (!string.equals("q")) {
                addClassToOntology(string);
            }else if (string.equals("q")) {
                sw = 1;
            }
        }

        System.out.println("Object Properties : Ontology");
        sw = 0;
        while (sw == 0) {
            System.out.println("Add a property name :");
            String string = input.next();
            if (!string.equals("q")) {
///
                ;//addPropertyToOntology(string);
///
            }else if (string.equals("q")) {
                sw = 1;
            }
        }

        System.out.println("Add SubClass : Ontology");
        sw = 0;
        while (sw == 0) {
            System.out.println("Add two name of class :");
            String principala = input.next();
            String secundara = input.next();
            if (!principala.equals("q")) {
                ;//addSubClassInOntology(principala, secundara);
            }else if (principala.equals("q")) {
                sw = 1;
            }
        }

        System.out.println("Search a Specific Class : Ontology");
        sw = 0;
        while (sw == 0) {
            System.out.println("Add a class name :");
            String string = input.next();
            if (!string.equals("q")) {
                System.out.println(searchClassInOntology(string));
            }else if (string.equals("q")) {
                sw = 1;
            }
        }

        System.out.println("Assigned a Property to a Class : Ontology");
        sw = 0;
        while (sw == 0) {
            System.out.println("Add a property name and class name :");
            String proprietate = input.next();
            String clasa = input.next();
            if (!proprietate.equals("q")) {
                assignedPropertyToClass(proprietate, clasa);
            }else if (proprietate.equals("q")) {
                sw = 1;
            }
        }

        System.out.println("Show the Properties List :");
        ArrayList<String> list = new ArrayList<String>();
        list = getPropertyList();

        for(int i = 0; i < list.size(); i++) {
            System.out.print(i + " : ");
            String element = list.get(i);
            System.out.println(element);
        }
        System.out.println("Numar de proprietati : " + list.size());

        System.out.println("Show the Classes List :");
        ArrayList<String> lista = new ArrayList<String>();
        lista = getClassList();

        for(int i = 0; i < lista.size(); i++) {
            System.out.print(i + " : ");
            String element = lista.get(i);
            System.out.println(element);
        }
        System.out.println("Numar de clase : " + lista.size());
        System.out.println("");

        System.out.println("Add a Data Property : Ontology");
        String newProperty = input.next();
        addDataPropertyToOntology(newProperty);

        System.out.println("Add a Individual : Ontology");
        String newIndividual = input.next();
        String newClass = input.next();
        addIndividualToOntology(newIndividual, newClass);


        getClassHierarchy(newClass);
        addAnnotationForClass(newClass);
        addAnnotationForObjectProperty(newProperty);
        addAnnotationForDataProperty(newProperty);
*/


        // Class Hierarchy : bifat
        // Annotation for Object Property : bifat
        // Annotation for Class : bifat
        // Annotation for Data Property : bifat
        //addLabelForProperty();

        //// Java and Owl : Am ramas la Slide-ul :::
        /*
            Create Ontology Model
            Read a File Into Ontology Model
            Retrieve Ontology Class
            Retrieve a Specified Class
            Get the Ontology URI
            Class Hierarchy
            Intersection/Union/Complement
            Retrieve the Properties of a Specified Class
            Property Types
            Property Domain and Range
            Datatype Properties
            Object Properties
            Other Types of Properties
            Restrictions
            AllValuesFrom / SomeValuesFrom
            HasValue
            Cardinality / MinCardinality / MaxCardinality
            Individuals

            PLUSS -> Creating a New Ontology
        */


        //close the Scanner
        input.close();
    }


    static void addAnnotationForDataProperty(String newProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        DatatypeProperty dataProperty = model.createDatatypeProperty(uriBase + "#" + newProperty);

        dataProperty.addVersionInfo(String s);
        dataProperty.addComment(String s, String s1);
        dataProperty.addIsDefinedBy(Resource resource);
        dataProperty.addLabel(String s, String s1);
        dataProperty.addSeeAlso(Resource resource);

        // salvez modificarile facute
        writeToOntology(model);
    }

    static void addAnnotationForObjectProperty(String newProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        ObjectProperty ontProperty = model.createObjectProperty(uriBase + "#" + newProperty);

        ontProperty.addVersionInfo(String s);
        ontProperty.addComment(String s, String s1);
        ontProperty.addIsDefinedBy(Resource resource);
        ontProperty.addLabel(String s, String s1);
        ontProperty.addSeeAlso(Resource resource);

        // salvez modificarile facute
        writeToOntology(model);
    }

    static void addAnnotationForClass(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);

        ontClass.addVersionInfo(String s);
        ontClass.addComment(String s, String s1);
        ontClass.addIsDefinedBy(Resource resource);
        ontClass.addLabel(String s, String s1);
        ontClass.addSeeAlso(Resource resource);

        // salvez modificarile facute
        writeToOntology(model);
    }

    static void getClassHierarchy(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);
        Iterator supIter = ontClass.listSuperClasses();
        while (supIter.hasNext()) {
            OntClass sup = (OntClass) supIter.next();
            System.out.println(sup);
        }
        System.out.println("----------------");
        Iterator subIter = ontClass.listSubClasses();
        while (subIter.hasNext()) {
            OntClass sub = (OntClass) subIter.next();
            System.out.println(sub);
        }
    }

    static void addIndividualToOntology(String newIndividual, String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);
        Individual indiv = ontClass.createIndividual(uriBase + "#" + newIndividual);

        // salvez modificarile facute
        writeToOntology(model);
    }

    static void addDataPropertyToOntology(String newProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        DatatypeProperty dataProperty = model.createDatatypeProperty(uriBase + "#" + newProperty);

        // salvez modificarile facute
        writeToOntology(model);
    }

    static ArrayList<String> getClassList() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriRoot = "http://www.w3.org/2002/07/owl";

        Iterator classIter = model.listClasses();

        ArrayList<String> list = new ArrayList<String>();
        while (classIter.hasNext()) {
            OntClass ontClass = (OntClass) classIter.next();
            String nameClass = ontClass.getLocalName();
            if (nameClass != null) {
                list.add(nameClass);
            }
        }

        return list;
    }

    static ArrayList<String> getPropertyList() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriRoot = "http://www.w3.org/2002/07/owl";

        OntClass ontClass = model.getOntClass(uriRoot + "#Thing");
        Iterator propIter = ontClass.listDeclaredProperties();

        ArrayList<String> list = new ArrayList<String>();
        while (propIter.hasNext()) {
            OntProperty ontProperty = (OntProperty) propIter.next();
            String nameProperty = ontProperty.getLocalName();
            list.add(nameProperty);
        }

        return list;
    }

    static void assignedPropertyToClass(String proprietate, String clasa) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        OntClass ontClass = model.getOntClass(uriBase + "#" + clasa);
        ObjectProperty ontProperty = model.getObjectProperty(uriBase + "#" + proprietate);

        SomeValuesFromRestriction svfr =
                model.createSomeValuesFromRestriction(null, ontProperty, ontClass);
        ontClass.addEquivalentClass(svfr);

        // salvez modificarile facute
        writeToOntology(model);
    }

    // NEED functia de verificare a existentei unei clase
    static String searchClassInOntology(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";
        OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);
        String nameClass = ontClass.getLocalName();
        if (!nameClass.equals(null)) {
            return nameClass;
        }

        return "Not Exist";
    }

    static void addSubClassInOntology(String principala, String secundara) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        OntClass ontPrincipala = model.getOntClass(uriBase + "#" + principala);
        OntClass ontSecundara = model.getOntClass(uriBase + "#" + secundara);

        ontPrincipala.addSubClass(ontSecundara);

        // salvez modificarile facute
        writeToOntology(model);
    }

    static void addClassToOntology(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";
        OntClass ontClass = model.createClass(uriBase + "#" + newClass);

        // salvez modificarile facute
        writeToOntology(model);
    }


    // not so usefull
    static void addSubClass() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        OntClass beni2 = model.getOntClass(uriBase + "#beni2");
        model.getOntClass(uriBase + "#beniamin").addSubClass(beni2);

        // salvez modificarile facute
        writeToOntology(model);
    }


    // !!!!!!!!!!!!!!!
    // Functii Pentru A Elimina Liniile Care Se Repeta

    static void writeToOntology(OntModel model) {
        File file = new File("C:\\Users\\Beniamin\\Documents\\IntelliJ Projects\\ModifyOntology\\ontology.owl");
        StringWriter sw = new StringWriter();
        model.write(sw, "RDF/XML-ABBREV");
        String owlCode = sw.toString();

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(owlCode);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}