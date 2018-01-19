# sample-server

This is the Producer(Server) of the customer API.

The API is built as a Mule flow with REST component. This exposes the service using JAX-RS.

API-Toolkit features are not used here.

The RAML files are kept at "/sample/src/main/api" folder.

The Customer entity is denied in com.raml.sample.service.CustomerService.java

The saving, updating, retreival of entity is done using a DAO pattern. 

The DAO interface is defined in the com.raml.sample.data.CustomerDAO.java file.

The DAO is implemented in com.raml.sample.data.impl.CustomerDAOImpl.java file.

The methods in DAO are mocked and it does not do actuall database operations.

The Exceptions are declared in the com.raml.sample.exceptions package. 

Two types of test cases are written here.

The "sample-test-suite.xml" defined in src/test/munit is a "munit" test case, and it will mock a MULE flow.

The test cases defined in src/test/java are "JUnit" test cases. This will test both DAO and Service classes.

All the Test cases are tested and found to be working satisfactorily.

The consumer can be run using a "POSTMAN" chrome plugin or use the client project provided with this.

Both the server and client project can be imported into the Anypoint IDE and run accordingly.
