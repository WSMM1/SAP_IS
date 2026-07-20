import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;

def Message processData(Message message) {
    // Get the dynamic root element name from a property (set in a previous step)
    def dynamicRootName = message.getProperty("root_node");
    def jsonPayload = message.getBody(String.class);

    // Wrap the original JSON payload with the dynamic root element name
    def wrappedJsonPayload = "{\"" + dynamicRootName + "\": " + jsonPayload + "}";
    
    // Set the modified JSON payload back to the message body
    message.setBody(wrappedJsonPayload);
    return message;
}
