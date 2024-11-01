package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.ColetaModel;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class BuscaColetaService {
    final ColetaModel coleta = new ColetaModel();
    private final String baseUrl = "http://localhost:8080/v1/coletas/agendamento/2";
    private Response response;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void setFieldsDelivery(String field, String value) {
        switch (field) {
            case "dataColeta" ->  coleta.setDataColeta(value);
            case "dataRegistro" -> coleta.setDataRegistro(value);
            case "nome_bairro" -> coleta.setNome_bairro(value);
            case "numero_volume" -> coleta.setNumero_volume(Double.parseDouble(value));
            case "rota" -> coleta.setRota(null);
            case "idColeta" -> coleta.setIdColeta(Integer.parseInt(value));
            default -> throw new IllegalStateException("Campo inesperado: " + field);
        }
    }

    public Response buscarColeta(String endpoint) {
        response = given()
                .accept(ContentType.JSON)
                .when()
                .get(baseUrl)
                .then()
                .extract()
                .response();
        return response;
    }

    public JsonSchema loadJsonSchema(String filePath) throws IOException {
        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {
            String rawSchemaString = new String(inputStream.readAllBytes());
            JSONObject rawSchema = new JSONObject(new JSONTokener(rawSchemaString));
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
            return factory.getSchema(rawSchema.toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<ValidationMessage> validateJsonSchema(JsonSchema schema, JSONObject jsonResponse) throws IOException {
        JsonNode jsonResponseNode = objectMapper.readTree(jsonResponse.toString());
        return schema.validate(jsonResponseNode);
    }
}