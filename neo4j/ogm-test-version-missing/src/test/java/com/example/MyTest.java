package com.example;

import org.junit.Before;
import org.junit.Test;
import org.neo4j.ogm.testutil.TestServer;
import org.neo4j.harness.ServerControls;

import static org.junit.Assert.assertNotNull;

public class MyTest {

	private ServerControls testServer;

	@Before public void setupTestServer() {
		testServer = TestServer.newInProcessBuilder().newServer();
	}

	@Test public void test() {
		assertNotNull(testServer);
	}
}
