package com.codecool.expertsystem.parsers;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public abstract class XMLParser {
    private Document xmlDocument;

    public void loadXmlDocument(String xmlPath) {
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File xmlFile = new File(classLoader.getResource(xmlPath).getFile());
//            File xmlFile = new File(xmlPath);
            DocumentBuilder xmlDocBuilder = DocumentBuilderFactory.newInstance()
                                                                  .newDocumentBuilder();

            this.xmlDocument = xmlDocBuilder.parse(xmlFile);
            this.xmlDocument.normalize();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public Document getDocument() {
        return this.xmlDocument;
    }

    public abstract void parseDocumentToRepository();
}