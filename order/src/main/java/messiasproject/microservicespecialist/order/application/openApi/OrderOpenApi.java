package messiasproject.microservicespecialist.order.application.openApi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import messiasproject.microservicespecialist.order.application.model.DTO.OrderClientDTO;
import messiasproject.microservicespecialist.order.application.model.DTO.OrderRecivedDTO;
import messiasproject.microservicespecialist.order.application.model.specification.OrderFilterSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderOpenApi {


    @Operation(summary = "A requisição precisa ser feita no corpo dela. Ou seja, precisa passar um objeto conforme mostrarei!")
    void reciveOrder(@Parameter(name = "Objeto que recebe o pedido do sistema EXTERNO A") OrderRecivedDTO order);

    @Operation(summary = "Busca os pedidos, Ele pode ou não receber parametro, o retorno é uma lista paginada com 5 conteúdos por lista para não pesar o sistema! " +
            "se não passar parametro ele retorna do primeiro ao ultimo registro!")
    Page<OrderClientDTO> searchOrderByData(@Parameter(name = "data pretendida",
            description = "data ou hora que pretende consultar. Mesmo sendo hora, deve se passar em formato de data com o time no final (será mostrado)",
            examples ={
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
            }, required = false) Pageable page, OrderFilterSpec orderFilterSpec );

    @Operation(summary = "Busca os pedidos pelo codigo, o parametro é obrigatorio e deve ser passado na url: 'url/uuid'")
    OrderClientDTO searchOrderByUuid(@PathVariable String uuid);
}
