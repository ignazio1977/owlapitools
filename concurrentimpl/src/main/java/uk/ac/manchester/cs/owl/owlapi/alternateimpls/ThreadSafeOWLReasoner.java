/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, The University of Manchester
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2011, University of Manchester
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.manchester.cs.owl.owlapi.alternateimpls;

import static org.semanticweb.owlapi.util.OWLAPIPreconditions.checkNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.*;
import org.semanticweb.owlapi.util.Version;

/** @author ignazio a threadsafe wrapper for OWLReasoners */
public class ThreadSafeOWLReasoner implements OWLReasoner {

    private final OWLReasoner delegate;
    private boolean log = false;

    /**
     * @param reasoner
     *        the reasoner to wrap
     * @param log
     *        true if logging is required
     */
    public ThreadSafeOWLReasoner(OWLReasoner reasoner, boolean log) {
        this(reasoner);
        this.log = log;
    }

    /**
     * @param reasoner
     *        the reasoner to wrap
     */
    public ThreadSafeOWLReasoner(OWLReasoner reasoner) {
        checkNotNull(reasoner, "The input reasoner cannot be null");
        delegate = reasoner;
    }

    @Override
    public String getReasonerName() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getReasonerName()");
                System.out.flush();
            }
            return delegate.getReasonerName();
        }
    }

    @Override
    public Version getReasonerVersion() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getReasonerVersion()");
                System.out.flush();
            }
            return delegate.getReasonerVersion();
        }
    }

    @Override
    public BufferingMode getBufferingMode() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getBufferingMode()");
                System.out.flush();
            }
            return delegate.getBufferingMode();
        }
    }

    @Override
    public void flush() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.flush()");
                System.out.flush();
            }
            delegate.flush();
        }
    }

    @Override
    public List<OWLOntologyChange> getPendingChanges() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getPendingChanges()");
                System.out.flush();
            }
            return delegate.getPendingChanges();
        }
    }

    @Override
    public Set<OWLAxiom> getPendingAxiomAdditions() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getPendingAxiomAdditions()");
                System.out.flush();
            }
            return delegate.getPendingAxiomAdditions();
        }
    }

    @Override
    public Set<OWLAxiom> getPendingAxiomRemovals() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getPendingAxiomRemovals()");
                System.out.flush();
            }
            return delegate.getPendingAxiomRemovals();
        }
    }

    @Override
    public OWLOntology getRootOntology() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getRootOntology()");
                System.out.flush();
            }
            return delegate.getRootOntology();
        }
    }

    @Override
    public void interrupt() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.interrupt()");
                System.out.flush();
            }
            delegate.interrupt();
        }
    }

    @Override
    public void precomputeInferences(InferenceType... inferenceTypes)
        throws ReasonerInterruptedException, TimeOutException,
        InconsistentOntologyException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.precomputeInferences() "
                    + Arrays.toString(inferenceTypes));
                System.out.flush();
            }
            delegate.precomputeInferences(inferenceTypes);
        }
    }

    @Override
    public boolean isPrecomputed(InferenceType inferenceType) {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.isPrecomputed() " + inferenceType);
                System.out.flush();
            }
            return delegate.isPrecomputed(inferenceType);
        }
    }

    @Override
    public Set<InferenceType> getPrecomputableInferenceTypes() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getPrecomputableInferenceTypes()");
                System.out.flush();
            }
            return delegate.getPrecomputableInferenceTypes();
        }
    }

    @Override
    public boolean isConsistent() throws ReasonerInterruptedException,
        TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.isConsistent()");
                System.out.flush();
            }
            return delegate.isConsistent();
        }
    }

    @Override
    public boolean isSatisfiable(OWLClassExpression classExpression)
        throws ReasonerInterruptedException, TimeOutException,
        ClassExpressionNotInProfileException, FreshEntitiesException,
        InconsistentOntologyException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.isSatisfiable() " + classExpression);
                System.out.flush();
            }
            return delegate.isSatisfiable(classExpression);
        }
    }

    @Override
    public Node<OWLClass> getUnsatisfiableClasses()
        throws ReasonerInterruptedException, TimeOutException,
        InconsistentOntologyException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getUnsatisfiableClasses()");
                System.out.flush();
            }
            return delegate.getUnsatisfiableClasses();
        }
    }

    @Override
    public boolean isEntailed(OWLAxiom axiom)
        throws ReasonerInterruptedException,
        UnsupportedEntailmentTypeException, TimeOutException,
        AxiomNotInProfileException, FreshEntitiesException,
        InconsistentOntologyException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.isEntailed() " + axiom);
                System.out.flush();
            }
            try {
                return delegate.isEntailed(axiom);
            } catch (RuntimeException e) {
                throw new RuntimeException(
                    "Exception checking entailment of axiom: " + axiom, e);
            }
        }
    }

    @Override
    public boolean isEntailed(Set<? extends OWLAxiom> axioms)
        throws ReasonerInterruptedException,
        UnsupportedEntailmentTypeException, TimeOutException,
        AxiomNotInProfileException, FreshEntitiesException,
        InconsistentOntologyException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.isEntailed() " + axioms);
                System.out.flush();
            }
            return delegate.isEntailed(axioms);
        }
    }

    @Override
    public boolean isEntailmentCheckingSupported(AxiomType<?> axiomType) {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.isEntailmentCheckingSupported() "
                    + axiomType);
                System.out.flush();
            }
            return delegate.isEntailmentCheckingSupported(axiomType);
        }
    }

    @Override
    public Node<OWLClass> getTopClassNode() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getTopClassNode()");
                System.out.flush();
            }
            return delegate.getTopClassNode();
        }
    }

    @Override
    public Node<OWLClass> getBottomClassNode() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getBottomClassNode()");
                System.out.flush();
            }
            return delegate.getBottomClassNode();
        }
    }

    @Override
    public NodeSet<OWLClass> getSubClasses(OWLClassExpression ce, boolean direct)
        throws ReasonerInterruptedException, TimeOutException,
        FreshEntitiesException, InconsistentOntologyException,
        ClassExpressionNotInProfileException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getSubClasses() " + ce + " " + direct);
                System.out.flush();
            }
            NodeSet<OWLClass> subClasses = delegate.getSubClasses(ce, direct);
            return subClasses;
        }
    }

    @Override
    public NodeSet<OWLClass> getSuperClasses(OWLClassExpression ce,
        boolean direct) throws InconsistentOntologyException,
            ClassExpressionNotInProfileException, FreshEntitiesException,
            ReasonerInterruptedException, TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getSuperClasses()" + ce + " " + direct);
                System.out.flush();
            }
            NodeSet<OWLClass> superClasses = delegate.getSuperClasses(ce,
                direct);
            return superClasses;
        }
    }

    @Override
    public Node<OWLClass> getEquivalentClasses(OWLClassExpression ce)
        throws InconsistentOntologyException,
        ClassExpressionNotInProfileException, FreshEntitiesException,
        ReasonerInterruptedException, TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getEquivalentClasses() " + ce);
                System.out.flush();
            }
            Node<OWLClass> equivalentClasses = delegate
                .getEquivalentClasses(ce);
            return equivalentClasses;
        }
    }

    @Override
    public NodeSet<OWLClass> getDisjointClasses(OWLClassExpression ce)
        throws ReasonerInterruptedException, TimeOutException,
        FreshEntitiesException, InconsistentOntologyException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getDisjointClasses() " + ce);
                System.out.flush();
            }
            NodeSet<OWLClass> disjointClasses = delegate.getDisjointClasses(ce);
            return disjointClasses;
        }
    }

    @Override
    public Node<OWLObjectPropertyExpression> getTopObjectPropertyNode() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getTopObjectPropertyNode()");
                System.out.flush();
            }
            return delegate.getTopObjectPropertyNode();
        }
    }

    @Override
    public Node<OWLObjectPropertyExpression> getBottomObjectPropertyNode() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getBottomObjectPropertyNode()");
                System.out.flush();
            }
            return delegate.getBottomObjectPropertyNode();
        }
    }

    @Override
    public NodeSet<OWLObjectPropertyExpression> getSubObjectProperties(
        OWLObjectPropertyExpression pe, boolean direct)
            throws InconsistentOntologyException, FreshEntitiesException,
            ReasonerInterruptedException, TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getSubObjectProperties() " + pe + " "
                    + direct);
                System.out.flush();
            }
            NodeSet<OWLObjectPropertyExpression> subObjectProperties = delegate
                .getSubObjectProperties(pe, direct);
            return subObjectProperties;
        }
    }

    @Override
    public NodeSet<OWLObjectPropertyExpression> getSuperObjectProperties(
        OWLObjectPropertyExpression pe, boolean direct)
            throws InconsistentOntologyException, FreshEntitiesException,
            ReasonerInterruptedException, TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getSuperObjectProperties() " + pe + " "
                    + direct);
                System.out.flush();
            }
            NodeSet<OWLObjectPropertyExpression> superObjectProperties = delegate
                .getSuperObjectProperties(pe, direct);
            return superObjectProperties;
        }
    }

    @Override
    public Node<OWLObjectPropertyExpression> getEquivalentObjectProperties(
        OWLObjectPropertyExpression pe)
            throws InconsistentOntologyException, FreshEntitiesException,
            ReasonerInterruptedException, TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getEquivalentObjectProperties() " + pe);
                System.out.flush();
            }
            Node<OWLObjectPropertyExpression> equivalentObjectProperties = delegate
                .getEquivalentObjectProperties(pe);
            return equivalentObjectProperties;
        }
    }

    @Override
    public NodeSet<OWLObjectPropertyExpression> getDisjointObjectProperties(
        OWLObjectPropertyExpression pe)
            throws InconsistentOntologyException, FreshEntitiesException,
            ReasonerInterruptedException, TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getDisjointObjectProperties() " + pe);
                System.out.flush();
            }
            return delegate.getDisjointObjectProperties(pe);
        }
    }

    @Override
    public Node<OWLObjectPropertyExpression> getInverseObjectProperties(
        OWLObjectPropertyExpression pe)
            throws InconsistentOntologyException, FreshEntitiesException,
            ReasonerInterruptedException, TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getInverseObjectProperties() " + pe);
                System.out.flush();
            }
            return delegate.getInverseObjectProperties(pe);
        }
    }

    @Override
    public NodeSet<OWLClass> getObjectPropertyDomains(
        OWLObjectPropertyExpression pe, boolean direct)
            throws InconsistentOntologyException, FreshEntitiesException,
            ReasonerInterruptedException, TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getObjectPropertyDomains() " + pe + " "
                    + direct);
                System.out.flush();
            }
            return delegate.getObjectPropertyDomains(pe, direct);
        }
    }

    @Override
    public NodeSet<OWLClass> getObjectPropertyRanges(
        OWLObjectPropertyExpression pe, boolean direct)
            throws InconsistentOntologyException, FreshEntitiesException,
            ReasonerInterruptedException, TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getObjectPropertyRanges() " + pe + " "
                    + direct);
                System.out.flush();
            }
            return delegate.getObjectPropertyRanges(pe, direct);
        }
    }

    @Override
    public Node<OWLDataProperty> getTopDataPropertyNode() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getTopDataPropertyNode()");
                System.out.flush();
            }
            return delegate.getTopDataPropertyNode();
        }
    }

    @Override
    public Node<OWLDataProperty> getBottomDataPropertyNode() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getBottomDataPropertyNode()");
                System.out.flush();
            }
            return delegate.getBottomDataPropertyNode();
        }
    }

    @Override
    public NodeSet<OWLDataProperty> getSubDataProperties(OWLDataProperty pe,
        boolean direct) throws InconsistentOntologyException,
            FreshEntitiesException, ReasonerInterruptedException,
            TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getSubDataProperties() " + pe + " "
                    + direct);
                System.out.flush();
            }
            return delegate.getSubDataProperties(pe, direct);
        }
    }

    @Override
    public NodeSet<OWLDataProperty> getSuperDataProperties(OWLDataProperty pe,
        boolean direct) throws InconsistentOntologyException,
            FreshEntitiesException, ReasonerInterruptedException,
            TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getSuperDataProperties() " + pe + " "
                    + direct);
                System.out.flush();
            }
            return delegate.getSuperDataProperties(pe, direct);
        }
    }

    @Override
    public Node<OWLDataProperty> getEquivalentDataProperties(OWLDataProperty pe)
        throws InconsistentOntologyException,
        FreshEntitiesException, ReasonerInterruptedException,
        TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getEquivalentDataProperties() " + pe);
                System.out.flush();
            }
            return delegate.getEquivalentDataProperties(pe);
        }
    }

    @Override
    public NodeSet<OWLDataProperty> getDisjointDataProperties(
        OWLDataPropertyExpression pe) throws InconsistentOntologyException,
            FreshEntitiesException, ReasonerInterruptedException,
            TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getDisjointDataProperties() " + pe);
                System.out.flush();
            }
            return delegate.getDisjointDataProperties(pe);
        }
    }

    @Override
    public NodeSet<OWLClass> getDataPropertyDomains(OWLDataProperty pe,
        boolean direct) throws InconsistentOntologyException,
            FreshEntitiesException, ReasonerInterruptedException,
            TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getDataPropertyDomains() " + pe + " "
                    + direct);
                System.out.flush();
            }
            return delegate.getDataPropertyDomains(pe, direct);
        }
    }

    @Override
    public NodeSet<OWLClass> getTypes(OWLNamedIndividual ind, boolean direct)
        throws InconsistentOntologyException, FreshEntitiesException,
        ReasonerInterruptedException, TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getTypes() " + ind + " " + direct);
                System.out.flush();
            }
            return delegate.getTypes(ind, direct);
        }
    }

    @Override
    public NodeSet<OWLNamedIndividual> getInstances(OWLClassExpression ce,
        boolean direct) throws InconsistentOntologyException,
            ClassExpressionNotInProfileException, FreshEntitiesException,
            ReasonerInterruptedException, TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getInstances() " + ce + " " + direct);
                System.out.flush();
            }
            return delegate.getInstances(ce, direct);
        }
    }

    @Override
    public NodeSet<OWLNamedIndividual> getObjectPropertyValues(
        OWLNamedIndividual ind, OWLObjectPropertyExpression pe)
            throws InconsistentOntologyException, FreshEntitiesException,
            ReasonerInterruptedException, TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getObjectPropertyValues() " + ind + " "
                    + pe);
                System.out.flush();
            }
            return delegate.getObjectPropertyValues(ind, pe);
        }
    }

    @Override
    public Set<OWLLiteral> getDataPropertyValues(OWLNamedIndividual ind,
        OWLDataProperty pe) throws InconsistentOntologyException,
            FreshEntitiesException, ReasonerInterruptedException,
            TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out
                    .println(Thread.currentThread().getName()
                        + " reasoner.getDataPropertyValues() " + ind
                        + " " + pe);
                System.out.flush();
            }
            return delegate.getDataPropertyValues(ind, pe);
        }
    }

    @Override
    public Node<OWLNamedIndividual> getSameIndividuals(OWLNamedIndividual ind)
        throws InconsistentOntologyException, FreshEntitiesException,
        ReasonerInterruptedException, TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getSameIndividuals() " + ind);
                System.out.flush();
            }
            return delegate.getSameIndividuals(ind);
        }
    }

    @Override
    public NodeSet<OWLNamedIndividual> getDifferentIndividuals(
        OWLNamedIndividual ind) throws InconsistentOntologyException,
            FreshEntitiesException, ReasonerInterruptedException,
            TimeOutException {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getDifferentIndividuals() " + ind);
                System.out.flush();
            }
            return delegate.getDifferentIndividuals(ind);
        }
    }

    @Override
    public long getTimeOut() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getTimeOut()");
                System.out.flush();
            }
            return delegate.getTimeOut();
        }
    }

    @Override
    public FreshEntityPolicy getFreshEntityPolicy() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getFreshEntityPolicy()");
                System.out.flush();
            }
            return delegate.getFreshEntityPolicy();
        }
    }

    @Override
    public IndividualNodeSetPolicy getIndividualNodeSetPolicy() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.getIndividualNodeSetPolicy()");
                System.out.flush();
            }
            return delegate.getIndividualNodeSetPolicy();
        }
    }

    @Override
    public void dispose() {
        synchronized (delegate) {
            if (log) {
                System.out.println(Thread.currentThread().getName()
                    + " reasoner.dispose()");
                System.out.flush();
            }
            delegate.dispose();
        }
    }
}
