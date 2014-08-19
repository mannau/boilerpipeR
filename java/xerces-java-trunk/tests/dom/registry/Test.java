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


package dom.registry;

import org.apache.xerces.dom.CoreDOMImplementationImpl;
import org.apache.xerces.dom.DOMImplementationImpl;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;

import dom.util.Assertion;

public class Test {

    public static void main(String argv[])
    {                                  
        
        System.out.println("Running dom.registry.Test...");
        // set DOMImplementationSource
        System.setProperty(DOMImplementationRegistry.PROPERTY,
                          "org.apache.xerces.dom.DOMImplementationSourceImpl" +
                          " org.apache.xerces.dom.DOMXSImplementationSourceImpl");

        DOMImplementationRegistry registry = null;
        try {
            registry = DOMImplementationRegistry.newInstance();
            Assertion.verify(registry != null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            DOMImplementation i = registry.getDOMImplementation("XML");

            Assertion.verify(i ==
                             CoreDOMImplementationImpl.getDOMImplementation());

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            DOMImplementation i =
                registry.getDOMImplementation("XML MutationEvents");

            Assertion.verify(i ==
                             DOMImplementationImpl.getDOMImplementation());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}    
