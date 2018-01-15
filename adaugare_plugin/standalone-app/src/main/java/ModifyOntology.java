import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

import java.util.*;
import java.io.*;


public class ModifyOntology {

    public static void addClassToOntology(String newClass) {
        OntModel model = setupConfiguration();
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (!verifyIfClassExist(newClass)) {
            model.createClass(uriBase + "#" + newClass);

            // salvez modificarile facute
            writeToOntology(model);
        }
    }

    public static boolean verifyIfClassExist(String newClass) {
        ArrayList<String> listClass = getClassList();

        for(int i = 0; i < listClass.size(); i++) {
            String element = listClass.get(i);
            if (newClass.equals(element)) {
                return true;
            }
        }

        return false;
    }

    public static ArrayList<String> getClassList() {
        OntModel model = setupConfiguration();
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

    public static void addIndividualToOntology(String newIndividual, String newClass) {
        OntModel model = setupConfiguration();
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (!verifyIfIndividualExist(newIndividual)) {
            if (verifyIfClassExist(newClass)) {
                OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);
                ontClass.createIndividual(uriBase + "#" + newIndividual);

                // salvez modificarile facute
                writeToOntology(model);
            }
        }
    }

    public static void assignedDataPropertyToClass(String proprietate, String clasa) {
        OntModel model = setupConfiguration();
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (!verifyIfDataPropertyExist(proprietate)) {
            if (verifyIfClassExist(clasa)) {
                OntClass ontClass = model.getOntClass(uriBase + "#" + clasa);
                DatatypeProperty ontProperty = model.createDatatypeProperty(uriBase + "#" + proprietate);

                SomeValuesFromRestriction svfr =
                        model.createSomeValuesFromRestriction(null, ontProperty, ontClass);
                ontClass.addEquivalentClass(svfr);

                // salvez modificarile facute
                writeToOntology(model);
            }
        }
    }

    public static void assignedObjectPropertyToClass(String proprietate, String clasa) {
        OntModel model = setupConfiguration();
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (!verifyIfObjectPropertyExist(proprietate)) {
            if (verifyIfClassExist(clasa)) {
                OntClass ontClass = model.getOntClass(uriBase + "#" + clasa);
                ObjectProperty ontProperty = model.createObjectProperty(uriBase + "#" + proprietate);

                SomeValuesFromRestriction svfr =
                        model.createSomeValuesFromRestriction(null, ontProperty, ontClass);
                ontClass.addEquivalentClass(svfr);

                // salvez modificarile facute
                writeToOntology(model);
            }
        }
    }

    public static void addSubClassInOntology(String principala, String secundara) {
        OntModel model = setupConfiguration();
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(principala)) {
            if (!verifyIfClassExist(secundara)) {
                OntClass ontPrincipala = model.getOntClass(uriBase + "#" + principala);
                OntClass ontSecundara = model.createClass(uriBase + "#" + secundara);

                ontPrincipala.addSubClass(ontSecundara);

                // salvez modificarile facute
                writeToOntology(model);
            }
        }
    }

    public static ArrayList<String> getObjectPropertyList() {
        OntModel model = setupConfiguration();
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

    public static ArrayList<String> getDataPropertyList() {
        OntModel model = setupConfiguration();
        Iterator propIter = model.listDatatypeProperties();

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

    public static ArrayList<String> getIndividualList() {
        OntModel model = setupConfiguration();
        Iterator individuals = model.listIndividuals();

        ArrayList<String> list = new ArrayList<String>();
        while (individuals.hasNext()) {
            Individual individual = (Individual) individuals.next();
            String nameIndividual = individual.getLocalName();
            list.add(nameIndividual);
        }

        return list;
    }

    public static ArrayList<String> getInstanceOfClass(String newClass) {
        OntModel model = setupConfiguration();
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(newClass)) {
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

    public static ArrayList<String> getSubClassesOfClass(String newClass) {
        OntModel model = setupConfiguration();
        String uriBase = "http://www.semanticweb.org/beniamin/ontologies/2017/11/untitled-ontology-12";

        if (verifyIfClassExist(newClass)) {
            OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);
            Iterator classIter = ontClass.listSubClasses();

            ArrayList<String> list = new ArrayList<String>();
            while (classIter.hasNext()) {
                OntClass ont = (OntClass) classIter.next();
                String nameCLass = ont.getLocalName();
                list.add(nameCLass);
            }

            return list;
        }

        ArrayList<String> lista = new ArrayList<String>();
        return lista;
    }

    public static boolean verifyIfObjectPropertyExist(String newObjectProperty) {
        ArrayList<String> listObjectProperty = getObjectPropertyList();

        for(int i = 0; i < listObjectProperty.size(); i++) {
            String element = listObjectProperty.get(i);
            if (newObjectProperty.equals(element)) {
                return true;
            }
        }

        return false;
    }

    public static boolean verifyIfDataPropertyExist(String newDataProperty) {
        ArrayList<String> listDataProperty = getDataPropertyList();

        for(int i = 0; i < listDataProperty.size(); i++) {
            String element = listDataProperty.get(i);
            if (newDataProperty.equals(element)) {
                return true;
            }
        }

        return false;
    }

    public static boolean verifyIfIndividualExist(String newIndividual) {
        ArrayList<String> listIndividual = getIndividualList();

        for(int i = 0; i < listIndividual.size(); i++) {
            String element = listIndividual.get(i);
            if (newIndividual.equals(element)) {
                return true;
            }
        }

        return false;
    }


    public static OntModel setupConfiguration() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        return model;
    }

    // Schimba Calea Catre Ontologie :D
    public  static void writeToOntology(OntModel model) {
        File file = new File("C:\\Users\\Beniamin\\Documents\\IntelliJ Projects\\IntegrareProiectAI\\ontology.owl");

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