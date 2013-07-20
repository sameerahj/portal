package org.dhara.portal.web.airavataClient;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.dhara.portal.web.exception.PortalException;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 6/13/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class AiravataConfig {
    private  int port;
    private  String serverUrl;
    private  String serverContextName;

    private  String gatewayName;
    private  String userName;
    private  String password;
    private  String jcr;
    private  String messageBox;
    private  String broker;
    private  String gfac;
    private static AiravataConfig airavataConfig;
    private AiravataConfig() throws PortalException {
        if(isAiravataConfigurationExists()) {
            airavataConfig=getAiravataConfiguration();
        } else {
            airavataConfig=getDefaultConfig();
        }
    }

    private static  AiravataConfig getAiravataConfig() throws PortalException {
        if(airavataConfig!=null) {
            return airavataConfig;
        } else {
            return new AiravataConfig();
        }
    }

    private boolean isAiravataConfigurationExists() {
        File file=new File("airavata_config.xml");
        return file.exists();
    }

    private AiravataConfig getDefaultConfig() throws PortalException {
        AiravataConfig defaultConfig=new AiravataConfig();
        defaultConfig.setPassword("admin");
        defaultConfig.setUserName("admin");
        defaultConfig.setGatewayName("default");
        defaultConfig.setPort(8080);
        defaultConfig.setServerContextName("airavata-registry");
        defaultConfig.setServerUrl("localhost");
        return defaultConfig;
    }

    private AiravataConfig getAiravataConfiguration() throws PortalException {
        File file= new File("airavata_config.xml");
        FileInputStream fis;
        XMLInputFactory xif;
        XMLStreamReader reader;
        StAXOMBuilder builder;
        try {
            fis= new FileInputStream(file);
            xif= XMLInputFactory.newInstance();
            reader= xif.createXMLStreamReader(fis);
            builder= new StAXOMBuilder(reader);
        } catch (FileNotFoundException e) {
            throw new PortalException(e.getMessage(),e);
        } catch (XMLStreamException e) {
            throw new PortalException(e.getMessage(),e);
        }
        OMElement documentElement= builder.getDocumentElement();
        OMElement airavataConfiguration=documentElement.getFirstElement();
        OMElement server=airavataConfiguration.getFirstElement();
        AiravataConfig defaultConfig=new AiravataConfig();
        defaultConfig.setPassword(server.getFirstChildWithName(new QName("username")).toString());
        defaultConfig.setUserName(server.getFirstChildWithName(new QName("password")).toString());
        defaultConfig.setGatewayName(server.getFirstChildWithName(new QName("gateway-name")).toString());
        defaultConfig.setPort(Integer.parseInt(server.getFirstChildWithName(new QName("port")).toString()));
        defaultConfig.setServerContextName(server.getFirstChildWithName(new QName("server-context")).toString());
        defaultConfig.setServerUrl(server.getFirstChildWithName(new QName("server-url")).toString());
        defaultConfig.setBroker(server.getFirstChildWithName(new QName("broker")).toString());
        defaultConfig.setGfac(server.getFirstChildWithName(new QName("gfac")).toString());
        defaultConfig.setMessageBox(server.getFirstChildWithName(new QName("message-box")).toString());
        defaultConfig.setJcr(server.getFirstChildWithName(new QName("jcr")).toString());
        return defaultConfig;
    }
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getServerContextName() {
        return serverContextName;
    }

    public void setServerContextName(String serverContextName) {
        this.serverContextName = serverContextName;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessageBox() {
        return messageBox;
    }

    public void setMessageBox(String messageBox) {
        this.messageBox = messageBox;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getGfac() {
        return gfac;
    }

    public void setGfac(String gfac) {
        this.gfac = gfac;
    }

    public String getJcr() {
        return jcr;
    }

    public void setJcr(String jcr) {
        this.jcr = jcr;
    }
}
