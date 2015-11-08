/**
 * Date: Dec 17, 2007
 *
 * code made available under Mozilla Public License (http://www.mozilla.org/MPL/MPL-1.1.html)
 *
 * copyright 2007, The University of Manchester
 *
 * @author Nick Drummond, The University Of Manchester, Bio Health Informatics Group
 */
package org.coode.suggestor.test;

import static org.junit.Assert.*;

import java.util.*;

import org.coode.suggestor.util.ReasonerHelper;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.profiles.Profiles;
import org.semanticweb.owlapi.reasoner.BufferingMode;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

@SuppressWarnings("javadoc")
public class RedundancyTests extends AbstractSuggestorTest {

    public void testFilterClasses() throws Exception {
        OWLOntology ont = createOntology();
        OWLReasoner r = Profiles.instantiateFactory(Profiles.JFact).createNonBufferingReasoner(ont);
        // SuggestorFactory fac = new SuggestorFactory(r);
        // PropertySuggestor ps = fac.getPropertySuggestor();
        // FillerSuggestor fs = fac.getFillerSuggestor();
        OWLClass a1 = createClass("a1");
        OWLClass a2 = createClass("a2");
        OWLClass a3 = createClass("a3");
        OWLClass b1 = createClass("b1");
        OWLClass b2 = createClass("b2");
        /*
         * a1 a2 a3 b1 b2
         */
        mngr.applyChange(new AddAxiom(ont, df.getOWLSubClassOfAxiom(a2, a1)));
        mngr.applyChange(new AddAxiom(ont, df.getOWLSubClassOfAxiom(a3, a2)));
        mngr.applyChange(new AddAxiom(ont, df.getOWLSubClassOfAxiom(b2, b1)));
        ReasonerHelper helper = new ReasonerHelper(r);
        Random ran = new Random(2);
        List<OWLClassExpression> data = Arrays.<OWLClassExpression> asList(a2,
            b2, a3, b1, a1);
        for (int i = 0; i < 25; i++) {
            System.out.println(data);
            Set<OWLClassExpression> test = new LinkedHashSet<>(data);
            Set<OWLClassExpression> result = helper
                .filterClassExpressions(test);
            assertEquals(
                new HashSet<OWLClassExpression>(Arrays.asList(a3, b2)),
                result);
            Collections.shuffle(data, ran);
        }
    }

    public void testFilters() throws Exception {
        OWLOntology ont = createOntology();
        OWLReasoner r = Profiles.instantiateFactory(Profiles.JFact).createNonBufferingReasoner(ont);
        // SuggestorFactory fac = new SuggestorFactory(r);
        // PropertySuggestor ps = fac.getPropertySuggestor();
        // FillerSuggestor fs = fac.getFillerSuggestor();
        OWLObjectProperty q = createObjectProperty("q");
        OWLObjectProperty p = createObjectProperty("p");
        OWLClass a = createClass("a");
        OWLClass b = createClass("b");
        OWLObjectSomeValuesFrom pSomeA = df.getOWLObjectSomeValuesFrom(p,
            a);
        OWLObjectSomeValuesFrom qSomeA = df.getOWLObjectSomeValuesFrom(q,
            a);
        OWLObjectSomeValuesFrom pSomeB = df.getOWLObjectSomeValuesFrom(p,
            b);
        OWLObjectSomeValuesFrom qSomeB = df.getOWLObjectSomeValuesFrom(q,
            b);
        mngr.applyChange(new AddAxiom(ont, df.getOWLSubObjectPropertyOfAxiom(p,
            q)));
        mngr.applyChange(new AddAxiom(ont, df.getOWLSubClassOfAxiom(a, b)));
        if (r.getBufferingMode().equals(BufferingMode.BUFFERING)) {
            r.flush();
        }
        Set<OWLClassExpression> expressions = new HashSet<>();
        expressions.add(pSomeA);
        expressions.add(qSomeA); // redundant as p some a is more specific
        expressions.add(pSomeB); // redundant as p some a is more specific
        expressions.add(qSomeB); // redundant as p some b and p some a are more
                                 // specific
        ReasonerHelper helper = new ReasonerHelper(r);
        Set<OWLClassExpression> nonRedundantExpressions = helper
            .filterClassExpressions(expressions);
        assertEquals(1, nonRedundantExpressions.size());
        assertTrue(nonRedundantExpressions.contains(pSomeA));
    }
}
