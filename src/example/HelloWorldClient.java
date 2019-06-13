package example;

import axis.client.PruebasServiceLocator;
import axis.client.PruebasSoapBindingStub;
import org.apache.axis.AxisFault;
import org.apache.axis.EngineConfiguration;
import org.apache.axis.configuration.FileProvider;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.apache.ws.security.message.token.UsernameToken;

public class HelloWorldClient {

    public static final String USER_NAME_SERVICE = "cxf";

    public static void main(String[] argv) {
        try {

            PruebasSoapBindingStub getpruebas = configurationService();
            handlerConfigurations(getpruebas);
            int resul = addService(getpruebas);
            System.out.println(resul);
        } catch (AxisFault e) {
            System.out.println("Acceso denegado");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static int addService(PruebasSoapBindingStub getpruebas) throws java.rmi.RemoteException {
        return getpruebas.suma(2, 232);
    }

    private static PruebasSoapBindingStub configurationService() throws javax.xml.rpc.ServiceException {
        EngineConfiguration config = new FileProvider("client_deploy.wsdd");
        PruebasServiceLocator pruebasServiceLocator = new PruebasServiceLocator(config);
        return (PruebasSoapBindingStub) pruebasServiceLocator.getpruebas();
    }

    private static void handlerConfigurations(PruebasSoapBindingStub getpruebas) {
        getpruebas._setProperty(UsernameToken.PASSWORD_TYPE, WSConstants.PASSWORD_DIGEST);
        getpruebas._setProperty(WSHandlerConstants.USER, USER_NAME_SERVICE);
        getpruebas._setProperty(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        getpruebas._setProperty(WSHandlerConstants.PW_CALLBACK_CLASS, PWCallback.class.getName());
    }
}
