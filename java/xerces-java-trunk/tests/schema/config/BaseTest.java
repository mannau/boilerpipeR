/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package schema.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import junit.framework.TestCase;

import org.apache.xerces.dom.PSVIElementNSImpl;
import org.apache.xerces.impl.Constants;
import org.apache.xerces.impl.xs.SchemaGrammar;
import org.apache.xerces.xs.ElementPSVI;
import org.apache.xerces.xs.ItemPSVI;
import org.apache.xerces.xs.XSElementDeclaration;
import org.apache.xerces.xs.XSTypeDefinition;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * @author Peter McCracken, IBM
 * @version $Id: BaseTest.java 447700 2006-09-19 03:13:41Z mrglavas $
 */
public abstract class BaseTest extends TestCase {
    protected final static String ROOT_TYPE = Constants.XERCES_PROPERTY_PREFIX
        + Constants.ROOT_TYPE_DEFINITION_PROPERTY;
    
    protected final static String IGNORE_XSI_TYPE = Constants.XERCES_FEATURE_PREFIX
        + Constants.IGNORE_XSI_TYPE_FEATURE;
    
    protected final static String ID_IDREF_CHECKING = Constants.XERCES_FEATURE_PREFIX
        + Constants.ID_IDREF_CHECKING_FEATURE;
    
    protected final static String IDC_CHECKING = Constants.XERCES_FEATURE_PREFIX
        + Constants.IDC_CHECKING_FEATURE;
    
    protected final static String UNPARSED_ENTITY_CHECKING = Constants.XERCES_FEATURE_PREFIX
        + Constants.UNPARSED_ENTITY_CHECKING_FEATURE;
    
    protected final static String USE_GRAMMAR_POOL_ONLY = Constants.XERCES_FEATURE_PREFIX
        + Constants.USE_GRAMMAR_POOL_ONLY_FEATURE;
    
    protected final static String DYNAMIC_VALIDATION = Constants.XERCES_FEATURE_PREFIX
        + Constants.DYNAMIC_VALIDATION_FEATURE;
    
    protected final static String DOCUMENT_CLASS_NAME = Constants.XERCES_PROPERTY_PREFIX
        + Constants.DOCUMENT_CLASS_NAME_PROPERTY;
    
    protected Validator fValidator;
    protected SpecialCaseErrorHandler fErrorHandler;
    protected Document fDocument;
    protected ElementPSVI fRootNode;
    protected URL fDocumentURL;
    protected URL fSchemaURL;
    
    protected abstract String getSchemaFile();
    
    protected abstract String getXMLDocument();
    
    public BaseTest(String name) {
        super(name);
        fErrorHandler = new SpecialCaseErrorHandler(getRelevantErrorIDs());
    }
    
    protected void setUp() throws Exception {
        super.setUp();
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory
        .newInstance();
        docFactory.setAttribute(DOCUMENT_CLASS_NAME,
        "org.apache.xerces.dom.PSVIDocumentImpl");
        docFactory.setNamespaceAware(true);
        DocumentBuilder builder = docFactory.newDocumentBuilder();
        // build the location URL of the document
        String packageDir = this.getClass().getPackage().getName().replace('.',
                File.separatorChar);
        String documentPath = packageDir + "/" + getXMLDocument();
        fDocumentURL = ClassLoader.getSystemResource(documentPath);
        if (fDocumentURL == null) {
            throw new FileNotFoundException("Couldn't find xml file for test: " + documentPath);
        }
        fDocument = builder.parse(fDocumentURL.toExternalForm());
        fRootNode = (ElementPSVI) fDocument.getDocumentElement();
        SchemaFactory sf = SchemaFactory
        .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        sf.setFeature(USE_GRAMMAR_POOL_ONLY, getUseGrammarPoolOnly());
        String schemaPath = packageDir + "/" + getSchemaFile();
        fSchemaURL = ClassLoader.getSystemResource(schemaPath);
        if (fSchemaURL == null) {
            throw new FileNotFoundException("Couldn't find schema file for test: " + schemaPath);
        }
        Schema schema = sf.newSchema(fSchemaURL);
        fValidator = schema.newValidator();
        fValidator.setErrorHandler(fErrorHandler);
        fValidator.setFeature(DYNAMIC_VALIDATION, false);
    }
    
