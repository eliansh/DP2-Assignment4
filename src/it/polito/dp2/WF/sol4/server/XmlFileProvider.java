package it.polito.dp2.WF.sol4.server;

import java.io.InputStream;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Provider;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.Service;

@WebServiceProvider
@ServiceMode(value=Service.Mode.PAYLOAD)
public class XmlFileProvider implements Provider<Source> {
	private InputStream file;
	
	public XmlFileProvider(InputStream file) {
		super();
		this.file = file;
	}

	public Source invoke(Source source) {
		return new StreamSource(file);
     }
}
