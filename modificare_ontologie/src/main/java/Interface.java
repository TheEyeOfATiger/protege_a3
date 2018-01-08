import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFList;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.util.FileManager;

import java.util.*;
import java.io.*;


public class Interface {

    public static void main(String args[]) {

        System.out.println("Type 'q' to skip a step...");
        Scanner input = new Scanner(System.in);
        int sw = 0;
/*
        System.out.println("Class : Ontology");
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
            System.out.println("Add a object property name :");
            String string = input.next();
            if (!string.equals("q")) {
                addObjectPropertyToOntology(string);
            }else if (string.equals("q")) {
                sw = 1;
            }
        }

        System.out.println("Data Properties : Ontology");
        sw = 0;
        while (sw == 0) {
            System.out.println("Add a data property name :");
            String string = input.next();
            if (!string.equals("q")) {
                addDataPropertyToOntology(string);
            }else if (string.equals("q")) {
                sw = 1;
            }
        }

        System.out.println("Individual : Ontology");
        sw = 0;
        while (sw == 0) {
            System.out.println("Add an individual name :");
            String string = input.next();
            String clasa = input.next();
            if (!string.equals("q")) {
                addIndividualToOntology(string, clasa);
            }else if (string.equals("q")) {
                sw = 1;
            }
        }
*/
        System.out.println("Add SubClass : Ontology");
        sw = 0;
        while (sw == 0) {
            System.out.println("Add two name of class :");
            String principala = input.next();
            String secundara = input.next();
            if (!principala.equals("q")) {
                addSubClassInOntology(principala, secundara);
            }else if (principala.equals("q")) {
                sw = 1;
            }
        }
/*
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
                assignedObjectPropertyToClass(proprietate, clasa);
            }else if (proprietate.equals("q")) {
                sw = 1;
            }
        }

        System.out.println("Show the Classes List :");
        ArrayList<String> lista = new ArrayList<String>();
        lista = getClassList();
        for(int i = 0; i < lista.size(); i++) {
            System.out.print(i + " : ");
            String element = lista.get(i);
            System.out.println(element);
        }

        System.out.println("Show the Object Properties List :");
        ArrayList<String> lista1 = new ArrayList<String>();
        lista1 = getObjectPropertyList();
        for(int i = 0; i < lista1.size(); i++) {
            System.out.print(i + " : ");
            String element = lista1.get(i);
            System.out.println(element);
        }

        System.out.println("Show the Data Properties List :");
        ArrayList<String> lista2 = new ArrayList<String>();
        lista2 = getDataPropertyList();
        for(int i = 0; i < lista2.size(); i++) {
            System.out.print(i + " : ");
            String element = lista2.get(i);
            System.out.println(element);
        }

        System.out.println("Show the Individual List :");
        ArrayList<String> lista3 = new ArrayList<String>();
        lista3 = getIndividualList();
        for(int i = 0; i < lista3.size(); i++) {
            System.out.print(i + " : ");
            String element = lista3.get(i);
            System.out.println(element);
        }

        System.out.println("Add Annotation for Class : Ontology");
        while (sw == 0) {
            System.out.println("Add a class name :");
            String string = input.next();
            if (!string.equals("q")) {
                addAnnotationForClass(string);
            }else if (string.equals("q")) {
                sw = 1;
            }
        }

        System.out.println("Add Annotation for Object Properties : Ontology");
        sw = 0;
        while (sw == 0) {
            System.out.println("Add a object property name :");
            String string = input.next();
            if (!string.equals("q")) {
                addAnnotationForObjectProperty(string);
            }else if (string.equals("q")) {
                sw = 1;
            }
        }

        System.out.println("Add Annotation for Data Properties : Ontology");
        sw = 0;
        while (sw == 0) {
            System.out.println("Add a data property name :");
            String string = input.next();
            if (!string.equals("q")) {
                addAnnotationForDataProperty(string);
            }else if (string.equals("q")) {
                sw = 1;
            }
        }

        System.out.println("Add Annotation for Individual : Ontology");
        sw = 0;
        while (sw == 0) {
            System.out.println("Add an individual name :");
            String string = input.next();
            String clasa = input.next();
            if (!string.equals("q")) {
                addAnnotationForIndividual(string);
            }else if (string.equals("q")) {
                sw = 1;
            }
        }

        System.out.println("Verify Existence of Class");
        System.out.println(verifyIfClassExist("beniamin"));
        System.out.println(verifyIfClassExist("ben"));

        System.out.println("Verify Existence of Object Property");
        System.out.println(verifyIfObjectPropertyExist("teach"));
        System.out.println(verifyIfObjectPropertyExist("nullw"));

        System.out.println("Verify Existence of Data Property");
        System.out.println(verifyIfDataPropertyExist("volume"));
        System.out.println(verifyIfDataPropertyExist("age"));

        System.out.println("Verify Existence of Individual");
        System.out.println(verifyIfIndividualExist("decan"));
        System.out.println(verifyIfIndividualExist("profesor"));

        System.out.println("Add Disjoint With for a Class");
        addDisjointWithClass("beniamin");

        System.out.println("Add Description for ObjectProperty");
        addDescriptionForObjectProperties("teach");

        System.out.println("Add Description for DataProperty");
        addDescriptionForDataProperty("volume");


        System.out.println("Show The Ontology Class");
        retrieveOntologyClasses();

        System.out.println("Show SubClasses of a Class");
        getSubClassesOfClass("Patologia_Vertebromedulara_neurochirurgicala");

        System.out.println("Show SuperClasses of a Class");
        getSuperClassesOfClass("Patologia_Vertebromedulara_neurochirurgicala");

        System.out.println("Verify if a class is Root");
        verifyIfClassIsRoot("beniamin");
        verifyIfClassIsRoot("Compresiuni");
        verifyIfClassIsRoot("Patologia_Vertebromedulara_neurochirurgicala");

        System.out.println("Intersection Union Complement of a Class");
        IntersectionUnionComplement("beniamin");


        System.out.println("Show the Instances of a Class");
        getInstanceOfClass("beniamin");

        System.out.println("Show Range of a DataProperty");
        getRangeOfDataProperty("volume");

        System.out.println("Show Domain of a DataProperty");
        getDomainOfDataProperty("volume");

        System.out.println("Show Domain of a ObjectProperty");
        getDomainOfObjectProperty("teach");

        System.out.println("Show Range of a ObjectProperty");
        getRangeOfObjectProperty("teach");

        System.out.println("Show the Properties of a Class");
        getPropertiesOfClass("beniamin");

*/

        //close the Scanner
        input.close();
    }