    protected void tearDown() throws Exception {
        super.tearDown();
        fValidator = null;
        fDocument = null;
        fRootNode = null;
        fErrorHandler.reset();
    }
    
    protected void validateDocument() throws Exception {
        Source source = new DOMSource(fDocument);
        source.setSystemId(fDocumentURL.toExternalForm());
        Result result = new DOMResult(fDocument);
        fValidator.validate(source, result);
    }
    
    protected void validateFragment() throws Exception {
        Source source = new DOMSource((Node) fRootNode);
        source.setSystemId(fDocumentURL.toExternalForm());
        Result result = new DOMResult((Node) fRootNode);
        fValidator.validate(source, result);
    }
    
    protected PSVIElementNSImpl getChild(int n) {
        int numFound = 0;
        Node child = ((Node) fRootNode).getFirstChild();
        while (child != null) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                numFound++;
                if (numFound == n) {
                    return (PSVIElementNSImpl) child;
                }
            }
            child = child.getNextSibling();
        }
        return null;
    }
    
    protected String[] getRelevantErrorIDs() {
        return new String[] {};
    }
    
    protected boolean getUseGrammarPoolOnly() {
        return false;
    }
    
    // specialized asserts
    
    protected void assertValidity(short expectedValidity, short actualValidity) {
        String expectedString = expectedValidity == ItemPSVI.VALIDITY_VALID ? "valid"
                : (expectedValidity == ItemPSVI.VALIDITY_INVALID ? "invalid"
                        : "notKnown");
        String actualString = actualValidity == ItemPSVI.VALIDITY_VALID ? "valid"
                : (actualValidity == ItemPSVI.VALIDITY_INVALID ? "invalid"
                        : "notKnown");
        String message = "{validity} was <" + actualString
        + "> but it should have been <" + expectedString + ">";
        assertEquals(message, expectedValidity, actualValidity);
    }
    
    protected void assertValidationAttempted(short expectedAttempted,
            short actualAttempted) {
        String expectedString = expectedAttempted == ItemPSVI.VALIDATION_FULL ? "full"
                : (expectedAttempted == ItemPSVI.VALIDATION_PARTIAL ? "partial"
                        : "none");
        String actualString = actualAttempted == ItemPSVI.VALIDATION_FULL ? "full"
                : (actualAttempted == ItemPSVI.VALIDATION_PARTIAL ? "partial"
                        : "none");
        String message = "{validity} was <" + actualString
        + "> but it should have been <" + expectedString + ">";
        assertEquals(message, expectedAttempted, actualAttempted);
    }
    
    protected void assertElementName(String expectedName, String actualName) {
        assertEquals("Local name of element declaration is wrong.",
                expectedName, actualName);
    }
    
    protected void assertElementNull(XSElementDeclaration elem) {
        assertNull("Element declaration should be null.", elem);
    }
    
    protected void assertElementNamespace(String expectedName, String actualName) {
        assertEquals("Namespace of element declaration is wrong.",
                expectedName, actualName);
    }
    
    protected void assertElementNamespaceNull(String actualName) {
        assertNull("Local name of element declaration should be null.",
                actualName);
    }
    
    protected void assertTypeName(String expectedName, String actualName) {
        assertEquals("Local name of type definition is wrong.", expectedName,
                actualName);
    }
    
    protected void assertTypeNull(XSTypeDefinition type) {
        assertNull("Type definition should be null.", type);
    }
    
    protected void assertTypeNamespace(String expectedName, String actualName) {
        assertEquals("Namespace of type definition is wrong.", expectedName,
                actualName);
    }
    
    protected void assertTypeNamespaceNull(String actualName) {
        assertNull("Namespace of type definition should be null.", actualName);
    }
    
    protected void assertError(String error) {
        assertTrue("Error <" + error + "> should have occured, but did not.",
                fErrorHandler.specialCaseFound(error));
    }
    
    protected void assertNoError(String error) {
        assertFalse("Error <" + error
                + "> should not have occured (but it did)", fErrorHandler
                .specialCaseFound(error));
    }
    
    protected void assertAnyType(XSTypeDefinition type) {
        assertEquals("Type is supposed to be anyType", SchemaGrammar.fAnyType,
                type);
    }
}
