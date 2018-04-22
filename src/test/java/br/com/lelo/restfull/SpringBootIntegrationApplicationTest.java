package br.com.lelo.restfull;

import static br.com.lelo.restfull.controller.LancamentoContabilApi.URI;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpStatus.CREATED;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.http.client.ClientProtocolException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.lelo.restfull.domain.BaseModel;
import br.com.lelo.restfull.message.LancamentoContabilMessage;
import br.com.lelo.restfull.message.LancamentoContabilStatusMessage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootIntegrationApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String url = "/" + URI;

    @Test
    public void insertGetById() throws ClientProtocolException, IOException {
        String valor = "5566.00";
        LancamentoContabilMessage message = this.newwLancamento(123l, valor, "09032017");

        String getByIdUrl = url + this.getInsertedLancamentoId(message);
        ResponseEntity<LancamentoContabilMessage> response = restTemplate.getForEntity(getByIdUrl,
                LancamentoContabilMessage.class);

        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getValor());
        assertNotNull(response.getBody().getValor().toString().equals(valor));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void insertGetStatus() throws ClientProtocolException, IOException {

        getInsertedLancamentoId(this.newwLancamento(1233l, "4000.50", "09032017"));
        getInsertedLancamentoId(this.newwLancamento(12331l, "945.00", "09032017"));

        String getStatus = url + "_status/";
        ResponseEntity<LancamentoContabilStatusMessage> response = restTemplate.getForEntity(getStatus,
                LancamentoContabilStatusMessage.class);

        assertNotNull(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void insertGetStatusByConta() throws ClientProtocolException, IOException {

        Long contaContabil = 122233l;

        getInsertedLancamentoId(this.newwLancamento(contaContabil, "4000.50", "09032017"));
        getInsertedLancamentoId(this.newwLancamento(contaContabil, "945.00", "09032017"));
        getInsertedLancamentoId(this.newwLancamento(contaContabil, "2945.00", "09032017"));

        String getStatus = url + "_status/?contaContabil=" + contaContabil;
        ResponseEntity<LancamentoContabilStatusMessage> response = restTemplate.getForEntity(getStatus,
                LancamentoContabilStatusMessage.class);

        assertNotNull(response.getBody());

        assertEquals("7890.50", response.getBody().getSoma().toString());
        assertEquals("4000.50", response.getBody().getMax().toString());
        assertEquals("3", response.getBody().getQuantidade().toString());
        assertEquals("945.00", response.getBody().getMin().toString());
        assertEquals("2630.17", response.getBody().getMedia().toString());

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private String getInsertedLancamentoId(LancamentoContabilMessage message) {
        ResponseEntity<String> response = restTemplate.postForEntity(url, message, String.class);
        assertNotNull(BaseModel.fromString(response.getBody()));
        assertEquals(CREATED, response.getStatusCode());
        return response.getBody();
    }

    private LancamentoContabilMessage newwLancamento(Long contaContabil, String valor, String data) {
        LancamentoContabilMessage message = new LancamentoContabilMessage();
        message.setContaContabil(contaContabil);
        message.setData(data);
        message.setValor(new BigDecimal(valor));
        return message;
    }

}