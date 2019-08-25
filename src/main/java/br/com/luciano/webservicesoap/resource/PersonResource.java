package br.com.luciano.webservicesoap.resource;

import br.com.luciano.webservicesoap.repository.PersonRepository;
import br.com.luciano.webservicesoap.xml.PersonDetailsRequest;
import br.com.luciano.webservicesoap.xml.PersonDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint("/persons")
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @PayloadRoot(localPart = "PersonDetailsRequest")
    @ResponsePayload
    public PersonDetailsResponse getPerson(@RequestPayload PersonDetailsRequest request) {
        PersonDetailsResponse response = new PersonDetailsResponse();
        response.setPerson(this.personRepository.findByName(request.getName()));

        return response;
    }

}
