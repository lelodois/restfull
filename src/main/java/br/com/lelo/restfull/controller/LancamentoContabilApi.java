package br.com.lelo.restfull.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lelo.restfull.message.LancamentoContabilMessage;
import br.com.lelo.restfull.message.LancamentoContabilStatusMessage;
import br.com.lelo.restfull.service.MovimentoContabilService;

@RestController
@RequestMapping("lancamentos-contabeis/")
public class LancamentoContabilApi {

    @Autowired
    private MovimentoContabilService service;

    @PostMapping
    public ResponseEntity<UUID> adicionar(@Validated @RequestBody(required = true) LancamentoContabilMessage message) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.novoLancamento(message));
    }

    @GetMapping("{id}")
    public ResponseEntity<LancamentoContabilMessage> getById(@PathVariable String id) {

        return ResponseEntity.ok(service.getLancamentoById(UUID.fromString(id)));
    }

    @GetMapping
    public ResponseEntity<List<LancamentoContabilMessage>> getByContaContabil(
            @RequestParam(required = true, value = "contaContabil") Long contaContabil) {

        return ResponseEntity.ok(service.getLancamentosByContaContabil(contaContabil));
    }

    @GetMapping("_status/")
    public ResponseEntity<LancamentoContabilStatusMessage> getStatus() {

        return ResponseEntity.ok(service.getLancamentoStatus());
    }

    @GetMapping("_status/{contaContabil}")
    public ResponseEntity<LancamentoContabilStatusMessage> getStatusByContaContabil(
            @RequestParam(required = true, value = "contaContabil") Long contaContabil) {

        return ResponseEntity.ok(service.getLancamentoStatusByContaContabil(contaContabil));
    }

}