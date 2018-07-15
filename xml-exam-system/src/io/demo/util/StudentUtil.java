package io.demo.util;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class StudentUtil {
	
	public Document getDocument() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return (Document) builder.parse("exam-system.xml");
	}

	public void saveDocument(Document doc) throws Exception {
		TransformerFactory tfFoctiry = TransformerFactory.newInstance();
		Transformer tf = tfFoctiry.newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("exam-system.xml")));
	}

}
