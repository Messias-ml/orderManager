package messiasproject.microservicespecialist.order.infra.documentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import messiasproject.microservicespecialist.order.application.handler.Problem;
import messiasproject.microservicespecialist.order.application.representation.CodeOrder;
import messiasproject.microservicespecialist.order.application.representation.OrderRepresentation;
import messiasproject.microservicespecialist.order.application.representation.ReceivingOrder;
import messiasproject.microservicespecialist.order.application.representation.specification.OrderFilterSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderOpenApi {


    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "409", description = "Pedido duplicado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
    })
    @Operation(summary = "A requisição precisa ser feita no corpo dela. Ou seja, precisa passar um objeto conforme mostrarei!")
    CodeOrder reciveOrder(@Parameter(name = "Objeto que recebe o pedido do sistema EXTERNO A") ReceivingOrder order);


    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Recursos encontrados"),
            @ApiResponse(responseCode = "400", description = "Lista vazia",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
    })
    @Operation(summary = "Busca os pedidos, Ele pode ou não receber parametro, o retorno é uma lista paginada com 5 conteúdos por lista para não pesar o sistema! " +
            "se não passar parametro ele retorna do primeiro ao ultimo registro!")
    Page<OrderRepresentation> searchOrderByData(@Parameter(name = "paginação",
                                                   content = @Content(mediaType = "application/json", schema = @Schema(implementation = PageOpenApi.class)))
                                           Pageable page,

                                                @Parameter(name = "data pretendida", required = false,
                                                   description = "data ou hora que pretende consultar. Mesmo sendo hora, deve se passar em formato de data com o time no final (será mostrado)",
                                                   examples = {
                                                           @ExampleObject(
                                                                   name = "time",
                                                                   summary = "Busca pedidos de uma determinada hora",
                                                                   description = "utilizando dessa forma você consegue buscar todos os registros feitos no espaço de 1 hora, no exemplo mostra de 1:00H da manha e traz registros até de 2:00H",
                                                                   value = "http://localhost:8080/order?time=27-11-2024T01:00:00.000"),
                                                           @ExampleObject(
                                                                   name = "initiate and Terminate",
                                                                   summary = "Busca todos os pedidos no intervalo de tempo que selecionar",
                                                                   description = "o initiate e terminate SEMPRE devem ser usado juntos!",
                                                                   value = "http://localhost:8080/order?initiate=27-11-2024T01:00:00.000&terminate=29-11-2024T01:00:00.000")
                                                   })
                                           OrderFilterSpec orderFilterSpec);
/*

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Recursos encontrdos"),
            @ApiResponse(responseCode = "400", description = "Registro não existente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class)))
            *//*
            DESSA MANEIRA CONSEGUIMOS DOCUMENTAR 2 ERROS DO MESMO STATUS, EM VALUE: COLOCAMOS O JSON QUE QUEREMOS QUE APAREÇA DE EXEMPLO.
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Problem.class),
            examples = {
                @ExampleObject(name = "Registro não existente",
                               value = "{\"status\": 400, \"message\": \"Registro não existente\"}"),
                @ExampleObject(name = "Registro não encontrado",
                               value = "{\"status\": 400, \"message\": \"Registro não encontrado\"}")
            }
        )*//*
    })
    @Operation(summary = "Busca os pedidos pelo codigo, o parametro é obrigatorio e deve ser passado na url: 'url/uuid'")
    OrderClientDTO searchOrderByUuid(@PathVariable String uuid);*/
}
