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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/")
public class UsuariosControladores {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping(value = "/auth")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<String> login(@RequestParam("usuario") String username, @RequestParam("contraisenia") String contraisenia) throws JsonProcessingException {
        Usuario usuario = new Usuario();

        usuario.setContraisenia(contraisenia);
        usuario.setUsuario(username);

        ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        final String jsonNode = mapper.writeValueAsString(usuario);
        System.out.println(jsonNode);

        // {
        //	"usuario": "admin",
        //	"contraisenia": "admin"
        //}

        HttpEntity<String> entity = new HttpEntity<String>(jsonNode);
        ResponseEntity<String> r = restTemplate.postForEntity("http://TIENDAFIREBORN/api/auth?usuario="+username+"&"+"contraisenia="+contraisenia, entity, String.class);

        return r;
    }
}
