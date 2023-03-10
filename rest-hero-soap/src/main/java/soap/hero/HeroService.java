package soap.hero;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface HeroService {
    
    @WebMethod
    @WebResult(name = "hero")
    List<Hero> heroes();

    @WebMethod
    @WebResult(name = "hero")
    Hero heroById(@WebParam(name = "id") Long id);
}
