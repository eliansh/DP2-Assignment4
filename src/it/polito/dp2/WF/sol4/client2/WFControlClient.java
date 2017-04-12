package it.polito.dp2.WF.sol4.client2;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import it.polito.dp2.WF.sol4.client2.workflow.*;

public class WFControlClient {
	private static WFProcessCreator proxy ;

	public static void main(String[] args){
		if(args.length != 2){
			System.out.println(" **1- exit with exit code (2) **");

			System.exit(2);
		}
		String url = args[0];
		String flowName = args[1];
		URL serviceURL = null;
		QName qname = null;
		try {
			serviceURL = new URL(url);
			qname = new QName("http://www.example.org/Workflow/", "WFProcessCreator");
		} catch (MalformedURLException e1) {
			System.out.println(" **2- exit with exit code (2) **");

			System.exit(2);
		}

			WFProcessCreator_Service service = new WFProcessCreator_Service(serviceURL, qname);
			
			proxy = service.getWFProcessCreatorSOAP();

			
			try {
			
				proxy.createProcess(flowName);
			} catch (ServerErrorFault_Exception e) {
				System.out.println(" **4- exit with exit code (1) **");

				System.exit(1);
			} catch (WrongArgumentFault e) {
				System.out.println(" **5- exit with exit code (1) **");

				System.exit(1);
			} catch (WrongStartTimeFault_Exception e) {
				System.out.println(" **6- exit with exit code (1) **");

				System.exit(1);
			} catch (WrongWorkFlowFault e) {
				System.out.println(" **7- exit with exit code (1) **");

				System.exit(1);
			}
			System.out.println(" **8- exit with exit code (0) **");

			System.exit(0);
			
	}
}
