package org.learning.startup;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest extends BrowserTest{

	@Test
	public void testIfLoggedInWithPO() throws InterruptedException {		
		Assert.assertTrue(loginPage.getMyAccountLabel().isDisplayed(), "My Account Lable is displayed");
	}

	@Test
	public void testBadPassPO() throws InterruptedException {
		Assert.assertEquals(loginPage.getLogginErrorLabel(),
	    "Ai introdus gresit parola sau adresa de email. Te rog completeaza din nou.");
	}
	
    

}
