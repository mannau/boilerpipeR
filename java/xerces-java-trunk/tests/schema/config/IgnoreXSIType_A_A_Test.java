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

import junit.framework.Assert;

import org.apache.xerces.dom.PSVIElementNSImpl;
import org.apache.xerces.xs.ItemPSVI;
import org.xml.sax.SAXException;

/**
 * @author Peter McCracken, IBM
 * @version $Id: IgnoreXSIType_A_A_Test.java 447700 2006-09-19 03:13:41Z mrglavas $
 */
public class IgnoreXSIType_A_A_Test extends BaseTest {
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(IgnoreXSIType_A_A_Test.class);
    }
    
    protected String getXMLDocument() {
        return "xsitype_A_A.xml";
    }
    
    protected String getSchemaFile() {
        return "base.xsd";
    }
    
    public IgnoreXSIType_A_A_Test(String name) {
        super(name);
    }
    
    public void testDefaultDocument() {
        try {
            validateDocument();
        } catch (Exception e) {
            Assert.fail("Validation failed: " + e.getMessage());
        }
        
        // default value of the feature is false
        checkFalseResult();
    }
    
    public void testDefaultFragment() {
        try {
            validateFragment();
        } catch (Exception e) {
            Assert.fail("Validation failed: " + e.getMessage());
        }
        
        // default value of the feature is false
        checkFalseResult();
    }
    
    public void testSetFalseDocument() {
        try {
            fValidator.setFeature(IGNORE_XSI_TYPE, false);
        } catch (SAXException e1) {
            Assert.fail("Problem setting feature: " + e1.getMessage());
        }
        
        try {
            validateDocument();
        } catch (Exception e) {
            Assert.fail("Validation failed: " + e.getMessage());
        }
        
        checkFalseResult();
    }
    
    public void testSetFalseFragment() {
        try {
            fValidator.setFeature(IGNORE_XSI_TYPE, false);
        } catch (SAXException e1) {
            Assert.fail("Problem setting feature: " + e1.getMessage());
        }
        
        try {
            validateFragment();
        } catch (Exception e) {
            Assert.fail("Validation failed: " + e.getMessage());
        }
        
        checkFalseResult();
    }
    
    public void testSetTrueDocument() {
        try {
            fValidator.setFeature(IGNORE_XSI_TYPE, true);
        } catch (SAXException e1) {
            Assert.fail("Problem setting feature: " + e1.getMessage());
        }
        
        try {
            validateDocument();
        } catch (Exception e) {
            Assert.fail("Validation failed: " + e.getMessage());
        }
        
        checkTrueResult();
    }
    
    public void testSetTrueFragment() {
        try {
            fValidator.setFeature(IGNORE_XSI_TYPE, true);
        } catch (SAXException e1) {
            Assert.fail("Problem setting feature: " + e1.getMessage());
        }
        
        try {
            validateFragment();
        } catch (Exception e) {
            Assert.fail("Validation failed: " + e.getMessage());
        }
        
        checkTrueResult();
    }
    
    private void checkTrueResult() {
        checkResult();
    }
    
    private void checkFalseResult() {
        checkResult();
    }
    
    private void checkResult() {
        assertValidity(ItemPSVI.VALIDITY_VALID, fRootNode.getValidity());
        assertValidationAttempted(ItemPSVI.VALIDATION_FULL, fRootNode
                .getValidationAttempted());
        assertElementName("A", fRootNode.getElementDeclaration().getName());
        assertTypeName("Y", fRootNode.getTypeDefinition().getName());
        assertTypeNamespaceNull(fRootNode.getTypeDefinition().getNamespace());
        
        PSVIElementNSImpl child = super.getChild(1);
        assertValidity(ItemPSVI.VALIDITY_VALID, child.getValidity());
        assertValidationAttempted(ItemPSVI.VALIDATION_FULL, child
                .getValidationAttempted());
        assertElementName("A", child.getElementDeclaration().getName());
        assertTypeName("Y", child.getTypeDefinition().getName());
        assertTypeNamespaceNull(child.getTypeDefinition().getNamespace());
    }
}