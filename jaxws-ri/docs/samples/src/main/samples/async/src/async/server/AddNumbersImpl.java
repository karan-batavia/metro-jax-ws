/*
 * Copyright (c) 1997, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package async.server;

import jakarta.jws.WebService;

@WebService (serviceName = "AddNumbersService", targetNamespace = "http://duke.example.org")
public class AddNumbersImpl {
    
    public int addNumbers (int number1, int number2) {
        System.out.println ("Received Request!");
        System.out.println("Sleeping for 5 seconds");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return number1 + number2;
    }
}
