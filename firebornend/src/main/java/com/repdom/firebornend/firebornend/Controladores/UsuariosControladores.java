package com.repdom.firebornend.firebornend.Controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.repdom.firebornend.firebornend.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/")
public class UsuariosControladores {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping(value = "/auth")
    public ResponseEntity<String> login(@RequestParam("usuario") String username, @RequestParam("contraisenia") String contraisenia) throws JsonProcessingException {
        Usuario usuario = new Usuario();

        usuario.setContraisenia(contraisenia);
        usuario.setUsuario(username);

        ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        final String jsonNode = mapper.writeValueAsString(usuario);
        System.out.println(jsonNode);

        HttpEntity<String> entity = new HttpEntity<String>(jsonNode);
        ResponseEntity<String> r = restTemplate.postForEntity("http://TIENDAFIREBORN/api/auth/", entity, String.class);

        return r;
    }
}
