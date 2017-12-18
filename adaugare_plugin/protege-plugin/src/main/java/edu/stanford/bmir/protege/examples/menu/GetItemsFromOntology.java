package edu.stanford.bmir.protege.examples.menu;
import org.protege.editor.owl.ui.action.ProtegeOWLAction;
import org.semanticweb.owlapi.model.OWLClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Set;

public class GetItemsFromOntology extends ProtegeOWLAction {
    public static ArrayList<String> ontologyAttributes=new ArrayList<String>();

	public void initialise() throws Exception {
	}

	public void dispose() throws Exception {
	}

	public void initList()
    {
        Set<OWLClass> records = getOWLModelManager().getActiveOntology().getClassesInSignature();
        for(OWLClass item : records) {
            String reformatItem = item.toString();
            if(reformatItem.equals("owl:Thing"))
                continue;
            if(reformatItem.contains("#")) {
                String[] splitterVect = reformatItem.split("#");
                if (splitterVect[1].contains(">")) {
                    ontologyAttributes.add(splitterVect[1].replace(">", ""));
                } else {
                    ontologyAttributes.add(splitterVect[1]);
                }
            }
            else
            {
                ontologyAttributes.add(reformatItem);
            }
        }
    }
    public static ArrayList<String>getOntologyAttributes()
    {
        return ontologyAttributes;
    }

	public void actionPerformed(ActionEvent event) {
        initList();
        new Principal().setVisible(true);
	}
}
