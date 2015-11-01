package org.coode.suggestor.impl;

import javax.annotation.Nonnull;

import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLPropertyExpression;
import org.semanticweb.owlapi.model.OWLPropertyRange;
import org.semanticweb.owlapi.reasoner.NodeSet;

// DELEGATES
// F is an OWLEntity that extends R and will be the type returned by getMatches().
// eg for R = OWLClassExpression, F = OWLClass, P = OWLObjectPropertyExpression
// It would be nice if we could enforce this with multiple generics, but R & OWLEntity is disallowed currently
interface Matcher<R extends OWLPropertyRange, F extends R, P extends OWLPropertyExpression> {

    boolean isMatch(@Nonnull OWLClassExpression c, @Nonnull P p, @Nonnull R f);

    boolean isMatch(@Nonnull OWLClassExpression c, @Nonnull P p, @Nonnull R f,
            boolean direct);

    /**
     * Perform a recursive search, adding nodes that match. If direct is true
     * only add nodes if they have no subs that match
     * 
     * @param c
     *        class
     * @param p
     *        property
     * @param start
     *        start
     * @param direct
     *        direct
     * @return set of leave nodes
     */
    @Nonnull
    NodeSet<F> getLeaves(@Nonnull OWLClassExpression c, @Nonnull P p,
            @Nonnull R start, boolean direct);

    /**
     * Perform a search on the direct subs of start, adding nodes that match. If
     * direct is false then recurse into descendants of start
     * 
     * @param c
     *        class
     * @param p
     *        property
     * @param start
     *        start
     * @param direct
     *        direct
     * @return set of root nodes
     */
    @Nonnull
    NodeSet<F> getRoots(@Nonnull OWLClassExpression c, @Nonnull P p,
            @Nonnull R start, boolean direct);
}
