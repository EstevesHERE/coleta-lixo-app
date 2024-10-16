package br.com.app.coleta.lixo.advice.config.security;

import br.com.app.coleta.lixo.models.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class TokenService {

    @Value("minha.chave.secreta")
    private String palavraSecreta;

    public String gerarToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);
            String token = JWT.create()
                    .withIssuer("usuario")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt((gerarDataDeExpiracao()))
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e){
            throw new RuntimeException("Não foi posssível gerar o Token!");
        }
    }

    public Instant gerarDataDeExpiracao(){
        return LocalDate
                .now()
                .plusDays(1)
                .atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant();
    }

    public String validarToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);

            return JWT.require(algorithm)
                    .withIssuer("usuario")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTCreationException e){
            return "";
        }
    }
}
