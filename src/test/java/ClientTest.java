import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.rules.ExternalResource;
import java.util.ArrayList;


public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void client_instantiatesCorrectly_true(){
    Client client = new Client("Justin", "253-448-1364", "06-16-2016", "Client needs a little of the top, no biggie");
    assertEquals(true, client instanceof Client);
  }

  @Test
  public void clientGetName_getName_String(){
    Client client = new Client("Justin", "253-448-1364", "06-16-2016", "Client needs a little of the top, no biggie");
    assertEquals("Justin", client.getName());
  }

  @Test
  public void clientPhone_getPhone_String(){
    Client client = new Client("Justin", "253-448-1364", "06-16-2016", "Client needs a little of the top, no biggie");
    assertEquals("253-448-1364", client.getPhone());
  }

  @Test
  public void clientGetRequestedDate_getRequestedDate_String(){
    Client client = new Client("Justin", "253-448-1364", "06-16-2016", "Client needs a little of the top, no biggie");
    assertEquals("06-16-2016", client.getRequestedDate());
  }

  @Test
  public void clientGetRequests_getClientRequests_String(){
    Client client = new Client("Justin", "253-448-1364", "06-16-2016", "Client needs a little of the top, no biggie");
    assertEquals("Client needs a little of the top, no biggie", client.getClientRequests());
  }

  @Test
  public void save_clientSavedToStylist_int(){
    Client client = new Client("Justin", "253-448-1364", "06-16-2016", "Client needs a little of the top, no biggie"); 
    client.saveClientToStylist(5);
    assertEquals(Client.all().get(0).getId(), client.getId());
  }

  @Test
  public void find_findReviewById_int() {
    Client client = new Client("Justin", "253-448-1364", "06-16-2016", "Client needs a little of the top, no biggie"); 
    client.saveClientToStylist(5);
    Client clientId = Client.find(client.getId());
    assertEquals("Justin", clientId.getName());
  }
}





