/**
 * Date: Dec 17, 2007
 *
 * code made available under Mozilla Public License (http://www.mozilla.org/MPL/MPL-1.1.html)
 *
 * copyright 2007, The University of Manchester
 *
 * @author Nick Drummond, The University Of Manchester, Bio Health Informatics Group
 */
package org.coode.suggestor.util;

import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/** Get all fillers in restrictions using the given data property. */
public class DataFillerAccumulator extends FillerAccumulator<OWLObject> {

    /**
     * @param r
     *        reasoner to use
     */
    public DataFillerAccumulator(OWLReasoner r) {
        super(r);
    }

    @Override
    protected RestrictionVisitor getVisitor(OWLPropertyExpression prop,
        Class<? extends OWLRestriction> type) {
        return new RestrictionVisitor(r, prop, type) {

            @Override
            public void visit(OWLDataSomeValuesFrom desc) {
                super.visit(desc);
                if (props.contains(desc.getProperty())) {
                    add(desc.getFiller());
                }
            }

            @Override
            public void visit(OWLDataMinCardinality desc) {
                super.visit(desc);
                if (desc.getCardinality() > 0
                        && props.contains(desc.getProperty())) {
                    add(desc.getFiller());
                }
            }

            @Override
            public void visit(OWLDataExactCardinality desc) {
                super.visit(desc);
                if (desc.getCardinality() > 0
                        && props.contains(desc.getProperty())) {
                    add(desc.getFiller());
                }
            }

            @Override
            public void visit(OWLDataHasValue desc) {
                super.visit(desc);
                if (props.contains(desc.getProperty())) {
                    add(desc.getFiller());
                }
            }
        };
    }
}
