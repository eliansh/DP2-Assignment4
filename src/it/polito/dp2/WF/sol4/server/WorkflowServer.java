package it.polito.dp2.WF.sol4.server;

import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import javax.xml.ws.Endpoint;
import javax.xml.ws.http.HTTPBinding;

public class WorkflowServer {
private static Logger logger = Logger.getLogger(WorkflowServer.class.getName());
	
	public static void main(String[] args) {
		logger.entering(logger.getName(), "main");
		
		publishService("http://localhost:7071/wfinfo", new MyWorkflowInfo());
		publishService("http://localhost:7070/wfcontrol", new MyWorkflowControl());

		publishSchema("http://localhost:7070/Workflow.xsd", "/META-INF/Workflow.xsd");
		publishSchema("http://localhost:7071/Workflow.xsd", "/META-INF/Workflow.xsd");
		
		logger.exiting(logger.getName(), "main");
	}

	private static void publishService(String address, Object implementator) {
		logger.entering(logger.getName(), "publishService");
		logger.info("Publishing service to " + address + "...");
		
		Endpoint endpoint = Endpoint.create(implementator);
		endpoint.setExecutor(Executors.newFixedThreadPool(10));
		endpoint.publish(address);
		
		logger.info("Service published successfully to " + address);
		logger.exiting(logger.getName(), "publishService");
	}
	
	private static void publishSchema(String address, String xsdFileName) {
		logger.entering(logger.getName(), "publishSchema");
		
		logger.info("Publishing schema " + xsdFileName + " to " + address + "...");

		InputStream xsdFileStream = WorkflowServer.class.getResourceAsStream(xsdFileName);
        Endpoint xsdcontrolEndpoint = Endpoint.create(HTTPBinding.HTTP_BINDING, new XmlFileProvider(xsdFileStream));
        xsdcontrolEndpoint.publish(address);
		
		logger.info("Schema " + xsdFileName + " published successfully to " + address);
		logger.exiting(logger.getName(), "publishSchema");
	}
}
