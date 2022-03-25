package com.assignment.bridgelabz;

import org.junit.BeforeClass;

class CabInvoiceServiceTest {
	static InvoiceGenerator invoiceGenerator;

    @BeforeClass
    public static void start(){
        invoiceGenerator = new InvoiceGenerator();
        System.out.println("Welcome to cab invoice generator problem");
    }

}
