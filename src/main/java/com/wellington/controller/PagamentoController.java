package com.wellington.controller;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.resources.preference.Preference;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

@Value("${mp.access.token}")
private String accessToken;

    @PostMapping("/criar")
    public String criarPagamento(@RequestBody List<ItemRequest> itens) throws Exception {
        MercadoPagoConfig.setAccessToken(accessToken);

        PreferenceItemRequest item = PreferenceItemRequest.builder()
            .title(itens.get(0).getNome())
            .quantity(1)
            .unitPrice(new BigDecimal(itens.get(0).getPreco()))
            .build();

        PreferenceRequest request = PreferenceRequest.builder()
            .items(List.of(item))
            .build();

        PreferenceClient client = new PreferenceClient();
        Preference preference = client.create(request);
        return preference.getInitPoint();
    }
}