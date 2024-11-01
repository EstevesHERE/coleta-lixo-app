package steps;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;
import org.json.JSONObject;
import services.BuscaColetaService;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;

public class BuscaColetaSteps {
    private final BuscaColetaService buscaColetaService = new BuscaColetaService();
    private Response response;

    @Dado("que eu receba os seguintes dados da coleta:")
    public void queEuRecebaOsSeguintesDadosDaColeta(List<Map<String, String>> rows) {
        for (Map<String, String> columns : rows) {
            buscaColetaService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisição para o endpoint {string} de busca de coleta")
    public void euEnviarARequisicaoParaOEndpointDeBuscaDeColeta(String endpoint) {
        response = buscaColetaService.buscarColeta(endpoint);
    }

    @Então("o status code da resposta da busca deve ser {int}")
    public void oStatusCodeDaRespostaDaBuscaDeveSer(int statusCode) {
        response.then().statusCode(statusCode)
                .and()
                .body("idColeta", equalTo(2))
                .body("nomeBairro", equalTo("Vila cesar"))
                .body("numeroVolume", equalTo(15000.0F))
                .body("dataColeta", equalTo("2024-05-03T03:00:00.000+00:00"))
                .body("dataRegistro", equalTo("2024-05-26T21:40:43.000+00:00"))
                .body("rota", equalTo(null));

        try {
            JsonSchema schema = buscaColetaService.loadJsonSchema("src/test/resources/schemas/busca-bem-sucedido-coleta.json");
            JSONObject jsonResponse = new JSONObject(response.asString());
            Set<ValidationMessage> validationMessages = buscaColetaService.validateJsonSchema(schema, jsonResponse);

            if (!validationMessages.isEmpty()) {
                throw new AssertionError("JSON does not match schema: " + validationMessages);
            }
        } catch (Exception e) {
            throw new AssertionError("Error loading or validating JSON schema: " + e.getMessage());
        }
    }
}