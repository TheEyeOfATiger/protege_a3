package edu.stanford.bmir.protege.examples.menu;
import javafx.event.ActionEvent;
import org.protege.editor.owl.ProtegeOWL;
import org.protege.editor.owl.ui.action.ProtegeOWLAction;
import org.semanticweb.owlapi.model.*;
import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;
import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;
import uk.ac.manchester.cs.owl.owlapi.OWLOntologyImpl;
import uk.ac.manchester.cs.owl.owlapi.SWRLIndividualArgumentImpl;

import javax.annotation.Nonnull;
import java.util.*;
import java.io.*;

import static com.hp.hpl.jena.vocabulary.DB.uri;


public class GetItemsFromOntology extends ProtegeOWLAction {
    public static ArrayList<String> getOntologyClass() {
        return ontologyClass;
    }
    public static ArrayList<String> ontologyAttributes=new ArrayList<String>();

    public static ArrayList<String> getOntolgyDataPropertyClass() {
        return ontolgyDataPropertyClass;
    }

    public static ArrayList<String> getOntologyObjectPropertyClass() {
        return ontologyObjectPropertyClass;
    }

    public static ArrayList<String> getOntologyInstanceOfClass() {
        return ontologyInstanceOfClass;
    }

    public static ArrayList<String> ontologyClass=new ArrayList<String>();
    public static ArrayList<String> ontolgyDataPropertyClass=new ArrayList<String>();
    public static ArrayList<String> ontologyObjectPropertyClass=new ArrayList<String>();
    public static ArrayList<String> ontologyInstanceOfClass=new ArrayList<String>();

	public void initialise() throws Exception {
	}

	public void dispose() throws Exception {
	}

    static void addClassToOntology(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/onu/ontologies/2018/0/untitled-ontology-82";

        if (!verifyIfClassExist(newClass)) {
            OntClass ontClass = model.createClass(uriBase + "#" + newClass);

            // salvez modificarile facute
            writeToOntology(model);
        }
    }

    static void addIndividualToOntology(String newIndividual, String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/onu/ontologies/2018/0/untitled-ontology-82";

        if (!verifyIfIndividualExist(newIndividual)) {
            if (verifyIfClassExist(newClass)) {
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

    static void assignedDataPropertyToClass(String proprietate, String clasa) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/onu/ontologies/2018/0/untitled-ontology-82";

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

    static void assignedObjectPropertyToClass(String proprietate, String clasa) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/onu/ontologies/2018/0/untitled-ontology-82";

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

    static void addSubClassInOntology(String principala, String secundara) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/onu/ontologies/2018/0/untitled-ontology-82";

        if (verifyIfClassExist(principala)) {
            if (verifyIfClassExist(secundara)) {
                OntClass ontPrincipala = model.getOntClass(uriBase + "#" + principala);
                OntClass ontSecundara = model.getOntClass(uriBase + "#" + secundara);

                ontPrincipala.addSubClass(ontSecundara);

                // salvez modificarile facute
                writeToOntology(model);
            }
        }
    }


    private static ArrayList<String> getObjectPropertyList() {
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

    private static ArrayList<String> getDataPropertyList() {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

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

    private static ArrayList<String> getIndividualList() {
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
        String uriBase = "http://www.semanticweb.org/onu/ontologies/2018/0/untitled-ontology-82";

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

    static void getSubClassesOfClass(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/onu/ontologies/2018/0/untitled-ontology-82";

        if (verifyIfClassExist(newClass)) {
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

    static boolean verifyIfClassIsRoot(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);
        String uriBase = "http://www.semanticweb.org/onu/ontologies/2018/0/untitled-ontology-82";

        if (verifyIfClassExist(newClass)) {
            OntClass ontClass = model.getOntClass(uriBase + "#" + newClass);
            if (ontClass.isHierarchyRoot());
            return true;
        }

        return false;
    }

    private static boolean verifyIfClassExist(String newClass) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        String filename = "ontology.owl";
        InputStream in = FileManager.get().open(filename);
        model.read(in, null);

        ArrayList<String> listClass = new ArrayList<String>();
        listClass = getOntologyClass();

        for(int i = 0; i < listClass.size(); i++) {
            String element = listClass.get(i);
            if (newClass.equals(element)) {
                return true;
            }
        }

        return false;
    }

    private static boolean verifyIfObjectPropertyExist(String newObjectProperty) {
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

    private static boolean verifyIfDataPropertyExist(String newDataProperty) {
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

    private static boolean verifyIfIndividualExist(String newIndividual) {
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

   private static void writeToOntology(OntModel model) {
        File file = new File("C:\\Users\\Onu\\Downloads\\ontology.owl");
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

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        this.ontologyClass=getOntologyClass();
        this.ontolgyDataPropertyClass=getDataPropertyList();
         //this.ontologyInstanceOfClass=getInstanceOfClass();
        this.ontologyObjectPropertyClass=getObjectPropertyList();
        Principal proiect = new Principal();
        proiect.start();

    }


}
