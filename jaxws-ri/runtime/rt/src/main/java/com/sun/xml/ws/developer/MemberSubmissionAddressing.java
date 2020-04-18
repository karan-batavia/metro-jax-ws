/*
 * Copyright (c) 1997, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package com.sun.xml.ws.developer;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import jakarta.xml.ws.spi.WebServiceFeatureAnnotation;

/**
 * This feature represents the use of WS-Addressing with either
 * the SOAP 1.1/HTTP or SOAP 1.2/HTTP binding.  Using this feature
 * with any other binding is NOT required.
 * <p>
 * Enabling this feature will result in the
 * <code>wsaw:UsingAddressing</code> element being added to the
 * <code>wsdl:Binding</code> for
 * the endpoint and in the runtime being capable of responding to
 * WS-Addressing headers.
 * <p>
 * The following describes the affects of this feature with respect
 * to be enabled or disabled:
 * <ul>
 *  <li> ENABLED: In this Mode, Addressing will be enabled.
 *       If there is not a WSDL associated with the Endpoint and
 *       a WSDL is to be generated, it MUST be generated with the
 *       wsaw:UsingAddressing element. At runtime, Addressing headers
 *       MUST be consumed by the receiver and generated by the
 *       sender even if the WSDL declares otherwise. The
 *       mustUnderstand="0" attribute MUST be used on the Addressing
 *       headers.
 *  <li> DISABLED: In this Mode, Addressing will be disabled
 *       even if an associated WSDL specifies otherwise. At runtime,
 *       Addressing headers MUST NOT be used.
 * </ul>
 * <p>
 * The {@link #required} property can be used to
 * specify if the <code>required</code> attribute on the
 * <code>wsaw:UsingAddressing</code> element should
 * be <code>true</code> or <code>false</code>.  By default the
 * <code>wsdl:required</code> parameter is <code>false</code>.
 *
 * See <a href="http://www.w3.org/TR/2006/REC-ws-addr-core-20060509/">WS-Addressing</a>
 * for more information on WS-Addressing.
 * See <a href="http://www.w3.org/TR/2006/CR-ws-addr-wsdl-20060529/">WS-Addressing - WSDL 1.0
 * </a> for more information on <code>wsaw:UsingAddressing</code>.
 *
 * @since JAX-WS 2.1
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@WebServiceFeatureAnnotation(id= MemberSubmissionAddressingFeature.ID,bean=MemberSubmissionAddressingFeature.class)
public @interface MemberSubmissionAddressing {
    /**
     * Specifies if this feature is enabled or disabled.
     */
    boolean enabled() default true;

    /**
     * Property to determine the value of the
     * <code>wsdl:required</code> attribute on
     * <code>wsaw:UsingAddressing</code> element in the WSDL.
     */
    boolean required() default false;

    /**
     * Property to determine if the incoming messsages should be checked for conformance
     * with MemberSubmission version of WS-Addressing.
     *
     * If Validation.LAX, then some WS-Adressing headers are not strictly checked.
     */
    public enum Validation { LAX, STRICT }

    Validation validation() default Validation.LAX;                   

}
