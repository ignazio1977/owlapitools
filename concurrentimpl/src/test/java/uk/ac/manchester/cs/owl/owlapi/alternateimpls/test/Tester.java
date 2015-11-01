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
package uk.ac.manchester.cs.owl.owlapi.alternateimpls.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;

@SuppressWarnings("javadoc")
public class Tester {
    public static final int _10 = 10;
    public static final int _10000 = 10000;
    protected List<IRI> iriClasses = new ArrayList<>();
    protected List<IRI> iriDataproperties = new ArrayList<>();
    protected List<IRI> iriObjectProperties = new ArrayList<>();
    protected List<IRI> iriIndividuals = new ArrayList<>();
    protected List<IRI> iriDatatypes = new ArrayList<>();
    protected List<IRI> iriAnnotations = new ArrayList<>();

    public Tester() {
        init();
    }

    private void init() {
        String uriClasses = "urn:test:classes#A";
        add(iriClasses, uriClasses);
        String objects = "urn:test:objectproperties#B";
        add(iriObjectProperties, objects);
        String datas = "urn:test:dataproperties#C";
        add(iriDataproperties, datas);
        String inds = "urn:test:individuals#D";
        add(iriIndividuals, inds);
        String datatypes = "urn:test:datatypes#E";
        add(iriDatatypes, datatypes);
        String annotations = "urn:test:annotations#F";
        add(iriAnnotations, annotations);
    }

    public void run(OWLDataFactory toTest) {
        for (int i = 0; i < _10; i++) {
            for (IRI iri : iriClasses) {
                assert iri != null;
                singleRunClasses(toTest, iri);
            }
            for (IRI iri : iriObjectProperties) {
                assert iri != null;
                singleRunObjectProp(toTest, iri);
            }
            for (IRI iri : iriDataproperties) {
                assert iri != null;
                singleRunDataprop(toTest, iri);
            }
            for (IRI iri : iriIndividuals) {
                assert iri != null;
                singleRunIndividuals(toTest, iri);
            }
            for (IRI iri : iriDatatypes) {
                assert iri != null;
                singleRunDatatype(toTest, iri);
            }
            for (IRI iri : iriAnnotations) {
                assert iri != null;
                singleRunAnnotations(toTest, iri);
            }
        }
    }

    private static void add(List<IRI> l, String s) {
        for (int i = 0; i < _10000; i++) {
            l.add(IRI.create(s + i));
        }
    }

    private static void
            singleRunClasses(OWLDataFactory toTest, @Nonnull IRI iri) {
        toTest.getOWLClass(iri);
    }

    private static void singleRunObjectProp(OWLDataFactory toTest,
            @Nonnull IRI iri) {
        toTest.getOWLObjectProperty(iri);
    }

    private static void singleRunDataprop(OWLDataFactory toTest,
            @Nonnull IRI iri) {
        toTest.getOWLDataProperty(iri);
    }

    private static void singleRunDatatype(OWLDataFactory toTest,
            @Nonnull IRI iri) {
        toTest.getOWLDatatype(iri);
    }

    private static void singleRunIndividuals(OWLDataFactory toTest,
            @Nonnull IRI iri) {
        toTest.getOWLNamedIndividual(iri);
    }

    private static void singleRunAnnotations(OWLDataFactory toTest,
            @Nonnull IRI iri) {
        toTest.getOWLAnnotationProperty(iri);
    }
}
