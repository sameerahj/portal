package org.dhara.portal.web.external;


import org.w3c.dom.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 6/5/13
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLRequestHandler extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        String url=request.getParameter("url");
        URL xmlUrl = new URL(url);
        InputStream in = xmlUrl.openStream();
        Document doc = parse(in);
        PrintWriter out = response.getWriter();
        out.write(doc.toString());
    }

    /**
     * Constructs a Document object by reading from an input stream.
     */
    private static Document parse (InputStream is) {
        Document ret = null;
        DocumentBuilderFactory domFactory;
        DocumentBuilder builder;

        try {
            domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setValidating(false);
            domFactory.setNamespaceAware(false);
            builder = domFactory.newDocumentBuilder();

            ret = builder.parse(is);
        }
        catch (Exception ex) {
            System.out.println("unable to load XML: " + ex);
        }
        return ret;
    }

}
