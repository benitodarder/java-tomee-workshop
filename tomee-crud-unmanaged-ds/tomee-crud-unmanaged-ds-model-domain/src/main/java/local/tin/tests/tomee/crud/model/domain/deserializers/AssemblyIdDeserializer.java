package local.tin.tests.tomee.crud.model.domain.deserializers;

import java.io.IOException;
import local.tin.tests.tomee.crud.model.domain.compositeIds.AssemblyId;
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
public class AssemblyIdDeserializer extends StdDeserializer<AssemblyId> {

    public AssemblyIdDeserializer(Class<?> vc) {
        super(vc);
    }

    public AssemblyIdDeserializer(JavaType valueType) {
        super(valueType);
    }

    public AssemblyIdDeserializer(StdDeserializer<?> src) {
        super(src);
    }


    @Override
    public AssemblyId deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = jp.getCodec().readTree(jp);
        AssemblyId request = new AssemblyId();
        request.setComponentId(jsonNode.get("componentId").asInt());
        request.setProductId(jsonNode.get("productId").asInt());
        return request;
    }

}
