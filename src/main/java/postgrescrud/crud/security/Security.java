package postgrescrud.crud.security;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
// import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;


public class Security {
    
    private final String SECRET_KEY = "qwerghb..2345@#$%^&dfdij"; // Replace with your actual secret key

    public  String generateToken(String username) throws Exception {
        Algorithm algorithm = Algorithm.HMAC512(SECRET_KEY);
        Date issuedAt = new Date();
        Date expirationDate = new Date(issuedAt.getTime() + 86400000); // 24 hours in milliseconds

        String token = "";
    
        token =  JWT.create()
                .withSubject(username)
                .withClaim("userId", username)
                .withIssuedAt(issuedAt)
                .withExpiresAt(expirationDate)
                .sign(algorithm);
        

        return token;
    }

    public  String validateToken(String token) throws Exception {
        try {
            Algorithm algorithm = Algorithm.HMAC512(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("userId").asString(); // Get the subject claim (username)
        } catch (JWTVerificationException e) {
            // Invalid token or signature
            throw new SecurityException("Invalid JWT token", e);
        }
    }
    
}