    static String searchClassInOntology(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(newClass) == true) {
            OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);
            String nameClass = ontClass.getLocalName();
            if (!nameClass.equals(null)) {
                return nameClass;
            }
        }

        return "Not Exist";
    }

    static boolean verifyIfClassExist(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        ArrayList<String> listClass = new ArrayList<String>();
        listClass = getClassList();

        for(int i = 0; i < listClass.size(); i++) {
            String element = listClass.get(i);
            if (newClass.equals(element)) {
                return true;
            }
        }

        return false;
    }

    static boolean verifyIfObjectPropertyExist(String newObjectProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        ArrayList<String> listObjectProperty = new ArrayList<String>();
        listObjectProperty = getObjectPropertyList();

        for(int i = 0; i < listObjectProperty.size(); i++) {
            String element = listObjectProperty.get(i);
            if (newObjectProperty.equals(element)) {
                return true;
            }
        }

        return false;
    }

    static boolean verifyIfDataPropertyExist(String newDataProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        ArrayList<String> listDataProperty = new ArrayList<String>();
        listDataProperty = getDataPropertyList();

        for(int i = 0; i < listDataProperty.size(); i++) {
            String element = listDataProperty.get(i);
            if (newDataProperty.equals(element)) {
                return true;
            }
        }

        return false;
    }

    static boolean verifyIfIndividualExist(String newIndividual) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        ArrayList<String> listIndividual = new ArrayList<String>();
        listIndividual = getIndividualList();

        for(int i = 0; i < listIndividual.size(); i++) {
            String element = listIndividual.get(i);
            if (newIndividual.equals(element)) {
                return true;
            }
        }

        return false;
    }

    static void addDisjointWithClass(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(newClass) == true) {
            OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);
            ontClass.addDisjointWith(ontClass);
        }

        // salvez modificarile facute
        writeToOntology(model);
    }

    static void addDescriptionForObjectProperties(String newObjectProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfObjectPropertyExist(newObjectProperty) == true) {
            ObjectProperty ontProperty = model.getObjectProperty(uriBase + "#" + newObjectProperty);

            ontProperty.addEquivalentProperty(ontProperty);
            ontProperty.addSubProperty(ontProperty);
            ontProperty.addInverseOf(ontProperty);
            ontProperty.setDomain(ontProperty);
            ontProperty.setRange(ontProperty);
        }

        // salvez modificarile facute
        writeToOntology(model);
    }

    static void addDescriptionForDataProperty(String newDataProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfDataPropertyExist(newDataProperty) == true) {
            DatatypeProperty ontProperty = model.getDatatypeProperty(uriBase + "#" + newDataProperty);

            ontProperty.addEquivalentProperty(ontProperty);
            ontProperty.addSubProperty(ontProperty);
            ontProperty.setDomain(ontProperty);
            ontProperty.setRange(ontProperty);
        }

        // salvez modificarile facute
        writeToOntology(model);
    }

    static void addAnnotationForIndividual(String newIndividual) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfIndividualExist(newIndividual) == true) {
            Individual ontIndividual = model.getIndividual(uriBase + "#" + newIndividual);
            Scanner scanner = new Scanner(System.in);

            String versionInfo = scanner.next();
            ontIndividual.addVersionInfo(versionInfo);

            String comment = scanner.next();
            ontIndividual.addComment(comment, null);

            String nameClass1 = scanner.next();
            String nameProperty1 = scanner.next();
            OntClass ontClass1 = model.getOntClass(uriBase + "#" + nameClass1);
            ObjectProperty ontProperty1 = model.getObjectProperty(uriBase + "#" + nameProperty1);
            SomeValuesFromRestriction isDefinedBy =
                    model.createSomeValuesFromRestriction(null, ontProperty1, ontClass1);
            ontIndividual.addIsDefinedBy(isDefinedBy);

            String label = scanner.next();
            ontIndividual.addLabel(label, null);

            String nameClass2 = scanner.next();
            String nameProperty2 = scanner.next();
            OntClass ontClass2 = model.getOntClass(uriBase + "#" + nameClass2);
            ObjectProperty ontProperty2 = model.getObjectProperty(uriBase + "#" + nameProperty2);
            SomeValuesFromRestriction seeAlso =
                    model.createSomeValuesFromRestriction(null, ontProperty2, ontClass2);
            ontIndividual.addSeeAlso(seeAlso);

            scanner.close();
            // salvez modificarile facute
            writeToOntology(model);
        }else {
            System.out.println("Not Possible. The Individual Not Exist.");
        }

    }

    static void addAnnotationForDataProperty(String newDataProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfDataPropertyExist(newDataProperty) == true) {
            DatatypeProperty dataProperty = model.createDatatypeProperty(uriBase + "#" + newDataProperty);
            Scanner scanner = new Scanner(System.in);

            String versionInfo = scanner.next();
            dataProperty.addVersionInfo(versionInfo);

            String comment = scanner.next();
            dataProperty.addComment(comment, null);

            String nameClass1 = scanner.next();
            String nameProperty1 = scanner.next();
            OntClass ontClass1 = model.getOntClass(uriBase + "#" + nameClass1);
            ObjectProperty ontProperty1 = model.getObjectProperty(uriBase + "#" + nameProperty1);
            SomeValuesFromRestriction isDefinedBy =
                    model.createSomeValuesFromRestriction(null, ontProperty1, ontClass1);
            dataProperty.addIsDefinedBy(isDefinedBy);

            String label = scanner.next();
            dataProperty.addLabel(label, null);

            String nameClass2 = scanner.next();
            String nameProperty2 = scanner.next();
            OntClass ontClass2 = model.getOntClass(uriBase + "#" + nameClass2);
            ObjectProperty ontProperty2 = model.getObjectProperty(uriBase + "#" + nameProperty2);
            SomeValuesFromRestriction seeAlso =
                    model.createSomeValuesFromRestriction(null, ontProperty2, ontClass2);
            dataProperty.addSeeAlso(seeAlso);

            scanner.close();
            // salvez modificarile facute
            writeToOntology(model);
        }else {
            System.out.println("Not Possible. The DataProperty Not Exist.");
        }
    }

    static void addAnnotationForObjectProperty(String newObjectProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfObjectPropertyExist(newObjectProperty) == true) {
            ObjectProperty ontProperty = model.createObjectProperty(uriBase + "#" + newObjectProperty);
            Scanner scanner = new Scanner(System.in);

            String versionInfo = scanner.next();
            ontProperty.addVersionInfo(versionInfo);

            String comment = scanner.next();
            ontProperty.addComment(comment, null);

            String nameClass1 = scanner.next();
            String nameProperty1 = scanner.next();
            OntClass ontClass1 = model.getOntClass(uriBase + "#" + nameClass1);
            ObjectProperty ontProperty1 = model.getObjectProperty(uriBase + "#" + nameProperty1);
            SomeValuesFromRestriction isDefinedBy =
                    model.createSomeValuesFromRestriction(null, ontProperty1, ontClass1);
            ontProperty.addIsDefinedBy(isDefinedBy);

            String label = scanner.next();
            ontProperty.addLabel(label, null);

            String nameClass2 = scanner.next();
            String nameProperty2 = scanner.next();
            OntClass ontClass2 = model.getOntClass(uriBase + "#" + nameClass2);
            ObjectProperty ontProperty2 = model.getObjectProperty(uriBase + "#" + nameProperty2);
            SomeValuesFromRestriction seeAlso =
                    model.createSomeValuesFromRestriction(null, ontProperty2, ontClass2);
            ontProperty.addSeeAlso(seeAlso);

            scanner.close();
            // salvez modificarile facute
            writeToOntology(model);
        }else {
            System.out.println("Not Possible. The ObjectProperty Not Exist.");
        }
    }

    static void addAnnotationForClass(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(newClass) == true) {
            OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);
            Scanner scanner = new Scanner(System.in);

            String versionInfo = scanner.next();
            ontClass.addVersionInfo(versionInfo);

            String comment = scanner.next();
            ontClass.addComment(comment, null);

            String nameClass1 = scanner.next();
            String nameProperty1 = scanner.next();
            OntClass ontClass1 = model.getOntClass(uriBase + "#" + nameClass1);
            ObjectProperty ontProperty1 = model.getObjectProperty(uriBase + "#" + nameProperty1);
            SomeValuesFromRestriction isDefinedBy =
                    model.createSomeValuesFromRestriction(null, ontProperty1, ontClass1);
            ontClass.addIsDefinedBy(isDefinedBy);

            String label = scanner.next();
            ontClass.addLabel(label, null);

            String nameClass2 = scanner.next();
            String nameProperty2 = scanner.next();
            OntClass ontClass2 = model.getOntClass(uriBase + "#" + nameClass2);
            ObjectProperty ontProperty2 = model.getObjectProperty(uriBase + "#" + nameProperty2);
            SomeValuesFromRestriction seeAlso =
                    model.createSomeValuesFromRestriction(null, ontProperty2, ontClass2);
            ontClass.addSeeAlso(seeAlso);

            scanner.close();
            // salvez modificarile facute
            writeToOntology(model);
        }else {
            System.out.println("Not Possible. The Class Not Exist.");
        }
    }

    static void addIndividualToOntology(String newIndividual, String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfIndividualExist(newIndividual) == false) {
            if (verifyIfClassExist(newClass) == true) {
                OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);
                Individual indiv = ontClass.createIndividual(uriBase + "#" + newIndividual);

                // salvez modificarile facute
                writeToOntology(model);
            }else {
                System.out.println("Not Possible. The Class Not Exist.");
            }
        }else {
            System.out.println("Not Possible. The Individual Exist.");
        }
    }

    static void addDataPropertyToOntology(String newDataProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfDataPropertyExist(newDataProperty) == false) {
            DatatypeProperty dataProperty = model.createDatatypeProperty(uriBase + "#" + newDataProperty);

            // salvez modificarile facute
            writeToOntology(model);
        }else {
            System.out.println("Not Possible. The DataProperty Exist.");
        }
    }

    static ArrayList<String> getClassList() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

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

    static ArrayList<String> getObjectPropertyList() {
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
            if (ontProperty.isObjectProperty()) {
                String nameProperty = ontProperty.getLocalName();
                list.add(nameProperty);
            }
        }

        return list;
    }

    static ArrayList<String> getDataPropertyList() {
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
            if (ontProperty.isDatatypeProperty()) {
                String nameProperty = ontProperty.getLocalName();
                list.add(nameProperty);
            }
        }

        return list;
    }

    static ArrayList<String> getIndividualList() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        Iterator individuals = model.listIndividuals();

        ArrayList<String> list = new ArrayList<String>();
        while (individuals.hasNext()) {
            Individual individual = (Individual) individuals.next();
            String nameIndividual = individual.getLocalName();
            list.add(nameIndividual);
        }

        return list;
    }

    static ArrayList<String> getInstanceOfClass(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(newClass) == true) {
            OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);

            Iterator iter = ontClass.listInstances();
            ArrayList<String> list = new ArrayList<String>();
            while (iter.hasNext()) {
                Individual individual = (Individual) iter.next();
                String nameInstance = individual.getLocalName();
                if (nameInstance != null) {
                    list.add(nameInstance);
                }
            }

            return list;
        }

        ArrayList<String> lista = new ArrayList<String>();
        return lista;
    }

    static void getRangeOfDataProperty(String newDataProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfDataPropertyExist(newDataProperty) == true) {
            DatatypeProperty ontProperty = model.getDatatypeProperty(uriBase + "#" + newDataProperty);
            String propName = ontProperty.getLocalName();
            String rng = "";

            if (ontProperty.getRange() != null)
                rng = ontProperty.getRange().getLocalName();

            System.out.println(propName + ": \t(" + rng + ") ");
        }
    }

    static void getDomainOfDataProperty(String newDataProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfDataPropertyExist(newDataProperty) == true) {
            DatatypeProperty ontProperty = model.getDatatypeProperty(uriBase + "#" + newDataProperty);
            String propName = ontProperty.getLocalName();
            String dom = "";

            if (ontProperty.getDomain() != null)
                dom = ontProperty.getDomain().getLocalName();

            System.out.println(propName + ": \t(" + dom + ") ");
        }
    }

    static void getDomainOfObjectProperty(String newObjectProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if(verifyIfObjectPropertyExist(newObjectProperty) == true) {
            ObjectProperty ontProperty = model.getObjectProperty(uriBase + "#" + newObjectProperty);
            String propertyName = ontProperty.getLocalName();
            String dom = "";

            if (ontProperty.getDomain() != null)
                dom = ontProperty.getDomain().getLocalName();

            System.out.println(propertyName + ": \t(" + dom + ") ");
        }
    }

    static void getRangeOfObjectProperty(String newObjectProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if(verifyIfObjectPropertyExist(newObjectProperty) == true) {
            ObjectProperty ontProperty = model.getObjectProperty(uriBase + "#" + newObjectProperty);
            String propertyName = ontProperty.getLocalName();
            String rng = "";

            if (ontProperty.getRange() != null)
                rng = ontProperty.getRange().getLocalName();

            System.out.println(propertyName + ": \t(" + rng + ") ");
        }
    }

    static void getPropertiesOfClass(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(newClass) == true) {
            OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);
            Iterator propIter = ontClass.listDeclaredProperties();

            while (propIter.hasNext()) {
                OntProperty property = (OntProperty) propIter.next();
                System.out.println(property.getLocalName());
            }
        }
    }

    static void IntersectionUnionComplement(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(newClass) == true) {
            OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);

            if (ontClass.isIntersectionClass()) {
                IntersectionClass intersection = ontClass.asIntersectionClass();
                RDFList operands = intersection.getOperands();
                for (int i = 0; i < operands.size(); i++) {
                    RDFNode rdfNode = operands.get(i);
                    System.out.println(rdfNode);
                }
            } else if (ontClass.isUnionClass()) {
                UnionClass union = ontClass.asUnionClass();
                RDFList operands = union.getOperands();
                System.out.println(operands);
            } else if (ontClass.isComplementClass()) {
                ComplementClass compl = ontClass.asComplementClass();
                RDFList operands = compl.getOperands();
                System.out.println(operands);
            }
        }
    }

    static void verifyIfClassIsRoot(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(newClass) == true) {
            OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);
            System.out.println(ontClass.isHierarchyRoot());
        }
    }

    static void getSuperClassesOfClass(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(newClass) == true) {
            OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);
            Iterator classIteration = ontClass.listSuperClasses();

            while (classIteration.hasNext()) {
                OntClass auxClass = (OntClass) classIteration.next();
                String nameClass = auxClass.getLocalName();
                System.out.println(nameClass);
            }
        }
    }

    static void getSubClassesOfClass(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(newClass) == true) {
            OntClass ontClass = model.createClass(uriBase + "#" + newClass);
            Iterator classIter = ontClass.listSubClasses();

            while (classIter.hasNext()) {
                OntClass ont = (OntClass) classIter.next();
                String nameCLass = ont.getLocalName();
                if (nameCLass != null) {
                    System.out.println(nameCLass);
                }
            }
        }
    }

    static void retrieveOntologyClasses() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        Iterator classIter = model.listClasses();

        while (classIter.hasNext()) {
            OntClass ontClass = (OntClass) classIter.next();
            String uriClass = ontClass.getURI();
            if (uriClass != null) {
                System.out.println(uriClass);
            }
        }

    }

    static void assignedObjectPropertyToClass(String proprietate, String clasa) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfObjectPropertyExist(proprietate) == true) {
            if (verifyIfClassExist(clasa) == true) {
                OntClass ontClass = model.getOntClass(uriBase + "#" + clasa);
                ObjectProperty ontProperty = model.getObjectProperty(uriBase + "#" + proprietate);

                SomeValuesFromRestriction svfr =
                        model.createSomeValuesFromRestriction(null, ontProperty, ontClass);
                ontClass.addEquivalentClass(svfr);

                // salvez modificarile facute
                writeToOntology(model);
            }
        }
    }

    static void addSubClassInOntology(String principala, String secundara) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(principala) == true) {
            if (verifyIfClassExist(secundara) == true) {
                OntClass ontPrincipala = model.getOntClass(uriBase + "#" + principala);
                OntClass ontSecundara = model.getOntClass(uriBase + "#" + secundara);

                ontPrincipala.addSubClass(ontSecundara);

                // salvez modificarile facute
                writeToOntology(model);
            }
        }
    }

    static void addClassToOntology(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(newClass) == false) {
            OntClass ontClass = model.createClass(uriBase + "#" + newClass);

            // salvez modificarile facute
            writeToOntology(model);
        }
    }

    static void addObjectPropertyToOntology(String newObjectProperty) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfObjectPropertyExist(newObjectProperty) == false) {
            ObjectProperty ontProperty = model.createObjectProperty(uriBase + "#" + newObjectProperty);

            // salvez modificarile facute
            writeToOntology(model);
        }
    }

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