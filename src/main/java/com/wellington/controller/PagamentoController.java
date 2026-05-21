package com.wellington.controller;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.resources.preference.Preference;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @PostMapping("/criar")
    public String criarPagamento(@RequestBody List<ItemRequest> itens) throws Exception {
        MercadoPagoConfig.setAccessToken("APP_USR-2032993205069418-051407-8729d18c4babf882690a8662640b5278-3402580890");

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