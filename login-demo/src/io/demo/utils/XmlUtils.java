package io.demo.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtils {
	private static String filePath;
	static {
		filePath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
		// D:\workspace\login-demo\build\classes
	}
	public static Document getDocument() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filePath));
		return document;
	}
	public static void updateXML(Document document) throws IOException {
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream(filePath), format);
		writer.write(document);
		writer.close();
	}
}
