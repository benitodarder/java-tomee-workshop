package local.tin.tests.tomee.crud.model.domain.deserializers;

import java.io.IOException;
import local.tin.tests.tomee.crud.model.domain.messaging.Request;
import local.tin.tests.tomee.crud.model.domain.product.Assembly;
import local.tin.tests.tomee.crud.model.domain.product.Component;
import local.tin.tests.tomee.crud.model.domain.product.Product;
import local.tin.tests.tomee.crud.model.domain.product.Unit;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 *
 * @author benitodarder
 */
public class RequestDeserializer extends StdDeserializer<Request> {

    public RequestDeserializer(Class<?> vc) {
        super(vc);
    }

    public RequestDeserializer(JavaType valueType) {
        super(valueType);
    }

    public RequestDeserializer(StdDeserializer<?> src) {
        super(src);
    }



    @Override
    public Request deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = jp.getCodec().readTree(jp);
        Request request = new Request();
        if (jsonNode.get("assembly") != null) {
            request.setItem(mapper.readValue(jsonNode.get("assembly").toString(), Assembly.class));
        } else if (jsonNode.get("component") != null) {
            request.setItem(mapper.readValue(jsonNode.get("component").toString(), Component.class));
        } else if (jsonNode.get("product") != null) {
            request.setItem(mapper.readValue(jsonNode.get("product").toString(), Product.class));
        } else if (jsonNode.get("unit") != null) {
            request.setItem(mapper.readValue(jsonNode.get("unit").toString(), Unit.class));
        }        
        return request;
    }

}
