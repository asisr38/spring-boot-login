package com.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.web.SwaggerCtrl;
import com.web.controller.vo.ApplicationResponse;
import com.web.controller.vo.CreditCard;

import lombok.Data;

@RestController
@RequestMapping("/v3")
@SwaggerCtrl
public class CreditCardController {
	
	@PostMapping(value="/creditcards")
	//@PathVariable means reading data from URI
	//@RequestBody - it is used to convert in coming JSON data into java object by using jackson mapper library
	@ResponseStatus(code=HttpStatus.CREATED)
	// {
 //   "name": "VISA",
   // "cvv": 909,
    //"exp": "01/2022",
    //"cardHolder": "Mr. David King"
//}
	public ApplicationResponse createData(@RequestBody CreditCard creditCard) {
		System.out.println("/creditcards is called");
		System.out.println(creditCard);
		ApplicationResponse applicationResponse = new ApplicationResponse();
		applicationResponse.setCode("200");
		applicationResponse.setId(112);
		applicationResponse.setMessage("resource is created!");
		return applicationResponse;
	}
	
	
	@PutMapping(value="/creditcards")
	//@PathVariable means reading data from URI
	//@RequestBody - it is used to convert in coming JSON data into java object by using jackson mapper library
	@ResponseStatus(code=HttpStatus.OK)
	public ApplicationResponse updateData(@RequestBody CreditCard creditCard) {
		System.out.println("/creditcards is called");
		System.out.println(creditCard);
		ApplicationResponse applicationResponse = new ApplicationResponse();
		applicationResponse.setCode("200");
		applicationResponse.setId(112);
		applicationResponse.setMessage("resource is created!");
		return applicationResponse;
	}
	
	@DeleteMapping(value="/creditcards/{cid}")
	@ResponseStatus(code=HttpStatus.OK)
	//@PathVariable means reading data from URI
	public ApplicationResponse deleteData(@PathVariable int cid) {
		System.out.println("Resource is deleted with cid = "+cid);
		ApplicationResponse applicationResponse = new ApplicationResponse();
		applicationResponse.setCode("200");
		applicationResponse.setId(112);
		applicationResponse.setMessage("Resource is deleted with cid = "+cid);
		return applicationResponse;
	}
	
	@GetMapping(value="/creditcards/{cvv}")
	@ResponseStatus(code=HttpStatus.OK)
	//@PathVariable means reading data from URI
	public CreditCard geData(@PathVariable int cvv) {
		CreditCard creditCard = new CreditCard();
		creditCard.setCardHolder("NAGENDRA KUMAR");
		creditCard.setCvv(cvv);
		creditCard.setExp("12/2024");
		creditCard.setName("VISA");
		return creditCard;
	}
	
	@GetMapping(value="/creditcards")
	@ResponseStatus(code=HttpStatus.OK)
	public ListWrapper getCreditCards() {
		CreditCard tcreditCard = new CreditCard();
		tcreditCard.setCardHolder("Amogh KUMAR");
		tcreditCard.setCvv(902);
		tcreditCard.setExp("01/2022");
		tcreditCard.setName("METRO");
		
		CreditCard creditCard = new CreditCard();
		creditCard.setCardHolder("NAGENDRA KUMAR");
		creditCard.setCvv(702);
		creditCard.setExp("12/2024");
		creditCard.setName("VISA");
		ListWrapper listWrapper=new ListWrapper();
		listWrapper.setCards(Arrays.asList(tcreditCard,creditCard));
		return listWrapper;		
	}
	
	@Data
	@XmlRootElement
	private static class ListWrapper {
		private List<CreditCard> cards=new ArrayList<CreditCard>();
		
	}
	

}
