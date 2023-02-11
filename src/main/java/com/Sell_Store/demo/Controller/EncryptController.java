package com.Sell_Store.demo.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.Base64Utils;
import com.Sell_Store.demo.Utils.RSA;



@Controller
@RestController
@RequestMapping(path = "encrypt")
public class EncryptController {
    private static final String publicKey = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAxnvPjlA/K/adq6mA6+uUtlyBBxFaKeK+WD2FypOeCAP0qtucmaDrIbxirykrxQjRpGxl2HKRBwGd2h/hDuk9CxRUXD2p0Hrzb1Hb9M5px19TPXM6AWSClR1kozehRusIFrxP6PHqDLx5prJFLlSZzg3N3oGhS6oP/a4Ku/iAdCUCiHb5TX3b3+y4Ll/QViZhpKZjU6BhIOsiVIJhyXvn0cSqLXPjNuXR5A4JkmRl9T9cWncEHTKmoVUyXQJaDZa3yH/OJSEmhhGyKNKkM5solasJWSBKenFnFvphw3+KG8BGfJwGkvtRAVbS1ljduH8z8fxALxHgUdnTtgpxB+KZ/CVnNr97EGqYPLVlX+duGkuy1yCunqVTiY2HyL/0bMTBK84oCQjtMVAHgZ345hZnmGST71D8+i5HGtOOFoRyP6qK6ex1qfEROzWsmVDA00aHLlQcKOLaHvT/DB30aeUsZoL/kQo100XccufpHESrits0mEuoyza4CCFM04F3pDOXAgMBAAE=";
    @PostMapping("/getEncrypt")
    public ResponseEntity<String> getEncrypt(@RequestBody Data data) throws Exception{
            System.out.println(data.getData());
            RSA rsa = new RSA();
            byte[] encryptData =  rsa.encrypt(data.getData(), publicKey);
            return ResponseEntity.status(HttpStatus.OK).body(Base64Utils.encodeToString(encryptData));
    } 
   
}
class Data{
    private String data;
    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }
}