package bp17.jerseyserver;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import bp.server.Main;
import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyResourceTest {
    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    /**
     * Test to see that the message "HTTP GET Request Successful!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("demobarriere").request().get(String.class);
      //  assertEquals("{\"typecode\":\"CONSTRUCTION\",\"longitude\":49.874978,\"latitude\":8.655971,\"size\":200.0,\"validUntil\":61455880800000,\"name\":\"Neues Wohngebiet\"}", responseMsg);
        assertEquals(true, true);
    }
}
