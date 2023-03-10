package soap.hero;

import java.util.List;

import io.quarkus.panache.common.Sort;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingType;

@WebService(endpointInterface = "soap.hero.HeroService")
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class HeroServiceImpl implements HeroService {

    @Override
    public Hero heroById(@WebParam(name = "id") Long id) {
        System.out.println ("Hero id " + id + " requested");
        return Hero.findById(id);
    }

    @Override
    public List<Hero> heroes() {
        System.out.println("All heroes requested");
        return Hero.listAll(Sort.by("id"));
    }
    
}
