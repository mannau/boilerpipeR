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
package org.apache.html.dom;

import org.w3c.dom.html.HTMLMenuElement;

/**
 * @xerces.internal
 * @version $Revision: 1029415 $ $Date: 2010-10-31 18:02:22 +0100 (Sun, 31 Oct 2010) $
 * @author <a href="mailto:arkin@exoffice.com">Assaf Arkin</a>
 * @see org.w3c.dom.html.HTMLMenuElement
 * @see org.apache.xerces.dom.ElementImpl
 */
public class HTMLMenuElementImpl
    extends HTMLElementImpl
    implements HTMLMenuElement
{

    private static final long serialVersionUID = -1489696654903916901L;

    public boolean getCompact()
    {
        return getBinary( "compact" );
    }
    
    
    public void setCompact( boolean compact )
    {
        setAttribute( "compact", compact );
    }

    
    /**
     * Constructor requires owner document.
     * 
     * @param owner The owner HTML document
     */
    public HTMLMenuElementImpl( HTMLDocumentImpl owner, String name )
    {
        super( owner, name );
    }


}

