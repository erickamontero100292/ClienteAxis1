/**
 * PruebasServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2 May 03, 2005 (02:20:24 EDT) WSDL2Java emitter.
 */

package axis.client;

public class PruebasServiceLocator extends org.apache.axis.client.Service implements axis.client.PruebasService {

    public PruebasServiceLocator() {
    }


    public PruebasServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PruebasServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for pruebas
    private java.lang.String pruebas_address = "http://localhost:8080/SoapAxisJava6_war_exploded/services/pruebas";

    public java.lang.String getpruebasAddress() {
        return pruebas_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String pruebasWSDDServiceName = "pruebas";

    public java.lang.String getpruebasWSDDServiceName() {
        return pruebasWSDDServiceName;
    }

    public void setpruebasWSDDServiceName(java.lang.String name) {
        pruebasWSDDServiceName = name;
    }

    public axis.client.Pruebas_PortType getpruebas() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(pruebas_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getpruebas(endpoint);
    }

    public axis.client.Pruebas_PortType getpruebas(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            axis.client.PruebasSoapBindingStub _stub = new axis.client.PruebasSoapBindingStub(portAddress, this);
            _stub.setPortName(getpruebasWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setpruebasEndpointAddress(java.lang.String address) {
        pruebas_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (axis.client.Pruebas_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                axis.client.PruebasSoapBindingStub _stub = new axis.client.PruebasSoapBindingStub(new java.net.URL(pruebas_address), this);
                _stub.setPortName(getpruebasWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("pruebas".equals(inputPortName)) {
            return getpruebas();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicios", "pruebasService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicios", "pruebas"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        if ("pruebas".equals(portName)) {
            setpruebasEndpointAddress(address);
        }
        else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
